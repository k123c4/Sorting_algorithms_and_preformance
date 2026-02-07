import java.util.Random;

public class Tester {
    private final SortingAlgorithm sa;
    private final Random rng;

    /**
     * Constructor for the Tester that takes as parameter the sorting algorithm to be tested.
     */
    public Tester(SortingAlgorithm sa) {
        if (sa == null) {
            throw new IllegalArgumentException("SortingAlgorithm cannot be null");
        }
        this.sa = sa;
        this.rng = new Random(); // you can seed this if you want repeatable results
    }

    /**
     * Creates an array of integers of the given size, fills it with random numbers,
     * runs sorty, and returns the elapsed time in milliseconds.
     */
    public double singleTest(int size, boolean useKSorted) {
            int[] data = new int[size];
//        //  Generate random data
//        int[] data = new int[size];
//        for (int i = 0; i < size; i++) {
//            data[i] = rng.nextInt();
//        }

        // k sorted generate data
        if (useKSorted) {
            KSortedGenerator.generateKSorted(data); // 10-sorted
        } else {
            for (int i = 0; i < size; i++) data[i] = rng.nextInt(); // random
        }

        // Time the sorting call
        long start_time = System.nanoTime();
        sa.sorty(data);
        long end_time = System.nanoTime();

        // Convert nanoseconds → milliseconds
        return (end_time - start_time) / 1_000_000.0;
    }


    /**
     * Runs singleTest() iterations times and prints the average time in ms.
     */
    public void test(int iterations, int size) {
        if (iterations <= 0) {
            throw new IllegalArgumentException("iterations must be > 0");
        }

        double totalMs = 0.0;
        for (int i = 0; i < iterations; i++) {
            totalMs += singleTest(size);
        }

        double avgMs = totalMs / iterations;

        System.out.printf(
                "%s | iterations=%d | size=%d | avg=%.3f ms%n",
                sa.getClass().getSimpleName(),
                iterations,
                size,
                avgMs
        );
    }
}
