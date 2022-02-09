public class BitonicSort implements ISort {

    /* The parameter dir indicates the sorting direction,
          ASCENDING or DESCENDING; if (a[i] > a[j]) agrees
          with the direction, then a[i] and a[j] are
          swapped. */
    void compAndSwap(Forest[] a, int i, int j, int dir) {
        if ((a[i].getNumberOfTrees() > a[j].getNumberOfTrees() && dir == 1) ||
                (a[i].getNumberOfTrees() < a[j].getNumberOfTrees() && dir == 0)) {
            // Swapping objects
            Forest temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    /* It recursively sorts a bitonic sequence in ascending
          order, if dir = 1, and in descending order otherwise
          (means dir=0). The array to be sorted starts at
          index position low, the parameter count(cnt) is the number
          of objects to be sorted.*/
    void bitonicMerge(Forest[] a, int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            for (int i = low; i < low + k; i++)
                compAndSwap(a, i, i + k, dir);
            bitonicMerge(a, low, k, dir);
            bitonicMerge(a, low + k, k, dir);
        }
    }

    /* This function first produces a bitonic sequence by
       recursively sorting its two halves in opposite sorting
       orders, and then  calls bitonicMerge to make them in
       the same order */
    void bitonicSort(Forest[] a, int low, int cnt, int dir) {
        if (cnt > 1) {
            int k = cnt / 2;
            // sort in ascending order since dir here is 1
            bitonicSort(a, low, k, 1);
            // sort in descending order since dir here is 0
            bitonicSort(a, low + k, k, 0);
            // Will merge whole array in ascending order
            // since dir=1.
            bitonicMerge(a, low, cnt, dir);
        }
    }

    public Forest[] sort(Forest[] forest) {
        Forest[] a = forest.clone(); // cloning parameter array and working on its clone.
        int N = a.length;
        bitonicSort(a, 0, N, 1); // automatically we sort it in ascending order.
        return a;
    }
}