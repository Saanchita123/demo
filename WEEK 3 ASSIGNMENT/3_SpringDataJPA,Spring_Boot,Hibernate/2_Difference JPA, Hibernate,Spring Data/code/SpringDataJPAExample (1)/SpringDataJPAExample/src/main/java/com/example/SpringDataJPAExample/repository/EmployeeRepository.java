package com.example.SpringDataJPAExample.repository;
import com.example.SpringDataJPAExample.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // CRUD methods provided automatically
}
