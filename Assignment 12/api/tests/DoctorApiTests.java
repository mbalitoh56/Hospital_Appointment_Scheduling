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
public class DoctorApiTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetDoctors() throws Exception {
        mockMvc.perform(get("/api/doctors"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateDoctor() throws Exception {
        String json = "{ \"id\": \"D1\", \"name\": \"Dr. House\", \"specialization\": \"Diagnostics\" }";

        mockMvc.perform(post("/api/doctors")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateDoctor() throws Exception {
        String json = "{ \"id\": \"D1\", \"name\": \"Dr. Wilson\", \"specialization\": \"Oncology\" }";

        mockMvc.perform(put("/api/doctors/D1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }
}
