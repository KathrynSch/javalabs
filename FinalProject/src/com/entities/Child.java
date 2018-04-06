package com.entities;
// Generated 6 avr. 2018 18:17:58 by Hibernate Tools 5.2.8.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Child generated by hbm2java
 */
@Entity
@Table(name = "child", catalog = "nursery")
public class Child implements java.io.Serializable {

	private Integer childId;
	private String firstName;
	private String lastName;
	private Integer age;

	public Child() {
	}

	public Child(String firstName, String lastName, Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "child_id", unique = true, nullable = false)
	public Integer getChildId() {
		return this.childId;
	}

	public void setChildId(Integer childId) {
		this.childId = childId;
	}

	@Column(name = "first_name", length = 20)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", length = 20)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
