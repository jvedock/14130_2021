package org.firstinspires.ftc.teamcode.lib.core.hardware;

import org.firstinspires.ftc.teamcode.lib.core.AutoBotCore;

public class AutoMove extends Thread{
    AutoBotCore bot;
    double distance, angle, speedMod;
    public boolean isDone = false;

    public AutoMove(AutoBotCore bot, double angle, double distance, double speedMod){
        this.bot = bot;
        this.angle = angle;
        this.distance = distance;
        this.speedMod = speedMod;
    }

    public void run(){
        bot.autoMove(angle, distance, speedMod);

        try {
            this.join();
        }catch(Exception e){

        }
    }
}
