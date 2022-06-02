package com.example.smartplay_haha;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class Evil {
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

    public Evil(String name, int health, ImageView imageView, Resources resources, Activity activity, GameActivity gameActivity, ImageView imageViewHealth){
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
    int[] evilLife = {
            R.drawable.left_life_0,
            R.drawable.left_life_1,
            R.drawable.left_life_2,
            R.drawable.left_life_3,
            R.drawable.left_life_4,
            R.drawable.left_life_5,
            R.drawable.left_life_6,
            R.drawable.left_life_7,
    };
    public void evilHit(){
        this.health--;
        timer.cancel();
        timer = new Timer();
        HitTimeTask hitTimeTask = new HitTimeTask();
        timer.schedule(hitTimeTask, 2000);
        Bitmap bitmapEvil = BitmapFactory.decodeResource(resources, R.drawable.evil_hit);
        imageView.setImageBitmap(Bitmap.createScaledBitmap(bitmapEvil, 400, 550, false));
        Bitmap healthBMP = BitmapFactory.decodeResource(resources, evilLife[health]);
        imageViewHealth.setImageBitmap(healthBMP);
    }

    public void evilDamage(){
        timer.cancel();
        timer = new Timer();
        DamageTimeTask damageTimeTask = new DamageTimeTask();
        timer.schedule(damageTimeTask, 2000);
        Bitmap bitmapEvil = BitmapFactory.decodeResource(resources, R.drawable.evil_damage);
        imageView.setImageBitmap(Bitmap.createScaledBitmap(bitmapEvil, 400, 550, false));
    }

    class StandTimeTask extends TimerTask {
        private boolean flagEvil;

        public void run() {
            if (flagEvil) {
                Bitmap bitmapEvil = BitmapFactory.decodeResource(resources, R.drawable.evil_1);
                imageView.setImageBitmap(Bitmap.createScaledBitmap(bitmapEvil, 400, 550, false));
                flagEvil = false;
            } else {
                Bitmap bitmapEvil = BitmapFactory.decodeResource(resources, R.drawable.evil_2);
                imageView.setImageBitmap(Bitmap.createScaledBitmap(bitmapEvil, 400, 550, false));
                flagEvil = true;
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
