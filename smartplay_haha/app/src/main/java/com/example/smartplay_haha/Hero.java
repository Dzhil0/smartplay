package com.example.smartplay_haha;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class Hero {
    private String name;
    private int health;
    private ImageView imageView;
    private ImageView imageViewHealth;
    private Resources resources;
    private Timer timer;
    private Activity activity;
    private GameActivity gameActivity;

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public Hero(String name, int health, ImageView imageView, Resources resources, Activity activity, GameActivity gameActivity, ImageView imageViewHealth){
        this.name = name;
        this.health = health;
        this.imageView = imageView;
        this.resources = resources;
        this.activity = activity;
        this.gameActivity = gameActivity;
        this.imageViewHealth = imageViewHealth;
        timer = new Timer();
    }


    public void stand(){
        timer.cancel();
        timer = new Timer();
        StandTimeTask standTimeTask = new StandTimeTask();
        timer.schedule(standTimeTask, 0, 150);
    }

    int[] heroLife = {
            R.drawable.right_life_0,
            R.drawable.right_life_1,
            R.drawable.right_life_2,
            R.drawable.right_life_3,
            R.drawable.right_life_4,
            R.drawable.right_life_5,
            R.drawable.right_life_6,
            R.drawable.right_life_7,
    };

    public void heroHit(){
        this.health--;
        timer.cancel();
        timer = new Timer();
        HitTimeTask hitTimeTask = new HitTimeTask();
        timer.schedule(hitTimeTask, 2000);
        Bitmap bitmapStiv = BitmapFactory.decodeResource(resources, R.drawable.stiv_hit);
        imageView.setImageBitmap(Bitmap.createScaledBitmap(bitmapStiv, 400, 550, false));
        Bitmap healthBMP = BitmapFactory.decodeResource(resources, heroLife[health]);
        imageViewHealth.setImageBitmap(healthBMP);
    }

    public void heroDamage(){
        timer.cancel();
        timer = new Timer();
        DamageTimeTask damageTimeTask = new DamageTimeTask();
        timer.schedule(damageTimeTask, 2000);
        Bitmap bitmapStiv = BitmapFactory.decodeResource(resources, R.drawable.stiv_damage);
        imageView.setImageBitmap(Bitmap.createScaledBitmap(bitmapStiv, 400, 550, false));
    }

    class StandTimeTask extends TimerTask {
        private boolean flagHero;

        public void run() {
            if (flagHero) {
                Bitmap bitmapStiv = BitmapFactory.decodeResource(resources, R.drawable.stiv_stand_1);
                imageView.setImageBitmap(Bitmap.createScaledBitmap(bitmapStiv, 400, 550, false));
                flagHero = false;
            } else {
                Bitmap bitmapStiv = BitmapFactory.decodeResource(resources, R.drawable.stiv_stand_2);
                imageView.setImageBitmap(Bitmap.createScaledBitmap(bitmapStiv, 400, 550, false));
                flagHero = true;
            }
        }
    }

    class HitTimeTask extends TimerTask implements Runnable{
        public void run() {
            stand();

            activity.runOnUiThread(new Runnable() {
                public void run() {
                    gameActivity.newQuestion();
                }
            });
        }
    }

    class DamageTimeTask extends TimerTask implements Runnable{
        public void run() {
            stand();

            activity.runOnUiThread(new Runnable() {
                public void run() {
                    gameActivity.newQuestion();
                }
            });
        }
    }
}
