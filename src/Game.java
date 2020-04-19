import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;

public class Game {
    private static int WORLD_SIZE_X = 10, WORLD_SIZE_Y = 10;
    private Cell[][] world = new Cell[WORLD_SIZE_X][WORLD_SIZE_Y];
    private int lifeCycles;
    private Game gameWorld;
    private int nIteration;

    private Game() {
        nIteration = 0;
        for (int y = 0; y < WORLD_SIZE_Y; y++) {
            for (int x = 0; x < WORLD_SIZE_X; x++) {
                Random randomGen = new Random();
                int r = randomGen.nextInt(2);
                Cell cell = new Cell();
                cell.setName("X" + x + "Y" + y);
                if (r == 0) {
                    cell.setAlive(false);
                } else {
                    cell.setAlive(true);
                }
                world[x][y] = cell;
            }
        }
    }

    public static Game intialize() {
        Game gameWorld = new Game();
        return gameWorld;
    }

    public Game update() {
        nIteration++;
        int yMax = this.world.length;
        int xMax = this.world[0].length;
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                List neighborList = new ArrayList();
                if (y < WORLD_SIZE_Y - 1 && x > 0) {
                    if (world[x - 1][y + 1].isAlive()) {
                        neighborList.add("SW");
                    }
                }
                if (y < WORLD_SIZE_Y - 1) {
                    if (world[x][y + 1].isAlive()) {
                        neighborList.add("S");
                    }
                }
                if (x < WORLD_SIZE_X - 1 && y < WORLD_SIZE_Y - 1) {
                    if (world[x + 1][y + 1].isAlive()) {
                        neighborList.add("SE");
                    }
                }
                if (x > 0) {
                    if (world[x - 1][y].isAlive()) {
                        neighborList.add("W");
                    }
                }
                if (x < WORLD_SIZE_X - 1) {
                    if (world[x + 1][y].isAlive()) {
                        neighborList.add("E");
                    }
                }
                if (x > 0 && y > 0) {
                    if (world[x - 1][y - 1].isAlive()) {
                        neighborList.add("NW");
                    }
                }
                if (y > 0) {
                    if (world[x][y - 1].isAlive()) {
                        neighborList.add("N");
                    }
                }
                if (x < WORLD_SIZE_X - 1 && y > 0) {
                    if (world[x + 1][y - 1].isAlive()) {
                        neighborList.add("NE");
                    }
                }
                world[x][y].setLivingNeighbours(neighborList.size());
                world[x][y].setNeighborList(neighborList);
            }
        }
        for (int y = 0; y < yMax; y++) {
            for (int x = 0; x < xMax; x++) {
                String result = world[x][y].update();
            }
        }
        return gameWorld;
    }

    public static int getWorldSizeX() {
        return WORLD_SIZE_X;
    }

    public static void setWorldSizeX(int worldSizeX) {
        WORLD_SIZE_X = worldSizeX;
    }

    public static int getWorldSizeY() {
        return WORLD_SIZE_Y;
    }

    public static void setWorldSizeY(int worldSizeY) {
        WORLD_SIZE_Y = worldSizeY;
    }

    public int getLifeCycles() {
        return lifeCycles;
    }

    public void setLifeCycles(int lifeCycles) {
        this.lifeCycles = lifeCycles;
    }

    public Cell[][] getWorld() {
        return world;
    }

    public void setWorld(Cell[][] world) {
        this.world = world;
    }

    public int getnIteration() {
        return nIteration;
    }

    public void setnIteration(int nIteration) {
        this.nIteration = nIteration;
    }
}
