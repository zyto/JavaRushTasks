package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

import java.util.Arrays;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped = false;
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

        if (getMaxTileValue() == 2048){
            win();
            return;
        }
        
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
        boolean res = false;
        for (int[] row : gameField){
            res |= compressRow(row);
            res |= mergeRow(row);
            res |= compressRow(row);
        }

        if (res){
            createNewNumber();
        }
    }

    private void moveRight(){
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveUp(){
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void moveDown(){
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    public void onKeyPress(Key key){
        switch (key){
            case LEFT: moveLeft(); drawScene(); break;
            case RIGHT: moveRight(); drawScene(); break;
            case UP: moveUp(); drawScene(); break;
            case DOWN: moveDown(); drawScene(); break;
        }
    }

    private void rotateClockwise(){

        int[][] copy = new int[SIDE][SIDE];


        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                copy[x][SIDE-1-y] = gameField[y][x];
            }
        }



        /*
        int width = SIDE-1;
        int height = SIDE-1;

        for (int y = 0; y < (width + 1) / 2; y++) {
            for (int x = y; x < height - y; x++) {
                copy[x][height-y] = gameField[y][x];
                copy[height-y][width-x] = gameField[x][height-y];
                copy[height-x][y] = gameField[height-y][width-x];
                copy[y][x] = gameField[height-x][y];
            }
        }
        */

        gameField = copy;
    }

    private void printMatrix(int[][] matrix){
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                System.out.printf("\t%d\t", matrix[y][x]);
            }
            System.out.println();
        }
        System.out.println("---");
    }

    private int getMaxTileValue(){
        int max = 0;
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                max = Math.max(max,gameField[y][x]);
            }
        }
        return max;
    }

    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.WHITE,"YOU WIN!!!", Color.GREEN, 70);
    }

    private boolean canUserMove(){
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                int current = gameField[y][x];
                if (current == 0){
                    return true;
                }

                int down = 0;
                int right = 0;

                if(y+1 <= SIDE-1){
                    down = gameField[y+1][x];
                }
                if(x+1 <= SIDE-1){
                    right = gameField[y][Math.min(SIDE-1, x+1)];
                }

                if (current == down || current == right){
                    return true;
                }

            }
        }
        return false;
    }
}
