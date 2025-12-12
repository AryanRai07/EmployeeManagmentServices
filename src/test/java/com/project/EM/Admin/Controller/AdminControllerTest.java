package com.project.EM.Admin.Controller;

import com.project.EM.Admin.Entity.EmployeeEntity;
import com.project.EM.Admin.Repository.EmployeeRepositry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.MediaType;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AdminController.class)
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepositry empRepo;




    @Test
    void testSaveEmployeeData() throws Exception {

        EmployeeEntity entity = new EmployeeEntity();
        entity.setId(1);
        entity.setName("Aryan");
        Mockito.when(empRepo.save(Mockito.any())).thenReturn(entity);

        String json = """
                {
                  "employeeName": "Aryan",
                  "contactNo": "9876543210",
                  "emailId": "aryan@example.com",
                  "deptId": 2,
                  "password": "Test@123",
                  "gender": "Male",
                  "role": "ADMIN"
                }
                """;

//        mockMvc.perform(post("/saveData")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(json))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.status").value(true));
    }
}
