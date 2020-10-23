package com.robin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.ParameterOutOfBoundsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.robin.model.CassandraEmployee;
import com.robin.model.Employee;
import com.robin.model.CassandraEmployee;

import com.robin.model.EmployeePojo;
import com.robin.repository.CassandraRepository;
import com.robin.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private CassandraRepository cassandraRepo;
	
	
	@Override
	public List<Employee> listAll() {
		
		return empRepo.findAll();
	}
	
	@Override
	public List<CassandraEmployee> listAllEmployee() {
		return (List<CassandraEmployee>) cassandraRepo.findAll();
	}
	
	@Override
	public Employee get(int id) {
		// TODO Auto-generated method stub
		return empRepo.findById(id).get();
	}
	

	@Override
	public void delete(int id) {
		empRepo.deleteById(id);
	}

	@Override
	public void save(Employee employee) {
		empRepo.save(employee);
	}

	
	@Override
	public Employee saveOrUpdate(EmployeePojo employee) {
		
		Employee emp = new Employee();
		emp = empRepo.findByName(employee.getName());
		if(emp != null) {
			emp.setAge(employee.getAge());
			emp.setName(employee.getName());
			emp.setAddress(employee.getAddress());
			emp.setPosition(employee.getPosition());
			emp.setLastname(employee.getLastname());
			
			empRepo.save(emp);
		}
		else {
			
			Employee newEmployee = new Employee();
			newEmployee.setName(employee.getName());
			newEmployee.setAge(employee.getAge());
			newEmployee.setAddress(employee.getAddress());
			newEmployee.setPosition(employee.getPosition());
			newEmployee.setLastname(employee.getLastname());
			empRepo.save(newEmployee);
				
		}
		return emp;
	}


@Override
public Optional<CassandraEmployee> findById(int id) {
	return cassandraRepo.findById(id);
}

@Override
public void save(CassandraEmployee emp) {
	cassandraRepo.save(emp);
}

@Override
public CassandraEmployee uniqueResults(EmployeePojo pojo) {
	System.out.println("Inside unique results");
	return cassandraRepo.findByNameAndAddresss(pojo.getName(), pojo.getAddress());
}

@Override
public List<CassandraEmployee> listAllUniqueEmployee(EmployeePojo employee) {
	return cassandraRepo.findByNameAndAddress(employee.getName(), employee.getAddress());
}
}
