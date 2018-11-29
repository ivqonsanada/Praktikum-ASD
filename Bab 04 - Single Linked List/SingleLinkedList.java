package Praktikum4;

public class SingleLinkedList {

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public SingleLinkedList() {
    }

    public void sisipDidepan(Buku dt) {
        Node nodeBaru = new Node();
        nodeBaru.data = dt;
        nodeBaru.next = head;
        head = nodeBaru;
    }

    public boolean sisip(Buku dt1, Buku dt2) {
        Node temp = head;
        Node nodeBaru = new Node();
        nodeBaru.data = dt1;
        while (temp != null && temp.data != dt2) {
            temp = temp.next;
        }
        if (temp != null) {
            nodeBaru.next = temp.next;
            temp.next = nodeBaru;
            return true;
        }
        return false;
    }

    public Buku hapusDiDepan() {
        if (head == tail) {
            tail = null;
        }
        Node hapus = head;
        head = head.next;
        return hapus.data;
    }

    public Buku hapusDiAkhir() {
        if (head == tail) {
            tail = null;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            temp = null;
        }
        return tail.data;
    }

    boolean isEmpty() {
        return (size == 0);
    }

    public void sisipDataDiAkhir(Buku data) {
        Node nodeBaru = new Node();
        nodeBaru.data = data;
        tail.next = nodeBaru;
        tail = nodeBaru;
    }

    public void sisipDataUrut(Buku data) {
        Node temp = new Node();
        temp.data = data;
        if (head == null) {
            head = temp;
        } else {
            Node a = head;
            temp = null;
            while (a != null && a.data.getHargaSewa() < data.getHargaSewa()) {
                temp = a;
                a = a.next;
            }
            while (a != null && a.data.getHargaDenda() < data.getHargaDenda() && a.data.getHargaSewa() == data.getHargaSewa()) {
                temp = a;
                a = a.next;
            }
            if (temp != null) {
                Node baru = new Node();
                baru.data = data;
                baru.next = a;
                temp.next = baru;
            } else {
                sisipDidepan(data);
            }
        }
    }

    public void hapusData(Buku key) {
        Node temp = head;
        if (!isEmpty()) {
            while (temp != null) {
                if (temp.next.data.getHargaDenda() == key.getHargaDenda()) {
                    temp.next = temp.next.next;
                    if (temp.next == null) {
                        tail = temp;
                    }
                    break;
                } else if ((temp.data.getHargaDenda() == key.getHargaDenda()) && (temp == head)) {
                    this.hapusDiDepan();
                    break;
                }
                temp = temp.next;
            }
        } else {
            System.out.println("Data is empty!");
        }
        size--;
    }

    public Node getPointer() {
        return head;
    }

    public void cetak(String kom) {
        System.out.println(kom);
        Node n = head;
        while (n != null) {
            System.out.println("==================");
            System.out.println("JUDUL       :" + n.data.getJudul());
            System.out.println("KATEGORI    :" + n.data.getKategori());
            System.out.println("HARGA SEWA  :" + n.data.getHargaSewa());
            System.out.println("HARGA DENDA :" + n.data.getHargaDenda());
            System.out.println("==================");
            n = n.next;
        }
        System.out.println("NULL");
    }

}
