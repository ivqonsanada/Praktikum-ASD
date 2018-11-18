/*
3. Lakukan modifikasi pada ADT graph di atas sehingga suatu hubungan antar node
terdapat nilai jarak. -> KASIH WEIGHT
4. Berdasarkan hasil modifikasi pada tugas 5 susun method untuk menghitung jarak
terpendek dari suatu node asal ke node tujuan. -> BUAT UNTUK MENENTUKAN JARAK
 */
package praktikum11;

public class MainClass {

    public static void main(String[] args) {

        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(8);
        graph.addEdge(0, 1, 5);
        graph.addEdge(1, 0, 7);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 1, 9);
        graph.addEdge(3, 7, 6);
        graph.addEdge(4, 2, 5);
        graph.addEdge(6, 4, 2);
        graph.addEdge(7, 5, 10);
        graph.addEdge(0, 4, 3);
        graph.addEdge(1, 2, 7);
        graph.addEdge(3, 5, 11);
        graph.addEdge(4, 6, 3);
        graph.addEdge(6, 7, 8);
        System.out.println("Hasil penelusuran BFS mulai node 0: ");
        graph.BreadthFirstSearch(0);
        System.out.println("Hasil penelusuran Tetangga");
        graph.tetangga(2);;
        System.out.println("Hasil penelusuran DFS mulai node 0: ");
        graph.DFS(0);
        
    }
}