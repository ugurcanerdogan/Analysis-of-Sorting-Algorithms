public class StoogeSort implements ISort {

    public static void stoogeSort(Forest[] L, int i, int j) {
        // If first number is smaller than last,
        // swap them
        if (L[j].getNumberOfTrees() < L[i].getNumberOfTrees()) {
            Forest tmp = L[i];
            L[i] = L[j];
            L[j] = tmp;
        }
        // If there are more than 2 elements in
        // the array
        if (j - i > 1) {
            int t = (j - i + 1) / 3;
            // Recursively sort first 2/3 objects
            stoogeSort(L, i, j - t);
            // Recursively sort last  2/3 objects
            stoogeSort(L, i + t, j);
            // Recursively sort first 2/3 objects
            // again to confirm
            stoogeSort(L, i, j - t);
        }
    }

    public Forest[] sort(Forest[] forest) {
        Forest[] L = forest.clone(); // cloning parameter array and working on its clone.
        stoogeSort(L, 0, L.length - 1);
        return L;
    }
}