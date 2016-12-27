package com.masbie.papb_pa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

/**
 * Created by AnangHanafi on 14/12/2016.
 */

public class Splash extends AppCompatActivity {

    private ImageView imgSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imgSplash = (ImageView) findViewById(R.id.imgSplash);

//        SharedPreferences pref = getApplicationContext().getSharedPreferences("home", 0);
//        SharedPreferences.Editor editor = pref.edit();
//        editor.putBoolean("pertama", false);
//        editor.commit();

        AnimationSet animation = new AnimationSet(true);
        animation.addAnimation(new AlphaAnimation(0.0F, 1.0F));
        animation.addAnimation(new ScaleAnimation(0.0f, 1, 0.0f, 1, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f));
        animation.setDuration(1500);

        imgSplash.startAnimation(animation);

        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {


                Intent i = new Intent(Splash.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }.start();
    }
}

