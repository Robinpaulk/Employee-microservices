package com.robin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.robin.model.CassandraEmployee;
import com.robin.model.Employee;
import com.robin.model.CassandraEmployee;

import com.robin.model.EmployeePojo;
import com.robin.repository.CassandraRepository;
import com.robin.service.EmployeeService;

@RestController
@RequestMapping("/")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping
	public List<Employee> listAll() {
		return empService.listAll();
	}
	
	@GetMapping("/emp")
	public List<CassandraEmployee> listAllEMployee() {
		return empService.listAllEmployee();
	}
	
	@PostMapping("/employee")
	public Employee add(@RequestBody EmployeePojo employee) {
		
		
		return empService.saveOrUpdate(employee);
	
	}
	@PostMapping("/emp")
	public void insert(@RequestBody CassandraEmployee emp) {
		empService.save(emp);
	}
	
	
	@PostMapping("/employeeunique")
	public CassandraEmployee uniqueResult(@RequestBody EmployeePojo employee) {
		
		System.out.println(employee.getName());
		CassandraEmployee uniqueResults = empService.uniqueResults(employee);
		System.out.println(uniqueResults);
		return uniqueResults;
	}
	
	@PostMapping("/listAllUniqueEmployee")
	public List<CassandraEmployee> uniqueResults(@RequestBody EmployeePojo employee) {
		List<CassandraEmployee> listAllUniqueEmployee = empService.listAllUniqueEmployee(employee);
		return listAllUniqueEmployee;
	}
	
	@GetMapping("/employee/{id}")
	public Optional<CassandraEmployee> getEmployee(@PathVariable("id") int id) {
	Optional<CassandraEmployee> optional = empService.findById(id);
	if(optional.isPresent()) {
		System.out.println(optional.get());
	} else{
		System.out.println("No EMployee found");
	}
	return optional;
	}
	
	
}