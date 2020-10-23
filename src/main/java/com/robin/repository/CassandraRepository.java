package com.robin.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.robin.model.CassandraEmployee;
import com.robin.model.Employee;
import com.robin.model.CassandraEmployee;
@Repository
public interface CassandraRepository extends CrudRepository<CassandraEmployee, Integer>{
	
	CassandraEmployee findByName(String name);

	@AllowFiltering
	@Query(value=" select * from employee_table  where name=?0 AND address=?1 ALLOW FILTERING")
	CassandraEmployee findByNameAndAddresss(String name, String address);
	@Query(value=" select * from employee_table  where name=?0 AND address=?1 ALLOW FILTERING")
	List<CassandraEmployee> findByNameAndAddress(String name, String address);
	
	
	
}
