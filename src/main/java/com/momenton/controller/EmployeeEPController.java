package com.momenton.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.momenton.employee.dto.EmployeeOrgStructDTO;
import com.momenton.employee.service.EmployeeService;

@RestController
public class EmployeeEPController {
	@Autowired
	private EmployeeService employeeService;

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public EmployeeEPController() {
		super();

	}

	@GetMapping(path = "/employees/hierarchy")
	public ResponseEntity<EmployeeOrgStructDTO> getEmployeeHierarchyDetails() {
		logger.info("In getEmployeeHierarchyDetails");
		return new ResponseEntity<>(employeeService.getEmployeesByHierarchy(employeeService.createEmployeeList()),
				HttpStatus.OK);
	}

}
