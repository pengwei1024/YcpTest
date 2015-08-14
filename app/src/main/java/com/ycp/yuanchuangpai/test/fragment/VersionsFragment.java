package com.ycp.yuanchuangpai.test.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.quentindommerc.superlistview.OnMoreListener;
import com.quentindommerc.superlistview.SuperListview;
import com.ycp.yuanchuangpai.test.R;
import com.ycp.yuanchuangpai.test.adapter.VersionsAdapter;
import com.ycp.yuanchuangpai.test.app.URLS;
import com.ycp.yuanchuangpai.test.fragment.base.BaseFragment;
import com.ycp.yuanchuangpai.test.model.VersionObject;

/**
 * Created by pengwei08 on 2015/7/3.
 */
public class VersionsFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, OnMoreListener {
    private final static int REQUEST_DATA = 1;
    private SuperListview listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View content = inflater.inflate(R.layout.fragment_versions, null);
        listView = (SuperListview) content.findViewById(R.id.list);
        listView.setRefreshListener(this);
        listView.setupMoreListener(this, 1);
        getRequest(URLS.ALL_VERSION_URL, null, REQUEST_DATA);
        return content;
    }

    @Override
    protected void onRequestCallBack(int requestCode, String result, boolean success) {
        if(requestCode == REQUEST_DATA){
            VersionObject object = new Gson().fromJson(result, VersionObject.class);
            if(object.getErrno() == 0 && object.getData() != null){
                listView.setAdapter(new VersionsAdapter(getActivity(), object.getData()));
            }
        }
    }

    @Override
    public void onMoreAsked(int i, int i1, int i2) {

    }

    @Override
    public void onRefresh() {

    }
}
