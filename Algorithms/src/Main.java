import BinarySearchTree.MyBinarySearchTree;

public class Main
{
    public static void main(String[] args)
    {
        MyBinarySearchTree<String> mbt = new MyBinarySearchTree<>("D");
        mbt.insertValue("B");
        mbt.insertValue("C");
        mbt.insertValue("A");
        mbt.insertValue("F");

        mbt.printTree();

    }
}
