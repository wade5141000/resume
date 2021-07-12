package com.sedia.resume.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LanguageEntity extends GenericEntity {

    // user ID
    private int uid;

    /* Language info */

    // 語言
    private String language;

    // 聽力 - 3:精通、2:中等、1:略懂
    private int listening;

    // 口說 - 3:精通、2:中等、1:略懂
    private int speaking;

    // 閱讀 - 3:精通、2:中等、1:略懂
    private int reading;

    // 寫作 - 3:精通、2:中等、1:略懂
    private int writing;

}
