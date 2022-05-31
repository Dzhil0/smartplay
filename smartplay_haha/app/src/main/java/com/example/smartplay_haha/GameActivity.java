package com.example.smartplay_haha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {
    private ImageView Hero1;
    private ImageView Evil1;
    private Object TimerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Hero1 = findViewById(R.id.stiv);
        Evil1 = findViewById(R.id.villain);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameActivity.this, GameActivity.class);
                startActivity(intent);
            }
        };

        /*
        public void actionPerformed(ActionEvent e)
{
  JButton button = (JButton)e.getSource();
  String  text   = button.getText();

  JLabel img = new JLabel(new ImageIcon("resources/1920.png"));
  img.setBounds(642, 230, 100, 100); // x, y, width, height
  add(img);
  img.setVisible(false);

  if (text.equals("1920a"))
  {
     try
     {
       getMediaPlayer().setURI(mediaPaths[0]);
       img.setVisible(true);

     }
     catch (URISyntaxException e1)
     {
        e1.printStackTrace();
     }
         */

        Bitmap bitmapStiv = BitmapFactory.decodeResource(getResources(), R.drawable.stiv_1);
        Hero1.setImageBitmap(Bitmap.createScaledBitmap(bitmapStiv, 400, 550, false));
        Bitmap bitmapEvil = BitmapFactory.decodeResource(getResources(), R.drawable.evil_1);
        Evil1.setImageBitmap(Bitmap.createScaledBitmap(bitmapEvil, 400, 550, false));

        Timer timer = new Timer();
        UpdateTimeTask updateTimeTask = new UpdateTimeTask();
        timer.schedule(updateTimeTask, 0, 200);

    }

    class UpdateTimeTask extends TimerTask {
        private boolean flagHero;

        public void run() {
            if (flagHero) {
                Bitmap bitmapStiv = BitmapFactory.decodeResource(getResources(), R.drawable.stiv_1);
                Hero1.setImageBitmap(Bitmap.createScaledBitmap(bitmapStiv, 400, 550, false));
                Bitmap bitmapEvil = BitmapFactory.decodeResource(getResources(), R.drawable.evil_1);
                Evil1.setImageBitmap(Bitmap.createScaledBitmap(bitmapEvil, 400, 550, false));
                flagHero = false;
            } else {
                Bitmap bitmapStiv = BitmapFactory.decodeResource(getResources(), R.drawable.stiv_2);
                Hero1.setImageBitmap(Bitmap.createScaledBitmap(bitmapStiv, 400, 550, false));
                Bitmap bitmapEvil = BitmapFactory.decodeResource(getResources(), R.drawable.evil_2);
                Evil1.setImageBitmap(Bitmap.createScaledBitmap(bitmapEvil, 400, 550, false));
                flagHero = true;
            }
        }
    }
}