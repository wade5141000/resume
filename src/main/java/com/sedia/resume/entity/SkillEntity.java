package com.sedia.resume.entity;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SkillEntity {
	
	// Primary key
	private int id;
	
	//user ID
	private int uid;
	
	/* skill info */
	
	// 技能
	private String skillName;
	
	// 技能描述
	private String SkillDesc;
	
	//建立日期
	private LocalDate createDate;
	
	//建立者
	private String createUser;
			
	//更新日期
	private LocalDate updateDate;
		
	//更新者
	private String updateUser;

   
}
