package BAB_4;
public class main {
    public static void main(String[] args) {
        Buku buku1 = new Buku("Komputer", "Pemrograman Java", 2000, 3000);
        Buku buku2 = new Buku("Pendidikan", "Matematika SMA", 2500, 2500);
        Buku buku3 = new Buku("Komputer", "Belajar Microsoft Office", 2000, 7000);
        Buku buku4 = new Buku("Novel", "Laskar Pelangi", 1000, 4000);
        Buku buku5 = new Buku("Komik", "Doraemon", 2000, 5000);
        SingleLinkedList ll = new SingleLinkedList();
        ll.sisipDataUrut(buku1);
        ll.sisipDataUrut(buku2);
        ll.sisipDataUrut(buku3);
        ll.sisipDataUrut(buku4);
        ll.sisipDataUrut(buku5);
        ll.cetak("LINKED LIST BUKU");
    }
}
