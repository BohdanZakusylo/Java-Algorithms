package ImportData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;


public class SelectedData<E>
{
    private List<E> dataPoints;
    private String dataName;

    public SelectedData()
    {
    }

    public SelectedData(List<E> dataPoints, String selectedName)
    {
        this.dataPoints = dataPoints;
        this.dataName = selectedName;
    }

    public String getSelectedName()
    {
        return dataName;
    }

    public void setSelectedName(String selectedName)
    {
        this.dataName = selectedName;
    }

    public List<E> getDataPoints()
    {
        return dataPoints;
    }

    public void setDataPoints(List<String> dataPoints)
    {

        if (dataPoints == null || dataPoints.isEmpty())
        {
            this.dataPoints = new ArrayList<>();
            return;
        }

        dataPoints.removeIf(Objects::isNull);
        dataPoints.removeIf(e -> e instanceof String && ((String) e).isEmpty());

        String firstElement = dataPoints.get(0);
        System.out.println(firstElement);
        String type = determineTypeWithRegex(firstElement);

        List<E> convertedList = new ArrayList<>();

        switch (type) {
            case "int":
                for (String item : dataPoints)
                {
                    convertedList.add((E) Integer.valueOf(item));
                }
                break;

            case "double":
                for (String item : dataPoints)
                {
                    try
                    {
                        convertedList.add((E) Double.valueOf(item));
                    }
                    catch (Exception e)
                    {
                        System.out.println("error with variable: "+ item + " at: " + dataPoints.indexOf(item));

                    }

                }
                break;

            case "boolean":
                for (String item : dataPoints)
                {
                    convertedList.add((E) Boolean.valueOf(item));
                }
                break;

            case "string":
            default:
                for (String item : dataPoints)
                {
                    convertedList.add((E) item);
                }
                break;
    }
    this.dataPoints = convertedList;
}

    public String determineTypeWithRegex(String input) {
        if (input == null || input.isEmpty()) {
            return "string";
        }

        try
        {
            Integer.parseInt(input);
            return "int";
        }
        catch (NumberFormatException e1)
        {
            try
            {
                Double.parseDouble(input);
                return "double";
            }
            catch (NumberFormatException e2)
            {
                if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false"))
                {
                    return "boolean";
                }
                return "string";
            }
        }
    }

}
