package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	@Autowired
	public EmployeeServiceImplementation(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public List<Employee> getAllEmplpoyees() {
		
		return employeeDAO.getAllEmplpoyees();
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int theId) {
		
		return employeeDAO.getEmployeeById(theId);
	}

	@Override
	@Transactional
	public Employee addEmployee(Employee theEmployee) {
		
		return employeeDAO.addEmployee(theEmployee);
	}

	/*@Override
	@Transactional
	public Employee editEmployee(int theId) {
		
		return employeeDAO.;
	}*/

	@Override
	@Transactional
	public void deleteEmployee(int theId) {
		// TODO Auto-generated method stub
		employeeDAO.deleteEmployee(theId);
	}

}
