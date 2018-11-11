package asd_bab_9;
public class Node {
    int intDt;
    char charDt;
    Node kiri;
    Node kanan;
    public Node(int dt) {
        intDt = dt;
        kiri = kanan = null;
    }
    public Node(char dt) {
        charDt = dt;
        kiri = kanan = null;
    }
    public void sisipDt(int dtSisip) {
        if (dtSisip < intDt) {
            if (kiri == null) {
                kiri = new Node(dtSisip);
            } else {
                kiri.sisipDt(dtSisip);
            }
        } else if (dtSisip > intDt) {
            if (kanan == null) {
                kanan = new Node(dtSisip);
            } else {
                kanan.sisipDt(dtSisip);
            }
        }
    }
    public void sisipDt(char dtSisip) {
        if (dtSisip < charDt) {
            if (kiri == null) {
                kiri = new Node(dtSisip);
            } else {
                kiri.sisipDt(dtSisip);
            }
        } else if (dtSisip > charDt) {
            if (kanan == null) {
                kanan = new Node(dtSisip);
            } else {
                kanan.sisipDt(dtSisip);
            }
        }
    }
    public boolean isDaun() {
        return this.kiri == null && this.kanan == null;
    }
}
