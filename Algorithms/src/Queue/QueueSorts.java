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

        while (!leftQueue.isEmpty()) {
            queue.enqueue(leftQueue.dequeue());
        }

        while (!rightQueue.isEmpty()) {
            queue.enqueue(rightQueue.dequeue());
        }

        System.out.print("MainQueue");
        queue.printToArray();
        System.out.println("----------------------------------------------------");

    }


    static public <E extends Comparable<E>> QueueImplementation<E> selectionSort(QueueImplementation<E> queue) {
        if (queue.getSize() <= 1) {
            return queue;
        }

        QueueImplementation<E> sortedQueue = new QueueImplementation<E>();

        while (!queue.isEmpty()) {
            E min = findAndRemoveMin(queue);
            sortedQueue.enqueue(min);

        }

        return sortedQueue;
    }

    static private <E extends Comparable<E>> E findAndRemoveMin(QueueImplementation<E> queue) {
        if (queue.isEmpty()) {
            return null;
        }

        int size = queue.getSize();
        E min = queue.dequeue();

        for (int i = 1; i < size; i++) {
            E current = queue.dequeue();
            if (current.compareTo(min) < 0) {
                queue.enqueue(min);
                min = current;
            } else {
                queue.enqueue(current);
            }
        }
        System.out.println();
        return min;
    }
}
