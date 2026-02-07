public class QuickSort implements SortingAlgorithm {

    @Override
    public int[] sorty(int[] input) {
        if (input == null) return null;

        quicksort(input, 0, input.length - 1);
        return input;
    }

    private void quicksort(int[] a, int lo, int hi) {
        if (lo >= hi) return;

        int pivotIndex = medianOfThree(a, lo, hi);
        int pivot = a[pivotIndex];

        // move pivot to end
        swap(a, pivotIndex, hi);

        int p = partition(a, lo, hi, pivot);

        quicksort(a, lo, p - 1);
        quicksort(a, p + 1, hi);
    }

    private int partition(int[] a, int lo, int hi, int pivot) {
        int i = lo; // place for next element < pivot
        for (int j = lo; j < hi; j++) {
            if (a[j] < pivot) {
                swap(a, i, j);
                i++;
            }
        }
        // put pivot into its final place
        swap(a, i, hi);
        return i;
    }

    // Returns the index of the median value among a[lo], a[mid], a[hi]
    private int medianOfThree(int[] a, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;

        int x = a[lo], y = a[mid], z = a[hi];

        if (x < y) {
            if (y < z) return mid;      // x < y < z
            if (x < z) return hi;       // x < z <= y
            return lo;                  // z <= x < y
        } else { // x >= y
            if (x < z) return lo;       // y <= x < z
            if (y < z) return hi;       // y < z <= x
            return mid;                 // z <= y <= x
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
