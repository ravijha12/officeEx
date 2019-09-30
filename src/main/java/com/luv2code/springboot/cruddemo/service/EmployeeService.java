package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmplpoyees();
	public Employee getEmployeeById(int theId);
	public Employee addEmployee(Employee theEmployee);
	/*public Employee editEmployee(int theId);*/
	public void deleteEmployee(int theId);
}
