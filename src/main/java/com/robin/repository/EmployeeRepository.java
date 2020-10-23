package com.robin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.robin.model.Employee;
import com.robin.model.EmployeePojo;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	Employee findByName(String name);
	@Query("SELECT t from Employee t WHERE t.name= ?2 AND t.address=?3")
	Employee findByNameAndAddress(String name, String address);
}
