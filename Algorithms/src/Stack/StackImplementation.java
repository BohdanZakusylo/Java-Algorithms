package Stack;
/*
* Implementation of a Stack data structure
* Extends from Vector, similar to the java.util implementation
* Implements all methods specified in the Java 8 documentation plus a few extras
 */
import java.util.*;

public class StackImplementation<E extends Comparable<E>>
{
    private Object[] stack;
    private int size;

    public StackImplementation(int size)
    {
        this.size = -1;
        this.stack = new Object[size];
    }

    public StackImplementation(Collection<? extends E> c)
    {
        this.size = c.size() - 1;
        this.stack = new Object[size];
        addAll(c);
    }

    public E[] getStack()
    {
        return (E[]) this.stack;
    }

    public int size()
    {
        return this.size;
    }

    public boolean empty()
    {
        return this.size == -1;
    }

    public boolean addAll(Collection<? extends E> c)
    {
        if (c.isEmpty())
        {
            return false;
        }

        for (E e : c)
        {
            this.push(e);
        }

        return true;
    }

    public void push(E e)
    {
        if (size == (stack.length - 1))
        {
            throw new StackOverflowError();
        }
        this.size++;
        this.stack[this.size] = e;
    }

    public E pop()
    {
        Object element = this.stack[this.size];
        this.stack[this.size] = null;
        this.size--;
        return (E) element;
    }

    public E peek()
    {
        if (empty())
        {
            throw new EmptyStackException();
        }

        return (E) this.stack[this.size];
    }

    public void print()
    {
        for (Object e : this.stack)
        {
            System.out.println(e);
        }
    }

    public void reverse()
    {
        for (int i = 0; i < this.size / 2; i++)
        {
            Object element = this.stack[i];
            this.stack[i] = this.stack[this.size - 1 - i];
            this.stack[this.size - 1 - i] = element;
        }
    }

    public int search(E searchElement)
    {
        for (int pos = this.size; pos > 0; pos--)
        {
            Object element = this.stack[pos];
            if (equals(element, searchElement))
            {
                return pos;
            }
        }

        return -1;
    }

    private boolean equals(Object target, Object element)
    {
        if (target == null)
        {
            return element == null;
        }
        else
        {
            return target.equals(element);
        }
    }

}
