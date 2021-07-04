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
	
	//建立時間
	private LocalDateTime createDate;
	
	//建立者
	private String createUser;
	
	//更新時間
	private LocalDateTime updateDate;
	
	//更新者
	private String updateUser;

   
}
