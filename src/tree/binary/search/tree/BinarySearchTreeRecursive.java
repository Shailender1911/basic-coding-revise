package tree.binary.search.tree;

public class BinarySearchTreeRecursive {

    Node root;

    public Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            insert(node.left, value);
        } else if (value > node.value) {
            insert(node.right, value);
        }

        return node;
    }

    public void inorderTraversalRec(Node node) {
        if (node == null) return;

        inorderTraversalRec(node.left);
        System.out.print(node.value + " ");
        inorderTraversalRec(node.right);
    }
}
