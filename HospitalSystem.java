import java.util.ArrayList;

class Hospital {
    // Class attributes
    private String hospitalName;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    // Parameterized Constructor
    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    // Inner Class Doctor
    static class Doctor {
        // Class attributes
        private String doctorName;

        // Parameterized Constructor
        public Doctor(String doctorName) {
            this.doctorName = doctorName;
        }

        // Method to get doctor name
        public String getDoctorName() {
            return doctorName;
        }
    }

    // Inner Class Patient
    static class Patient {
        // Class attributes
        private String patientName;

        // Parameterized Constructor
        public Patient(String patientName) {
            this.patientName = patientName;
        }

        // Method to get patient name
        public String getPatientName() {
            return patientName;
        }

    }

    // Method to add doctors
    public void addDoctors(Doctor doctor) {
        doctors.add(doctor);
    }

    // Method to display doctor details
    public void displayDoctorDetails() {
        System.out.println("Doctors in " + hospitalName + ":");
        for(Doctor doctor : doctors) {
            System.out.println("-> " + doctor.getDoctorName());
        }
    }

    // Method to add patients
    public void addPatients(Patient patient) {
        patients.add(patient);
    }

    // Method to display patient details
    public void displayPatientDetails() {
        System.out.println("Patients in " + hospitalName + ":");
        for(Patient patient : patients) {
            System.out.println("-> " + patient.getPatientName());
        }
    }

    // Method to add consultations
    public static void consult(Doctor doctor, Patient patient) {
        System.out.println(doctor.getDoctorName() + " is consulting with " + patient.getPatientName() + ".");
    }
}

public class HospitalSystem {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Hospital.Doctor doctor1 = new Hospital.Doctor("Dr. Sharma");
        Hospital.Doctor doctor2 = new Hospital.Doctor("Dr. Grewal");

        Hospital.Patient patient1 = new Hospital.Patient("Sehaj");
        Hospital.Patient patient2 = new Hospital.Patient("Charlie");
        Hospital.Patient patient3 = new Hospital.Patient("Alice");

        hospital.addDoctors(doctor1);
        hospital.addDoctors(doctor2);

        hospital.addPatients(patient1);
        hospital.addPatients(patient2);
        hospital.addPatients(patient3);

        hospital.displayPatientDetails();
        hospital.displayDoctorDetails();

        System.out.println("Consultations:");
        hospital.consult(doctor1, patient1);
        hospital.consult(doctor1, patient2);
        hospital.consult(doctor2, patient3);
        hospital.consult(doctor2, patient2);
    }
}

/*
Output:
    Patients in City Hospital:
    -> Sehaj
    -> Charlie
    -> Alice
    Doctors in City Hospital:
    -> Dr. Sharma
    -> Dr. Grewal
    Consultations:
    Dr. Sharma is consulting with Sehaj.
    Dr. Sharma is consulting with Charlie.
    Dr. Grewal is consulting with Alice.
    Dr. Grewal is consulting with Charlie.
 */