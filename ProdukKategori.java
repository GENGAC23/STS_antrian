public class ProdukKategori {
   public ProdukKategori() {
   }

   public static String kategorikanProduk(String kategoriPelanggan, String namaPelanggan, String statusAntrian) {
       String hasil = "";

       // Menambahkan Pelanggan
       switch (kategoriPelanggan) {
           case "Menambahkan Pelanggan: 1":
               hasil += "andi pelanggan Reservasi";
               break;
           case "Menambahkan Pelanggan: 2":
               hasil += "rafif pelanggan non-Reservasi";
               break;
           default:
               hasil += "Pelanggan tidak dikenal";
               break;
       }

       // Memanggil Pelanggan
       switch (namaPelanggan) {
           case "andi":
               hasil += ", Reservasi";
               break;
           case "rafif":
               hasil += ", non-Reservasi";
               break;
           default:
               hasil += ", Pelanggan tidak dikenal";
               break;
       }

       // Melihat Antrian
       switch (statusAntrian) {
           case "Reservasi":
               hasil += ", tidak ada pelanggan";
               break;
           case "non-Reservasi":
               hasil += ", rafif";
               break;
           default:
               hasil += ", Status antrian tidak dikenal";
               break;
       }

       return hasil; // Pastikan untuk mengembalikan hasil
   }

   public static void main(String[] args) {
       String hasil = kategorikanProduk("Menambahkan Pelanggan: 1", "andi", "Reservasi");
       System.out.println(hasil);
   }
}
