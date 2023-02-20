package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<GameObject> snakeParts = new ArrayList<>();
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    public Snake(int x, int y){
        for (int i = 0; i < 3; i++) {
            GameObject gameObject = new GameObject(x+i,y);
            snakeParts.add(gameObject);
        }
    }

    public void draw(Game game){
        for (int i = 0; i < snakeParts.size(); i++) {
            GameObject snakePart = snakeParts.get(i);
           if (i == 0){
               game.setCellValue(snakePart.x, snakePart.y, HEAD_SIGN);
           }else{
               game.setCellValue(snakePart.x, snakePart.y, BODY_SIGN);
           }
        }
    }
}
