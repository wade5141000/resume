package com.sedia.resume.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Builder
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
	
	//建立日期
		private LocalDate createDate;
		
	//建立者
	private String createUser;
		
	//更新日期
	private LocalDate updateDate;
		
	//更新者
	private String updateUser;
}
