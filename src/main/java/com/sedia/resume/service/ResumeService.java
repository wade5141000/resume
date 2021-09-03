
package com.sedia.resume.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sedia.resume.repository.ResumeRelationMapper;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ResumeService {

	final ResumeRelationMapper resumeMapper;

	// 使用者挑選resumeId根據自己需要的eduId加入
	public boolean updateResumeEducation(int id, List<Integer> educationId) {
		// 資料庫rel_resume_edu table的RID跟EDU_ID都是PrimeKey
		resumeMapper.deleteResumeEducation(id);

		for (int i = 0; i < educationId.size(); i++) {
			resumeMapper.insertResumeEducation(id, educationId.get(i));
		}

		return true;
	}

	public boolean updateResumeExperience(int id, List<Integer> experienceId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateResumeLanguage(int id, List<Integer> languageId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateResumeLicense(int id, List<Integer> licenseId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateResumeSkill(int id, List<Integer> skillId) {
		// TODO Auto-generated method stub
		return false;
	}

}
