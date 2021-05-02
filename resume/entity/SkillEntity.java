package com.sedia.resume.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SkillEntity extends GenericEntity {
	
	// Primary key
	private int SN;
	
	//user ID
	private String USER_ID;
	
	/* skill info */
	
	// 技能
	private String SKILL_NAME;
	
	// 技能描述
	private String SKILL_DESC;

   
}
