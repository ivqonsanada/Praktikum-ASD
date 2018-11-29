package BAB_2;
public class main {
    public static void main(String[] args) {
        double[] A = {3, 4, 1, 10, 5, 2, 10, 20, 16};
        double[] B = {4, 3, 1, 11, 7};
        Larik L1 = new Larik(A);
        Larik L2 = new Larik(B);
        L1.cetak("L1");
        L2.cetak("L2");
        Larik L3 = Larik.sambung(L1, L2);
        L3.cetak("L3 (Menyambung L1 dan L2)");
        Larik L4 = Larik.copyLarik(0, L1.getSize(), L1);
        L1.cetak("L1");
        L4.cetak("L4 (Menyalin L1)");
        Larik L5 = Larik.BubbleSort(L1);
        L5.cetak("L5 (Mengurutkan L1)");
        L1.cetak("L1");
        L1.findPosKelipatan(5, 0, 4);
        double hasil = Larik.LarikKaliLarik(L1, L4);
        System.out.printf("HASIL KALI %.3f\n", hasil);
    }
}
