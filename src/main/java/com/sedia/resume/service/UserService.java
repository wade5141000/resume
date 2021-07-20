package com.sedia.resume.service;

import com.sedia.resume.entity.LinkEntity;
import com.sedia.resume.entity.UserEntity;
import com.sedia.resume.exception.ApiException;
import com.sedia.resume.repository.LinkMapper;
import com.sedia.resume.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    final BCryptPasswordEncoder passwordEncoder;
    final UserMapper userMapper;
    final LinkMapper linkMapper;

    public UserEntity getCurrentUser() {
        String account = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userMapper.findByAccount(account).orElseThrow(() -> new ApiException("找不到使用者"));
    }

    public List<UserEntity> getUsers() {
        return userMapper.findAll();
    }

    public UserEntity getUserById(int id) {
        return userMapper.findById(id).orElseThrow(() -> new ApiException("找不到 User"));
    }

    public UserEntity save(UserEntity user) {
        if (userMapper.findByAccount(user.getAccount()).isEmpty()) {
            LocalDateTime now = LocalDateTime.now();
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setCreateDate(now);
            user.setCreateUser(user.getAccount());
            user.setUpdateDate(now);
            user.setUpdateUser(user.getAccount());
            user.setEmail(user.getAccount());
            userMapper.save(user);
            return user;
        }
        throw new ApiException("account already exists");
    }

    public UserEntity getUser() {
        UserEntity currentUser = getCurrentUser();
        currentUser.setLinks(linkMapper.findAll(currentUser.getId()));
        return currentUser;
    }

    public boolean updateBasicInfo(UserEntity user) {
        LocalDateTime now = LocalDateTime.now();

        try {
            UserEntity currentUser = getCurrentUser();
            user.setId(currentUser.getId());
            user.setUpdateDate(now);
            user.setUpdateUser(user.getAccount());
            userMapper.update(user);

            List<LinkEntity> links = user.getLinks();
            List<Integer> originalLinkIds = linkMapper.findAll(user.getId()).stream().mapToInt(LinkEntity::getId)
                    .boxed().collect(Collectors.toList());
            links.forEach(link -> {
                if (link.getId() == null) {
                    link.setUid(currentUser.getId());
                    link.setCreateDate(now);
                    link.setCreateUser(user.getAccount());
                    link.setUpdateDate(now);
                    link.setUpdateUser(user.getAccount());
                    linkMapper.save(link);
                } else {
                    link.setUpdateDate(now);
                    linkMapper.update(link);
                    originalLinkIds.remove(link.getId());
                }
            });
            originalLinkIds.forEach(id -> linkMapper.delete(id, user.getId()));
            return true;
        } catch (Exception e) {
            log.error("更新失敗", e);
            return false;
        }
    }

}
