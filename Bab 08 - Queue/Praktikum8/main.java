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
public class main {

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.cetak();
        q.enqueue(54);
        q.cetak();
        q.enqueue(10);
        q.cetak();
        q.enqueue(94);
        q.cetak();
        Object dtHapus = null;
        while (!q.kosong()) {
            dtHapus = q.dequeue();
            System.out.printf("%s dihapus \n", dtHapus);
            q.cetak();
        }
    }
}
