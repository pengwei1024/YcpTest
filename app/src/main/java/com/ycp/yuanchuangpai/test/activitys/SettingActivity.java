package com.ycp.yuanchuangpai.test.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ycp.yuanchuangpai.test.R;
import com.ycp.yuanchuangpai.test.activitys.base.BaseActivity;
import com.ycp.yuanchuangpai.test.helper.VersionHelper;

/**
 * Created by pengwei08 on 2015/7/3.
 */
public class SettingActivity extends BaseActivity implements View.OnClickListener {
    private TextView version;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        version = findView(R.id.version_value);
        version.setText("V" + VersionHelper.getVersion(this));
        setOnclickListener(R.id.current_version);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.current_version:
                break;
            default:
                break;
        }
    }

    /**
     * 设置点击事件监听
     * @param ids
     */
    private void setOnclickListener(int ... ids){
        for(int id : ids){
            findView(id).setOnClickListener(this);
        }
    }

}
