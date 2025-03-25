package Queue;

public class Profiler
{
    public static double timeMe(Runnable function)
    {
        long startTime = System.nanoTime();
        function.run();
        long endTime = System.nanoTime();

        return (double) Math.round((endTime - startTime) / 100_000_000.0) / 10; // Convert nanoseconds to milliseconds
    }
}
