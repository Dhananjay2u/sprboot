package com.dj.boot.student;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Student {
	@Size(max=2,message="Max no char for Id is 2.")
	private String id;
	@Pattern(regexp="[A-Z][a-z]*", message="Name has to start with Capital letter and small letter onwards only.")
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
}
