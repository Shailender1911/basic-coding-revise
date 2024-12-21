package tree.binary.search.tree;

import java.util.Stack;

public class IterativePreOrderTraversal {

    public void iterativePreOrder(Node root) {

        if (root == null)
            return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node temp = stack.pop();

            System.out.print(temp.value + " ");
            if (temp.right != null) {
                stack.push(temp.right);
            }

            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);

        IterativePreOrderTraversal iterativePreOrderTraversal = new IterativePreOrderTraversal();

        iterativePreOrderTraversal.iterativePreOrder(bst.root);

    }
}
