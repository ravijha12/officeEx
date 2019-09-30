package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO{
	
	private EntityManager entityManager;
	@Autowired
	public EmployeeDAOImplementation(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> getAllEmplpoyees() {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee getEmployeeById(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee employee  = currentSession.get(Employee.class,theId);
		return employee;
	}

	@Override
	public Employee addEmployee(Employee theEmployee) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theEmployee);
		
		return theEmployee;
	}
/*
	@Override
	public Employee editEmployee(int theId,Employee tempEmployee) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		Employee tempEmployee = currentSession.get(Employee.class, theId);
		currentSession.save(employee);
		return null;
	}*/

	@Override
	public void deleteEmployee(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("DELETE FROM Employee where empId=:theId");
		theQuery.setParameter("theId", theId);
		theQuery.executeUpdate();
		
	}

}
