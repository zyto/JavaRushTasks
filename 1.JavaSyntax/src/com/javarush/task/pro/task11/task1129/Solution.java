package com.javarush.task.pro.task11.task1129;

/* 
Био-Нано-Боты
*/

public class Solution {

    public static Human sysadmin = new Human();

    public static void main(String[] args) {
        Class[] playlist = new Class[15];
        playlist[0] = AlternativeMetal.class;
        playlist[1] = BlackMetal.class;
        playlist[2] = DeathMetal.class;
        playlist[3] = DoomMetal.class;
        playlist[4] = FolkMetal.class;
        playlist[5] = GlamMetal.class;
        playlist[6] = GothicMetal.class;
        playlist[7] = HeavyMetal.class;
        playlist[8] = Metalcore.class;
        playlist[8] = PowerMetal.class;
        playlist[10] = ProgressiveMetal.class;
        playlist[11] = SpeedMetal.class;
        playlist[12] = SymphonicMetal.class;
        playlist[13] = ThrashMetal.class;
        playlist[14] = IndustrialMetal.class;

        sysadmin.load(playlist);


    }
}
