public class CombSort implements ISort {
    // To find gap between elements
    int getNextGap(int gap) {
        // Shrink gap by shrink factor
        gap = (gap * 10) / 13;
        if (gap < 1)
            return 1;
        return gap;
    }

    // Function to sort arr[] using Comb Sort
    public Forest[] sort(Forest[] forest) {
        Forest[] arr = forest.clone();
        int n = arr.length;

        // initialize gap
        int gap = n;

        // Initialize swapped as true to make sure that
        // loop runs
        boolean swapped = true;

        // Keep running while gap is more than 1 and last
        // iteration caused a swap
        while (gap != 1 || swapped) {
            // Find next gap
            gap = getNextGap(gap);

            // Initialize swapped as false so that we can
            // check if swap happened or not
            swapped = false;

            // Compare all objects with current gap
            for (int i = 0; i < n - gap; i++) {
                if (arr[i].getNumberOfTrees() > arr[i + gap].getNumberOfTrees()) {
                    // Swap arr[i] and arr[i+gap]
                    Forest temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;

                    // Set swapped true
                    swapped = true;
                }
            }
        }
        return arr;
    }
}