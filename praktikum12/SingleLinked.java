/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum12;

/**
 *
 * @author rockwell
 */
public class SingleLinked {

    Node pAwal;
    Node sorted;

    public SingleLinked() {
        pAwal = null;
    }

    public void SisipDataDiAwal(int data) {
        Node pBaru = new Node();
        pBaru.data = data;
        pBaru.next = null;
        if (pAwal == null) {
            pAwal = pBaru;
            pBaru.next = null;
            pBaru.prev = null;
        } else {
            pBaru.next = pAwal;
            pAwal.prev = pBaru;
            pAwal = pBaru;
        }
    }

    public void cetak() {
        Node temp = pAwal;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("");
    }

    public void bubblesort() {
        boolean swapped = false;
        do {
            swapped = false;
            Node temp = pAwal;
            while (temp.next != null) {
                if (temp.data > temp.next.data) {
                    int sementara = temp.data;
                    temp.data = temp.next.data;
                    temp.next.data = sementara;
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
    }

    public Node sortedMerge(Node a, Node b) {
        Node result = null;
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;

    }

    public Node mSort() {
        Node h = pAwal;
        return mergeSort(h);
    }

    public Node mergeSort(Node h) {
        if (h == null || h.next == null) {
            return h;
        }
        Node middle = getMiddle(h);
        Node nextofmiddle = middle.next;
        middle.next = null;
        Node left = mergeSort(h);
        Node right = mergeSort(nextofmiddle);
        Node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    public Node getMiddle(Node h) {
        if (h == null) {
            return h;
        }
        Node fastptr = h.next;
        Node slowptr = h;
        while (fastptr != null) {
            fastptr = fastptr.next;
            if (fastptr != null) {
                slowptr = slowptr.next;
                fastptr = fastptr.next;
            }
        }
        return slowptr;
    }

    public void insertionSort(Node headref) {
        // Initialize sorted linked list 
        sorted = null;
        Node current = headref;
        // Traverse the given linked list and insert every 
        // node to sorted 
        while (current != null) {
            // Store next for next iteration 
            Node next = current.next;
            // insert current in sorted linked list 
            sortedInsert(current);
            // Update current 
            current = next;
        }
        // Update head_ref to point to sorted linked list 
        pAwal = sorted;
    }

    public void sortedInsert(Node newnode) {
        /* Special case for the head end */
        if (sorted == null || sorted.data >= newnode.data) {
            newnode.next = sorted;
            sorted = newnode;
        } else {
            Node current = sorted;
            /* Locate the node before the point of insertion */
            while (current.next != null && current.next.data < newnode.data) {
                current = current.next;
            }
            newnode.next = current.next;
            current.next = newnode;
        }
    }

    public Node partition(Node l, Node h) {
        int x = h.data;

        Node i = l.prev;

        for (Node j = l; j != h; j = j.next) {
            if (j.data <= x) {
                // Similar to i++ for array 
                i = (i == null) ? l : i.next;
                int temp = i.data;
                i.data = j.data;
                j.data = temp;
            }
        }
        i = (i == null) ? l : i.next;
        int temp = i.data;
        i.data = h.data;
        h.data = temp;
        return i;
    }

    public void quickSortRec(Node l, Node h) {
        if (h != null && l != h && l != h.next) {
            Node temp = partition(l, h);
            quickSortRec(l, temp.prev);
            quickSortRec(temp.next, h);
        }
    }

    public Node lastNode(Node node) {
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    public void quickSort(Node node) {
        Node head = lastNode(node);
        quickSortRec(node, head);
    }
}
