package praktikum10;

public class AVLTree {

    Node akar;

    int getTinggi(Node N) {
        return (N != null) ? N.tinggi : 0;
    }

    // Fungsi untuk memutar node melalui y
    // Lihat diagram diatas
    Node putarKanan(Node y) {
        Node x = y.nodeKiri;
        Node T2 = x.nodeKanan;

        // Melakukan putaran
        x.nodeKanan = y;
        y.nodeKiri = T2;

        // Update tinggi
        y.tinggi = Math.max(getTinggi(y.nodeKiri),
                getTinggi(y.nodeKanan)) + 1;

        x.tinggi = Math.max(getTinggi(x.nodeKiri),
                getTinggi(x.nodeKanan)) + 1;

        // hasilkan pasangan node baru
        return x;
    }

    // Fungsi untuk memutar node melalui x
    // Lihat diagram diatas
    Node putarKiri(Node x) {
        Node y = x.nodeKanan;
        Node T2 = y.nodeKiri;

        // Melakukan putaran
        y.nodeKiri = x;
        x.nodeKanan = T2;

        // Update tinggi
        x.tinggi = Math.max(getTinggi(x.nodeKiri), getTinggi(x.nodeKanan)) + 1;

        y.tinggi = Math.max(getTinggi(y.nodeKiri), getTinggi(y.nodeKanan)) + 1;

        // hasilkan pasangan node baru
        return y;
    }

// Dapatkan nilai seimbang dari node N
    int getBalance(Node N) {

        return (N != null) ? getTinggi(N.nodeKiri)
                - getTinggi(N.nodeKanan) : 0;
    }

    Node insert(Node node, int data) {

        /* 1. Penambahan Node pada BST biasa */
        if (node == null) {
            return (new Node(data));
        }

        if (data < node.data) {
            node.nodeKiri = insert(node.nodeKiri, data);
        } else if (data > node.data) {
            node.nodeKanan = insert(node.nodeKanan, data);
        } else // Duplicate datas not allowed
        {
            return node;
        }

        /* 2. Update tinggi pada ancestor node */
        node.tinggi = 1 + Math.max(getTinggi(node.nodeKiri),
                getTinggi(node.nodeKanan));
        /* 3. Melakukan keseimbangan pada melalui nilai
71 ancestor untuk mengecek apakah node tidak
seimbang*/
        Node result = balance(node, data);

        // hasilkan pasangan node baru
        return result;
    }

    Node balance(Node node, int data) {
        int balance = getBalance(node);

        // Apabila kondisi tidak seimbang maka terjadi rotasi
        // Kondisi putar kanan
        if (balance > 1 && data < node.nodeKiri.data) {
            return putarKanan(node);
        } // Kondisi putar kiri
        else if (balance < -1 && data > node.nodeKanan.data) {
            return putarKiri(node);
        } // Kondisi putar kiri kanan
        else if (balance > 1 && data > node.nodeKiri.data) {
            node.nodeKiri = putarKiri(node.nodeKiri);
            return putarKanan(node);
        } // Kondisi putar kanan kiri
        else if (balance < -1 && data < node.nodeKanan.data) {
            node.nodeKanan = putarKanan(node.nodeKanan);
            return putarKiri(node);
        } // Kondisi tidak berubah sama sekali
        else {
            return node;
        }
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    Node minValueNode(Node node) {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.nodeKiri != null) {
            current = current.nodeKiri;
        }

        return current;
    }

    Node deleteNode(Node root, int key) {
        // STEP 1: PERFORM STANDARD BST DELETE  
        if (root == null) {
            return root;
        }

        // If the key to be deleted is smaller than  
        // the root's key, then it lies in left subtree  
        if (key < root.data) {
            root.nodeKiri = deleteNode(root.nodeKiri, key);
        } // If the key to be deleted is greater than the  
        // root's key, then it lies in right subtree  
        else if (key > root.data) {
            root.nodeKanan = deleteNode(root.nodeKanan, key);
        } // if key is same as root's key, then this is the node  
        // to be deleted  
        else {
            // node with only one child or no child  
            if ((root.nodeKiri == null) || (root.nodeKanan == null)) {
                Node temp = null;
                if (temp == root.nodeKiri) {
                    temp = root.nodeKanan;
                } else {
                    temp = root.nodeKiri;
                }
                // No child case  
                if (temp == null) {
                    temp = root;
                    root = null;
                } else // One child case  
                {
                    root = temp; // Copy the contents of  
                }                                // the non-empty child  
            } else {
                // node with two children: Get the inorder  
                // successor (smallest in the right subtree)  
                Node temp = minValueNode(root.nodeKanan);
                // Copy the inorder successor's data to this node  
                root.data = temp.data;
                // Delete the inorder successor  
                root.nodeKanan = deleteNode(root.nodeKanan, temp.data);
            }
        }

        // If the tree had only one node then return  
        if (root == null) {
            return root;
        }

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE  
        root.tinggi = max(getTinggi(root.nodeKiri), getTinggi(root.nodeKanan)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether  
        // this node became unbalanced)  
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases  
        // Left Left Case  
        if (balance > 1 && getBalance(root.nodeKiri) >= 0) {
            return putarKanan(root);
        }

        // Left Right Case  
        if (balance > 1 && getBalance(root.nodeKiri) < 0) {
            root.nodeKiri = putarKiri(root.nodeKiri);
            return putarKanan(root);
        }

        // Right Right Case  
        if (balance < -1 && getBalance(root.nodeKanan) <= 0) {
            return putarKiri(root);
        }

        // Right Left Case  
        if (balance < -1 && getBalance(root.nodeKanan) > 0) {
            root.nodeKanan = putarKanan(root.nodeKanan);
            return putarKiri(root);
        }

        return root;
    }

    boolean Search(int key) {
        Node temp = akar;
        while (temp != null) {
            if (key > temp.data) {
                temp = temp.nodeKanan;
            } else if (key < temp.data) {
                temp = temp.nodeKiri;
            } else {
                return true;
            }
        }
        return false;
    }

    static int miniNode(int tinggi) {
        return (int) (Math.round(((Math.sqrt(5) + 2) / Math.sqrt(5)) * Math.pow((1 + Math.sqrt(5)) / 2, tinggi) - 1));
    }

    void inOrder(Node node) {
        if (node != null) {
            inOrder(node.nodeKiri);
            System.out.print(node.data + " ");
            inOrder(node.nodeKanan);
        }
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.nodeKiri);
            preOrder(node.nodeKanan);
        }
    }
}
