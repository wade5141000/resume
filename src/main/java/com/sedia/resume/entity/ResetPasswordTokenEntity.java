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
    private String crUser;
    // 建立時間
    private LocalDateTime crDatetime;
    // 更新人
    private String upUser;
    // 更新時間
    private LocalDateTime upDatetime;

}
