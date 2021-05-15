package com.sedia.resume.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Builder
public class ExperienceEntity {
	//流水號
	int SN;
	//userID
	String USER_ID;
	//公司名稱
	String COMPANY_NAME;
	//職稱
	String POSITION;
	//到職日
	LocalDate START_DATE;
	//離職日
	LocalDate END_DATE;
	//職務簡介(100字)
	String EXPERIENCE_DESC;
	//技能(table表未定義明確型別)
//	String ability;
	
	
}
