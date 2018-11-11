package Tugas_BST;
import java.util.Scanner;
public class main {
    public static void main(String args[]) {
        int input;
        Tree Tree = new Tree();
        Tree Tree2 = new Tree();
        Scanner inKu = new Scanner(System.in);
        System.out.printf("%27s%s", "Jumlah data yang dimasukkan", ": ");
        int jumlahDt = inKu.nextInt();
        System.out.printf("%27s%s", "Input data (berupa Integer/Int)", ": ");
        for (int i = 0; i < jumlahDt; i++) {
            input = inKu.nextInt();
            Tree.sisipDtNode(input);
        }
        System.out.printf("%27s%s", "PreOrder traversal", ": ");
        Tree.preOrderTraversal();
        System.out.printf("\n%27s%s", "InOrder traversal", ": ");
        Tree.inOrderTraversal();
        System.out.printf("\n%27s%s", "PostOrder traversal", ": ");
        Tree.postOrderTraversal();
        System.out.printf("\n%27s%s%d", "Jumlah Daun/Leaf", ": ", Tree.getHitungDaun());
        System.out.printf("\n%27s%s%d", "Kedalaman Pohon", ": ", Tree.hitungKedalaman(Tree.getRoot()));
        System.out.printf("\n%27s%s%d", "Jumlah Simpul", ": ", Tree.hitungSimpul(Tree.getRoot()));
        System.out.printf("\n%27s%s%s", "Min Value", ": ", Tree.hitungMinValue(Tree.getRoot()));
        System.out.printf("\n%27s%s%s\n", "Max Value", ": ", Tree.hitungMaxValue(Tree.getRoot()));
        System.out.printf("%27s%s", "Input data", ": ");
        input = inKu.nextInt();
        System.out.printf("\n%27s%s%s\n", "Adakah angka "+input+"?", ": ", Tree.searchDt(Tree.getRoot(), input) ? "Ada" : "Tidak ada");
        System.out.printf("\n%27s%s%s\n", "Test", ": ", Tree.deleteRec(Tree.getRoot(), input).intDt);
        System.out.println("Setelah dihapus");
        System.out.printf("%27s%s", "PreOrder traversal", ": ");
        Tree.preOrderTraversal();
        System.out.printf("\n%27s%s", "InOrder traversal", ": ");
        Tree.inOrderTraversal();
        System.out.printf("\n%27s%s", "PostOrder traversal", ": ");
        Tree.postOrderTraversal();

        System.out.printf("\n\n%27s%s", "Jumlah data yang dimasukkan", ": ");
        jumlahDt = inKu.nextInt();
        System.out.printf("%27s%s", "Input data (berupa Character/Char)", ": ");
        for (int i = 0; i < jumlahDt; i++) {
            char c = inKu.next().charAt(0);
            Tree2.sisipDtNode(c);
        }
        System.out.printf("%27s%s", "PreOrder traversal", ": ");
        Tree2.preOrderTraversal();
        System.out.printf("\n%27s%s", "InOrder traversal", ": ");
        Tree2.inOrderTraversal();
        System.out.printf("\n%27s%s", "PostOrder traversal", ": ");
        Tree2.postOrderTraversal();
        System.out.printf("\n%27s%s%d", "Jumlah Daun/Leaf", ": ", Tree2.getHitungDaun());
        System.out.printf("\n%27s%s%d", "Kedalaman Pohon", ": ", Tree2.hitungKedalaman(Tree2.getRoot()));
        System.out.printf("\n%27s%s%d", "Jumlah Simpul", ": ", Tree2.hitungSimpul(Tree2.getRoot()));
        System.out.printf("\n%27s%s%s", "Min Value", ": ", Tree2.hitungMinValue(Tree2.getRoot()));
        System.out.printf("\n%27s%s%s\n", "Max Value", ": ", Tree2.hitungMaxValue(Tree2.getRoot()));
    }
}
