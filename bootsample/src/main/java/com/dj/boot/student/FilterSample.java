package com.dj.boot.student;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"desc"})
//@JsonFilter("SampleFilter")
public class FilterSample implements Serializable {

	private String id;
	private String name;
	//@JsonIgnore
	private String desc;
	
	public FilterSample() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FilterSample(String id, String name, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
	}
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
