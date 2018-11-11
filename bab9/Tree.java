package Tugas_BST;
public class Tree {
    private Node root;
    public Tree() {
        root = null;
    }
    int getHitungDaun() {
        return hitungDaun(root);
    }
    int hitungDaun(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.isDaun()) {
            return 1;
        } else {
            return hitungDaun(node.kiri) + hitungDaun(node.kanan);
        }
    }
    int hitungKedalaman(Node node) {
        if (node == null) {
            return 0;
        } else {
            int kiri = hitungKedalaman(node.kiri);
            int kanan = hitungKedalaman(node.kanan);
            if (kiri > kanan) {
                return (kiri + 1);
            } else {
                return (kanan + 1);
            }
        }
    }
    String hitungMinValue(Node node) {
        if (node == null) {
            return "0";
        } else {
            while (node.kiri != null) {
                node = node.kiri;
            }
        }
        if (node.intDt == 0) {
            return Character.toString(node.charDt);
        } else {
            return Integer.toString(node.intDt);
        }
    }
    String hitungMaxValue(Node node) {
        if (node == null) {
            return "0";
        } else {
            while (node.kanan != null) {
                node = node.kanan;
            }
        }
        if (node.intDt == 0) {
            return Character.toString(node.charDt);
        } else {
            return Integer.toString(node.intDt);
        }
    }
    int hitungSimpul(Node node) {
        if (node == null) {
            return 0;
        } else if (node.isDaun()) {
            return 0;
        } else {
            int kiri = hitungSimpul(node.kiri);
            int kanan = hitungSimpul(node.kanan);
            return kiri + kanan + 1;
        }
    }
    boolean searchDt(Node node, int key) {
        while (node != null) {
            if (node.intDt == key) {
                return true;
            } else if (node.intDt > key) {
                node = node.kiri;
            } else {
                node = node.kanan;
            }
        }
        return false;
    }
    
    Node deleteRec(Node node, int key) {
        /* Base Case: If the tree is empty */
        if (node == null) {
            return node;
        }

        /* Otherwise, recur down the tree */
        if (key < node.intDt) {
            node.kiri = deleteRec(node.kiri, key);
        } else if (key > node.intDt) {
            node.kanan = deleteRec(node.kanan, key);
        } // if key is same as root's key, then This is the node 
        // to be deleted 
        else {
            // node with only one child or no child 
            if (node.kiri == null) {
                return node.kanan;
            } else if (node.kanan == null) {
                return node.kiri;
            }

            // node with two children: Get the inorder successor (smallest 
            // in the right subtree) 
            node.intDt = Integer.valueOf(hitungMinValue(node.kanan));

            // Delete the inorder successor 
            node.kanan = deleteRec(node.kanan, node.intDt);
        }
        return node;
    }
    
    
    public void sisipDtNode(int dtSisip) {
        if (root == null) {
            root = new Node(dtSisip);
        } else {
            root.sisipDt(dtSisip);
        }
    }
    public void sisipDtNode(char dtSisip) {
        if (root == null) {
            root = new Node(dtSisip);
        } else {
            root.sisipDt(dtSisip);
        }
    }
    public void preOrderTraversal() {
        preOrder(root);
    }
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        if (node.intDt == 0) {
            System.out.printf("%s ", node.charDt);
        } else {
            System.out.printf("%s ", node.intDt);
        }
        preOrder(node.kiri);
        preOrder(node.kanan);
    }
    public void inOrderTraversal() {
        inOrder(root);
    }
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.kiri);
        if (node.intDt == 0) {
            System.out.printf("%s ", node.charDt);
        } else {
            System.out.printf("%s ", node.intDt);
        }
        inOrder(node.kanan);
    }
    public void postOrderTraversal() {
        postOrder(root);
    }
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.kiri);
        postOrder(node.kanan);
        if (node.intDt == 0) {
            System.out.printf("%s ", node.charDt);
        } else {
            System.out.printf("%s ", node.intDt);
        }
    }
    public Node getRoot() {
        return root;
    }
}
