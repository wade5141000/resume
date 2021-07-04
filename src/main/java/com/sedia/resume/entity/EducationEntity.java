package com.sedia.resume.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.joda.time.DateTime;

import lombok.NoArgsConstructor;



@Getter
@Setter
@NoArgsConstructor
public class EducationEntity  {
	
	// Primary key
	private int id;
	
	//user ID
	private int uid;
	
	/* school info */
	
	// GPA
	private float GPA;
	
	// 學校
	private String schoolName;
	
	// 年級
	private String level;
	
	// 學系
	private String major;
	
	// 輔修
	private String secondMajor;
	
	// 在學狀態
	private String status;
	
	// 入學時間
	private LocalDate startDate;
	
	// 畢業時間
	private LocalDate endDate;
	
	// 國家
	private String country;
	
	//建立時間
	private LocalDateTime createDate;
		
	//建立者
	private String createUser;
		
	//更新時間
	private LocalDateTime updateDate;
		
	//更新者
	private String updateUser;
}
