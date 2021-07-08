package com.sedia.resume.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.joda.time.DateTime;

import lombok.NoArgsConstructor;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationEntity extends GenericEntity  {
	
	
	
	//user ID
	private int uid;
	
	/* school info */
	
	// GPA
	private float gpa;
	
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
	
	
}
