package com.sedia.resume.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
class GenericEntity {

    private Integer id;

    private LocalDateTime createDate;

}
