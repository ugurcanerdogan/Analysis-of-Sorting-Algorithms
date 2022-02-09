public class Forest {
    private final int numberOfTrees; // main compare attribute
    private final String forestName; // stability check attribute

    public Forest(int treeVal, String typeVal) {
        this.numberOfTrees = treeVal;
        this.forestName = typeVal;
    }

    public int getNumberOfTrees() {
        return numberOfTrees;
    }

    public String getForestName() {
        return forestName;
    }

    @Override
    public String toString() {
        return "Forest{" +
                "numberOfTrees=" + numberOfTrees +
                ", forestName='" + forestName + '\'' +
                '}';
    }
}
