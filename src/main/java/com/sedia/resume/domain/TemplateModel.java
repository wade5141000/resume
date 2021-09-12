package com.sedia.resume.domain;

import com.sedia.resume.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TemplateModel {

    List<EducationEntity> educations;

    List<ExperienceEntity> experiences;

    List<LanguageEntity> languages;

    List<LicenseEntity> licenses;

    List<SkillEntity> skills;
}
