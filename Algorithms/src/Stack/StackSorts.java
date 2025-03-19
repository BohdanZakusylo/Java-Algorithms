package Stack;

public class StackSorts {

    private static <E extends Comparable<E>> int partition(StackImplementation stack, int low, int high)
    {
        StackImplementation highStack = new StackImplementation(stack.size());
        StackImplementation lowStack = new StackImplementation(stack.size());

        int size = stack.size();
        for (int i = 0; i < (size) - high; i++)
        {
            highStack.push(stack.pop());
        }
        E pivot = (E) stack.pop();

        int i = (low - 1);
        for (int j = low; j <= (high - 1); j++) {
            E element = (E) stack.pop();
            if (element.compareTo(pivot) <= 0) {
                i++; // Track position of pivot
                lowStack.push(element);
            } else {
                highStack.push(element);
            }
        }

        while (!lowStack.empty())
        {
            stack.push(lowStack.pop());
        }
        stack.push(pivot);
        while (!highStack.empty())
        {
            stack.push(highStack.pop());
        }

        return i + 1;
    }

    public static <E extends Comparable<E>> void quickSortIter(StackImplementation stack)
    {
        StackImplementation<Integer> auxStack = new StackImplementation(stack.size());
        int low = 0;
        int high = stack.size();

        auxStack.push(low);
        auxStack.push(high);
        while (!auxStack.empty())
        {
            high = auxStack.pop();
            low = auxStack.pop();

            int pivot = partition(stack, low, high);
            if ((pivot - 1) > low)
            {
                auxStack.push(low);
                auxStack.push(pivot - 1);
            }

            if ((pivot + 1) < high)
            {
                auxStack.push(pivot + 1);
                auxStack.push(high);
            }
        }

    }


}
