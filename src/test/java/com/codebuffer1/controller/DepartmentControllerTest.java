package com.codebuffer1.controller;

import com.codebuffer1.entity.Department;
import com.codebuffer1.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService;

    private Department department;
    @BeforeEach
    void seUp()
    {
        department = Department.builder().departmentAddress("Ahm").departmentCode("tt55").departmentAddress("mum").departmentName("IT").departmentId(1L).build();

    }
    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder().departmentName("IT").departmentAddress("Ahm").departmentCode("tt55").build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/department").contentType(MediaType.APPLICATION_JSON).content("{\"departmentName\": \"IT\",\n" +
                "        \"departmentAddress\": \"Ahm\",\n" +
                "        \"departmentCode\": \"tt55\"\n" +
                "    }")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void fetchById() {
    }
}