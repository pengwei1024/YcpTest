package com.ycp.yuanchuangpai.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.ycp.yuanchuangpai.test.helper.ViewHolder;


/**
 * 自定义CustomAdapter，去除BaseAdapter冗余部分
 * Created by pengwei08 on 2015/4/16.
 */
public  abstract class CustomAdapter extends BaseAdapter {
    private Context context;
    public CustomAdapter(Context context) {
        this.context = context;
    }
    /**
     * 返回Context对象
     * @return
     */
    protected Context getContext(){
        return context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(getLayoutRes(), null);
        }
        setView(position,convertView,parent);
        return convertView;
    }

    /**
     * 设置Item资源文件
     * @return
     */
    public abstract int getLayoutRes();

    /**
     * 设置属性
     * @param position
     * @param convertView
     * @param parent
     */
    public abstract void setView(int position, View convertView, ViewGroup parent);

    /**
     * 获取控件
     * @param view
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View>T getViewById(View view, int id){
        return ViewHolder.get(view, id);
    }
}
