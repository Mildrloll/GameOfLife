import java.util.Random;

public class Game {
    private static int WORLD_SIZE_X = 10, WORLD_SIZE_Y = 10;
    private Cell[][] world = new Cell[WORLD_SIZE_X][WORLD_SIZE_Y];

    private Game() {
        for (int y = 0; y < WORLD_SIZE_Y; y++) {
            for (int x = 0; x < WORLD_SIZE_X; x++) {
                Random randomGen = new Random();
                int r = randomGen.nextInt(2);
                Cell cell = new Cell();
                if (r == 0) {
                    cell.setAlive(false);
                } else {
                    cell.setAlive(true);
                }
            }
        }
    }
}
