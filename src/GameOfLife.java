import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameOfLife extends Application {
    private Cell[][] matrix;
    private Label label;
    private Game gameWorld;
    private Pane root;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        Game gameWorld = Game.intialize();
        matrix = gameWorld.getWorld();
        updateScene(matrix, root);
        Scene scene = new Scene(root, 640, 400);
        Button button = new Button();
        button.setText("100 iterations");
        button.setOnAction((ActionEvent event) -> {
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(300), ae -> evolve(gameWorld, root)));
            timeline.setCycleCount(100);
            timeline.play();
        });
        label = new Label("0");
        label.setLayoutX(200);
        root.getChildren().add(label);
        root.getChildren().add(button);
        primaryStage.setTitle("Game of Life");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void evolve(Game gameWorld, Pane root) {
        matrix = gameWorld.getWorld();
        gameWorld.update();
        updateScene(matrix, root);
        String iterations = String.valueOf(gameWorld.getnIteration());
        label.setText(iterations);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void updateScene(Cell[][] matrix, Pane root) {
        root.getChildren().removeAll();
        int yMax = matrix.length;
        int xMax = matrix[0].length;
        for (int x = 0; x < xMax; x++) {
            for (int y = 0; y < yMax; y++) {
                double xVal = x * 20 + 20;
                double yVal = y * 20 + 20;
                Paint color;
                if (matrix[x][y].isAlive()) {
                    color = Paint.valueOf("RED");
                } else {
                    color = Paint.valueOf("WHITE");
                }
                Circle circle = new Circle(xVal, yVal, 6, color);
                if (matrix[x][y].isAlive()) {
                    circle.setStrokeType(StrokeType.OUTSIDE);
                    circle.setStroke(Color.web("red", 1));
                    circle.setStrokeWidth(2);
                } else {
                    circle.setStrokeType(StrokeType.OUTSIDE);
                    circle.setStroke(Color.web("black", 1));
                    circle.setStrokeWidth(2);
                }
                String toolTop = matrix[x][y].toString();
                Tooltip.install(circle, new Tooltip(toolTop));
                root.getChildren().add(circle);
            }
        }
    }
}
