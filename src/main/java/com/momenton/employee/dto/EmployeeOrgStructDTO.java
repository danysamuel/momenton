package com.momenton.employee.dto;

import java.util.List;

import com.momenton.employee.model.Employee;

public class EmployeeOrgStructDTO {

	private Employee companyCEO;
	private List<Employee> employees;

	public Employee getCompanyCEO() {
		return companyCEO;
	}

	public void setCompanyCEO(Employee companyCEO) {
		this.companyCEO = companyCEO;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
