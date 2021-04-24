package com.sedia.resume.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
class GenericEntity {

	//識別碼
//    private String id;

    //建立時間
    private LocalDateTime CR_DATETIME;
    
    //更新時間
    private LocalDateTime UP_DATETIME;
}
