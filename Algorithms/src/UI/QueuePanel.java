package UI;

import ImportData.SelectedData;
import Queue.QueueImplementation;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

import static Queue.Profiler.timeMe;
import static Queue.QueueSorts.mergeSort;
import static Queue.QueueSorts.selectionSort;

public class QueuePanel extends JPanel
{
    private JButton mergeSortButton;
    private JPanel queuePanel;
    private JButton selectionSortButton;
    private JButton backButton;
    private JTextArea output;
    private JLabel slowLabel;

    public QueuePanel(JFrame parentFrame, JPanel mainMenuPanel, SelectedData<?> selectedData)
    {  // Pass original contentPane
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(queuePanel);

        backButton.addActionListener(e ->
        {
            parentFrame.setContentPane(mainMenuPanel); // Restore MainMenu panel
            parentFrame.revalidate();
            parentFrame.repaint();
        });

        mergeSortButton.addActionListener(e ->
        {
            output.setText(null);
            QueueImplementation<?> queue = new QueueImplementation<>();
            List<?> array = new ArrayList<>(selectedData.getDataPoints());
            queue.addAll(array);

            output.append("Original Queue elements: ");
            output.append("\n");
            output.append("------------------------------------------------------------");
            output.append("\n");
            double time;
            time = timeMe(() ->
            {
                mergeSort(queue);
            });

            output.append(queue.printToArray() + "\n");
            output.append("\n");
            output.append("Sorted using mergesort in: " + time + " seconds");
            System.out.println(queue.printToArray());
        });

        selectionSortButton.addActionListener(e -> {
            output.setText(null);

            // Get the list of data points
            ArrayList<?> array = new ArrayList<>(selectedData.getDataPoints());

            // Create a queue with a proper generic type
            QueueImplementation<?> queue = new QueueImplementation<>();
            queue.addAll(array);

            // Measure sorting time
            double time = timeMe(() -> {
                selectionSort(queue);
            });

            output.append(queue.printToArray() + "\n");
            output.append("\n");
            output.append("Sorted using SelectionSort in: " + time + " seconds");
        });


    }
}
