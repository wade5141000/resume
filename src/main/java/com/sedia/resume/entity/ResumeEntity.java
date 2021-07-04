package com.sedia.resume.entity;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResumeEntity extends GenericEntity {

    private Integer userId;

    // private Integer templateId;
    // // type id
    // private List<Integer> basicInfoType;
    // // edu id
    // private List<Integer> education;
    // // exp id
    // private List<Integer> experience;
    // // skill id
    // private List<Integer> skill;
    // // license id
    // private List<Integer> license;
    // // language id
    // private List<Integer> languageSkill;

}
