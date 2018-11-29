package Bab_5;
import static asd_bab_5.DoubleLinkedList.dll;
import java.util.Scanner;
public class main {
    static byte masukan;
    public static void main(String s[]) {
        Scanner inKu = new Scanner(System.in);
        do {
            System.out.println("====================================");
            System.out.println("Menu: ");
            System.out.println("1. sisip data di pKepala");
            System.out.println("2. sisip data di pEkor");
            System.out.println("3. hapus data tertentu");
            System.out.println("4. sisip data terurut");
            System.out.println("5. Exit");
            System.out.println("====================================");
            System.out.print("Pilih: ");
            masukan = inKu.nextByte();
            System.out.println("====================================");
            if (masukan < 5 & masukan > 0 & masukan != 3) {
                dll.masukanData();
            } else if (masukan == 3) {
                System.out.print("Judul Buku yang ingin dihapus: ");
                inKu.nextLine();
                String judul = inKu.nextLine();
                dll.hapusDataTertentu(judul);
                System.out.println("------------------------------------");
                dll.cetak("Isi DLL setelah data  dihapus");
            }
        } while (masukan != 5);
    }
}
