package Queue;

public class Profiler
{
    public static double timeMe(Runnable function)
    {
        long startTime = System.nanoTime();
        function.run();
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1_000_000.0; // Convert nanoseconds to milliseconds
    }
}
