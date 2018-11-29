package BAB_3;

public class Matrik {

    private int nBaris, nKolom;
    private double[][] itemDt;

    public Matrik(int nBrs, int nKlm) {
        nBaris = nBrs;
        nKolom = nKlm;
        itemDt = new double[nBaris][nKolom];
    }

    public Matrik(double[][] A) {
        this(A.length, A[0].length);
        this.nBaris = A.length;
        this.nKolom = A[0].length;
        for (int i = 0; i < nBaris; i++) {
            for (int j = 0; j < nKolom; j++) {
                this.itemDt[i][j] = A[i][j];
            }
        }
    }

    public int getNBaris() {
        return nBaris;
    }

    public int getNKolom() {
        return nKolom;
    }

    public double getItem(int idB, int idK) {
        return this.itemDt[idB][idK];
    }

    public void setItem(int idB, int idK, double dt) {
        this.itemDt[idB][idK] = dt;
    }

    public static Matrik tambah(Matrik A, Matrik B) {
        double[][] data = new double[A.nBaris][A.nKolom];
        Matrik C = new Matrik(data);
        if ((A.nBaris == B.nBaris) && (A.nKolom == B.nKolom)) {
            for (int i = 0; i < A.nBaris; i++) {
                for (int j = 0; j < A.nKolom; j++) {
                    C.itemDt[i][j] = A.itemDt[i][j] + B.itemDt[i][j];
                }
            }
        }
        return C;
    }

    public static Larik VektorKaliMatrik(Larik L, Matrik M) {
        double[] A = new double[M.getNKolom()];
        Larik lHasil = null;
        Larik lKolom = null;
        double nKolom;
        if (L.getSize() == M.getNBaris()) {
            lHasil = new Larik(A);
            for (int i = 0; i < M.getNKolom(); i++) {
                lKolom = M.getKolom(i);
                double hasil = Larik.LarikKaliLarik(L,
                        lKolom);
                System.out.println(hasil);
                lHasil.isiItem(i, hasil);
            }
        }
        return lHasil;
    }

    public static double determinan() {
        // yang ini belom
    }

    public static Matrik tranpos(Matrik A) {
        double[][] data = new double[A.nKolom][A.nBaris];
        Matrik B = new Matrik(data);
        for (int i = 0; i < A.nBaris; i++) {
            for (int j = 0; j < A.nKolom; j++) {
                B.itemDt[j][i] = A.itemDt[i][j];
            }
        }
        return B;
    }

    public Larik getBaris(int idBaris) {
        double[] A = new double[this.nKolom];
        Larik l = new Larik(A);
        for (int i = 0; i < this.nKolom; i++) {
            double itemBaris = this.getItem(idBaris, i);
            l.isiItem(i, itemBaris);
        }
        return l;
    }

    public Larik getKolom(int idKolom) {
        double[] A = new double[this.nBaris];
        Larik l = new Larik(A);
        for (int i = 0; i < this.nBaris; i++) {
            double itemKolom = this.getItem(i, idKolom);
            l.isiItem(i, itemKolom);
        }
        return l;
    }

    public void cetak(String kom) {
        System.out.println(kom);
        for (int i = 0; i < this.nBaris; i++) {
            for (int j = 0; j < this.nKolom; j++) {
                System.out.printf("%.2f ", this.itemDt[i][j]);
            }
            System.out.println();
        }
    }
}
