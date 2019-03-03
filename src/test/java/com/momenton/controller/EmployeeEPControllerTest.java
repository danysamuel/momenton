package com.momenton.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.momenton.employee.dto.EmployeeOrgStructDTO;
import com.momenton.employee.model.Employee;
import com.momenton.employee.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeEPControllerTest {

	@InjectMocks
	EmployeeEPController employeeEPController = spy(EmployeeEPController.class);

	@Mock
	private EmployeeService employeeService;

	@SuppressWarnings("unchecked")
	@Test
	public void testGetEmployeeHierarchyDetails() {
		final List<Employee> mockEmpList = mock(List.class);
		final EmployeeOrgStructDTO mockResponse = mock(EmployeeOrgStructDTO.class);
		when(employeeService.createEmployeeList()).thenReturn(mockEmpList);
		when(employeeService.getEmployeesByHierarchy(Mockito.anyList())).thenReturn(mockResponse);
		final ResponseEntity<EmployeeOrgStructDTO> result = employeeEPController.getEmployeeHierarchyDetails();
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}
}
