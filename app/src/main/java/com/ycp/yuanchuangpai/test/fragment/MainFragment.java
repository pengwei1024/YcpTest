package com.ycp.yuanchuangpai.test.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ycp.yuanchuangpai.test.fragment.base.BaseFragment;

/**
 * Created by pengwei08 on 2015/6/9.
 */
public class MainFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView tv= new TextView(getActivity());
        tv.setText("12345");
        return tv;
    }
}
