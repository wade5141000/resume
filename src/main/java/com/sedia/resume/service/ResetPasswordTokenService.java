package com.sedia.resume.service;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sedia.resume.entity.ResetPasswordTokenEntity;
import com.sedia.resume.repository.ResetPasswordTokenMapper;
import com.sedia.resume.repository.UserMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ResetPasswordTokenService {

	ResetPasswordTokenMapper resetPasswordTokenMapper;
	ResetPasswordTokenEntity reset;
	
	
	
	// token存入DB
    public boolean save(ResetPasswordTokenEntity reset) {  
    	
    	try { 		
    		String uuid = UUID.randomUUID().toString();
    		reset.setToken(uuid);
    		// EXPIRY_DATE = 24小時
         	int expiryDate = 60 * 24;
        	Calendar calendar = Calendar.getInstance();
        	calendar.setTime(calendar.getTime());
        	calendar.add(Calendar.MINUTE, expiryDate);
        	Date deadline = new Date(calendar.getTime().getTime());  
        	java.time.LocalDateTime ldt = deadline.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        	reset.setExpiryDate(ldt);
        	reset.setUsed(false);
        	resetPasswordTokenMapper.save(reset);
            return true;
        } catch (Exception e) {
            log.error("更新失敗");
            return false;
        }
    	
    }
    
    
}
