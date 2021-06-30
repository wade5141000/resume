package com.sedia.resume.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
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

    private String email;

    private String phone;

    private LocalDate birthday;

    private String sex;

    private boolean militaryService;

    private LocalDate militaryDate;

    private String address;

    private String identity;

    private String introduction;

    private String bioEng;

    private String bioChn;

    private String imgPath;

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
