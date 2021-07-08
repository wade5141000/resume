package com.sedia.resume.entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SkillEntity extends GenericEntity {
	
	
	
	//user ID
	private int uid;
	
	/* skill info */
	
	// 技能
	private String skillName;
	
	// 技能描述
	private String skillDesc;
	
	

   
}
