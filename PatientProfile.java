/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
// PatientProfile.java
public class PatientProfile {
    private String name;
    private int age;
    private String allergies;
    private String chronicConditions;

    public static class Builder {
        private final String name;
        private int age;
        private String allergies = "";
        private String chronicConditions = "";

        public Builder(String name) {
            this.name = name;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder allergies(String allergies) {
            this.allergies = allergies;
            return this;
        }

        public Builder chronicConditions(String chronicConditions) {
            this.chronicConditions = chronicConditions;
            return this;
        }

        public PatientProfile build() {
            PatientProfile profile = new PatientProfile();
            profile.name = this.name;
            profile.age = this.age;
            profile.allergies = this.allergies;
            profile.chronicConditions = this.chronicConditions;
            return profile;
        }
    }
}
