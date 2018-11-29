package praktikum10;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        Scanner in = new Scanner(System.in);
        tree.akar = tree.insert(tree.akar, 200);
        tree.akar = tree.insert(tree.akar, 1);
        tree.akar = tree.insert(tree.akar, 150);
        tree.akar = tree.insert(tree.akar, 111154);
        tree.akar = tree.insert(tree.akar, 55);

        /* hasil dari AVL Tree program diatas adalah
     150
     / \
    1 200
    \ \
     55 11154
         */
        System.out.println("Preorder");
        tree.preOrder(tree.akar);
        System.out.println("\nInorder");
        tree.inOrder(tree.akar);
        tree.akar = tree.deleteNode(tree.akar, 150);
        System.out.println("\n=====Setelah 150 dihapus=====");
        System.out.println("Preorder");
        tree.preOrder(tree.akar);
        System.out.println("\nInorder");
        tree.inOrder(tree.akar);
        System.out.println("\n===========Cari 55===========");
        tree.Search(55);
        System.out.println("Preorder");
        tree.preOrder(tree.akar);
        System.out.println("\nInorder");
        tree.inOrder(tree.akar);
        System.out.println("\n======Jumlah Minimal Node======");
        System.out.println("Masukkan level node: ");
        int input = in.nextInt();
        System.out.println("Jumlah minimal node: ");
        System.out.println(tree.miniNode(input));
        int val = 0;
        System.out.println("Urutan nilai node yang mungkin:");
        for (int i = 1; i <= tree.miniNode(input); i++) {
            val = in.nextInt(100);
            System.out.print(val + " ");
            tree.insert(tree.akar, val);
        }
    }
}
