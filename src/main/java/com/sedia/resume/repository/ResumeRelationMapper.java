package com.sedia.resume.repository;

import java.util.List;

public interface ResumeRelationMapper {

    List<Integer> getEducationIdByResumeId(int resumeId);

    List<Integer> getExperienceIdByResumeId(int resumeId);

    List<Integer> getLanguageIdByResumeId(int resumeId);

    List<Integer> getLicenseIdByResumeId(int resumeId);

    List<Integer> getSkillIdByResumeId(int resumeId);
}
