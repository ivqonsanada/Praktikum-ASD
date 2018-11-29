package Praktikum4;

public class Buku {

    String kategori;
    String judul;
    double hargaSewa;
    double hargaDenda;

    public Buku(String kateg, String judul, double hrgaS, double hrgaD) {
        this.kategori = kateg;
        this.judul = judul;
        this.hargaSewa = hrgaS;
        this.hargaDenda = hrgaD;
    }

    double getHargaSewa() {
        return hargaSewa;
    }

    double getHargaDenda() {
        return hargaDenda;
    }

    String getKategori() {
        return kategori;
    }

    String getJudul() {
        return judul;
    }
}
