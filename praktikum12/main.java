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
        bubble.bubblesort();
        bubble.cetak();

        SingleLinked merge = new SingleLinked();
        merge.SisipDataDiAwal(10);
        merge.SisipDataDiAwal(8);
        merge.SisipDataDiAwal(29);
        merge.SisipDataDiAwal(27);
        merge.SisipDataDiAwal(76);
        merge.SisipDataDiAwal(21);
        merge.pAwal = merge.mSort();
        merge.cetak();

        SingleLinked insert = new SingleLinked();
        insert.SisipDataDiAwal(10);
        insert.SisipDataDiAwal(8);
        insert.SisipDataDiAwal(29);
        insert.SisipDataDiAwal(27);
        insert.SisipDataDiAwal(76);
        insert.SisipDataDiAwal(21);
        insert.insertionSort(insert.pAwal);
        insert.cetak();

        SingleLinked quick = new SingleLinked();
        quick.SisipDataDiAwal(10);
        quick.SisipDataDiAwal(8);
        quick.SisipDataDiAwal(29);
        quick.SisipDataDiAwal(27);
        quick.SisipDataDiAwal(76);
        quick.SisipDataDiAwal(21);
        quick.quickSort(quick.pAwal);
        quick.cetak();
    }
}
