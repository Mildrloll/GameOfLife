public class Cell {
    private int livingNeighbours;
    private boolean alive;

    public String update() {
        String strAlive = "dead";
        if (alive) {
            strAlive = "alive";
        }
        return strAlive;
    }
}
