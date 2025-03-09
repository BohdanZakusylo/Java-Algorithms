import BinarySearchTree.MyBinarySearchTree;

public class Main
{
    public static void main(String[] args)
    {
        MyBinarySearchTree<String> mbt = new MyBinarySearchTree<>("A");
        mbt.addValue("B");
        mbt.addValue("C");
        mbt.addValue("D");
        mbt.addValue("F");

        mbt.printTree();

        mbt.remove("A");
        System.out.println("AAAAAAAAAA");
        mbt.printTree();
        System.out.println("AAAAAAAAAA");
        mbt.replace("D", "A");
        mbt.printTree();
    }
}
