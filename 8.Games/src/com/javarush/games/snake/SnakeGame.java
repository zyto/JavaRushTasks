package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private Snake snake;
    private Apple apple;
    private int turnDelay;
    private boolean isGameStopped;
    private static final int GOAL = 28;
    private int score;

    public void initialize(){
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame(){
        isGameStopped = false;
        score = 0;
        snake = new Snake(HEIGHT/2, WIDTH/2);
        setScore(score);
        createNewApple();
        drawScene();
        turnDelay = 300;
        setTurnTimer(turnDelay);
    }

    private void drawScene(){
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellValueEx(x, y, Color.DARKSEAGREEN, "");
            }
        }

        snake.draw(this);
        apple.draw(this);
    }

    @Override
    public void onTurn(int step){
        snake.move(apple);
        if(!apple.isAlive){
            score += 5;
            setScore(score);
            turnDelay -= 10;
            setTurnTimer(turnDelay);
            createNewApple();
        }
        if (!snake.isAlive){
            gameOver();
        }
        if(snake.getLength() > GOAL){
            win();
        }
        drawScene();
    }

    public void onKeyPress(Key key){
        if (key == Key.LEFT) {
            snake.setDirection(Direction.LEFT);
        } else if (key == Key.UP) {
            snake.setDirection(Direction.UP);
        } else if (key == Key.DOWN) {
            snake.setDirection(Direction.DOWN);
        }else if (key == Key.RIGHT){
            snake.setDirection(Direction.RIGHT);
        }else if (key == Key.SPACE && isGameStopped){
            createGame();
        }
    }

    private void createNewApple(){
        Apple apple;
        do {
            int x = getRandomNumber(WIDTH);
            int y = getRandomNumber(HEIGHT);
            apple = new Apple(x, y);
        } while (snake.checkCollision(apple));

        this.apple = apple;
    }

    private void gameOver(){
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.WHITE,"GAME OVER", Color.DARKRED, 70);
    }

    private void win(){
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "YOU WIN",Color.DARKGREEN,70);
    }
}
