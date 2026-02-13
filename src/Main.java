import com.airtribe.meditrack.Entity.*;
import com.airtribe.meditrack.Service.AppointmentService;
import com.airtribe.meditrack.Service.DoctorService;
import com.airtribe.meditrack.Service.PatientService;
import com.airtribe.meditrack.Util.AIHelper;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final DoctorService doctorService = new DoctorService();
    private static final PatientService patientService = new PatientService();
    private static final AppointmentService appointmentService = new AppointmentService();

    public static void main(String[] args) {

        System.out.println("===== Welcome to MediTrack =====");

        while (true) {
            printDashboard();

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    doctorMenu();
                    break;
                case 2:
                    patientMenu();
                    break;
                case 3:
                    appointmentMenu();
                    break;
                case 4:
                    recommendDoctor();
                    break;
                case 0:
                    System.out.println("Exiting MediTrack...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // ================= DASHBOARD =================

    private static void printDashboard() {
        System.out.println("\n==== Dashboard ====");
        System.out.println("1. Doctor Management");
        System.out.println("2. Patient Management");
        System.out.println("3. Appointment Management");
        System.out.println("4. AI Recommendation");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    // ================= DOCTOR MENU =================

    private static void doctorMenu() {
        while (true) {
            System.out.println("\n--- Doctor Management ---");
            System.out.println("1. Add Doctor");
            System.out.println("2. View All Doctors");
            System.out.println("3. Update Doctor Fee");
            System.out.println("4. Update Specialization");
            System.out.println("5. Delete Doctor");
            System.out.println("0. Back");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    addDoctor();
                    break;
                case 2:
                    doctorService.getAllDoctors()
                            .forEach(System.out::println);
                    break;
                case 3:
                    updateDoctorFee();
                    break;
                case 4:
                    updateDoctorSpecialization();
                    break;
                case 5:
                    deleteDoctor();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // ================= PATIENT MENU =================

    private static void patientMenu() {
        while (true) {
            System.out.println("\n--- Patient Management ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Update Disease");
            System.out.println("4. Delete Patient");
            System.out.println("5. Search Patient");
            System.out.println("0. Back");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    patientService.getAllPatients()
                            .forEach(System.out::println);
                    break;
                case 3:
                    updatePatientDisease();
                    break;
                case 4:
                    deletePatient();
                    break;
                case 5:
                    searchPatient();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // ================= APPOINTMENT MENU =================

    private static void appointmentMenu() {
        while (true) {
            System.out.println("\n--- Appointment Management ---");
            System.out.println("1. Create Appointment");
            System.out.println("2. Confirm Appointment");
            System.out.println("3. View All Appointments");
            System.out.println("4. Generate Bill");
            System.out.println("0. Back");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    createAppointment();
                    break;
                case 2:
                    confirmAppointment();
                    break;
                case 3:
                    appointmentService.getAllAppointments()
                            .forEach(System.out::println);
                    break;
                case 4:
                    generateBill();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // ================= DOCTOR OPERATIONS =================

    private static void addDoctor() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = getIntInput();

        System.out.print("Specialization (CARDIOLOGY, DERMATOLOGY, ORTHOPEDICS, GENERAL_MEDICINE): ");
        Specialization specialization =
                Specialization.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Consultation Fee: ");
        double fee = Double.parseDouble(scanner.nextLine());

        Doctor doctor = doctorService.addDoctor(name, age, specialization, fee);
        System.out.println("Doctor added: " + doctor);
    }

    private static void updateDoctorFee() {
        System.out.print("Doctor ID: ");
        String id = scanner.nextLine();

        System.out.print("New Fee: ");
        double fee = Double.parseDouble(scanner.nextLine());

        doctorService.updateDoctorFee(id, fee);
        System.out.println("Doctor fee updated.");
    }

    private static void updateDoctorSpecialization() {
        System.out.print("Doctor ID: ");
        String id = scanner.nextLine();

        System.out.print("New Specialization: ");
        Specialization spec =
                Specialization.valueOf(scanner.nextLine().toUpperCase());

        doctorService.updateSpecialization(id, spec);
        System.out.println("Specialization updated.");
    }

    private static void deleteDoctor() {
        System.out.print("Doctor ID: ");
        String id = scanner.nextLine();

        doctorService.deleteDoctor(id);
        System.out.println("Doctor deleted.");
    }

    // ================= PATIENT OPERATIONS =================

    private static void addPatient() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = getIntInput();

        System.out.print("Disease: ");
        String disease = scanner.nextLine();

        Patient patient = patientService.addPatient(name, age, disease);
        System.out.println("Patient added: " + patient);
    }

    private static void updatePatientDisease() {
        System.out.print("Patient ID: ");
        String id = scanner.nextLine();

        System.out.print("New Disease: ");
        String disease = scanner.nextLine();

        patientService.updateDisease(id, disease);
        System.out.println("Disease updated.");
    }

    private static void deletePatient() {
        System.out.print("Patient ID: ");
        String id = scanner.nextLine();

        patientService.deletePatient(id);
        System.out.println("Patient deleted.");
    }

    private static void searchPatient() {
        System.out.print("Enter keyword: ");
        String keyword = scanner.nextLine();

        patientService.searchPatients(keyword)
                .forEach(System.out::println);
    }

    // ================= APPOINTMENT OPERATIONS =================

    private static void createAppointment() {
        System.out.print("Doctor ID: ");
        Doctor doctor = doctorService.getDoctorById(scanner.nextLine());

        System.out.print("Patient ID: ");
        Patient patient = patientService.getPatientById(scanner.nextLine());

        Appointment appointment = appointmentService.createAppointment(
                doctor,
                patient,
                AIHelper.suggestAppointmentTime()
        );

        System.out.println("Appointment created: " + appointment);
    }

    private static void confirmAppointment() {
        System.out.print("Appointment ID: ");
        appointmentService.confirmAppointment(scanner.nextLine());
        System.out.println("Appointment confirmed.");
    }

    private static void generateBill() {
        System.out.print("Appointment ID: ");
        Bill bill = appointmentService.generateBill(scanner.nextLine());
        System.out.println(bill.generateSummary());
    }

    // ================= AI =================

    private static void recommendDoctor() {
        System.out.print("Enter symptom: ");
        String symptom = scanner.nextLine();

        Specialization recommended =
                AIHelper.recommendSpecialization(symptom);

        System.out.println("Recommended Specialization: " + recommended);

        doctorService.getAllDoctors()
                .stream()
                .filter(d -> d.getSpecialization() == recommended)
                .forEach(System.out::println);
    }

    // ================= UTILITY =================

    private static int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
