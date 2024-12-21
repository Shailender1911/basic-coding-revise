package tree.binary.search.tree;

import java.util.Stack;

public class IterativeInOrderTraversal {

    public  void iterativeInOrder(Node root)
    {
        if ( root == null)
            return;


        Stack<Node>stack = new Stack<>();
        Node current = root;

        while(current!=null || !stack.isEmpty())
        {

            while(current!=null)
            {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.value + " ");
            current = current.right;
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

        IterativeInOrderTraversal inOrderTraversal = new IterativeInOrderTraversal();

        inOrderTraversal.iterativeInOrder(bst.root);

    }
}
