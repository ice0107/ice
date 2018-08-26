package com.huawei.pojo;// default package

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Test entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Test", catalog = "dependencyanalysis")
public class Test implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;

	// Constructors

	/** default constructor */
	public Test() {
	}

	/** full constructor */
	public Test(String name) {
		this.name = name;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}