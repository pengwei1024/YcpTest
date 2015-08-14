package com.ycp.yuanchuangpai.test.activitys.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.umeng.analytics.MobclickAgent;
import com.ycp.yuanchuangpai.test.R;
import com.ycp.yuanchuangpai.test.helper.LayoutParamsHelper;

/**
 * Created by pengwei08 on 2015/6/5.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    public void setContentView(int layoutResID) {
        setContentView(getView(layoutResID));
    }

    @Override
    public void setContentView(View view) {
        if (showToolBar()) {
            LinearLayout parent = new LinearLayout(getContext());
            parent.setOrientation(LinearLayout.VERTICAL);
            parent.addView(getView(R.layout.view_toolbar),
                    LayoutParamsHelper.getLinearLayoutParamWrap());
            parent.addView(view, LayoutParamsHelper.getLinearLayoutParamMatch());
            super.setContentView(parent);
            setSupportActionBar(getToolBar());
            if (showBackIcon()) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setHomeButtonEnabled(false);
            }
        } else {
            super.setContentView(view);
        }
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    /**
     * 横竖屏切换
     *
     * @param newConfig
     */
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    /**
     * 启动Activity
     *
     * @param cla
     */
    protected void startActivity(Class<? extends Activity> cla) {
        startActivity(cla, false);
    }

    /**
     * 启动Activity
     *
     * @param cla
     * @param finish
     */
    protected void startActivity(Class<? extends Activity> cla, boolean finish) {
        Intent intent = new Intent(this, cla);
        startActivity(intent);
        if (finish) {
            finish();
        }
    }

    /**
     * toast提示
     *
     * @param msg
     */
    protected void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * findViewById
     *
     * @param id
     * @param <T>
     *
     * @return
     */
    protected <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }

    /**
     * 获取视图
     *
     * @param layoutResID
     *
     * @return
     */
    protected View getView(int layoutResID) {
        return View.inflate(getContext(), layoutResID, null);
    }

    public Context getContext() {
        return this;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
            case android.R.id.title:
                if(showBackIcon()){
                    finish();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 是否显示toolBar
     *
     * @return
     */
    public boolean showToolBar() {
        return true;
    }

    public boolean showBackIcon() {
        return true;
    }

    /**
     * 获得toolbar对象
     *
     * @return
     */
    protected Toolbar getToolBar() {
        if (!showToolBar()) {
            throw new NullPointerException(getString(R.string.no_find_toolbar));
        }
        if (toolbar != null) {
            return toolbar;
        }
        return toolbar = findView(R.id.toolbar);
    }
}
