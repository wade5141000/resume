package com.sedia.resume.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginUser {

    private String id;

    private String username;

    private String jwt;

}
