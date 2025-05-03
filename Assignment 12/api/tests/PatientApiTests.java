package com.hospital.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PatientApiTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetPatients() throws Exception {
        mockMvc.perform(get("/api/patients"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreatePatient() throws Exception {
        String json = "{ \"id\": \"P1\", \"name\": \"John Doe\" }";
        mockMvc.perform(post("/api/patients")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }
}
