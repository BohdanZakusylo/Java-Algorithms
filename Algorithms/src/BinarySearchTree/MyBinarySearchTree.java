package BinarySearchTree;

public class MyBinarySearchTree<E extends Comparable<E>>
{
    public Node<E> root;

//    public MyBinarySearchTree() {this.root = new Node<>();}
    public MyBinarySearchTree(E element){this.root = new Node<>(element);}

    public void printTree()
    {
        this.inorderTraversal(this.root);
    }

    public void insertValue(E element)
    {
        this.add(this.root, element);
    }

    private void inorderTraversal(Node<E> node)
    {
        if(node == null) {return;}

        System.out.println(node.element);

        inorderTraversal(node.left);
        inorderTraversal(node.right);
    }

    private Node<E> add(Node<E> node, E element)
    {
        if(node == null){return new Node<>(element);};

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
}
