package com.bytedance.finalhomework.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bytedance.finalhomework.R;
import com.bytedance.finalhomework.base.BaseActivity;
import com.bytedance.finalhomework.fragment.RecommendFragment;

public class PlayListActivity extends BaseActivity {
    public static int initPos;//具体播放哪个视频

    @Override
    protected int setLayoutId() {
        return R.layout.activity_play_list;
    }

    @Override
    protected void init() {
        //实际上调用的还是RecommendFragment,目前先调用一个空的
        getSupportFragmentManager().beginTransaction().add(R.id.framelayout, new RecommendFragment()).commit();
    }
}