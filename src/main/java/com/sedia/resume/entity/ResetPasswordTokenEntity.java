package com.sedia.resume.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResetPasswordTokenEntity extends GenericEntity {

    private int uid;

    private String token;

    private LocalDateTime expiryDate;

    private boolean isUsed;
    
    // 建立人
    private String createUser;
    // 建立時間
    private LocalDateTime createDate;
    // 更新人
    private String updateUser;
    // 更新時間
    private LocalDateTime updateDate;

}