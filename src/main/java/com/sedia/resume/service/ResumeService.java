
package com.sedia.resume.service;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.font.FontProvider;
import com.sedia.resume.domain.TemplateModel;
import com.sedia.resume.entity.TemplateEntity;
import com.sedia.resume.utils.AwsUtils;
import freemarker.template.Configuration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sedia.resume.entity.ResumeEntity;
import com.sedia.resume.entity.UserEntity;
import com.sedia.resume.exception.ApiException;
import com.sedia.resume.repository.ResumeMapper;
import com.sedia.resume.repository.ResumeRelationMapper;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ResumeService {

    final ResumeMapper resumeMapper;
    final UserService userService;
    final ResumeRelationMapper resumeRelationMapper;
    final TemplateService templateService;
    final Configuration freemarker;
    final EducationService educationService;
    final ExperienceService experienceService;
    final LanguageService languageService;
    final LicenseService licenseService;
    final SkillService skillService;
    final AwsUtils awsUtils;

    public ResumeEntity getResume(int id) {
        UserEntity currentUser = userService.getCurrentUser();
        int uid = currentUser.getId();
        return resumeMapper.firstResume(id, uid).orElseThrow(() -> new ApiException("找不到語言"));

    }

    public List<ResumeEntity> getResumeList() {
        UserEntity currentUser = userService.getCurrentUser();
        int uid = currentUser.getId();
        return resumeMapper.listResume(uid);

    }

    public boolean updateResume(ResumeEntity resume) {
        try {

            UserEntity currentUser = userService.getCurrentUser();
            resume.setUid(currentUser.getId());
            resume.setUpdateUser(currentUser.getAccount());
            resume.setUpdateDate(LocalDateTime.now());
            resumeMapper.updateResume(resume);
            return true;
        } catch (Exception e) {
            log.error("更新失敗");
            return false;
        }

    }

    public boolean insertResume(ResumeEntity resume) {
        try {
            log.debug("{}", resume);
            UserEntity currentUser = userService.getCurrentUser();
            resume.setUid(currentUser.getId());
            // 取得cr_user與cr_localdatetime
            resume.setCreateUser(currentUser.getAccount());
            resume.setCreateDate(LocalDateTime.now());
            resumeMapper.insertResume(resume);
            return true;
        } catch (Exception e) {
            log.error("新增失敗", e);
            return false;
        }

    }

    public boolean deleteResume(int id) {
        try {
            UserEntity currentUser = userService.getCurrentUser();
            int uid = currentUser.getId();
            resumeMapper.deleteResume(id, uid);
            return true;
        } catch (Exception e) {
            log.error("刪除失敗", e);
            return false;
        }

    }

    public boolean updateBasicInfo(int id, List<String> basicInfo) {
        try {
            UserEntity currentUser = userService.getCurrentUser();
            int uid = currentUser.getId();
            String UpdatebasicInfo = String.join(",", basicInfo);
            resumeMapper.updateBasicInfo(UpdatebasicInfo, id, uid);
            return true;
        } catch (Exception e) {
            log.error("更新失敗", e);
            return false;
        }
    }

    // 使用者挑選resumeId根據自己需要的eduId加入
    public boolean updateResumeEducation(int id, List<Integer> educationId) {
        // 資料庫rel_resume_edu table的RID跟EDU_ID都是PrimeKey
        resumeRelationMapper.deleteResumeEducation(id);

        for (int i = 0; i < educationId.size(); i++) {
            resumeRelationMapper.insertResumeEducation(id, educationId.get(i));
        }

        return true;
    }

    public boolean updateResumeExperience(int id, List<Integer> experienceId) {
        resumeRelationMapper.deleteResumeExperience(id);

        for (int i = 0; i < experienceId.size(); i++) {
            resumeRelationMapper.insertResumeExperience(id, experienceId.get(i));
        }

        return true;
    }

    public boolean updateResumeLanguage(int id, List<Integer> languageId) {
        resumeRelationMapper.deleteResumeLanguage(id);

        for (int i = 0; i < languageId.size(); i++) {
            resumeRelationMapper.insertResumeLanguage(id, languageId.get(i));
        }

        return true;
    }

    public boolean updateResumeLicense(int id, List<Integer> licenseId) {
        resumeRelationMapper.deleteResumeLicense(id);

        for (int i = 0; i < licenseId.size(); i++) {
            resumeRelationMapper.insertResumeLicense(id, licenseId.get(i));
        }

        return true;
    }

    public boolean updateResumeSkill(int id, List<Integer> skillId) {
        resumeRelationMapper.deleteResumeSkill(id);

        for (int i = 0; i < skillId.size(); i++) {
            resumeRelationMapper.insertResumeSkill(id, skillId.get(i));
        }

        return true;
    }

    public void applyResume(int resumeId) throws Exception {

        UserEntity user = userService.getCurrentUser();
        ResumeEntity resume = resumeMapper.firstResume(resumeId, user.getId()).orElseThrow();

        String[] basicInfoColumn = resume.getBasicInfo().split(",");
        TemplateEntity template = templateService.getTemplate(resume.getTemplateID());

        TemplateModel templateModel = new TemplateModel();
        // TODO 放 Basic Info
        templateModel.setEducations(resumeRelationMapper.getEducationIdByResumeId(resumeId).stream()
                .map(educationService::getEducation).collect(Collectors.toList()));
        templateModel.setExperiences(resumeRelationMapper.getExperienceIdByResumeId(resumeId).stream()
                .map(experienceService::getExperience).collect(Collectors.toList()));
        templateModel.setLanguages(resumeRelationMapper.getLanguageIdByResumeId(resumeId).stream()
                .map(languageService::getLanguage).collect(Collectors.toList()));
        templateModel.setLicenses(resumeRelationMapper.getLicenseIdByResumeId(resumeId).stream()
                .map(licenseService::getLicense).collect(Collectors.toList()));
        templateModel.setSkills(resumeRelationMapper.getSkillIdByResumeId(resumeId).stream().map(skillService::getSkill)
                .collect(Collectors.toList()));

        makePdfAndSave(processTemplate(template.getName() + ".html", new TemplateModel()), resume.getResumeName());

        // makePdfAndSave(processTemplate("left_right_green.html", new TemplateModel()), "myresume");

    }

    private void makePdfAndSave(String html, String pdfName) throws IOException {

        File outFile = null;

        try {

            outFile = new File("src/main/resources/temp/" + pdfName + ".pdf");
            if (!outFile.exists()) {
                FileUtils.touch(outFile);

            }

            PdfWriter writer = new PdfWriter(outFile);
            PdfDocument pdf = new PdfDocument(writer);
            PageSize a4 = PageSize.A4;
            a4.applyMargins(0, 0, 0, 0, false);
            pdf.setDefaultPageSize(a4);
            ConverterProperties prop = new ConverterProperties();

            FontProvider fontProvider = new DefaultFontProvider();

            String uri = ResumeService.class.getResource("/templates/").toString();
            log.debug("base uri:{}", uri);
            String font = uri + "font/TaipeiSansTCBeta-Regular.ttf";
            log.debug("font:{}", font);

            FontProgram fontProgram = FontProgramFactory.createFont(font);
            fontProvider.addFont(fontProgram);
            prop.setFontProvider(fontProvider);
            prop.setBaseUri(uri);

            HtmlConverter.convertToPdf(html, pdf, prop);

            boolean saveResult = awsUtils.uploadFileToS3(outFile);

            if (!saveResult) {
                // TODO
                log.error("save to s3 失敗");
            }

        } catch (Exception e) {
            log.error("產生PDF失敗", e);
        } finally {
            if (outFile != null && outFile.exists()) {
                FileUtils.forceDelete(outFile);
            }
        }

    }

    private String processTemplate(String template, TemplateModel templateModel) throws Exception {
        Map<String, String> user = new HashMap<>();
        user.put("name", "吳韋德");
        user.put("age", "30");

        StringWriter sw = new StringWriter();

        // freemarker.getTemplate("template_A4.html").process(user, sw);
        freemarker.getTemplate(template).process(user, sw);
        log.info("Process template result: {}", sw.toString());

        // return new ByteArrayInputStream(sw.toString().getBytes(StandardCharsets.UTF_8));
        return sw.toString();

    }
}
