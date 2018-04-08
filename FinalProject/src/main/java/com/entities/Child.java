package com.entities;
// Generated 6 avr. 2018 18:17:58 by Hibernate Tools 5.2.8.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Child generated by hbm2java
 */
@Entity
@Table(name = "child")
public class Child{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "child_id")
	private Integer child_id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "age")
	private Integer age;

	public Integer getChild_id() {
		return this.child_id;
	}

	public void setChild_id(Integer child_id) {
		this.child_id = child_id;
	}
	
	public String getFirst_name() {
		return this.first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return this.last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}