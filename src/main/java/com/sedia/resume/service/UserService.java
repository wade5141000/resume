package com.sedia.resume.service;

import com.sedia.resume.entity.UserEntity;
import com.sedia.resume.exception.ApiException;
import com.sedia.resume.repository.UserMapper;
import com.sedia.resume.utils.AwsUtils;

import lombok.RequiredArgsConstructor;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    final UserMapper userMapper;
    final BCryptPasswordEncoder passwordEncoder;
    final AwsUtils awsUtils;
//    @Autowired
//    final CacheManager cacheManager;

    public UserEntity getCurrentUser() {
        String account = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userMapper.findByAccount(account).orElseThrow(() -> new ApiException("找不到使用者"));
    }

    public List<UserEntity> getUsers() {
        return userMapper.findAll();
    }

    public UserEntity save(UserEntity user) {
        if (userMapper.findByAccount(user.getAccount()).isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setCreateDate(LocalDateTime.now());
            user.setCreateUser(user.getAccount());
            user.setUpdateDate(LocalDateTime.now());
            user.setUpdateUser(user.getAccount());
            userMapper.save(user);
            return user;
        }
        throw new ApiException("account already exists");
    }

    public UserEntity getUserById(int id) {
        return userMapper.findById(id).orElseThrow(() -> new ApiException("找不到 User"));
    }
//    * 1. 將圖片存到 resources/user/{account}/profile/{檔案名稱} (以後要換到 AWS S3 上)
//    * 2. 檔案名稱要替換，上傳新的圖片，舊的要刪掉
//    * 3. 儲存路徑寫入 user imgPath 欄位
//    * 4. 回傳成功 or 失敗
    //UserController for upload
	public boolean uptoS3(MultipartFile image) throws IOException {
		
		//取得token
		UserEntity currentuser = this.getCurrentUser();
		
		//預設重命名後的檔案名稱
		String name = currentuser.getAccount();
		
		//獲得檔案副檔名
		String ext = FilenameUtils.getExtension(image.getOriginalFilename());
		
		//設定圖片上傳路徑
		//HttpServletRequest request?要從哪得到該訊息
//		String filepath = request.getSession().getServletContext().getRealPath("/upload");
//		FileSystemResource filesystem = new FileSystemResource(null);
		
		//以絕對路徑儲存重命名後的圖片
		image.transferTo(new File("/" + name +"." + ext));
		
//		//Resource路徑，並替換名稱並加入絕對路徑
		Resource resource = 
				new ClassPathResource("resources/user/" 
		+ currentuser.getAccount() 
		+ "/profile/" + name + "." + ext);
		
		//取得檔案資訊
		File file = resource.getFile();
		
		//將file型別的檔案傳入儲存S3伺服器的方法
		boolean result = awsUtils.uploadFileToS3(file);
		if (result) {
			//將儲存的絕對路徑寫入userEntity
			currentuser.setImgPath(file.getAbsolutePath());
			//若已有圖片則刪除舊圖片資料
		       
            return true;
        }
        return false;
        
        
        
	}

}
