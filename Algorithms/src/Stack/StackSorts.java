package Stack;

public class StackSorts {

    private static <E extends Comparable<E>> int partition(StackImplementation stack, int low, int high)
    {
        StackImplementation highStack = new StackImplementation();
        StackImplementation lowStack = new StackImplementation();

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

        System.out.println("------------Sorted stack state------------");
        stack.print();
        System.out.println("------------------------------------------");
        return i + 1;
    }

    public static <E extends Comparable<E>> void quickSortIter(StackImplementation stack)
    {
        StackImplementation<Integer> auxStack = new StackImplementation();
        int low = 0;
        int high = stack.size() - 1;

        auxStack.push(low);
        auxStack.push(high);
        while (!auxStack.empty())
        {
            System.out.println("------------Current stack------------");
            auxStack.print();
            System.out.println("-------------------------------------");
            System.out.println();
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
