package com.sedia.resume.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Builder
@Table(name = "resume")
@NoArgsConstructor
@AllArgsConstructor
public class ResumeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private Integer userId;

//  private Integer templateId;
//  // type id
//  private List<Integer> basicInfoType;
//	// edu id
//	private List<Integer> education;
//	// exp id
//	private List<Integer> experience;
//	// skill id
//	private List<Integer> skill;
//	// license id
//	private List<Integer> license;
//	// language id
//	private List<Integer> languageSkill;



}
