import BinarySearchTree.MyBinarySearchTree;
import Profiler.Profiler;
import Queue.QueueImplementation;
import Queue.QueueSorts;

import java.util.List;

import static Queue.QueueProfiler.*;

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
        Integer[] array = {1,5,7,3,4,6,1,43,5,67,2,3,765,34,23,543,7634,1234,5346,3,23,-666, 234, 123,543,654,7654,876,23,345,2,43,-234};
        queue.addAll(List.of(array));

//        QueueSorts.mergeSort(queue);
        queue.printToArray();
        queue = QueueSorts.selectionSort(queue);
        queue.printToArray();



    }
}
