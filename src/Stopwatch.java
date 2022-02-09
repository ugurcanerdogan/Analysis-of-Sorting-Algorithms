public class Stopwatch {

    private final long start;

    //Initializes a new stopwatch.
    public Stopwatch() {
        start = System.currentTimeMillis();
    }

    // Returns the elapsed CPU time (in milliseconds) since the stopwatch was created.
    public double elapsedTimeMillis() {
        long now = System.currentTimeMillis();
        return (now - start);
    }
    // Returns the elapsed CPU time (in seconds) since the stopwatch was created.
    public double elapsedTimeSeconds() {
        long now = System.nanoTime();
        return (now - start) / 1000.0;
    }
}