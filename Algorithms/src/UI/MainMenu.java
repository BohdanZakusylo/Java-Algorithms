package UI;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MainMenu<E> extends JFrame {
    private JButton queueButton;
    private JButton stackButton;
    private JButton quitButton;
    private JButton importDataButton;
    private JPanel contentPane;
    private JButton binarySearchTreeButton;

    public MainMenu()
    {
        setTitle("Something");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();

        ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(23, 1, 5, 7, 123, 56, 78, 76, 234,111));
        binarySearchTreeButton.addActionListener(e ->{
            setContentPane(new BinarySearchTreeUI<Integer>(this, contentPane, ints));
            revalidate();
            repaint();
        });
    }

}
