package BAB_1;
public class Buku {
    private String namaBuku;
    private String kategori;
    private int sewa;
    private int denda;
    public Buku(){}
    public Buku(String namaBuku, String kategori, int sewa, int denda) {
        this.namaBuku = namaBuku;
        this.kategori = kategori;
        this.sewa = sewa;
        this.denda = denda;
    }
    public String getNamaBuku() {return namaBuku;}
    public String getKategori() {return kategori;}
    public int getDenda(int jumlahHari) {return jumlahHari*denda;}
    public int getSewa(int jumlahHari) {return jumlahHari*sewa;}
}
