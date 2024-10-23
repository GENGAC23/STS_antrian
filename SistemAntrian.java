import java.util.ArrayList;
import java.util.Scanner;

class Pelanggan {
    String nama;
    String jenisLayanan;

    public Pelanggan(String nama, String jenisLayanan) {
        this.nama = nama;
        this.jenisLayanan = jenisLayanan;
    }
}

public class SistemAntrianRestoran {
    private ArrayList<Pelanggan> antrian;

    public SistemAntrianRestoran() {
        antrian = new ArrayList<>();
    }

    // Menambahkan pelanggan ke antrian
    public void tambahPelanggan(String nama, String jenisLayanan) {
        antrian.add(new Pelanggan(nama, jenisLayanan));
        System.out.println(nama + " telah ditambahkan ke antrian sebagai " + jenisLayanan);
    }

    // Memanggil pelanggan berdasarkan prioritas
    public void panggilPelanggan() {
        if (antrian.isEmpty()) {4
            
            System.out.println("Antrian kosong!");
            return;
        }

        for (int i = 0; i < antrian.size(); i++) {
            if (antrian.get(i).jenisLayanan.equalsIgnoreCase("Reservasi")) {
                System.out.println("Pelanggan yang dipanggil: " + antrian.get(i).nama);
                antrian.remove(i);
                return;
            }
        }

        // Jika tidak ada pelanggan dengan reservasi, panggil pelanggan pertama di antrian
        System.out.println("Pelanggan yang dipanggil: " + antrian.get(0).nama);
        antrian.remove(0);
    }

    // Melihat daftar antrian
    public void lihatAntrian() {
        if (antrian.isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }

        System.out.println("Daftar pelanggan yang sedang menunggu:");
        for (Pelanggan p : antrian) {
            System.out.println("- " + p.nama + " (" + p.jenisLayanan + ")");
        }
    } public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemAntrianRestoran sistem = new SistemAntrianRestoran();
        int pilihan;

        do {
            System.out.println("\n=== Sistem Antrian Restoran ===");
            System.out.println("1. Tambah Pelanggan");
            System.out.println("2. Panggil Pelanggan");
            System.out.println("3. Lihat Antrian");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // membersihkan newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama pelanggan: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan jenis layanan (Reservasi/Tanpa Reservasi): ");
                    String layanan = scanner.nextLine();
                    sistem.tambahPelanggan(nama, layanan);
                    break;
                case 2:
                    sistem.panggilPelanggan();
                    break;
                case 3:
                    sistem.lihatAntrian();
                    break;
                case 4:
                    System.out.println("Keluar dari sistem. Terima kasih!");
                    break;
                default:
                    System.out.println("Opsi tidak valid. Silahkan pilih lagi.");
                    break;
            }
        } while (pilihan != 4);
        
        scanner.close();
    }
}