package com.sedia.resume.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LanguageEntity extends GenericEntity {
	
	// Primary key
	private int SN;
	
	//user ID
	private String USER_ID;
	
	/* Language info */
	
	// 語言
	private String LANGUAGE;
	
	// 聽力 - 3:精通、2:中等、1:略懂
	private int LISTENING;
	
	// 口說 - 3:精通、2:中等、1:略懂
	private int SPEAKING;
	
	// 閱讀 - 3:精通、2:中等、1:略懂
	private int READING;
		
	// 寫作 - 3:精通、2:中等、1:略懂
	private int WRITING;

   
}
