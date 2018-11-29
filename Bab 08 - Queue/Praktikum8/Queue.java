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
public class Queue {

    private List listAntrian;

    public Queue() {
        listAntrian = new List("queue");
    }

    public void enqueue(Object object) {
        listAntrian.sisipDiAkhir(object);
    }

    public Object dequeue() {
        return listAntrian.hapusDrDepan();
    }

    public boolean kosong() {
        return listAntrian.kosong();
    }

    public void cetak() {
        listAntrian.cetak();
    }
}
