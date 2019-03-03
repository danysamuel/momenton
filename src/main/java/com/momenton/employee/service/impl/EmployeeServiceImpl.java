package com.momenton.employee.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.momenton.employee.dto.EmployeeOrgStructDTO;
import com.momenton.employee.model.Employee;
import com.momenton.employee.service.EmployeeService;
import com.momenton.error.MomentoRuntimeException;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	private List<Employee> employeeList = Lists.emptyList();

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public List<Employee> createEmployeeList() {
		if (!ObjectUtils.isEmpty(employeeList)) {
			logger.debug("In createEmployeeList : List already populated");

			return employeeList;
		}
		final Employee alan = new Employee("100", "150", "Alan");
		final Employee martin = new Employee("220", "100", "Martin");
		final Employee jamie = new Employee("150", "", "Jamie");
		final Employee alex = new Employee("275", "100", "Alex");
		final Employee steve = new Employee("400", "150", "Steve");
		final Employee david = new Employee("190", "400", "David");

		employeeList = Lists.newArrayList(alan, martin, jamie, alex, steve, david);
		logger.debug("In createEmployeeList : List populated employeeList [{}]", employeeList);

		return employeeList;
	}

	@Override
	public EmployeeOrgStructDTO getEmployeesByHierarchy(List<Employee> employees) {
		if (ObjectUtils.isEmpty(employees)) {
			logger.debug("In getEmployeesByHierarchy employee list null, returning null");
			throw new MomentoRuntimeException("Cannot find employee data!..", HttpStatus.NOT_FOUND);
		}
		/*
		 * Find CEO of the Company
		 */
		final Employee companyCEO = findTopManager(employees);

		final List<Employee> employeeListUnderCEO = findEmployeesUnderManager(employees, companyCEO);

		final EmployeeOrgStructDTO employeeOrgStructDTO = new EmployeeOrgStructDTO();
		employeeOrgStructDTO.setCompanyCEO(companyCEO);
		if (ObjectUtils.isEmpty(employeeListUnderCEO)) {
			return employeeOrgStructDTO;
		}
		employeeOrgStructDTO.setEmployees(employeeListUnderCEO);

		/**
		 * Loads all Employees by hierarchy.
		 */
		employeeListUnderCEO.stream()
				.forEach(employee -> employee.setEmployees(findEmployeesUnderManager(employees, employee)));

		return employeeOrgStructDTO;
	}

	private static List<Employee> findEmployeesUnderManager(List<Employee> employees, final Employee mainManager) {
		return employees.stream().filter(employee -> mainManager.getId().equals(employee.getManagerId()))
				.collect(Collectors.toList());
	}

	private static Employee findTopManager(List<Employee> employees) {
		final Optional<Employee> mainManagerLst = employees.stream()
				.filter(employee -> StringUtils.isEmpty(employee.getManagerId())).findFirst();
		final Employee mainManager = mainManagerLst.isPresent() ? mainManagerLst.get() : null;
		if (mainManager == null || StringUtils.isEmpty(mainManager.getId())) {
			throw new MomentoRuntimeException("CEO Not Found !..", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return mainManager;
	}

}
