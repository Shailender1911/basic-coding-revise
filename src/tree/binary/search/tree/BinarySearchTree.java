package tree.binary.search.tree;

import javax.print.attribute.standard.NumberOfDocuments;

public class BinarySearchTree {

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }

        Node temp = root;

        while (true) {
            if (value < temp.value) {
                if (temp.left == null) {
                    temp.left = new Node(value);
                    break;
                }
                temp = temp.left;
            } else if (value > temp.value) {
                if (temp.right == null) {
                    temp.right = new Node(value);
                    break;
                }
                temp = temp.right;
            } else {
                break;
            }
        }
    }

    // In order traversal, LNR  (left --> root-->right)

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.value + " ");
            inOrderRec(root.right);

        }
    }

    void inOrderTraversal() {
        inOrderRec(root);
    }


}
