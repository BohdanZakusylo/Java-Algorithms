package Queue;

import java.util.*;

public class QueueImplementation<E extends Comparable<E>>
{

    private List<E> queue;
    private int size;

    public QueueImplementation()
    {
        queue = new LinkedList<>();
        size = 0;
    }

    public int getSize()
    {
        return this.size;
    }

    public void setSize(int size)
    {
        if (size < 0)
        {
        throw new IllegalArgumentException("Size can not be less than 0!");
        }

        this.size = size;
    }

    public List<E> getQueue()
    {
        return this.queue;
    }

    public void setQueue(ArrayList<E> queue)
    {
        this.queue = queue;
    }

    public boolean isEmpty()
    {
        if (this.size == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean equals(E element, E target)
    {
        if (element == target)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean contains(E target)
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("The queue is empty");
        }

        for (E element: this.queue)
        {
            if (equals(element, target))
            {
                return true;
            }
        }
        return false;
    }

    public void enqueue(E e)
    {
        this.queue.add(e);
        size++;
    }

    public E dequeue()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("The queue is empty");
        }
        size--;
        return this.queue.remove(0);
    }

    public void printQueue()
    {
        for (E e : queue) {
            System.out.println(e);
        }
    }

    public void addAll(List<E> elements)
    {
        for (E element: elements)
        {
            enqueue(element);
        }
    }

    public void removeAll()
    {
        this.queue = new LinkedList<>();
        this.size = 0;
    }

    public void printToArray()
    {
        System.out.println(Arrays.toString(this.queue.toArray()));
    }

    public E peek()
    {
        if (this.queue.isEmpty())
        {
            throw new NoSuchElementException("The queue is empty");
        }

       return this.queue.get(0);
    }

}

