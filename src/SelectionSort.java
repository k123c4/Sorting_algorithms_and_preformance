public class SelectionSort implements SortingAlgorithm {

    @Override
    public int[] sorty(int[] input) {
        if (input == null) return null;

        int n = input.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (input[j] < input[minIdx]) minIdx = j;
            }
            if (minIdx != i) {
                int tmp = input[i];
                input[i] = input[minIdx];
                input[minIdx] = tmp;
            }
        }
        return input;
    }
}
