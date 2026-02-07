public class BubbleSort implements SortingAlgorithm {

    @Override
    public int[] sorty(int[] input) {
        if (input == null) return null;

        int n = input.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; i < n - 1 - i; i++) {
                if (input[i] > input[i + 1]) {
                    int tmp = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break; // already sorted
        }
        return input;
    }
}
