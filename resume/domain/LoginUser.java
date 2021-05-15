package com.sedia.resume.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginUser {

    private Integer id;

    private String username;

    private String jwt;

}
