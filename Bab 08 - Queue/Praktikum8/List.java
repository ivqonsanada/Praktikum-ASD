/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum8;

/**
 *
 * @author rockwell
 */
public class List {

    private Node nodeAwal;
    private Node nodeAkhir;
    private String nama;

    public List() {
        this("list");
    }

    public List(String namaList) {
        nama = namaList;
        nodeAwal = nodeAkhir = null;
    }

    public void sisipDiAwal(Object dt) {
        if (nodeAwal == null || nodeAkhir == null) {
            nodeAwal = nodeAkhir = new Node(dt);
            return;
        }
        Node baru = new Node(dt);
        baru.next = nodeAwal;
        nodeAwal.prev = baru;
        nodeAwal = baru;
    }

    public void sisipDiAkhir(Object dt) {
        if (nodeAwal == null) {
            nodeAwal = nodeAkhir = new Node(dt);
            return;
        }
        Node temp = nodeAwal;
        Node baru = new Node(dt);
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = baru;
        baru.prev = temp;
        baru.next = null;
        nodeAkhir = baru;
    }

    public Object hapusDrDepan() {
        Object itemDihapus = null;
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

    public void cetak() {
        if (kosong()) {
            System.out.printf("Kosong %s\n", nama);
            return;
        }
        System.out.printf("Isi %s adalah : ", nama);
        Node kini = nodeAwal;
        while (kini != null) {
            System.out.printf("%s ", kini.data);
            kini = kini.next;
        }
        System.out.println("\n");
    }
}
