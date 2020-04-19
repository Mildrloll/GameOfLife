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

    public int getLivingNeighbours() {
        return livingNeighbours;
    }

    public void setLivingNeighbours(int livingNeighbours) {
        this.livingNeighbours = livingNeighbours;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
