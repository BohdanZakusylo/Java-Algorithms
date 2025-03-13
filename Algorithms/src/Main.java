import BinarySearchTree.MyBinarySearchTree;
import Queue.QueueImplementation;
import Queue.QueueSorts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Queue.Profiler.timeMe;


public class Main
{
    public static void main(String[] args)
    {
//        MyBinarySearchTree<String> mbt = new MyBinarySearchTree<>("D");
//        mbt.insertValue("B");
//        mbt.insertValue("C");
//        mbt.insertValue("A");
//        mbt.insertValue("F");
//
//        mbt.printTree();

        QueueImplementation<Integer> queue = new QueueImplementation<Integer>();
        ArrayList<Integer> array = new ArrayList<>();
        Random ran = new Random();
        for (int i = 0; i < 100; i++)
        {
            array.add(ran.nextInt());
        }

        queue.addAll(array);
        queue.printToArray();

        Double timeTaken = timeMe(() ->
        {
            QueueSorts.mergeSort(queue);
        });

        System.out.println(timeTaken);

        queue.printToArray();



    }
}
