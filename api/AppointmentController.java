// /api/controller/AppointmentController.java
@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.findAll();
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.save(appointment);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable String id, @RequestBody Appointment updated) {
        return appointmentService.update(id, updated);
    }

    @PostMapping("/{id}/confirm")
    public ResponseEntity<String> confirmAppointment(@PathVariable String id) {
        appointmentService.confirm(id);
        return ResponseEntity.ok("Appointment confirmed");
    }
}
