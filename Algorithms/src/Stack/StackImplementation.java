package Stack;/*
* Implementation of a Stack data structure
* Extends from Vector, similar to the java.util implementation
* Implements all methods specified in the Java 8 documentation plus a few extras
 */
import java.util.*;

public class StackImplementation<E extends Comparable<E>> extends Vector<E>
{
    private ArrayList<E> stack;

    public StackImplementation()
    {
        this.stack = new ArrayList<>();
    }

    public StackImplementation(Collection<? extends E> c)
    {
        this.stack = new ArrayList<>();
        this.stack.addAll(c);
    }

    public ArrayList<E> getStack()
    {
        return this.stack;
    }

    public int size()
    {
        return this.stack.size();
    }

    public boolean empty()
    {
        return this.stack.isEmpty();
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
        this.stack.add(e);
    }

    public E pop()
    {
        E element = this.stack.remove(this.stack.size() - 1);
        return element;
    }

    public E peek()
    {
        if (empty())
        {
            throw new EmptyStackException();
        }

        return this.stack.get(this.stack.size() - 1);
    }

    public void print()
    {
        for (E e : this.stack)
        {
            System.out.println(e);
        }
    }

    public void reverse() {
        Collections.reverse(this.stack);
    }

    public int search(E searchElement)
    {
        StackImplementation<E> tempStack = new StackImplementation<>(this.stack);
        int pos = 1; // 1-based position from top of stack

        while (!tempStack.empty())
        {
            E element = tempStack.pop();
            if (equals(element, searchElement))
            {
                return pos;
            }

            pos++;
        }

        return -1;
    }

    private boolean equals(E target, E element)
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
