package Queue;

public class Queue {

    private List listAntrian;

    public Queue() {
        listAntrian = new List();
    }

    public void enqueue(int dt) {
        listAntrian.sisipDiAkhir(dt);
    }

    public int dequeue() {
        return listAntrian.hapusDrDepan();
    }

    public boolean isEmpty() {
        return listAntrian.kosong();
    }
}
