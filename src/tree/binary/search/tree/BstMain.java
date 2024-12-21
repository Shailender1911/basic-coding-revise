package tree.binary.search.tree;

public class BstMain {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        // 50 ,30 ,20 ,40 .70.60,80
//
//        binarySearchTree.insert(50);
//        binarySearchTree.insert(30);
//        binarySearchTree.insert(20);
//        binarySearchTree.insert(40);
//        binarySearchTree.insert(70);
//        binarySearchTree.insert(60);
//        binarySearchTree.insert(80);
//
//        binarySearchTree.inOrderTraversal();

        BinarySearchTreeRecursive bstr = new BinarySearchTreeRecursive();


        bstr.root = bstr.insert(bstr.root, 50);
        bstr.insert(bstr.root,30);
        bstr.insert(bstr.root,20);
        bstr.insert(bstr.root,40);
        bstr.insert(bstr.root,70);
        bstr.insert(bstr.root,60);
        bstr.insert(bstr.root,80);

        bstr.inorderTraversalRec(bstr.root);

    }
}
