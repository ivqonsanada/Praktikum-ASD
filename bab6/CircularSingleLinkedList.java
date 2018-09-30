package praktikum5;

public class CircularSingleLinkedList {

    private NodeCSLL pAwal, pAkhir;
    private int counter;

    public CircularSingleLinkedList() {
        pAwal = null;
        pAkhir = null;
        counter = -1;
    }

    public void SisipDataDiAwal(Buku data) {
        NodeCSLL pBaru = new NodeCSLL();
        pBaru.data = data;
        pBaru.next = null;
        if (pAwal == null) {
            pAwal = pBaru;
            pAkhir = pBaru;
            pBaru.next = pAwal;
            pBaru.prev = pAkhir;
            counter = 0;
        } else {
            pBaru.next = pAwal;
            pAwal.prev = pBaru;
            pAwal = pBaru;
            pAwal.prev = pAkhir;
            pAkhir.next = pAwal;
            counter++;
        }
    }

    public void hapusData(Buku dtHapus) {
        if (pAwal != null) {
            NodeCSLL pSbl, pKini, pHapus;
            pSbl = null;
            pKini = pAwal;
            boolean ketemu = false;
            int i = -1;
            if (pAwal != null) {
                i = 0;
            }
            while (!ketemu && (i <= counter) && (i != -1)) {
                if (pKini.data.equals(dtHapus)) {
                    ketemu = true;
                } else {
                    pSbl = pKini;
                    pKini = pKini.next;
                }
                i++;
            }
            if (ketemu) {
                if (pSbl == null) {
                    pHapus = pAwal;
                    pHapus = null;
                } else {
                    pSbl.next = pKini.next;
                    pKini.prev = pSbl.prev;
                    pHapus = pKini;
                    pHapus = null;
                }
                this.counter--;
            }
        }
    }

    public Buku hapusSatuDataDiAkhir() {
        NodeCSLL temp = pAwal;
        while (temp.next != pAkhir) {
            temp = temp.next;
        }
        temp.next = pAwal;
        pAkhir = temp;
        pAwal.prev = temp;
        return temp.next.data;
    }

    public void cetakBuku(String param, double hargaSewa) {
        NodeCSLL pCetak;
        pCetak = pAwal;
        int i = -1;
        System.out.println("Buku dengan harga " + param +" " + hargaSewa);
        if (param.equals("lebihdari")) {
            while ((i < counter)) {
                if (pCetak.data.getHargaSewa() > hargaSewa) {
                    System.out.println("==================");
                    System.out.println("JUDUL       :" + pCetak.data.getJudul());
                    System.out.println("KATEGORI    :" + pCetak.data.getKategori());
                    System.out.println("HARGA SEWA  :" + pCetak.data.getHargaSewa());
                    System.out.println("==================");
                    pCetak = pCetak.next;
                    i++;
                }
            }
        } else if (param.equals("kurangdari")) {
            while ((i < counter)) {
                if (pCetak.data.getHargaSewa() < hargaSewa) {
                    System.out.println("==================");
                    System.out.println("JUDUL       :" + pCetak.data.getJudul());
                    System.out.println("KATEGORI    :" + pCetak.data.getKategori());
                    System.out.println("HARGA SEWA  :" + pCetak.data.getHargaSewa());
                    System.out.println("==================");
                    pCetak = pCetak.next;
                    i++;
                }
            }
        } else if (param.equals("samadengan")) {
            while ((i < counter)) {
                if (pCetak.data.getHargaSewa() == hargaSewa) {
                    System.out.println("==================");
                    System.out.println("JUDUL       :" + pCetak.data.getJudul());
                    System.out.println("KATEGORI    :" + pCetak.data.getKategori());
                    System.out.println("HARGA SEWA  :" + pCetak.data.getHargaSewa());
                    System.out.println("==================");
                    pCetak = pCetak.next;
                    i++;
                }
            }
        } else {
            System.out.println("parameter keliru");
        }
    }

    public void cetak(String Komentar) {
        System.out.println(Komentar);
        NodeCSLL pCetak;
        pCetak = pAwal;
        int i = -1;
        while ((i < counter)) {
            System.out.println("==================");
            System.out.println("JUDUL       :" + pCetak.data.getJudul());
            System.out.println("KATEGORI    :" + pCetak.data.getKategori());
            System.out.println("HARGA SEWA  :" + pCetak.data.getHargaSewa());
            System.out.println("HARGA DENDA :" + pCetak.data.getHargaDenda());
            System.out.println("==================");
            pCetak = pCetak.next;
            i++;
        }
        System.out.println();
    }
}
