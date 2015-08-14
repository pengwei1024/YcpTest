/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package com.ycp.yuanchuangpai.test.activitys;


import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.ycp.yuanchuangpai.test.R;
import com.ycp.yuanchuangpai.test.activitys.base.BaseActivity;
import com.ycp.yuanchuangpai.test.fragment.ConditionFragment;
import com.ycp.yuanchuangpai.test.fragment.MainFragment;
import com.ycp.yuanchuangpai.test.fragment.VersionsFragment;
import com.ycp.yuanchuangpai.test.fragment.base.BaseFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by pengwei08 on 2015/8/14.
 */
public class MainActivity extends BaseActivity implements Drawer.OnDrawerItemClickListener {
    private Drawer result = null;
    private AccountHeader accountHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeightDp(200)
                .withCompactStyle(true)
                .withHeaderBackground(R.drawable.drawer_header)
                .withSavedInstance(savedInstanceState)
                .build();
        result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(accountHeader)
                .withToolbar(getToolBar())
                .addDrawerItems(getDrawerItems())
                .withOnDrawerItemClickListener(this)
                .withSavedInstance(savedInstanceState)
                .withShowDrawerOnFirstLaunch(true)
                .build();
        if (savedInstanceState == null) {
            result.setSelectionByIdentifier(1, false);
        }
    }

    @Override
    public boolean onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {
        switch (i) {
            case 0:
                setPage(new MainFragment());
                break;
            case 1:
                setPage(new MainFragment());
                break;
            case 2:
                setPage(new MainFragment());
                break;
            case 3:
                setPage(new VersionsFragment());
                break;
            case 4:
                setPage(new ConditionFragment());
                break;
            case 5:
                startActivity(SettingActivity.class);
                break;
            default:
                break;
        }
        return false;
    }

    /**
     * 切换默认视图
     *
     * @param fragment
     */
    private void setPage(BaseFragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    /**
     * 获取菜单
     *
     * @return
     */
    private IDrawerItem[] getDrawerItems() {
        String[] values = getResources().getStringArray(R.array.slide_menu_value);
        String[] icons = getResources().getStringArray(R.array.slide_menu_icon);
        IDrawerItem[] items = new IDrawerItem[values.length];
        for (int i = 0; i < values.length; ++i) {
            items[i] = new PrimaryDrawerItem().withName(values[i])
                    .withIcon(getResources().getDrawable(getResources().getIdentifier(icons[i],
                                    "drawable", getApplicationInfo().packageName)
                    )).withIdentifier(i).withCheckable(false);
        }
        return items;
    }

    @Override
    public boolean showBackIcon() {
        return false;
    }
}
