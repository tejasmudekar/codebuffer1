package com.codebuffer1.service;

import com.codebuffer1.entity.Department;
import com.codebuffer1.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {
@Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;



    @BeforeEach
    void setUp() {

        Department department=Department.builder()
                                .departmentName("IT")
                                .departmentAddress("pune")
                                .departmentCode("55")
                                .build();

        Mockito.when(departmentRepository.findByDepartmentName("IT")).thenReturn(department);


    }

@Test
    public void whenValidDepartmentName_thenDepartmentShouldFound()
    {
    String departmentName="IT";
        Department found= departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());

    }
}