package com.example.smartplay_haha;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {

    private ImageView imageViewHero;
    private ImageView imageViewEvil;
    private ImageView imageViewHerohp;
    private ImageView imageViewEvilhp;
    private static TextView qText;
    private static Button button1;
    private static Button button2;
    private static Button button3;
    private static Button button4;

    private Object TimerTask;

    private static int currentQuestionPosition;
    private String selectedByUser = "";

    private List<Questions> questionsList;
    private Questions questions;
    private Hero heroSteve;
    private Evil evilDevil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        imageViewHero = findViewById(R.id.stiv);
        imageViewEvil = findViewById(R.id.villain);
        qText = findViewById(R.id.qtext);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        imageViewHerohp = findViewById(R.id.image_view_hero);
        imageViewEvilhp = findViewById(R.id.image_veiw_evil);

        currentQuestionPosition = 0;

        questions = new Questions();

        heroSteve = new Hero("Stiv", 7, imageViewHero, getResources(), GameActivity.this, this, imageViewHerohp);
        heroSteve.stand();
        evilDevil = new Evil("Evil", 7, imageViewEvil, getResources(), GameActivity.this, this, imageViewEvilhp);
        evilDevil.stand();

        qText.setText(Questions.questionsList.get(currentQuestionPosition).getQuestion());
        button1.setText(Questions.questionsList.get(currentQuestionPosition).getOption1());
        button2.setText(Questions.questionsList.get(currentQuestionPosition).getOption2());
        button3.setText(Questions.questionsList.get(currentQuestionPosition).getOption3());
        button4.setText(Questions.questionsList.get(currentQuestionPosition).getOption4());

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeButtons();
                if(button1.getText().equals(Questions.questionsList.get(currentQuestionPosition).getAnswer())){
                    button1.setBackgroundColor(getResources().getColor(R.color.green_true));
                    heroSteve.heroDamage();
                    evilDevil.evilHit();
                }
                else{
                    heroSteve.heroHit();
                    evilDevil.evilDamage();
                    button1.setBackgroundColor(getResources().getColor(R.color.red_false));
                }
                currentQuestionPosition++;
                if(currentQuestionPosition > 6){
                    currentQuestionPosition = 0;
                    finish();
                }
            }

        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeButtons();
                if(button2.getText().equals(Questions.questionsList.get(currentQuestionPosition).getAnswer())){
                    button2.setBackgroundColor(getResources().getColor(R.color.green_true));
                    heroSteve.heroDamage();
                    evilDevil.evilHit();
                }
                else{
                    heroSteve.heroHit();
                    evilDevil.evilDamage();
                    button2.setBackgroundColor(getResources().getColor(R.color.red_false));
                }
                currentQuestionPosition++;
                if(currentQuestionPosition > 6){
                    currentQuestionPosition = 0;
                    finish();
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeButtons();
                if(button3.getText().equals(Questions.questionsList.get(currentQuestionPosition).getAnswer())){
                    button3.setBackgroundColor(getResources().getColor(R.color.green_true));
                    heroSteve.heroDamage();
                    evilDevil.evilHit();
                }
                else{
                    heroSteve.heroHit();
                    evilDevil.evilDamage();
                    button3.setBackgroundColor(getResources().getColor(R.color.red_false));
                }
                currentQuestionPosition++;
                if(currentQuestionPosition > 6){
                    currentQuestionPosition = 0;
                    finish();
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeButtons();
                if(button4.getText().equals(Questions.questionsList.get(currentQuestionPosition).getAnswer())){
                    button4.setBackgroundColor(getResources().getColor(R.color.green_true));
                    heroSteve.heroDamage();
                    evilDevil.evilHit();
                }
                else{
                    heroSteve.heroHit();
                    evilDevil.evilDamage();
                    button4.setBackgroundColor(getResources().getColor(R.color.red_false));
                }
                currentQuestionPosition++;
                if(currentQuestionPosition > 6){
                    currentQuestionPosition = 0;
                    finish();
                }
            }
        });

        closeButtons();
        openButtons();
    }

    public void finish(){
        if(heroSteve.getHealth() > evilDevil.getHealth()){
            onCreateDialog(heroSteve.getName(), R.drawable.stiv_damage);
        }
        else {
            onCreateDialog(evilDevil.getName(), R.drawable.evil_damage);
        }
    }

    public void closeButtons(){
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
    }

    public void openButtons(){
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
    }

    private void defaultColor(){
        button1.setBackgroundColor(getResources().getColor(R.color.purple_500));
        button2.setBackgroundColor(getResources().getColor(R.color.purple_500));
        button3.setBackgroundColor(getResources().getColor(R.color.purple_500));
        button4.setBackgroundColor(getResources().getColor(R.color.purple_500));
    }

    public void newQuestion(){
        Log.d("GAME", String.valueOf(currentQuestionPosition));
        qText.setText(Questions.questionsList.get(currentQuestionPosition).getQuestion());

        openButtons();

        button1.setText(Questions.questionsList.get(currentQuestionPosition).getOption1());
        button2.setText(Questions.questionsList.get(currentQuestionPosition).getOption2());
        button3.setText(Questions.questionsList.get(currentQuestionPosition).getOption3());
        button4.setText(Questions.questionsList.get(currentQuestionPosition).getOption4());
        defaultColor();
    }


    public void onCreateDialog(String name, int id) {
        Intent intent = new Intent(GameActivity.this, FinishActivity.class).putExtra("name", name).putExtra("id", id);
        startActivity(intent);
        this.onDestroy();
    }
}