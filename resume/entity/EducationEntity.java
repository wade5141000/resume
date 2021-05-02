package com.sedia.resume.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class EducationEntity extends GenericEntity {
	
	// Primary key
	private int SN;
	
	//user ID
	private String USER_ID;
	
	/* school info */
	
	// GPA
	private float GPA;
	
	// 學校
	private String SCHOOL_NAME;
	
	// 年級
	private String LEVEL;
	
	// 學系
	private String MAJOR;
	
	// 輔修
	private String SECOND_MAJOR;
	
	// 在學狀態
	private String STATUS;
	
	// 入學時間
	private LocalDate START_DATE;
	
	// 畢業時間
	private LocalDate END_DATE;
	
	// 國家
	private String COUNTRY;

   
}
