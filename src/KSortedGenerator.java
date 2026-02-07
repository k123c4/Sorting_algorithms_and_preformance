import java.util.Arrays;
import java.util.Random;

public class KSortedGenerator {

    /**
     * Fills 'a' with 10-sorted data (each element is within 10 positions
     * of its position in the fully sorted array of the same values).
     */
    public static void generateKSorted(int[] a) {
        generateKSorted(a, 10, new Random());
    }

    /**
     * General k-sorted generator (guaranteed).
     */
    public static void generateKSorted(int[] a, int k, Random rng) {

        int n = a.length;

        // Generate random values
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = rng.nextInt();
        }

        // Sort to define each element's "correct" position
        Arrays.sort(sorted);

        // 3) Build a k-sorted permutation:
        // Keep a pool of the next (k+1) items; choose randomly from that pool.
        int poolSize = Math.min(k + 1, n);
        int[] pool = new int[poolSize];

        // Fill initial pool
        for (int i = 0; i < poolSize; i++) {
            pool[i] = sorted[i];
        }

        int nextIndex = poolSize; // next item to add into the pool from 'sorted'

        for (int out = 0; out < n; out++) {
            int r = rng.nextInt(poolSize); // pick random from the next k+1 items
            a[out] = pool[r];

            // Replace the chosen pool element with the next sorted value if available,
            // otherwise remove it from the pool (swap with last).
            if (nextIndex < n) {
                pool[r] = sorted[nextIndex++];
            } else {
                pool[r] = pool[poolSize - 1];
                poolSize--;
            }
        }
    }
}
