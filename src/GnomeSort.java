public class GnomeSort implements ISort {

    public Forest[] sort(Forest[] forest) {

        Forest[] arr = forest.clone(); // cloning parameter array and working on its clone.
        int index = 0;

        while (index < forest.length) {
            if (index == 0)
                index++;
            if (arr[index].getNumberOfTrees() >= arr[index - 1].getNumberOfTrees())
                index++;
            else {
                // Swapping objects
                Forest temp;
                temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
        return arr;
    }
}