package BinarySearchTree;

public class Node<E>
{
    E element;
    public Node<E> right = null;
    public Node<E> left = null;
    public Node(){}

    public Node(E element)
    {
        this.element = element;
    }
}
