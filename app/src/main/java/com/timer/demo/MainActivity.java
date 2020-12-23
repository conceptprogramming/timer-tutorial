package com.timer.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private  int maxTime=30;
    private TextView tvTimer;
    private ImageView imgTimer;
    private Animation animation;
    private int cnt=0,timeOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTimer=findViewById(R.id.tvTimer);
        imgTimer=findViewById(R.id.imgTimer);
        animation= AnimationUtils.loadAnimation(this,R.anim.timer_animation);
        setTimer(maxTime*1000);
    }

    private void setTimer(int myTime) {
        timeOut=maxTime-(maxTime/3);   // now we don't need to worry about maxTime
        new CountDownTimer(myTime, 1000) {
            @Override
            public void onTick(long l) {
                tvTimer.setText(String.valueOf(l/1000));
                if(cnt>=timeOut)    //  now it will always give us 1/3 remaining time .
                {
                    imgTimer.setAnimation(animation);
                    imgTimer.setImageResource(R.drawable.ic_baseline_alarm_on_red);
                }
                cnt++;
            }

            @Override
            public void onFinish() {
                imgTimer.setImageResource(R.drawable.ic_baseline_alarm_off_24);
                imgTimer.clearAnimation();

            }
        }.start();
    }
}