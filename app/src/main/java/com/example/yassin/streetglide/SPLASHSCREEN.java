package com.example.yassin.streetglide;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class SPLASHSCREEN extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);




        getSupportActionBar().hide();
        StartAnimations();


        Runnable mRunnable;
        Handler mHandler = new Handler();

//        if (!gps.canGetLocation()) {
//            gps.showSettingsAlert();
//        }

        mRunnable = new Runnable() {

            @Override
            public void run() {

                // TODO Auto-generated method stub
                Intent i = new Intent(SPLASHSCREEN.this, Welcome.class);
//                    Intent i = new Intent(Splash.this, MainActivity.class);
                startActivity(i);
            }
        };

        mHandler.postDelayed(mRunnable, 3 * 1000);

    }
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }
     private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        RelativeLayout l=(RelativeLayout) findViewById(R.id.rel_lay);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.splashlogo);
        iv.clearAnimation();
        iv.startAnimation(anim);

    }
}
