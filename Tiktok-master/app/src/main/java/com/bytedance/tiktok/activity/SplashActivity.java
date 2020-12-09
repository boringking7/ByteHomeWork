package com.bytedance.tiktok.activity;

import android.content.Intent;
import android.os.CountDownTimer;

import com.bytedance.tiktok.R;
import com.bytedance.tiktok.base.BaseActivity;

/**
 * create by libo
 * create on 2020/5/19
 * description App启动页面
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected int setLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void init() {
        setFullScreen();
        new CountDownTimer(500, 500) {//millisInFuture:倒计时的总时长,countDownInterval：每次的间隔时间  单位都是毫秒
            @Override
            ////这个是每次间隔指定时间的回调，millisUntilFinished：剩余的时间，单位毫秒
            public void onTick(long millisUntilFinished) {

            }

            @Override
            //这个是倒计时结束的回调
            //结束后来到main页面
            public void onFinish() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }.start();
    }
}
