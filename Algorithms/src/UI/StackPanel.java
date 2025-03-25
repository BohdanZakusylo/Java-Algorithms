package UI;

import ImportData.SelectedData;
import Stack.StackImplementation;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static Queue.Profiler.timeMe;
import static Stack.StackSorts.quickSortIter;

public class StackPanel extends JPanel
{
    private JPanel stackPanel;
    private JButton quickSortButton;
    private JButton backButton;
    private JTextArea output;

    public StackPanel(JFrame parentFrame, JPanel mainMenuPanel, SelectedData<?> selectedData)
    {  // Pass original contentPane
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(stackPanel);

        backButton.addActionListener(e ->
        {
            parentFrame.setContentPane(mainMenuPanel); // Restore MainMenu panel
            parentFrame.revalidate();
            parentFrame.repaint();
        });

        quickSortButton.addActionListener(e ->
        {
            output.setText(null);
            List<?> array = new ArrayList<>(selectedData.getDataPoints());
            StackImplementation<?> stack = new StackImplementation<>(array);

            output.append("Original stack elements: ");
            output.append("\n");
            output.append("------------------------------------------------------------");
            output.append("\n");
            double time;
            time = timeMe(() ->
            {
                quickSortIter(stack);
            });

            output.append("Sorted using mergesort in: " + time + " milliseconds");
            output.append("\n");
            System.out.println(stack.print());
        });

    }
}
