package com.sedia.resume.controller;

import com.sedia.resume.entity.TemplateEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/template")
public class TemplateController {

  @GetMapping
  public List<TemplateEntity> getTemplates(){
    return null;
  }

  @GetMapping("/{id}")
  public TemplateEntity getTemplate(@PathVariable int id){
    return null;
  }


}
