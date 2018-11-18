package praktikum11;

import Queue.Queue;
import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrixGraph {

    private int size;
    private int[][] adj;
    private int[] weight;
    private int count = 0;
    final static int INF = 99999;

    AdjacencyMatrixGraph(int size) {
        this.size = size;
        this.adj = new int[size][size];
    }

    void addEdge(int i, int j, int weight) {
        this.adj[i][j] = weight;
    }

    void removeEdge(int i, int j) {
        this.adj[i][j] = 0;
    }

    int hasEdge(int i, int j) {
        return this.adj[i][j];
    }

    List<Integer> outEdges(int i) {
        List<Integer> edges = new ArrayList<Integer>();
        for (int j = 0; j < size; j++) {
            if (this.adj[i][j] != 0) {
                edges.add(j);
            }
        }
        return edges;
    }

    List<Integer> inEdges(int i) {
        List<Integer> edges = new ArrayList<Integer>();
        for (int j = 0; j < size; j++) {
            if (this.adj[j][i] != 0) {
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

    void floydWarshall() {
        int dist[][] = new int[size][size];
        int i, j, k;

        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                if (adj[i][j] != 0) {
                    dist[i][j] = adj[i][j];
                }
            }
        }

        for (k = 0; k < size; k++) {
            for (i = 0; i < size; i++) {
                for (j = 0; j < size; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        printSolution(dist);
    }

    void printSolution(int dist[][]) {
        System.out.println("The following matrix shows the shortest "
                + "distances between every pair of vertices");
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }
}
