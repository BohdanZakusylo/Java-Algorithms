/*
* Implementation of a Stack data structure
* Extends from Vector, similar to the java.util implementation
* Implements all methods specified in the Java 8 documentation plus a few extras
 */
import java.util.*;

public class StackImplementation<E> extends Vector<E>
{
    private ArrayList<E> stack;

    public StackImplementation()
    {
        this.stack = new ArrayList<>();
    }

    public StackImplementation(Collection<? extends E> c)
    {
        this.stack.addAll(c);
    }

    public ArrayList<E> getStack()
    {
        return this.stack;
    }

    public boolean empty()
    {
        return this.stack.isEmpty();
    }

    public void push(E e)
    {
        this.stack.add(e);
    }

    public void pushAll(List<? extends E> c)
    {
        // Adds all elements of a List to the stack in order by reversing the list before adding it
        // Generic collections do not work with reverse
        Collections.reverse(c);
        this.stack.addAll(c);
    }

    public E pop()
    {
        E element = this.stack.remove(this.stack.size() - 1);
        return element;
    }

    public E peek()
    {
        return this.stack.get(this.stack.size() - 1);
    }

    public int search(E searchElement)
    {
        StackImplementation<E> tempStack = new StackImplementation<>(this.stack);

        while (!tempStack.isEmpty())
        {
            E element = tempStack.pop();
            if (equals(element, searchElement))
            {
                return tempStack.size() - 1;
            }
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
