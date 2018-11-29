package BAB_2;
public class Larik {
    private int size;
    private double[] itemDt;
    public Larik(double[] A) {
        this.size = A.length;
        this.itemDt = new double[this.size];
        for (int i = 0; i < this.size; i++) {
            this.itemDt[i] = A[i];
        }
    }
    public int getSize() {
        return this.size;
    }
    public double getItem(int i) {
        return this.itemDt[i];
    }
    public static Larik sambung(Larik l1, Larik l2) {
        double[] a = new double[l1.size + l2.size];
        Larik l3 = new Larik(a);
        for (int i = 0; i < l3.size; i++) {
            if (i < l1.size) {
                l3.itemDt[i] = l1.itemDt[i];
            } else {
                l3.itemDt[i] = l2.itemDt[i - l1.size];
            }
        }
        return l3;
    }
    public void isiItem(int id, double dt) {
        this.itemDt[id] = dt;
    }
    public void cetak(String komentar) {
        System.out.println(komentar);
        for (int i = 0; i < this.size; i++) {
            System.out.printf("%.2f ", this.itemDt[i]);
        }
        System.out.println();
    }
    public double findBesar() {
        double besar = this.itemDt[0];
        for (int i = 1; i < this.size; i++) {
            if (besar < this.itemDt[i]) {
                besar = this.itemDt[i];
            }
        }
        return besar;
    }
    public int getPosisi(double dtCari) {
        int pos = -99;
        boolean ketemu = false;
        int i = 0;
        while (!ketemu && i < this.size) {
            if (dtCari == this.itemDt[i]) {
                ketemu = true;
                pos = i;
            }
            i++;
        }
        return pos;
    }
    public static Larik copyLarik(int k, int n, Larik l) {
        double[] a = new double[n];
        Larik l2 = new Larik(a);
        for (int i = 0; i < n; i++) {
            l2.itemDt[i] = l.itemDt[i];
        }
        return l2;
    }
    public int getPosBesar(int awal, int akhir) {
        int posBesar = -1;
        double itemBesar;
        if (awal <= akhir) {
            posBesar = awal;
            itemBesar = this.getItem(awal);
            for (int i = awal + 1; i < akhir; i++) {
                double nilaiItem = this.getItem(i);
                if (itemBesar < nilaiItem) {
                    itemBesar = nilaiItem;
                    posBesar = i;
                }
            }
        }
        return posBesar;
    }
    public int getPosKecil(int awal, int akhir) {
        int posKecil = -1;
        double itemKecil;
        if (awal <= akhir) {
            posKecil = awal;
            itemKecil = this.getItem(awal);
            for (int i = awal + 1; i < akhir; i++) {
                double nilaiItem = this.getItem(i);
                if (itemKecil > nilaiItem) {
                    itemKecil = nilaiItem;
                    posKecil = i;
                }
            }
        }
        return posKecil;
    }
    public static double LarikKaliLarik(Larik l1, Larik l2) {
        double hasilKali = 0;
        if (l1.size == l2.size) {
            for (int i = 0; i < l1.size; i++) {
                hasilKali += l1.itemDt[i] * l2.itemDt[i];
            }
        }
        return hasilKali;
    }
    public void findPosKelipatan(int kelipatan, int awal, int akhir) {
        System.out.println("Posisi Kelipatan " +kelipatan+" pada range "+awal+"-"+akhir);
        for (; awal <= akhir; awal++) {
            if (itemDt[awal] % kelipatan == 0) {
                System.out.println(awal);
            }
        }
    }
    public static Larik BubbleSort(Larik L1) {
        int n = L1.getSize();
        Larik Bsort = Larik.copyLarik(0, n, L1);
        boolean swapped = true;
        do {
            swapped = false;
            for (int i = 0; i < Bsort.size - 1; i++) {
                if (Bsort.itemDt[i] > Bsort.itemDt[i + 1]) {
                    double temp = Bsort.itemDt[i];
                    Bsort.itemDt[i] = Bsort.itemDt[i + 1];
                    Bsort.itemDt[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
        return Bsort;
    }
}
