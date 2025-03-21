package UI;

import BinarySearchTree.MyBinarySearchTree;
import Queue.Profiler;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeUI<E extends Comparable<E>> extends JPanel
{
    private JButton binarySearchButton;
    private JTextArea textArea;
    private JButton jumpSearchButton;
    private JButton printTreeButton;
    private JButton addButton;
    private JButton removeButton;
    private JPanel bstPanel;
    private JTextField BSTOperationsInputElementTextField;
    private JLabel outputLabel;

    private MyBinarySearchTree<E> mbt;

    private final String shownText = "Output: ";

    public BinarySearchTreeUI(JFrame parentFrame, JPanel mainManyPanel, List<E> elements)
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(bstPanel);

        //BST Creation
        this.mbt = this.createMBT(elements);
        this.outputLabel.setText(this.shownText);

        //ActionListeners
        this.printTreeButton.addActionListener(e ->{
            System.out.println("Hello");
            this.printTree();
        });

        this.removeButton.addActionListener(e->{

        });

        this.binarySearchButton.addActionListener(e->{

        });

        this.jumpSearchButton.addActionListener(e->{

        });

        this.addButton.addActionListener(e->{

        });
    }

    private MyBinarySearchTree<E> createMBT(List<E> elements)
    {
        MyBinarySearchTree<E> mbt = new MyBinarySearchTree<>();
        for(E element: elements)
        {
            mbt.addValue(element);
        }

        return mbt;
    }

    private void printTree()
    {
        final List<E>[] lstHolder = new List[1];

        double time = Profiler.timeMe(() -> {
            lstHolder[0] = this.mbt.preorderTraversal();
        });
        List<E> lst = lstHolder[0];

        this.outputLabel.setText("Result: " + lst + " Time taken: " + time);
    }

    private void removeElement(E element)
    {
        double time = Profiler.timeMe(()->{
            this.mbt.remove(element);
        });

        this.outputLabel.setText("Result: " + this.mbt.preorderTraversal() + " Time taken: " + time);
    }

    private void binarySearch(E element)
    {
        boolean isContain = this.mbt.binarySearch(element);

        double time = Profiler.timeMe(() ->{
            this.mbt.binarySearch(element);
        });

        this.outputLabel.setText("Result: " + (!isContain ? " Does not contain " : " Contains " + element + "Time taken: " + time));
    }

    private void jumpSearch(E element)
    {
        boolean isContain = this.mbt.jumpSearch(element);

        double time = Profiler.timeMe(() ->{
            this.mbt.jumpSearch(element);
        });

        this.outputLabel.setText("Result: " + (!isContain ? " Does not contain " : " Contains " + element + "Time taken: " + time));
    }

    private void add(E element)
    {
        double time = Profiler.timeMe(() ->{
            this.mbt.addValue(element);
        });

        this.outputLabel.setText("Result: " + this.mbt.preorderTraversal() + " Time taken: " + time);
    }
}
