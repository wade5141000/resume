package com.sedia.resume.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ExperienceEntity {
    // 流水號
    private int sn;
    // userID
    private int uid;
    // 公司名稱
    private String company_name;
    // 職稱
    private String position;
    // 到職日
    // DB用timestamp,程式一樣用localdatetime
    private LocalDateTime start_date;
    // 離職日
    private LocalDateTime end_date;
    // 職務簡介(100字)
    private String experience_description;
    // 技能(table表未定義明確型別)
    private String ability;
    // 建立時間
    private LocalDateTime cr_datetime;
    // 更新時間
    private LocalDateTime up_datetime;

}
