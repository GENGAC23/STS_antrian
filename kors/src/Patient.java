import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Patient {
    private String name;
    private String category;

    public Patient(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
}

class ClinicQueue {
    private List<Patient> queue;

    public ClinicQueue() {
        // Inisialisasi list pasien
        queue = new ArrayList<>();
    }

    // Menambah pasien ke dalam antrian
    public void addPatient(String name, String category) {
        Patient patient = new Patient(name, category);
        queue.add(patient);
        System.out.println("Pasien " + name + " dengan kategori " + category + " ditambahkan ke antrian.");
    }

    // Memanggil pasien dengan prioritas tertinggi
    public void callPatient() {
        if (!queue.isEmpty()) {
            Patient nextPatient = getNextPatient();
            if (nextPatient != null) {
                System.out.println("Memanggil pasien " + nextPatient.getName() + " dengan kategori " + nextPatient.getCategory() + ".");
                queue.remove(nextPatient); // Hapus pasien yang dipanggil
            }
        } else {
            System.out.println("Tidak ada pasien dalam antrian.");
        }
    }

    // Mendapatkan pasien dengan prioritas tertinggi (manual sorting)
    private Patient getNextPatient() {
        for (Patient patient : queue) {
            if (patient.getCategory().equals("Darurat")) {
                return patient;
            }
        }
        for (Patient patient : queue) {
            if (patient.getCategory().equals("Lansia")) {
                return patient;
            }
        }
        return queue.get(0); // Pasien umum jika tidak ada pasien darurat/lansia
    }

    // Melihat daftar antrian pasien
    public void viewQueue() {
        if (queue.isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Daftar pasien dalam antrian:");
            for (int i = 0; i < queue.size(); i++) {
                Patient patient = queue.get(i);
                System.out.println((i + 1) + ". " + patient.getName() + " - " + patient.getCategory());
            }
        }
    }

    // Menampilkan jumlah pasien dalam antrian
    public void countPatients() {
        System.out.println("Jumlah pasien dalam antrian: " + queue.size());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClinicQueue queue = new ClinicQueue();
        boolean running = true;

        // Menu interaktif
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Pasien");
            System.out.println("2. Panggil Pasien");
            System.out.println("3. Lihat Antrian");
            System.out.println("4. Jumlah Pasien di Antrian");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Masukkan nama pasien: ");
                    String name = scanner.nextLine();
                    System.out.print("Kategori (Umum, Lansia, Darurat): ");
                    String category = scanner.nextLine();
                    if (category.equalsIgnoreCase("Umum") || category.equalsIgnoreCase("Lansia") || category.equalsIgnoreCase("Darurat")) {
                        queue.addPatient(name, category);
                    } else {
                        System.out.println("Kategori tidak valid! Masukkan kategori yang benar.");
                    }
                    break;
                case "2":
                    queue.callPatient();
                    break;
                case "3":
                    queue.viewQueue();
                    break;
                case "4":
                    queue.countPatients();
                    break;
                case "5":
                    System.out.println("Terima kasih, program selesai.");
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan coba lagi.");
            }
        }
        scanner.close();
    }
}
