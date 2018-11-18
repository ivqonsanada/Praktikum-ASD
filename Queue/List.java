/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class List {

    private Node nodeAwal;
    private Node nodeAkhir;

    public List() {
        nodeAwal = nodeAkhir = null;
    }

    public void sisipDiAkhir(int dt) {
        Node newNode = new Node(dt);
        if (kosong()) {
            nodeAkhir = nodeAwal = newNode;
        } else {
            nodeAkhir.next = newNode;
            nodeAkhir = newNode;
        }
    }

    public int hapusDrDepan() {
        int itemDihapus = -99;
        if (!kosong()) {
            itemDihapus = nodeAwal.data;
            if (nodeAwal == nodeAkhir) {
                nodeAwal = nodeAkhir = null;
            } else {
                nodeAwal = nodeAwal.next;
            }
        }
        return itemDihapus;
    }

    public boolean kosong() {
        return nodeAwal == null;
    }
}
