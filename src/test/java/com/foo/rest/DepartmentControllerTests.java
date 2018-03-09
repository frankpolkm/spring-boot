package com.foo.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getDepartmentCount() throws Exception {
        this.mockMvc.perform(get("/dep/count")).andDo(print()).andExpect(status().isOk())
        .andExpect(content().string("3"));	
        //.andExpect(jsonPath("$.count").value("3"));
    }
    
    @Test
    public void getDepartmentById() throws Exception {
        this.mockMvc.perform(get("/dep/1")).andDo(print()).andExpect(status().isOk())
        	.andExpect(jsonPath("$.name").value("IT"));
    }
    
    @Test
    public void getDepartmentByIdNotFound() throws Exception {
        this.mockMvc.perform(get("/dep/1000")).andDo(print()).andExpect(status().isNotFound());
    }
}
