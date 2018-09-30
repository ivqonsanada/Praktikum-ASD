package praktikum5;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        CircularSingleLinkedList csll = new CircularSingleLinkedList();
        Scanner in = new Scanner(System.in);
        String cuy = "";
        Buku buku1 = new Buku("Komputer", "Pemrograman Java", 2000, 3000);
        Buku buku2 = new Buku("Pendidikan", "Matematika SMA", 2500, 2500);
        Buku buku3 = new Buku("Komputer", "Belajar Microsoft Office", 2000, 7000);
        Buku buku4 = new Buku("Novel", "Laskar Pelangi", 1000, 4000);
        Buku buku5 = new Buku("Komik", "Doraemon", 2000, 5000);
        csll.SisipDataDiAwal(buku1);
        csll.SisipDataDiAwal(buku2);
        csll.SisipDataDiAwal(buku3);
        csll.SisipDataDiAwal(buku4);
        csll.SisipDataDiAwal(buku5);
        csll.SisipDataDiAwal(buku3);
        do {
            System.out.println("MASUKKAN PERBANDINGAN NILAI");
            cuy = in.nextLine();
        } while (!cuy.equals("lebihdari") && !cuy.equals("samadengan") && !cuy.equals("kurangdari"));
        System.out.println("MASUKKAN HARGA");
        int hello = in.nextInt();
        csll.cetakBuku(cuy, hello);
        csll.cetak("csll Asal");
        csll.hapusData(buku1);
        csll.cetak("csll stl 8 di hapus");
        csll.hapusData(buku2);
        csll.cetak("csll stl 90 di hapus");
    }
}
