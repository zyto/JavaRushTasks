package com.javarush.task.pro.task11.task1107;

/* 
Двигатель — сердце автомобиля
*/

public class Car {
    private Engine engine;
    public class Engine{
        private boolean isRunning;

        public void start(){
            isRunning = true;
        }

        public void stop(){
            isRunning = false;
        }
    }

}
