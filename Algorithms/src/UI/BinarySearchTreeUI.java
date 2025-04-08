package UI;

import BinarySearchTree.MyBinarySearchTree;
import ImportData.SelectedData;
import Queue.Profiler;

import javax.swing.*;
import java.util.List;
import java.util.Objects;

public class BinarySearchTreeUI<E extends Comparable<E>> extends JPanel
{
    private JButton binarySearchButton;
    private JTextArea textArea;
    private JButton jumpSearchButton;
    private JButton printTreeButton;
    private JPanel bstPanel;
    private JTextField BSTOperationsInputElementTextField;
    private JButton backButton;
    private JTextArea outputArea;
    private MyBinarySearchTree<E> mbt;

    private final String shownText = "Output: ";

    public BinarySearchTreeUI(JFrame parentFrame, JPanel mainManyPanel, SelectedData<?> selectedData)
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(bstPanel);
        List<?> selectedDataLst = selectedData.getDataPoints();

        //BST Creation
        this.mbt = this.createMBT(selectedDataLst);
        this.outputArea.setText(this.shownText);

        //ActionListeners
        backButton.addActionListener(e ->
        {
            parentFrame.setContentPane(mainManyPanel);
            parentFrame.revalidate();
            parentFrame.repaint();
        });

        this.printTreeButton.addActionListener(e ->{
            this.printTree();
        });

        this.binarySearchButton.addActionListener(e->{
            String userInput = this.textArea.getText();

            if(userInput.isEmpty())
            {
                this.outputArea.setText("The input should not be empty");
                return;
            }

            String dataType = selectedData.determineTypeWithRegex(userInput);

            if(Objects.equals(dataType, "string"))
            {
                try
                {
                    this.binarySearch((E) userInput);
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                    this.outputArea.setText("Error, pleae try again");
                }
            }else if (Objects.equals(dataType, "int"))
            {
                try{
                    Integer data = Integer.parseInt(userInput);
                    this.binarySearch((E) data);
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                    this.outputArea.setText("Error, please try again");
                }
            }
            else if(Objects.equals(dataType, "double"))
            {
                try
                {
                    Double data = Double.parseDouble(userInput);
                    this.binarySearch((E) data);
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                    this.outputArea.setText("Error, try again");
                }
            }
            else
            {
                this.outputArea.setText("Error");
            }
        });

        this.jumpSearchButton.addActionListener(e->{
            String userInput = this.textArea.getText();

            if(userInput.isEmpty())
            {
                this.outputArea.setText("The input should not be empty");
                return;
            }

            String dataType = selectedData.determineTypeWithRegex(userInput);

            if(Objects.equals(dataType, "string"))
            {
                try
                {
                    this.jumpSearch((E) userInput);
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                    this.outputArea.setText("Error, try again");
                }
            }else if (Objects.equals(dataType, "int"))
            {
                try{
                    Integer data = Integer.parseInt(userInput);
                    this.jumpSearch((E) data);
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                    this.outputArea.setText("Error, please try again");
                }
            }
            else if(Objects.equals(dataType, "double"))
            {
                try
                {
                    Double data = Double.parseDouble(userInput);
                    this.jumpSearch((E) data);
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                    this.outputArea.setText("Error, try again");
                }
            }
            else
            {
                this.outputArea.setText("Error");
            }
        });
    }

    private MyBinarySearchTree<E> createMBT(List<?> selectedDataLst)
    {
        MyBinarySearchTree<E> mbt = new MyBinarySearchTree<>();
        for(Object element: selectedDataLst)
        {
            mbt.addValue((E) element);
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

        this.outputArea.setText("Result: " + lst + "\nTime taken: " + time + " seconds");
    }

    private void binarySearch(E element)
    {
        boolean isContain = this.mbt.binarySearch(element);

        double time = Profiler.timeMe(() ->{
            this.mbt.binarySearch(element);
        });

        this.outputArea.setText("Result: " + (!isContain ? " Does not contain " : " Contains ") + element + "\nTime taken: " + time + " seconds");
    }

    private void jumpSearch(E element)
    {
        boolean isContain = this.mbt.jumpSearch(element);

        double time = Profiler.timeMe(() ->{
            this.mbt.jumpSearch(element);
        });

        this.outputArea.setText("Result: " + (!isContain ? " Does not contain " : " Contains ") + element + "\nTime taken: " + time + " seconds");
    }

}
