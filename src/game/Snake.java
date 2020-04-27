package game;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class Main- Simulates a snake game by creating a canvas and animating boxes in an ArrayList that represents the snake. The snake moves
 * with keyinputs A (left), S (down), D (right), and W (up) and grows bigger by eating randomly generated food on the canvas.
 *
 * @author Jonas Hulthén
 * @version 2019-11-07
 */
public class Snake extends Application {

    static int foodEaten = 0;
    static int speed = 5;
    static int roomWidth = 30;
    static int roomHeight = 30;
    static int boxSize = 15;
    static boolean hitWall = false;
    static List<Box> snake = new ArrayList();
    static List<Box> food = new ArrayList();
    static Random randomGenerator = new Random();
    static Dir direction = Dir.left;

    public enum Dir {
        left,
        right,
        up,
        down
    }

    /**
     * Class Box- Stores the x and y values of the ArrayList
     *
     * @author Jonas Hulthén
     * @version 2019-11-07
     */
    public static class Box {
        int x;
        int y;

        public Box(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    @Override
    //Creates the window that animates snake
    public void start(Stage primaryStage) throws Exception {

        for (int i = 0; i < 3; i++) {
            snake.add(new Box(12 + i, 7));
        }

        Group root = new Group();
        final Canvas canvas = new Canvas(boxSize * roomWidth, roomHeight * boxSize);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //Animates snake
        new AnimationTimer() {
            long lastTick = 0;

            public void handle(long now) {
                if (lastTick == 0) {
                    lastTick = now;
                    tick(gc);
                    return;
                }

                if (now - lastTick > 1000000000 / speed) {
                    lastTick = now;
                    tick(gc);

                }
            }

        }.start();

        root.getChildren().add(canvas);
        primaryStage.setTitle("Snake Game");
        Scene scene = new Scene(root, boxSize * roomWidth, roomHeight * boxSize);

        //Checks key input
        scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
            if (key.getCode() == KeyCode.W && direction != Dir.down) {
                direction = Dir.up;
            }
            if (key.getCode() == KeyCode.A && direction != Dir.right) {
                direction = Dir.left;
            }
            if (key.getCode() == KeyCode.S && direction != Dir.up) {
                direction = Dir.down;
            }
            if (key.getCode() == KeyCode.D && direction != Dir.left) {
                direction = Dir.right;
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * paints each frame of snake
     *
     * @param gc that handles the painting
     */
    public static void tick(GraphicsContext gc) {

        if (!hitWall) {
            gc.setFill(Color.BLACK);
            gc.fillRect(0, 0, roomWidth * boxSize, roomHeight * boxSize);
            for (int i = 0; i < snake.size(); i++) {
                gc.setFill(Color.BLUE);
                gc.fillRect((snake.get(i).x) * boxSize, (snake.get(i).y) * boxSize, boxSize, boxSize);
            }
            //paints the food if there exists food otherwise makes food
            if (food.size() != 0) {
                for (int i = 0; i < food.size(); i++) {
                    gc.setFill(Color.YELLOW);
                    gc.fillRect((food.get(i).x) * boxSize, (food.get(i).y) * boxSize, boxSize, boxSize);
                }
            } else {
                foodMaker();
            }
            //moves the snake
            for (int i = snake.size() - 1; i >= 1; i--) {
                snake.get(i).x = snake.get(i - 1).x;
                snake.get(i).y = snake.get(i - 1).y;
            }

            switch (direction) {
                case up:
                    if (direction != Dir.down) {
                        snake.get(0).y--;
                        eatFood();
                        hitWall = hitWall();
                    }
                    break;
                case down:
                    if (direction != Dir.up) {
                        snake.get(0).y++;
                        eatFood();
                        hitWall = hitWall();
                    }

                    break;
                case right:
                    if (direction != Dir.left) {
                        snake.get(0).x++;
                        eatFood();
                        hitWall = hitWall();
                    }
                    break;
                case left:
                    if (direction != Dir.right) {
                        snake.get(0).x--;
                        eatFood();
                        hitWall = hitWall();
                    }
                    break;
            }
            gc.setFill(Color.WHITE);
            gc.setFont(new Font("", boxSize));
            gc.fillText("Food eaten: " + foodEaten + " Snake size: " + snake.size(), boxSize, boxSize * roomWidth - boxSize);

        }
        //animates the game over screen
        else {
            gc.setFill(Color.WHITE);
            gc.setFont(new Font("", 50));
            gc.fillText("GAME OVER", 100, 150);
        }

    }

    /**
     * Checks if the snake hit a wall or itself
     *
     * @return returns a true or false depending on if the snake hit a wall or itself or hit none of them
     */
    public static boolean hitWall() {
        for (int i = 1; i < snake.size(); i++) {
            if (snake.get(0).x == snake.get(i).x && snake.get(0).y == snake.get(i).y) {
                return true;
            }
        }
        if (snake.get(0).x < 0 || snake.get(0).x >= (roomWidth) || snake.get(0).y < 0 || snake.get(0).y >= (roomHeight)) {
            return true;
        }
        return false;
    }

    //if the snake hits food it will remove the food, speed up the snake and it also grows longer
    public static void eatFood() {
        int foodIndex = -1;
        for (int f = 0; f < food.size(); f++) {
            if (snake.get(0).x == food.get(f).x && snake.get(0).y == food.get(f).y) {
                foodIndex = f;
                break;
            } else {
                foodIndex = -1;
            }
        }

        if (foodIndex >= 0) {
            food.remove(foodIndex);
            snake.add(new Box(snake.get(snake.size() - 1).x, snake.get(snake.size() - 1).y));
            speed++;
            foodEaten++;
        }
    }

    //makes food at a random non snake location
    public static void foodMaker() {
        if (food.size() == 0) {
            boolean boxAtPlace = true;
            int possibleFoodX = randomGenerator.nextInt(roomWidth);
            int possibleFoodY = randomGenerator.nextInt(roomHeight);
            //checks if there is a snake at the location
            while (boxAtPlace) {
                for (int i = 0; i < snake.size(); i++) {
                    if (snake.get(i).y == possibleFoodY && snake.get(i).x == possibleFoodX) {
                        boxAtPlace = true;
                        possibleFoodX = randomGenerator.nextInt(roomWidth);
                        possibleFoodY = randomGenerator.nextInt(roomHeight);
                        break;
                    }
                    else {
                        boxAtPlace = false;
                    }
                }
            }
            food.add(new Box(possibleFoodX, possibleFoodY));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}


