import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Performance {

    public static void main(String[] args) {
        final int iterations = 20;
        final int[] sizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};

        SortingAlgorithm[] algorithms = {
                new BubbleSort(),
                new InsertionSort(),
                new SelectionSort(),
                new ShellSort(),
                new QuickSort(),
                new MergeSort()
        };

        String outFile = "performance_report.txt";

        try (PrintWriter out = new PrintWriter(new FileWriter(outFile))) {

            for (SortingAlgorithm algo : algorithms) {
                String name = algo.getClass().getSimpleName();
                out.println("Sorting algorithm – " + (name));

                Tester tester = new Tester(algo);

                for (int size : sizes) {
                    double avgMs = averageMs(tester, iterations, size);
                    out.printf("Sorted %d elements in %.3f ms (avg)%n", size, avgMs);
                }

                out.println(); // blank line between algorithms
            }

            System.out.println("Wrote report to: " + outFile);

        } catch (IOException e) {
            System.err.println("Failed to write report file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Runs Tester.singleTest() 'iterations' times and returns the average milliseconds.
     */
    private static double averageMs(Tester tester, int iterations, int size) {
        double total = 0.0;
        for (int i = 0; i < iterations; i++) {
            total += tester.singleTest(size);
        }
        return total / iterations;
    }


}
