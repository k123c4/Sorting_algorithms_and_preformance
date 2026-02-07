public class MergeSort implements SortingAlgorithm {

    @Override
    public int[] sorty(int[] input) {
        if (input == null) return null;

        int[] aux = new int[input.length];
        mergesort(input, aux, 0, input.length - 1);
        return input;
    }

    private void mergesort(int[] a, int[] aux, int lo, int hi) {
        if (lo >= hi) return;

        int mid = lo + (hi - lo) / 2;
        mergesort(a, aux, lo, mid);
        mergesort(a, aux, mid + 1, hi);


        merge(a, aux, lo, mid, hi);
    }

    private void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) aux[k] = a[k];

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }
}
