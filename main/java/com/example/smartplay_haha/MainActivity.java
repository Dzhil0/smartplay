package com.example.smartplay_haha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageViewHello;
    private Button buttonHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewHello = findViewById(R.id.image_view_hello);
        buttonHello = findViewById(R.id.button_hello);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);
            }
        };

        buttonHello.setOnClickListener(listener);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.stiv_stand_2);
        imageViewHello.setImageBitmap(Bitmap.createScaledBitmap(bitmap, 500, 700, false));
    }

}