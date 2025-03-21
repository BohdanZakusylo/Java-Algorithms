package ImportData;

import java.io.*;
import java.util.*;
import java.util.function.Function;

public class CSVParser<E>
{
    private File importedFile;
    private HashMap<String, List<String>> parsedContent;

    public CSVParser()
    {
        parsedContent = new HashMap<>();
    }

    public HashMap<String, List<String>> getParsedContent()
    {
        return parsedContent;
    }

    public void setImportedFile(File importedFile)
    {
        if (isCorrectFileType(importedFile))
        {
            this.importedFile = importedFile;
        }
    }

    public void parseToHashMap()
    {
        HashMap<String, List<String>> dataMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(importedFile)))
        {
            String headerLine = br.readLine();
            if (headerLine == null)
            {
                throw new RuntimeException("CSV file is empty!");
            }

            String[] headers = cleanCSVLine(headerLine);
            for (String header : headers)
            {
                dataMap.put(header.trim(), new ArrayList<>());
            }

            String line;
            while ((line = br.readLine()) != null)
            {
                String[] values = cleanCSVLine(line);
                for (int i = 0; i < headers.length; i++)
                {
                    String columnName = headers[i].trim();
                    String value = (i < values.length) ? values[i].trim() : "";
                    dataMap.get(columnName).add(value);
                }
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException("Error reading CSV file: " + e.getMessage(), e);
        }

        this.parsedContent = dataMap;
    }

    private boolean isCorrectFileType(File importedFile)
    {
        String fileName = importedFile.getName().toLowerCase();
        if (!fileName.endsWith(".csv"))
        {
            throw new IllegalArgumentException("We only accept CSV files");
        }
        return true;
    }

    private String[] cleanCSVLine(String line)
    {
        List<String> values = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder value = new StringBuilder();

        for (char c : line.toCharArray())
        {
            if (c == '"')
            {
                inQuotes = !inQuotes;
            }
            else if (c == ',' && !inQuotes)
            {
                values.add(value.toString().trim());
                value.setLength(0);
            }
            else
            {
                value.append(c);
            }
        }
        values.add(value.toString().trim());

        return values.toArray(new String[0]);
    }
}