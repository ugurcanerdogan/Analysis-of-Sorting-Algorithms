import java.util.Random;

public class Main {

    public static void main(String[] args) {
        showAllElapsingTimes(15, 256);
        stabilityShow();
    }

    public static void showAllElapsingTimes(int workTime, int length) {
        if (workTime == 1) {
            System.out.println("YOU MUST ENTER REPETITION TIME MORE THAN 1 !");
            return;
        }
        Forest[] randomForests = createRandomArray(length);
        Forest[] descForests = createDescendingArray(length);
        System.out.println();
        System.out.println("***--- Sort algorithm and elapsing times (milliseconds) ---***");
        System.out.println(String.format("       (Repetition Time : %1$d) --- (Array length : %2$s) ", workTime, length));
        System.out.println("----------------------------------------");
        System.out.print("AVG FOR --> Comb sort: ");
        printAvgElapsingTime(descForests, workTime, new CombSort());
        System.out.print("WORST FOR --> Comb sort: ");
        printAvgElapsingTime(randomForests, workTime, new CombSort());
        System.out.println("----------------------------------------");
        System.out.print("AVG FOR --> Gnome sort: ");
        printAvgElapsingTime(randomForests, workTime, new GnomeSort());
        System.out.print("WORST FOR --> Gnome sort: ");
        printAvgElapsingTime(descForests, workTime, new GnomeSort());
        System.out.println("----------------------------------------");
        System.out.print("AVG FOR --> Shake sort: ");
        printAvgElapsingTime(randomForests, workTime, new ShakeSort());
        System.out.print("WORST FOR --> Shake sort: ");
        printAvgElapsingTime(descForests, workTime, new ShakeSort());
        System.out.println("----------------------------------------");
        System.out.print("AVG FOR --> Stooge sort: ");
        printAvgElapsingTime(randomForests, workTime, new StoogeSort());
        System.out.print("WORST FOR --> Stooge sort: ");
        printAvgElapsingTime(descForests, workTime, new StoogeSort());
        System.out.println("----------------------------------------");
        System.out.print("AVG FOR --> Bitonic sort: ");
        printAvgElapsingTime(descForests, workTime, new BitonicSort());
        System.out.print("WORST FOR --> Bitonic sort: ");
        printAvgElapsingTime(randomForests, workTime, new BitonicSort());
        System.out.println("----------------------------------------");
    }


    public static void elapsingTimesShow(Forest[] forests, int workTime) {
        if (workTime == 1) {
            System.out.println("YOU MUST ENTER REPETITION TIME MORE THAN 1 !");
            return;
        }
        System.out.println("***--- Sort algorithms and elapsing times ---***");
        System.out.print("Comb sort: ");
        printAvgElapsingTime(forests, workTime, new CombSort());
        System.out.print("Gnome sort: ");
        printAvgElapsingTime(forests, workTime, new GnomeSort());
        System.out.print("Shake sort: ");
        printAvgElapsingTime(forests, workTime, new ShakeSort());
        System.out.print("Bitonic sort: ");
        printAvgElapsingTime(forests, workTime, new BitonicSort());
        System.out.print("Stooge sort: ");
        printAvgElapsingTime(forests, workTime, new StoogeSort());
    }


    public static void stabilityShow() {
        System.out.println("***--- Sort algorithms and stabilities ---***");
        System.out.println("Comb sort: " + (stabilityCheck(new CombSort()) ? "is stable." : "is NOT stable."));
        System.out.println("Gnome sort: " + (stabilityCheck(new GnomeSort()) ? "is stable." : "is NOT stable."));
        System.out.println("Shake sort: " + (stabilityCheck(new ShakeSort()) ? "is stable." : "is NOT stable."));
        System.out.println("Stooge sort: " + (stabilityCheck(new StoogeSort()) ? "is stable." : "is NOT stable."));
        System.out.println("Bitonic sort: " + (stabilityCheck(new BitonicSort()) ? "is stable." : "is NOT stable."));
    }

    public static boolean stabilityCheck(ISort obj1) {
        Forest _1a = new Forest(1, "A");
        Forest _2a = new Forest(2, "A");
        Forest _2b = new Forest(2, "B");
        Forest _3a = new Forest(3, "A");
        Forest _3b = new Forest(3, "B");
        Forest _3c = new Forest(3, "C");

        String[] checkLetters = new String[]{"A", "B", "A", "C", "B", "A"};
        Forest[] forest1 = {_3c, _3b, _3a, _2b, _2a, _1a};

        forest1 = obj1.sort(forest1);

        for (int i = 0; i < forest1.length; i++) {
            if (!forest1[i].getForestName().equalsIgnoreCase(checkLetters[i])) {
                return false;
            }
        }
        return true;
    }

    public static void printAvgElapsingTime(Forest[] forestArr, int workTime, ISort obj1) {
        double[] times = new double[workTime];
        for (int i = 0; i < workTime; i++) {
            Stopwatch st1 = new Stopwatch();
            obj1.sort(forestArr);
            times[i] = st1.elapsedTimeMillis();
        }
        System.out.println(getAverageTime(times) * Math.pow(10, 0));
    }

    public static double getAverageTime(double[] times) {
        double sum = 0;
        for (int i = 1; i < times.length; i++) {
            sum += times[i];
        }
        return sum / (times.length - 1);
    }

    public static Forest[] createDescendingArray(int length) {
        Forest[] forestArray = new Forest[length];
        for (int i = 0; i < length; ++i) {
            String typeValue = "Tree-" + i;
            Forest forest = new Forest(length - 1 - i, typeValue);
            forestArray[i] = forest;
        }
        return forestArray;
    }

    public static Forest[] createRandomArray(int length) {
        Forest[] forestArray = new Forest[length];
        Random rnd = new Random();
        for (int i = 0; i < length; i++) {
            String typeValue = "Tree-" + i;
            Forest forest = new Forest(rnd.nextInt(length), typeValue);
            forestArray[i] = forest;
        }
        return forestArray;
    }

    public static void printArrayWithForestNames(Forest[] a) {
        for (Forest forest : a) System.out.print(forest.getForestName() + " ");
        System.out.println();
    }

    public static void printArrayWithNumberOfTrees(Forest[] a) {
        for (Forest forest : a) System.out.print(forest.getNumberOfTrees() + " ");
        System.out.println();
    }
}