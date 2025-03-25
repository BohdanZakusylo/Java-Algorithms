package UI;

import ImportData.CSVParser;
import ImportData.SelectedData;

import javax.swing.*;
import java.io.File;
import java.util.List;

public class MainMenu extends JFrame {
    private JButton queueButton;
    private JButton stackButton;
    private JButton quitButton;
    private JButton importDataButton;
    private JPanel contentPane;
    private JButton binarySearchTreeButton;
    private JComboBox<String> dropDownValue;
    private JButton applyDataButton;
    private JTextField selectedDataTextField;

    public MainMenu()
    {
        setTitle("Something");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();

        CSVParser<Object> parser = new CSVParser<>();
        SelectedData<String> selectedData = new SelectedData<>();

        importDataButton.addActionListener(e ->
        {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null); // Show open dialog

            if (returnValue == JFileChooser.APPROVE_OPTION)
            {
                File selectedFile = fileChooser.getSelectedFile();
                parser.setImportedFile(selectedFile);
                parser.parseToHashMap();

                for (String key : parser.getParsedContent().keySet())
                {
                    dropDownValue.addItem(key);
                }

                dropDownValue.setSelectedItem(dropDownValue.getItemAt(0));

                if (dropDownValue.getItemCount() > 0)
                {
                    dropDownValue.setSelectedIndex(0);
                }

                dropDownValue.setVisible(true);
                applyDataButton.setVisible(true);
            }
        });

        applyDataButton.addActionListener(e ->
        {
            String selectedItem = (String) dropDownValue.getSelectedItem();
            List<String> dataPoints = parser.getParsedContent().get(selectedItem);

            selectedData.setDataPoints(dataPoints);
            selectedData.setSelectedName(selectedItem);

            selectedDataTextField.setText("Currently selected data is: " + selectedData.getSelectedName());
            selectedDataTextField.setVisible(true);

            // System.out.println(selectedData.getDataPoints().get(0).getClass().getName());

            revalidate();
            repaint();
        });

        queueButton.addActionListener(e -> {
            setContentPane(new QueuePanel(this, contentPane, selectedData));
            revalidate();
            repaint();
        });

        stackButton.addActionListener(e -> {
            setContentPane(new StackPanel(this, contentPane, selectedData));
            revalidate();
            repaint();
        });

        binarySearchTreeButton.addActionListener(e ->{
            setContentPane(new BinarySearchTreeUI(this, contentPane, selectedData));
            revalidate();
            repaint();
        });
    }

}
