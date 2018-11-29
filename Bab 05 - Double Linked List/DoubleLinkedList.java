package Bab_5;
import static asd_bab_5.main.masukan;
import java.util.Scanner;
class NodeDLL {
    Buku data;
    NodeDLL prev, next;
}
public class DoubleLinkedList {
    private NodeDLL pKepala, pEkor;
    public void sisipDipKepala(Buku data) {
        NodeDLL baru = new NodeDLL();
        baru.data = data;
        baru.prev = null;
        baru.next = pKepala;
        if (pKepala != null) {
            pKepala.prev = baru;
        }
        pKepala = baru;
        pEkor = pKepala;
        while (pEkor.next != null) {
            pEkor = pEkor.next;
        }
    }
    public void sisipDipEkor(Buku data) {
        NodeDLL baru = new NodeDLL();
        pEkor = pKepala;
        baru.data = data;
        baru.next = null;
        if (pKepala == null) {
            baru.prev = null;
            pKepala = baru;
            return;
        }
        while (pEkor.next != null) {
            pEkor = pEkor.next;
        }
        pEkor.next = baru;
        baru.prev = pEkor;
    }
    public void cetak(String kom) {
        System.out.println(kom);
        NodeDLL p = pKepala;
        while (p != null) {
            System.out.print(
                    "------------------------------------\n"
                    + "Kategori: " + p.data.getKategori() + "\n"
                    + "Judul: " + p.data.getJudul() + "\n"
                    + "Harga Sewa: " + p.data.getHargaSewa() + "\n"
                    + "Harga Denda: " + p.data.getHargaDenda() + "\n"
            );
            p = p.next;
        }
        System.out.println();
    }
    public void hapusDataTertentu(String hapus) {
        NodeDLL p = pKepala;
        if (pKepala.data.getJudul().equals(hapus)) {
            pKepala = p.next;
            return;
        }
        while (p.next != null) {
            if (!p.next.data.getJudul().equals(hapus)) {
                p = p.next;
            } else {
                if (p.next.next != null) {
                    p.next.next.prev = p;
                    p.next = p.next.next;
                    break;
                } else {
                    p.next = null;
                }
            }
        }
    }
    public void sisipDataTerurut(Buku data) {
        NodeDLL temp = new NodeDLL();
        temp.data = data;
        if (pKepala == null) {
            pKepala = temp;
        } else {
            NodeDLL a = pKepala;
            temp = null;
            while (a != null && a.data.getHargaSewa() < data.getHargaSewa()) {
                temp = a;
                a = a.next;
            }
            while (a != null && a.data.getHargaDenda() < data.getHargaDenda() && a.data.getHargaSewa() == data.getHargaSewa()) {
                temp = a;
                a = a.next;
            }
            if (temp != null) {
                NodeDLL baru = new NodeDLL();
                baru.data = data;
                baru.next = a;
                temp.next = baru;
                baru.prev = temp;
            } else {
                sisipDipKepala(data);
            }
        }
    }
    static DoubleLinkedList dll = new DoubleLinkedList();
    static DoubleLinkedList dll2 = new DoubleLinkedList();
    public void masukanData() {
        Scanner inKu = new Scanner(System.in);
        System.out.print("Kategori: ");
        String kategori = inKu.next();
        System.out.print("Judul: ");
        inKu.nextLine();
        String judul = inKu.nextLine();
        System.out.print("Harga Sewa: ");
        int sewa = inKu.nextInt();
        System.out.print("Harga Denda: ");
        int denda = inKu.nextInt();
        System.out.println("====================================");
        switch (masukan) {
            case 1:
                dll.sisipDipKepala(new Buku(kategori, judul, sewa, denda));
                dll.cetak("Isi DLL setelah sisip data di pKepala");
                break;
            case 2:
                dll.sisipDipEkor(new Buku(kategori, judul, sewa, denda));
                dll.cetak("Isi DLL setelah sisip data di pEkor");
                break;
            case 4:
                dll2.sisipDataTerurut(new Buku(kategori, judul, sewa, denda));
                dll2.cetak("Isi dll2 sisip data terurut ");
                break;
        }
    }
}
