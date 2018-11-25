package praktikum12;

public class main {

    public static void main(String[] args) {
        SingleLinked bubble = new SingleLinked();
        bubble.SisipDataDiAwal(54);
        bubble.SisipDataDiAwal(94);
        bubble.SisipDataDiAwal(32);
        bubble.SisipDataDiAwal(2);
        bubble.SisipDataDiAwal(10);
        bubble.SisipDataDiAwal(10);
        long mulaiBubble = System.nanoTime();
        bubble.bubblesort();
        long selesaiBubble = System.nanoTime();
        bubble.cetak();

        SingleLinked merge = new SingleLinked();
        merge.SisipDataDiAwal(10);
        merge.SisipDataDiAwal(8);
        merge.SisipDataDiAwal(29);
        merge.SisipDataDiAwal(27);
        merge.SisipDataDiAwal(76);
        merge.SisipDataDiAwal(21);
        long mulaiMerge = System.nanoTime();
        merge.pAwal = merge.mSort();
        long selesaiMerge = System.nanoTime();
        merge.cetak();

        SingleLinked insert = new SingleLinked();
        insert.SisipDataDiAwal(10);
        insert.SisipDataDiAwal(8);
        insert.SisipDataDiAwal(29);
        insert.SisipDataDiAwal(27);
        insert.SisipDataDiAwal(76);
        insert.SisipDataDiAwal(21);
        long mulaiInsert = System.nanoTime();
        insert.insertionSort(insert.pAwal);
        long selesaiInsert = System.nanoTime();
        insert.cetak();

        SingleLinked quick = new SingleLinked();
        quick.SisipDataDiAwal(10);
        quick.SisipDataDiAwal(8);
        quick.SisipDataDiAwal(29);
        quick.SisipDataDiAwal(27);
        quick.SisipDataDiAwal(76);
        quick.SisipDataDiAwal(21);
        long mulaiQuick = System.nanoTime();
        quick.quickSort(quick.pAwal);
        long selesaiQuick = System.nanoTime();
        quick.cetak();
        
        System.out.println("Waktu yang dibutuhkan:");
        System.out.println("BubbleSort " + (selesaiBubble - mulaiBubble));
        System.out.println("MergeSort " + (selesaiMerge - mulaiMerge));
        System.out.println("InsertSort " + (selesaiInsert - mulaiInsert));
        System.out.println("QuickSort " + (selesaiQuick - mulaiQuick));
        
    }
}
