package Queue;

public class QueueSorts
{

    public static <E extends Comparable<E>> void mergeSort(QueueImplementation<E> queue)
    {
        int length = queue.getSize();
        if (length <= 1) return; //base case

        int middle = length / 2;
        QueueImplementation<E> leftQueue = new QueueImplementation<E>();
        QueueImplementation<E> rightQueue = new QueueImplementation<E>();

        for (int i = 0; i<length; i++ )
        {
            if (i < middle)
            {
                leftQueue.enqueue(queue.dequeue());
            }
            else
            {
                rightQueue.enqueue(queue.dequeue());
            }
        }

        mergeSort(leftQueue);
        mergeSort(rightQueue);
        merge(leftQueue, rightQueue, queue);

    }

    private static <E extends Comparable<E>> void merge(QueueImplementation<E> leftQueue, QueueImplementation<E> rightQueue, QueueImplementation<E> queue)
    {

        System.out.println("----------------------------------------------------");
        System.out.print("LeftQueue");
        leftQueue.printToArray();
        System.out.print("RightQueue");
        rightQueue.printToArray();

        queue.removeAll();

        // Main comparison loop
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty())
        {
            if (leftQueue.peek().compareTo(rightQueue.peek()) <= 0)
            {
                queue.enqueue(leftQueue.dequeue());
            }
            else
            {
                queue.enqueue(rightQueue.dequeue());
            }
        }

        // Add remaining elements from leftQueue (if any)
        while (!leftQueue.isEmpty()) {
            queue.enqueue(leftQueue.dequeue());
        }

        // Add remaining elements from rightQueue (if any)
        while (!rightQueue.isEmpty()) {
            queue.enqueue(rightQueue.dequeue());
        }

        System.out.print("MainQueue");
        queue.printToArray();
        System.out.println("----------------------------------------------------");

    }


    static public <E extends Comparable<E>> void bubbleSort(QueueImplementation<E> queue)
    {
//        int length = queue.getSize();
//        boolean swapped = true;
//
//        while (!queue.isEmpty() && swapped)
//        {
//            swapped = false;
//
//            for (int i = 0; i < length - 1; i++)
//            {
//                E firstElement = queue.dequeue();
//                E secondElement = queue.dequeue();
//
//                if
//            }
//        }
    }
}
