package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
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

        queueButton.addActionListener(e -> {
            setContentPane(new QueuePanel(this, contentPane)); // Pass the original contentPane
            revalidate();
            repaint();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainMenu::new);
    }
}
