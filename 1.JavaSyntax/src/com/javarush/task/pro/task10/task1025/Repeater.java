package com.javarush.task.pro.task10.task1025;

public class Repeater {
    private String trajectory = "parabolic";
    private int frequency = 30;

    public void setTrajectory(String trajectory){
        this.trajectory = trajectory;
    }

    public void setFrequency(int frequency){
        this.frequency = frequency;
    }

    public String getTrajectory(){
        return this.trajectory;
    }

    public int getFrequency(){
        return this.frequency;
    }

    @Override
    public String toString() {
        return String.format("Repeater trajectory is %s, with a %dGHz communication frequency.", trajectory, frequency);
    }
}