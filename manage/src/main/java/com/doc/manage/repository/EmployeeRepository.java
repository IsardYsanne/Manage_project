package com.doc.manage.repository;

import com.doc.manage.model.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    Optional<Employee> findBySurname(String surname);

}