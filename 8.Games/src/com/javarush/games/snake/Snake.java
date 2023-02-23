package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<GameObject> snakeParts = new ArrayList<>();
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    public boolean isAlive = true;
    private Direction direction = Direction.LEFT;
    public Snake(int x, int y){
        for (int i = 0; i < 3; i++) {
            GameObject gameObject = new GameObject(x+i,y);
            snakeParts.add(gameObject);
        }
    }

    public void draw(Game game) {
        for (int i = 0; i < snakeParts.size(); i++) {
            GameObject snakePart = snakeParts.get(i);
            Color snakeColor = Color.DARKGREEN;
            if (!isAlive) {
                snakeColor = Color.RED;
            }

            if (i == 0) {
                game.setCellValueEx(snakePart.x, snakePart.y, Color.NONE, HEAD_SIGN, snakeColor, 75);
            } else {
                game.setCellValueEx(snakePart.x, snakePart.y, Color.NONE, BODY_SIGN, snakeColor, 75);
            }
        }
    }

    public void setDirection(Direction direction){
        if(
                ((this.direction == Direction.LEFT || this.direction == Direction.RIGHT) && snakeParts.get(0).x == snakeParts.get(1).x)
                || ((this.direction == Direction.UP || this.direction == Direction.DOWN) && snakeParts.get(0).y == snakeParts.get(1).y)

        )
            return;

        if ((this.direction == Direction.LEFT && direction == Direction.RIGHT) ||
                (this.direction == Direction.RIGHT && direction == Direction.LEFT) ||
                (this.direction == Direction.DOWN && direction == Direction.UP) ||
                (this.direction == Direction.UP && direction == Direction.DOWN)
        )
            return;
        this.direction = direction;
    }

    public void move(Apple apple){
        GameObject newHead = createNewHead();
        if (newHead.x < 0 || newHead.x >= SnakeGame.WIDTH || newHead.y < 0 || newHead.y >= SnakeGame.HEIGHT){
            isAlive = false;
            return;
        }

        boolean collision = checkCollision(newHead);
        if (collision){
            isAlive = false;
            return;
        }

        snakeParts.add(0,newHead);

        if (newHead.x == apple.x && newHead.y == apple.y){
            apple.isAlive = false;
        }else{
            removeTail();
        }
    }

    public GameObject createNewHead(){
        GameObject head = snakeParts.get(0);
        if(direction == Direction.LEFT){
            return new GameObject(head.x-1, head.y);
        } else if (direction == Direction.RIGHT) {
            return new GameObject(head.x+1, head.y);
        } else if (direction == Direction.DOWN) {
            return new GameObject(head.x, head.y+1);
        }else{
            return new GameObject(head.x, head.y-1);
        }
    }

    public void removeTail(){
        snakeParts.remove(snakeParts.size()-1);
    }

    public boolean checkCollision(GameObject go){
        for (GameObject obj: snakeParts){
            if (obj.x == go.x && obj.y == go.y){
                return true;
            }
        }
        return false;
    }

    public int getLength(){
        return snakeParts.size();
    }
}
