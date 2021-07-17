package com.sedia.resume.controller;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.font.FontProvider;
import com.sedia.resume.queue.MessageSender;
import com.sedia.resume.security.JwtUtil;
import com.sedia.resume.service.UserService;
import com.sedia.resume.utils.AwsUtils;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM;

/**
 * 這是方便測試使用的 controller，這裡的方法不需要登入使用者也可以操作
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
@Slf4j
public class TestController {

    final AwsUtils awsUtils;

    final MessageSender sender;

    @Value("${sendgrid.api-key}")
    private String sendGridKey;

    final UserService userService;

    @GetMapping("/upload")
    public String testUpload() throws IOException {
    	
        Resource resource = new ClassPathResource("temp/test.txt");
        
        
        File file = resource.getFile();
        boolean result = awsUtils.uploadFileToS3(file);
        if (result) {
            return "上傳成功";
        }
        return "上傳失敗";
    }

    @GetMapping("/download-s3")
    public ResponseEntity<InputStreamResource> testDownload() {

        String fileName = "test.txt";

        InputStream source = awsUtils.downloadFileFromS3(fileName);
        InputStreamResource resource = new InputStreamResource(source);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity.ok().headers(headers).contentType(APPLICATION_OCTET_STREAM).body(resource);
    }

    @GetMapping("/queue")
    public String testQueue() {
        sender.send("Hello World!");
        // sender.sendObj();
        return "成功放入queue";
    }

    @GetMapping("/mail")
    public String testSendMail() throws IOException {

        Email from = new Email("wade5141000@outlook.com");
        Email to = new Email("wade5141000@gmail.com");
        from.setName("resume-service");
        String subject = "Sending with Twilio SendGrid is Fun";
        Content content = new Content("text/html", "and <em>easy</em> to do anywhere with <strong>Java</strong>");

        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(sendGridKey);
        Request request = new Request();

        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());

        Response response = sg.api(request);

        System.out.printf("response code: %d", response.getStatusCode());
        // System.out.println(response.getHeaders());
        // System.out.println(response.getBody());
        return "成功發信";
    }

    @GetMapping("/mock-login")
    @ResponseBody
    public String mockLogin(String username) {
        return Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + JwtUtil.EXPIRATION_TIME)).signWith(JwtUtil.key)
                .compact();
    }

    @GetMapping("/cv")
    @ResponseBody
    public void htmlToPdf(String html) {
        try {
            File template = new ClassPathResource("templates/" + html + ".html").getFile();

            // String htmlString = IOUtils.toString(new FileInputStream(template), UTF_8);
            // System.out.println(htmlString);

            File outFile = new File("src/main/resources/temp/test.pdf");
            FileUtils.touch(outFile);
            // File outFile = new ClassPathResource("temp/test.pdf").getFile();

            PdfWriter writer = new PdfWriter(outFile);
            // PdfWriter writer = new PdfWriter("test.pdf");
            PdfDocument pdf = new PdfDocument(writer);
            PageSize a4 = PageSize.A4;
            a4.applyMargins(0, 0, 0, 0, false);
            pdf.setDefaultPageSize(a4);
            ConverterProperties prop = new ConverterProperties();

            // PdfFont font = PdfFontFactory.createFont("STSongStd-Light", "UniGB-UCS2-H", false);
            // FontProvider fontProvider = new FontProvider();
            // fontProvider.addFont(font.getFontProgram(), "UniGB-UCS2-H");
            // prop.setFontProvider(fontProvider);
            FontProvider provider = new DefaultFontProvider(true, true, true);
            prop.setFontProvider(provider);
            // prop.setBaseUri("resources/");
            HtmlConverter.convertToPdf(new FileInputStream(template), pdf, prop);
            // HtmlConverter.convertToPdf(htmlString, pdf, prop);

        } catch (Exception e) {
            log.error("產生PDF失敗", e);
        }
    }

    @GetMapping("/download-cv")
    @ResponseBody
    public ResponseEntity<Resource> downloadPdf() throws IOException {
        File file = new ClassPathResource("temp/test.pdf").getFile();
        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", "test.pdf");
        return ResponseEntity.ok().headers(headers).contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
    }

    @GetMapping("/image")
    public void getImage(HttpServletResponse response) throws IOException {
        File file = new ClassPathResource("templates/images/pic.jpg").getFile();
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(new FileInputStream(file), response.getOutputStream());
    }

    @PostMapping(value = "/image/upload", consumes = "multipart/form-data")
    public boolean uploadImage(@RequestParam("image") MultipartFile image) {
        return false;
    }

}
