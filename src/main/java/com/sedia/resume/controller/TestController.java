package com.sedia.resume.controller;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.sedia.resume.queue.MessageSender;
import com.sedia.resume.security.JwtUtil;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM;

/**
 * 這是方便測試使用的 controller，這裡的方法不需要登入使用者也可以操作
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    final AwsUtils awsUtils;

    final MessageSender sender;

    @Value("${sendgrid.api-key}")
    private String sendGridKey;

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

    @GetMapping("/download")
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
//       System.out.println(response.getHeaders());
//       System.out.println(response.getBody());
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
    public void htmlToPdf(String html) throws IOException {

        File template = new ClassPathResource("templates/" + html + ".html").getFile();

        PdfWriter writer = new PdfWriter("test.pdf");
        PdfDocument pdf = new PdfDocument(writer);
        PageSize a4 = PageSize.A4;
        a4.applyMargins(0, 0, 0, 0, false);
        pdf.setDefaultPageSize(a4);
        ConverterProperties prop= new ConverterProperties();


        HtmlConverter.convertToPdf(new FileInputStream(template), pdf, prop);
    }

}
