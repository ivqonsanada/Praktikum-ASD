/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum8_No2;

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

    public void RR() {
        Object shet = dequeue();
        int coy = 0;
        if (shet instanceof String) {
            coy = Integer.parseInt((String) shet);
        } else {
            coy = (int) shet;
        }
        if (coy != 1) {
            enqueue(coy - 1);
        }
        cetak();
    }
    public void RoundRobin(){
        while(!listAntrian.kosong()){
            RR();
        }
    }

    public boolean kosong() {
        return listAntrian.kosong();
    }

    public void cetak() {
        listAntrian.cetak();
    }
}
