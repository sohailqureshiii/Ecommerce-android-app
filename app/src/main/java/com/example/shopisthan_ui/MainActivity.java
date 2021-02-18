package com.example.shopisthan_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    ImageView logoo;
    Handler handler;
    int progress= 0 ;
//    Animation ImgAnim ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImgAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);
        logoo = findViewById(R.id.logo);


                progressBar =(ProgressBar)findViewById(R.id.progressBar);
                setProgressValue(progress);
                progressBar.getProgressDrawable().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);

                //new activty
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this,IntroActivity.class);
                        startActivity(intent);
                        finish();
                    }
                },3000);
            }

            private  void setProgressValue(final int progress){
                progressBar.setProgress(progress);


                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);

                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }setProgressValue(progress + 30);
                    }
                });
                thread.start();

                logoo.setAnimation(ImgAnim);
            }
        }