package com.javarush.task.pro.task08.task0805;

import java.util.Random;

public class MagicBall {
    private static final String CERTAIN = "Бесспорно";
    private static final String DEFINITELY = "Определённо да";
    private static final String MOST_LIKELY = "Вероятнее всего";
    private static final String OUTLOOK_GOOD = "Хорошие перспективы";
    private static final String ASK_AGAIN_LATER = "Спроси позже";
    private static final String TRY_AGAIN = "Попробуй снова";
    private static final String NO = "Мой ответ — нет";
    private static final String VERY_DOUBTFUL = "Весьма сомнительно";

    public static String getPrediction() {
        Random rand = new Random();
        int r = (int)(rand.nextInt(8));

        if(r == 0){
            return CERTAIN;
        }else if (r==1){
            return DEFINITELY;
        }else if (r==2){
            return MOST_LIKELY;
        }else if (r==3){
            return OUTLOOK_GOOD;
        }else if (r==4){
            return ASK_AGAIN_LATER;
        }else if (r==5){
            return TRY_AGAIN;
        }else if (r==6){
            return NO;
        }else if (r==7){
            return VERY_DOUBTFUL;
        }
        return null;
    }
}
