package ADT_Larik;

public class AppPr1 {

    public static void main(String[] args) {
        double[] A = {3, 4, 1, 10, 5, 2, 10, 20, 16};
        double[] B = {4, 3, 1, 11, 7};
        Larik L1 = new Larik(A);
        Larik L2 = new Larik(B);
        
        L1.cetak("L1");
        L2.cetak("L2");
        Larik L3 = Larik.sambung(L1, L2);
        L3.cetak("L3");
        Larik L4 = Larik.copyLarik(0, L1.getSize(), L1);
        L1.cetak("L1");
        L4.cetak("L4");
        
        Larik L5 = Larik.SelectionSort(L1, 0);
        L5.cetak("L5");
        L1.cetak("L1");
        int[] posisi = L1.FindPosPos(10);
        
        double hasil = Larik.LarikKaliLarik(L1, L4);
        System.out.printf("HASIL KALI %.3f\n", hasil);
    }
}
