package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    public void initialize(){
        setScreenSize(SIDE,SIDE);
        createGame();
        drawScene();
    }

    private void createGame(){
        createNewNumber();
        createNewNumber();

    }

    private void drawScene(){
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                setCellColoredNumber(j,i,gameField[i][j]);
            }
        }
    }

    private void createNewNumber(){
        int x = 0;
        int y = 0;
        do{
            x = getRandomNumber(SIDE);
            y = getRandomNumber(SIDE);
        }while (gameField[y][x] != 0);

        int number = getRandomNumber(10);
        gameField[y][x] = number == 9 ? 4 : 2;

    }

    private void setCellColoredNumber(int x, int y, int value){
        Color color = getColorByValue(value);
        setCellValueEx(x, y, color, value == 0 ? "" : Integer.toString(value));
    }

    private Color getColorByValue(int value){
        switch (value){
            case 2: return Color.LIGHTPINK;
            case 4: return Color.BLUEVIOLET;
            case 8: return Color.LIGHTBLUE;
            case 16: return Color.TURQUOISE;
            case 32: return Color.LIGHTGREEN;
            case 64: return Color.GREEN;
            case 128: return Color.ORANGE;
            case 256: return Color.ORANGERED;
            case 512: return Color.DARKORANGE;
            case 1024: return Color.VIOLET;
            case 2048: return Color.DARKVIOLET;
            default: return Color.GRAY;
        }
    }

    private boolean compressRow(int[] row){
        boolean res = false;
        for (int i = 1; i < row.length; i++) {
            if(row[i]>0) {
                for (int j = 0; j < i ; j++) {
                    if (row[j] == 0){
                        row[j] = row[i];
                        row[i] = 0;
                        res = true;
                        break;
                    }
                }
            }
        }
        return res;
    }

    private boolean mergeRow(int[] row){
        boolean res = false;
        for (int i = 1; i < row.length; i++) {
            if (row[i] != 0 &&row[i] == row[i-1]){
                row[i-1] *= 2;
                row[i] = 0;
                res = true;
            }
        }
        return  res;
    }

    private void moveLeft(){

    }

    private void moveRight(){

    }

    private void moveUp(){

    }

    private void moveDown(){

    }

    public void onKeyPress(Key key){
        switch (key){
            case LEFT: moveLeft(); break;
            case RIGHT: moveRight(); break;
            case UP: moveUp(); break;
            case DOWN: moveDown(); break;
        }
    }
}
