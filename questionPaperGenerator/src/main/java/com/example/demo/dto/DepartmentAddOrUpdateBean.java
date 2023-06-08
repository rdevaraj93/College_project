package com.example.demo.dto;

public class DepartmentAddOrUpdateBean {
	private Integer departmentId;
	private String departmentName;
	

	public DepartmentAddOrUpdateBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DepartmentAddOrUpdateBean(Integer departmentId, String departmentName) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}
	
	public Integer getDepartmentId() {
		return departmentId;
	}
	
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	 
}
