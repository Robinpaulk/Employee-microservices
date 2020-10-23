package com.robin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.robin.model.CassandraEmployee;
import com.robin.model.Employee;
import com.robin.model.CassandraEmployee;

import com.robin.model.EmployeePojo;


public interface EmployeeService {
	
	List<Employee> listAll();
	
	Employee get(int id);
	
	void save(Employee employee);

    void delete(int id);

	Employee saveOrUpdate(EmployeePojo employee);
    
	
	Optional<CassandraEmployee> findById(int id);

	void save(CassandraEmployee emp);

	List<CassandraEmployee> listAllEmployee();

	CassandraEmployee uniqueResults(EmployeePojo employee);

	List<CassandraEmployee> listAllUniqueEmployee(EmployeePojo employee);




	    
    
}
