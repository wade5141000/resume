package com.sedia.resume.entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SkillEntity {
	
	// Primary key
	private int id;
	
	//user ID
	private int uid;
	
	/* skill info */
	
	// 技能
	private String skillName;
	
	// 技能描述
	private String skillDesc;
	
	//建立時間
	private LocalDateTime createDate;
	
	//建立者
	private String createUser;
			
	//更新時間
	private LocalDateTime updateDate;
		
	//更新者
	private String updateUser;

   
}
