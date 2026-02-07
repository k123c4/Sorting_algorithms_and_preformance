public class ShellSort implements SortingAlgorithm {

    @Override
    public int[] sorty(int[] input) {
        if (input == null) return null;

        int n = input.length;

        for (int gap = n / 2; gap > 0; gap /= 2)
            for (int i = gap; i < n; ++i) {
                int tmp = input[i];
                int j;
                for (j = i; j >= gap && tmp < input[j - gap]; j -= gap) {
                    input[j] = input[j - gap];
                }
                input[j] = tmp;
            }
        return input;
    }
}
