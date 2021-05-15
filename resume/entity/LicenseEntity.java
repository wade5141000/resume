package com.sedia.resume.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder //自動生成建構子
//實體資料由前端及DB存取,資料庫的table
public class LicenseEntity extends GenericEntity{
	
	//DB給予流水號,自動增長
	private int SN;
	
	//使用者帳號
	private String USER_ID;
	
	//,號區隔
	private String NAME;
	
}
