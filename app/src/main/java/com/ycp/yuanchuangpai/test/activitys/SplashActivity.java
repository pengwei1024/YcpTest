package com.ycp.yuanchuangpai.test.activitys;

import android.os.Bundle;
import android.os.Handler;

import com.ycp.yuanchuangpai.test.R;
import com.ycp.yuanchuangpai.test.activitys.base.BaseActivity;

/**
 * Created by pengwei08 on 2015/6/5.
 */
public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(MainActivity.class, true);
            }
        }, 2000);
    }

    @Override
    public boolean showToolBar() {
        return false;
    }
}
