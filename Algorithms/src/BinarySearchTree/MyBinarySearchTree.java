package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class MyBinarySearchTree<E extends Comparable<E>>
{
    public Node<E> root;

    public MyBinarySearchTree() {this.root = new Node<>();}
    public MyBinarySearchTree(E element){this.root = new Node<>(element);}

    public void printTree()
    {
        this.inorderTraversal(this.root);
    }

    public void addValue(E element)
    {
        this.root = this.add(this.root, element);
    }

    public Node<E> getNode(E element)
    {
        return this.binarySearch(this.root, element);
    }

    public void replace(E oldElement, E newElement)
    {
        Node<E> node = this.binarySearch(this.root, oldElement);
        if(node != null)
        {
            this.remove(oldElement);
            this.addValue(newElement);
        }
    }

    public void remove(E element)
    {
        this.root = this.remove(this.root, element);
    }

    public List<E> toList()
    {
        List<E> lst = new ArrayList<>();
        this.toList(this.root, lst);

        return lst;
    }

    private void toList(Node<E> node, List<E> lst)
    {
        if(node == null){
            return;
        }

        toList(node.left, lst);
        lst.add(node.element);
        toList(node.right, lst);
    }

    //binary search algorithm
    private Node<E> binarySearch(Node<E> node, E element)
    {
        while (node != null)
        {
            if(element == node.element) {return node;}
            else if(element.compareTo(node.element) < 0)
            {
                node = node.left;
            }
            else
            {
                node = node.right;
            }
        }
        return null;
    }
    private void inorderTraversal(Node<E> node)
    {
        if(node == null) {return;}

        System.out.println(node.element);

        inorderTraversal(node.left);
        inorderTraversal(node.right);
    }

    //adding elements based on the root node. smaller -> left subtree, bigger -> right subtree
    private Node<E> add(Node<E> node, E element)
    {
        if(this.root.element == null) {this.root.element = element;}

        if(node == null){
            return new Node<>(element);
        };

        if(element.compareTo(node.element) < 0)
        {
            node.left = add(node.left, element);
        }
        else if(element.compareTo(node.element) > 0)
        {
            node.right = add(node.right, element);
        }

        return node;
    }

    private Node<E> remove(Node<E> node, E element)
    {
        if (node == null) { return null; }

        if (element.compareTo(node.element) < 0)
        {
            node.left = remove(node.left, element);
        }
        else if (element.compareTo(node.element) > 0)
        {
            node.right = remove(node.right, element);
        }
        else
        {
            if (node.left == null) { return node.right; }
            if (node.right == null) { return node.left; }

            Node<E> successor = getSuccessor(node.right);
            node.element = successor.element;
            node.right = remove(node.right, successor.element);
        }

        return node;
    }

    private Node<E> getSuccessor(Node<E> node)
    {
        if (node == null) return null;

        while (node.left != null)
        {
            node = node.left;
        }
        return node;
    }

    public boolean jumpSearch(E element)
    {
        List<E> lst = this.toList();
        int size = lst.size();
        int jumpStep = (int) Math.sqrt(size);

        return this.jumpSearch(element, lst, size, jumpStep, 0, 0);
    }

    //my own, recursive implementation of the Jump Search Algorithm
    private boolean jumpSearch(E element, List<E> lst, int size, int jumpStep, int currentIndex, int prev)
    {
        if (currentIndex >= size) {
            return false;
        }

        if (lst.get(currentIndex) == element) {
            return true;
        }

        if (lst.get(currentIndex).compareTo(element) < 0) {
            prev = currentIndex;
            currentIndex = Math.min(currentIndex + jumpStep, size - 1);

            return jumpSearch(element, lst, size, jumpStep, currentIndex, prev);
        }

        for (int i = prev; i <= currentIndex; i++) {
            if (lst.get(i).equals(element)) {
                return true;
            }
        }

        return false;
    };

}
