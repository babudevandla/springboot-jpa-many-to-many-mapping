package com.spring.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class Project extends AuditModel {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "project_id")
	@GeneratedValue
	private Long projectId;

	@Column(name = "title")
	private String title;

	@ManyToMany(mappedBy = "projects", cascade = { CascadeType.ALL })
	private Set<Employee> employees = new HashSet<Employee>();

}