package main.java.amz;

public class AVLTree {
    Node root;
    static class Node {
        int val, height;
        Node left, right;
        public Node(int val) {
            this.val = val;
            height = 1;
        }
    }

    public int height(Node n) {
        if (n == null) return 0;
        return n.height;
    }

    public Node rotateRight(Node x) {
        Node y = x.left;
        Node T2 = y.right;

//        perform rotation
        x.left = T2;
        y.right = x;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return y;
    }

    public Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        x.right = T2;
        y.left = x;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return y;
    }

    int getBalance(Node node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    Node insert(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }

        if (node.val > val) {
            node.left = insert(node.left, val);
        } else if (node.val < val) {
            node.right = insert(node.right, val);
        } else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

//        left left case
        if (balance > 1 && val < node.left.val) {
            return rotateRight(node);
        }
        if (balance > 1 && val > node.left.val) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && val > node.right.val) {
            return rotateLeft(node);
        }
        if (balance < -1 && val < node.right.val) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(node.val + " ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        int[] vals = {10, 20, 30, 40, 50, 25};
        for (int val : vals) {
            tree.root = tree.insert(tree.root, val);
        }
        tree.printPreOrder(tree.root);


    }
}
