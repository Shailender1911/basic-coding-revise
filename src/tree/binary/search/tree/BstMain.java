package tree.binary.search.tree;

public class BstMain {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        // 50 ,30 ,20 ,40 .70.60,80

        binarySearchTree.insert(50);
        binarySearchTree.insert(30);
        binarySearchTree.insert(20);
        binarySearchTree.insert(40);
        binarySearchTree.insert(70);
        binarySearchTree.insert(60);
        binarySearchTree.insert(80);

        binarySearchTree.inOrderTraversal();
    }
}
