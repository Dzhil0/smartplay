package com.example.smartplay_haha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FinishActivity extends AppCompatActivity {
    private ImageView imageViewFinish;
    private Button buttonFinish;
    private TextView textViewFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        textViewFinish = findViewById(R.id.text_view_finish);
        imageViewFinish = findViewById(R.id.image_view_finish);
        buttonFinish = findViewById(R.id.button_finish);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int id = intent.getIntExtra("id", 0);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinishActivity.this, MainActivity.class);
                startActivity(intent);
            }
        };

        buttonFinish.setOnClickListener(listener);

        textViewFinish.setText("WINNER: " + name);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), id);
        imageViewFinish.setImageBitmap(Bitmap.createScaledBitmap(bitmap, 500, 700, false));
    }
}