import java.util.*;

public class SistemWaktuAdzan {

    // Data waktu adzan (hardcoded)
    private static List<WaktuAdzan> jadwalAdzan = new ArrayList<>(Arrays.asList(
            new WaktuAdzan("Subuh", "04:30"),
            new WaktuAdzan("Dzuhur", "12:00"),
            new WaktuAdzan("Ashar", "15:30"),
            new WaktuAdzan("Maghrib", "18:00"),
            new WaktuAdzan("Isya", "19:30")
    ));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            // Tampilkan menu
            tampilkanMenu();
            System.out.print("Pilih menu (1-4): ");
            int pilihan = scanner.nextInt();

            // Percabangan menu
            switch (pilihan) {
                case 1:
                    tampilkanJadwalAdzan();
                    break;
                case 2:
                    System.out.print("Masukkan nama waktu adzan (Subuh/Dzuhur/Ashar/Maghrib/Isya): ");
                    scanner.nextLine(); // Clear buffer
                    String namaAdzan = scanner.nextLine();
                    cariWaktuAdzan(namaAdzan);
                    break;
                case 3:
                    urutkanJadwalAdzan();
                    break;
                case 4:
                    System.out.println("Keluar dari program...");
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
        scanner.close();
    }

    // Fungsi untuk menampilkan menu
    private static void tampilkanMenu() {
        System.out.println("\n=== Sistem Waktu Adzan ===");
        System.out.println("1. Lihat semua waktu adzan");
        System.out.println("2. Cari waktu adzan tertentu");
        System.out.println("3. Urutkan jadwal adzan berdasarkan waktu");
        System.out.println("4. Keluar");
    }

    // Fungsi untuk menampilkan semua jadwal adzan
    private static void tampilkanJadwalAdzan() {
        System.out.println("\nJadwal Waktu Adzan:");
        for (WaktuAdzan waktu : jadwalAdzan) {
            System.out.println(waktu.getNama() + ": " + waktu.getWaktu());
        }
    }

    // Fungsi untuk mencari waktu adzan tertentu (Searching)
    private static void cariWaktuAdzan(String namaAdzan) {
        boolean ditemukan = false;
        for (WaktuAdzan waktu : jadwalAdzan) {
            if (waktu.getNama().equalsIgnoreCase(namaAdzan)) {
                System.out.println("Waktu Adzan " + namaAdzan + ": " + waktu.getWaktu());
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Waktu adzan " + namaAdzan + " tidak ditemukan.");
        }
    }

    // Fungsi untuk mengurutkan jadwal adzan berdasarkan waktu (Sorting)
    private static void urutkanJadwalAdzan() {
        jadwalAdzan.sort(Comparator.comparing(WaktuAdzan::getWaktu));
        System.out.println("\nJadwal adzan berhasil diurutkan berdasarkan waktu:");
        tampilkanJadwalAdzan();
    }

    // Kelas WaktuAdzan
    private static class WaktuAdzan {
        private String nama;
        private String waktu;

        public WaktuAdzan(String nama, String waktu) {
            this.nama = nama;
            this.waktu = waktu;
        }

        public String getNama() {
            return nama;
        }

        public String getWaktu() {
            return waktu;
        }
    }
}
