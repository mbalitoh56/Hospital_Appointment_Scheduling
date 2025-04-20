/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.HashMap;
/**
 *
 * @author Lenovo
 */
public class Prototype {
    
    // Schedule.java
public abstract class Schedule implements Cloneable {
    protected String doctorName;
    protected String timeSlot;

    public void setDoctorName(String name) {
        this.doctorName = name;
    }

    public void setTimeSlot(String slot) {
        this.timeSlot = slot;
    }

    public abstract void showSchedule();

    public Schedule clone() {
        try {
            return (Schedule) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

// WeeklySchedule.java
public class WeeklySchedule extends Schedule {
    public void showSchedule() {
        System.out.println("Doctor " + doctorName + " - Weekly Schedule: " + timeSlot);
    }
}

// ScheduleCache.java

public class ScheduleCache {
    private static HashMap<String, Schedule> scheduleMap = new HashMap<>();

    public void loadCache() {
        WeeklySchedule weekly = new WeeklySchedule();
        weekly.setDoctorName("Dr. Smith");
        weekly.setTimeSlot("Mon-Fri 10AM-2PM");
        scheduleMap.put("weekly", weekly);
    }

    public static Schedule getSchedule(String id) {
        return scheduleMap.get(id).clone();
    }
}
}
