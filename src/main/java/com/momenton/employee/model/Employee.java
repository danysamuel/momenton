package com.momenton.employee.model;

import java.util.List;

public class Employee {

	private String employeeName;
	private String id;
	private String managerId;
	private List<Employee> employees;

	public Employee(String id, String managerId, String employeeName) {
		super();

		this.id = id;
		this.managerId = managerId;
		this.employeeName = employeeName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public String getId() {
		return id;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", managerId=" + managerId + ", employeeName=" + employeeName + "]";
	}

}
