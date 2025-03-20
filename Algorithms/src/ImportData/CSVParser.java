package ImportData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class CSVParser<E>
{
 private File importedFile;
 private Function<String, String> valueParser;
 private HashMap<String, List<String>> parsedContent;

    public CSVParser()
    {
       parsedContent = new HashMap<>();
    }

    public HashMap<String, List<String>> getParsedContent()
    {
        return parsedContent;
    }

    public void setParsedContent(HashMap<String, List<String>> parsedContent)
    {
        this.parsedContent = parsedContent;
    }

    public File getImportedFile()
    {
        return importedFile;
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

            String[] headers = headerLine.split(",");
            for (String header : headers)
            {
                dataMap.put(header.trim(), new ArrayList<>());
            }

            String line;
            while ((line = br.readLine()) != null)
            {
                String[] values = line.split(",", headers.length);
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

        setParsedContent(dataMap);
    }

    private boolean isCorrectFileType(File importedFile)
    {
        String fileName = importedFile.getName();
        int lastIndex = fileName.lastIndexOf('.');
        String type = (lastIndex == -1) ? "" : fileName.substring(lastIndex);
        if (!type.equals(".csv"))
        {
            throw new IllegalArgumentException("We only accept csv files");
        }
        else return true;
    }

}
