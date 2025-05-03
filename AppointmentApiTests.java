@SpringBootTest
@AutoConfigureMockMvc
public class AppointmentApiTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAppointments() throws Exception {
        mockMvc.perform(get("/api/appointments"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateAppointment() throws Exception {
        String json = "{ \"doctorId\": \"D1\", \"patientId\": \"P1\", \"dateTime\": \"2025-06-01T10:00\" }";
        mockMvc.perform(post("/api/appointments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk());
    }
}
