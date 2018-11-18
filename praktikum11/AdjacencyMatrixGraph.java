package praktikum11;

import Queue.Queue;
import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrixGraph {

    private int size;
    private boolean[][] adj;
    private int weight;

    AdjacencyMatrixGraph(int size) {
        this.size = size;
        this.adj = new boolean[size][size];
    }

    void addEdge(int i, int j, int weight) {
        this.adj[i][j] = true;
        this.weight = weight;
    }

    void removeEdge(int i, int j) {
        this.adj[i][j] = false;
        this.weight = 0;
    }

    boolean hasEdge(int i, int j) {
        return this.adj[i][j];
    }
    
    List<Integer> outEdges(int i) {
        List<Integer> edges = new ArrayList<Integer>();
        for (int j = 0; j < size; j++) {
            if (this.adj[i][j]) {
                edges.add(j);
            }
        }
        return edges;
    }

    List<Integer> inEdges(int i) {
        List<Integer> edges = new ArrayList<Integer>();
        for (int j = 0; j < size; j++) {
            if (this.adj[j][i]) {
                edges.add(j);
            }
        }
        return edges;
    }

    public void BreadthFirstSearch(int nodeAwal) {
        boolean[] terkunjungi = new boolean[size];
        Queue q = new Queue();
        q.enqueue(nodeAwal);
        terkunjungi[nodeAwal] = true;
        System.out.printf("%d ", nodeAwal);
        while (!q.isEmpty()) {
            int i = q.dequeue();
            for (int j : this.outEdges(i)) {
                if (!terkunjungi[j]) {
                    q.enqueue(j);
                    terkunjungi[j] = true;
                    System.out.printf("%d ", j);
                }
            }
        }
        System.out.println("");
    }

    public void tetangga(int rumah) {
        for (int j : this.outEdges(rumah)) {
            System.out.print(j + " ");
        }
        System.out.println("");
    }

    public void DepthFirstSearch(int nodeAwal, boolean[] terkunjungi) {
        Queue q = new Queue();
        q.enqueue(nodeAwal);
        terkunjungi[nodeAwal] = true;
        System.out.printf("%d ", nodeAwal);
        while (!q.isEmpty()) {
            int i = q.dequeue();
            for (int j : this.outEdges(i)) {
                if (!terkunjungi[j]) {
                    terkunjungi[j] = true;
                    DepthFirstSearch(j, terkunjungi);
                }
            }
        }
    }

    public void DFS(int nodeAwal) {
        boolean[] terkunjungi = new boolean[size];
        DepthFirstSearch(nodeAwal, terkunjungi);
    }
    
    public String jalur(int nodeAwal, int nodeTujuan){
        return "";
    }
    public void beban(){
    }
}