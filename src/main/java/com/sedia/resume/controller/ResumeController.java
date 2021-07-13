package com.sedia.resume.controller;

import com.sedia.resume.entity.ResumeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/resume")
public class ResumeController {

    @GetMapping
    public List<ResumeEntity> getResumes() {
        return null;
    }

}
