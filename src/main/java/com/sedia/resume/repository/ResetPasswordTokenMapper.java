package com.sedia.resume.repository;

import java.util.Optional;

import com.sedia.resume.entity.ResetPasswordTokenEntity;
import com.sedia.resume.entity.UserEntity;

public interface ResetPasswordTokenMapper {
	
	 void save(ResetPasswordTokenEntity newUserToken);
	

}
