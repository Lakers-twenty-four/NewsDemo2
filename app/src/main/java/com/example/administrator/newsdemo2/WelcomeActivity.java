package com.example.administrator.newsdemo2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/5/16 0016.
 */

public class WelcomeActivity extends AppCompatActivity{
    private int num=3;
    private TextView time_tv;
    private Handler mHandler=new Handler();
    private Runnable mRunable=new Runnable() {
        @Override
        public void run() {
            if(isFirstRun==true){
                startActivity(new Intent(WelcomeActivity.this,GuideActivity.class));
                finish();
            }else{
                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                finish();
            }
        }
    };
    private Runnable numRunable=new Runnable() {
        @Override
        public void run() {
            num--;
            if(num>0){
                time_tv.setText("倒计时"+num+"秒");
                mHandler.postDelayed(numRunable,1000);
            }else {
                time_tv.setText("欢迎进入");
            }

        }
    };
    private boolean isFirstRun;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        isFirstRun = SpTools.getIsFirstRun(this);
        mHandler.postDelayed(mRunable,4500);

        time_tv= (TextView) findViewById(R.id.time_tv);
        mHandler.postDelayed(numRunable,1500);
    }
}
