package com.momenton.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.spy;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.ObjectUtils;

import com.momenton.employee.model.Employee;
import com.momenton.employee.service.impl.EmployeeServiceImpl;
import com.momenton.error.MomentoRuntimeException;

@RunWith(MockitoJUnitRunner.class)

public class EmployeeServiceTest {
	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl = spy(EmployeeServiceImpl.class);

	@Test
	public void testCreateEmployeeList() {

		assertFalse(ObjectUtils.isEmpty(employeeServiceImpl.createEmployeeList()));
		assertFalse(ObjectUtils.isEmpty(employeeServiceImpl.createEmployeeList()));
	}

	@Test
	public void testGetEmployeesByHierarchy() {
		final List<Employee> employees = getAllEmployees();

		assertNotNull(employeeServiceImpl.getEmployeesByHierarchy(employees));
	}

	@Test(expected = MomentoRuntimeException.class)
	public void testGetEmployeesByHierarchyThrowException() {

		employeeServiceImpl.getEmployeesByHierarchy(null);
	}

	@Test(expected = MomentoRuntimeException.class)
	public void testGetEmployeesByHierarchyTopManagerNotFoundThrowException() {
		final List<Employee> employees = getAllEmployeesWithBadCEOData();

		employeeServiceImpl.getEmployeesByHierarchy(employees);
	}

	private List<Employee> getAllEmployees() {
		final Employee alan = new Employee("100", "150", "Alan");
		final Employee martin = new Employee("220", "100", "Martin");
		final Employee jamie = new Employee("150", "", "Jamie");
		final Employee alex = new Employee("275", "100", "Alex");
		final Employee steve = new Employee("400", "150", "Steve");
		final Employee david = new Employee("190", "400", "David");

		return Lists.newArrayList(alan, martin, jamie, alex, steve, david);
	}

	private List<Employee> getAllEmployeesWithBadCEOData() {
		final Employee alan = new Employee("100", "150", "Alan");
		final Employee martin = new Employee("220", "100", "Martin");
		final Employee jamie = new Employee("", "", "Jamie");
		final Employee alex = new Employee("275", "100", "Alex");
		final Employee steve = new Employee("400", "150", "Steve");
		final Employee david = new Employee("190", "400", "David");

		return Lists.newArrayList(alan, martin, jamie, alex, steve, david);
	}

}
