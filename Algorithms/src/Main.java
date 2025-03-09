import BinarySearchTree.MyBinarySearchTree;

public class Main
{
    public static void main(String[] args)
    {
        MyBinarySearchTree<Integer> mbt = new MyBinarySearchTree<>();
        Integer[] values = {50, 30, 70, 20, 40, 60, 80, 10, 35, 65};
        for(int number: values)
        {
            mbt.addValue(number);
        }

        System.out.println(mbt.toList());
    }
}
