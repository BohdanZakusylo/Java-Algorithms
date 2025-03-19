package UI;

import Queue.QueueImplementation;

import javax.swing.*;
import java.util.ArrayList;
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

    public QueuePanel(JFrame parentFrame, JPanel mainMenuPanel)
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
            QueueImplementation<Integer> queue = new QueueImplementation<Integer>();
            ArrayList<Integer> array = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < 10; i++)
            {
                array.add(random.nextInt(100));
            }
            queue.addAll(array);
            output.append("Original Queue elements: ");
            output.append("\n");
            output.append(queue.printToArray());
            output.append("\n");
            output.append("------------------------------------------------------------");
            output.append("\n");
            double time;
            time = timeMe(() ->
            {
                mergeSort(queue);
            });

            output.append("Sorted using mergesort in: " + time + " milliseconds");
            output.append("\n");
            output.append(queue.printToArray());

        });

        selectionSortButton.addActionListener(e ->
        {
            output.setText(null);

            AtomicReference<QueueImplementation<Integer>> queue = new AtomicReference<>(new QueueImplementation<Integer>());
            ArrayList<Integer> array = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < 10; i++)
            {
                array.add(random.nextInt(100));
            }
            queue.get().addAll(array);

            output.append("Original Queue elements: ");
            output.append("\n");
            output.append(queue.get().printToArray());
            output.append("\n");
            output.append("------------------------------------------------------------");
            output.append("\n");
            double time;
            time = timeMe(() ->
            {
                queue.set(selectionSort(queue.get()));
            });

            output.append("Sorted using SelectionSort in: " + time + " milliseconds");
            output.append("\n");
            output.append(queue.get().printToArray());
        });


    }
}
