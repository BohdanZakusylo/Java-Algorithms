package Stack;

public class StackSorts {

    private static <E extends Comparable<E>> int partition(StackImplementation stack, int low, int high)
    {
        // Instead of swapping indexes, split into higher and lower stack
        // The pivot is moved between the higher and lower stacks
        StackImplementation highStack = new StackImplementation(stack.size());
        StackImplementation lowStack = new StackImplementation(stack.size());

        int size = stack.size();
        for (int i = 0; i < (size - 1) - high; i++)
        {
            highStack.push(stack.pop());
        }
        E pivot = (E) stack.pop();

        int i = (low - 1);
        for (int j = low; j <= (high - 1); j++) {
            E element = (E) stack.pop();
            if (element.compareTo(pivot) <= 0) {
                lowStack.push(element);
            } else {
                highStack.push(element);
            }
        }

        while (!lowStack.empty())
        {
            stack.push(lowStack.pop());
        }
        stack.push(pivot); // Add pivot back into stack at correct position
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
        int high = stack.size() - 1; // Default pivot for QuickSort

        auxStack.push(low);
        auxStack.push(high);
        while (!auxStack.empty())
        {
            // Read in reverse order because of the stack
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
            // If neither condition is met, nothing gets pushed to the stack
            // If the stack is empty after this, the data is sorted
        }

    }


}
