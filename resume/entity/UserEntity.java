package com.sedia.resume.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@Builder
public class UserEntity extends GenericEntity implements UserDetails {

    /** 帳號 */
    private String username;

    private String password;

    private String name;
    
    //帳號ID
    private String USER_ID;
    //密碼
    private String PASSWORD;
	//名稱
    private String USER_NAME;
    //信箱
    private String EMAIL;
    //電話號碼
    private String PHONE;
    //生日
    private LocalDate BIRTHDAY;
    //性別
    private int SEX;
    //已服役
    private boolean MILITARY_SERVICE;
    //退伍日期
    private LocalDate MILITARY_DATE;
    //通訊地址
    private String ADDRESS;
    //自我介紹
    private String INTRODUCTION;
    //建立日期
    private LocalDateTime CR_DATETIME;
    //更新日期
    private LocalDateTime UP_DATETIME;
    //英文自傳
    private String BIO_ENG;
    //中文自傳
    private String BIO_CHN;
    //附檔
    private String PROFILE_IMG;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
