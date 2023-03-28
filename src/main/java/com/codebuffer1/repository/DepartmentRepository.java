package com.codebuffer1.repository;

import com.codebuffer1.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentName(String name);
    Department findByDepartmentNameIgnoreCase(String departmentName);



}
