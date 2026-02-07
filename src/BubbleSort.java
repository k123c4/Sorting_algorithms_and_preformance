public class BubbleSort implements SortingAlgorithm {

    @Override
    public int[] sorty(int[] input) {
        if (input == null) return null;

        int[] a = input.clone();
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; i < n - 1 - i; i++) {
                if (a[i] > a[i + 1]) {
                    int tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break; // already sorted
        }
        return a;
    }
}
