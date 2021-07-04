package com.sedia.resume.entity;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LanguageEntity {
	
	// Primary key
	private int id;
	
	//user ID
	private int uid;
	
	/* Language info */
	
	// 語言
	private String language;
	
	// 聽力 - 3:精通、2:中等、1:略懂
	private int listening;
	
	// 口說 - 3:精通、2:中等、1:略懂
	private int spreaking;
	
	// 閱讀 - 3:精通、2:中等、1:略懂
	private int reading;
		
	// 寫作 - 3:精通、2:中等、1:略懂
	private int writing;
	
	//建立日期
	private LocalDate createDate;
	
	//建立者
	private String createUser;
	
	//更新日期
	private LocalDate updateDate;
	
	//更新者
	private String updateUser;

   
}
