package Queue;
import java.util.*;

import org.jfree.data.xy.XYSeries;
import Profiler.Profiler.Timeable;
import Profiler.Profiler;

import static Queue.QueueSorts.mergeSort;
import static Queue.QueueSorts.selectionSort;


public class QueueProfiler
{

    public static void profileQueueEnqueue()
    {
        Timeable timeable = new Timeable()
        {
            QueueImplementation<Integer> queue;

            public void setup(int n)
            {
                queue = new QueueImplementation<Integer>();
            }

            public void timeMe(int n)
            {
                for (int i=0; i<n; i++)
                {
                    queue.enqueue(i);
                }
            }
        };
        int startN = 10000;
        int endMillis = 5000;
        runProfiler("Queue enqueue", timeable, startN, endMillis);
    }

    public static void profileQueueDequeue()
    {
        Timeable timeable = new Timeable()
        {
            QueueImplementation<Integer> queue;

            public void setup(int n)
            {
                queue = new QueueImplementation<Integer>();
                List<Integer> list = Collections.nCopies(n, 1);
                queue.addAll(list);
            }

            public void timeMe(int n)
            {
                for (int i=0; i<n; i++)
                {
                    queue.dequeue();
                }
            }
        };
        int startN = 10000;
        int endMillis = 5000;
        runProfiler("Queue dequeue", timeable, startN, endMillis);
    }

    public static void profileQueueMergeSort()
    {
        Timeable timeable = new Timeable()
        {
            QueueImplementation<Integer> queue;

            public void setup(int n)
            {
                Random random = new Random();
                queue = new QueueImplementation<Integer>();
                for (int i = 0; i < n; i++)
                {
                    queue.enqueue(random.nextInt());
                }
            }

            public void timeMe(int n)
            {
                mergeSort(queue);
            }
        };
        int startN = 10000;
        int endMillis = 15000;
        runProfiler("Queue dequeue", timeable, startN, endMillis);
    }
    /*TODO
       Talk to the teacher cuz the profiler provided only supports in-place operations
       so when selectionSort function which has a return value, it gets confused and
       messes up the benchmarking
    */
    public static void profileQueueSelectionSort()
    {
        Timeable timeable = new Timeable()
        {
            QueueImplementation<Integer> queue;

            public void setup(int n)
            {
                Random random = new Random();
                queue = new QueueImplementation<Integer>();
                for (int i = 0; i < n; i++)
                {
                    queue.enqueue(random.nextInt());
                }
            }

            public void timeMe(int n)
            {
               queue = selectionSort(queue);
            }
        };
        int startN = 10000;
        int endMillis = 5000;
        runProfiler("Queue dequeue", timeable, startN, endMillis);
    }

    private static void runProfiler(String title, Timeable timeable, int startN, int endMillis)
    {
        Profiler profiler = new Profiler(title, timeable);
        XYSeries series = profiler.timingLoop(startN, endMillis);
        profiler.plotResults(series);
    }
}
