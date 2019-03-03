package com.momenton.employee.service;

import java.util.List;

import com.momenton.employee.dto.EmployeeOrgStructDTO;
import com.momenton.employee.model.Employee;

public interface EmployeeService {

	List<Employee> createEmployeeList();

	EmployeeOrgStructDTO getEmployeesByHierarchy(List<Employee> employees);

}
