package ADT_Larik;

/**
 *
 * @author achmad ridok
 *
 */
public class Larik {
//data (strukur data)

    private int size;
    private double[] itemDt;

    /**
     * Contructor untuk membuat ADT larik dari suatu array
     *
     * @param A : array bertipe int
     */
    public Larik(double[] A) {
        this.size = A.length;
        this.itemDt = new double[this.size];
        for (int i = 0; i < this.size; i++) {
            this.itemDt[i] = A[i];
        }
    }

    /**
     * fungsi untu mendapatkan ukuran larik
     *
     * @return size dari larik
     */
    public int getSize() {
        return this.size;
    }

    /**
     * fungsi untuk mendapatkan item ke i dari suatu larik
     *
     * @param i : posisi item
     * @return item larik
     */
    public double getItem(int i) {
        return this.itemDt[i];
    }

    /**
     * fungsi static untuk menyambung dua buah larik l1 dan l2
     *
     * @param l1 : Larik
     * @param l2 : Larik
     * @return Larik
     */
    public static Larik sambung(Larik l1, Larik l2) {
// Lengkapi bagian ini
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

    /**
     * procedure untuk isiItem suatu larik
     *
     * @param id : indeks larik
     * @param dt : item data yang akan disisipkan
     */
    public void isiItem(int id, double dt) {
        this.itemDt[id] = dt;
    }

    /**
     * procedure cetak suatu array
     *
     * @param komentar : String
     */
    public void cetak(String komentar) {
        System.out.println(komentar);
        for (int i = 0; i < this.size; i++) {
            System.out.printf("%.2f ", this.itemDt[i]);
        }
        System.out.println();
    }

    /**
     * fungsi untuk mendapatkan nilai terbesar dari suatu larik
     *
     * @return : item tebesar dari larik
     */
    public double findBesar() {
        double besar = this.itemDt[0];
        for (int i = 1; i < this.size; i++) {
            if (besar < this.itemDt[i]) {
                besar = this.itemDt[i];
            }
        }
        return besar;
    }

    /**
     * fungsi untuk mencari posisi suatu data tertentu di array
     *
     * @param dtCari : data yang akan dicari
     * @return posisiData
     */
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

    /**
     * fungsi static untuk mencopy isi suatu larik l
     *
     * @param k : posisi awal
     * @param n : jumlah item yang akan dicopy
     * @param l : larik asal
     * @return Larik hasil copy
     */
    public static Larik copyLarik(int k, int n, Larik l) {
        // lenkapi bagian ini
        double[] a = new double[n];
        Larik l2 = new Larik(a);
        for (int i = 0; i < n; i++) {
            l2.itemDt[i] = l.itemDt[i];
        }
        return l2;
    }

    /**
     * fungsi untuk mencari posisi terbesar suatu data suatu posisi awal sampai
     * akhir
     *
     * @param awal : posisi awal
     * @param akhir : posisi akhir
     * @return posisi data terbesar
     */
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

    /**
     * fungsi untuk mencari posisi data terkecil suatu array mulai dari posisi
     * awal sampai posisi akhir
     *
     * @param awal : posisi awal
     * @param akhir : posisi akhir
     * @return posisi data terkecil
     */
    public int getPosKecil(int awal, int akhir) {
// lenkapi bagian ini
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

    /**
     * fungsi pengurutan suatu larik lAsal dimana kondisi lAsal akan tetap
     * setelah proses pengurutan
     *
     * @param lAsal : Array asal yang akan diurutkan
     * @param status : 0-> urut dari kecil ke besar 1-> urut dari besar ke kecil
     *
     *
     * @return Array baru hasil pengurutan
     */
    public static Larik SelectionSort(Larik lAsal, int status) {

        int n = lAsal.getSize();
        Larik lhasil = Larik.copyLarik(0, n, lAsal);
        if (status == 0) {// urutkan data dari kecil ke besar

            for (int i = 0; i < n; i++) {
                int posKecil = lhasil.getPosKecil(i,
                        n);

                double itemKecil
                        = lhasil.getItem(posKecil);

                double itemI = lhasil.getItem(i);
                lhasil.isiItem(i, itemKecil);
                lhasil.isiItem(posKecil, itemI);
            }
        } else { // urutkan data dari besar ke kecil
            for (int i = 0; i < n; i++) {
                int posBesar = lhasil.getPosBesar(i,
                        n);

                double itemBesar
                        = lhasil.getItem(posBesar);

                double itemI = lhasil.getItem(i);
                lhasil.isiItem(i, itemBesar);
                lhasil.isiItem(posBesar, itemI);
            }
        }
        return lhasil;
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

}
