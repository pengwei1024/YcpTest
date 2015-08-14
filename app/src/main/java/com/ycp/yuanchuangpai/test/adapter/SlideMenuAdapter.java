package com.ycp.yuanchuangpai.test.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ycp.yuanchuangpai.test.R;


/**
 * Created by pengwei08 on 2015/4/20.
 */
public class SlideMenuAdapter extends CustomAdapter{

    private String[] values;
    private int[] icons;

    public SlideMenuAdapter(Context context, String[] values, int[] icons) {
        super(context);
        this.values = values;
        this.icons = icons;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.view_simple_list_item;
    }

    @Override
    public void setView(int position, View convertView, ViewGroup parent) {
        TextView textView = getViewById(convertView, R.id.text);
        textView.setText(values[position]);
        Drawable drawable = getContext().getResources().getDrawable(icons[position]);
        drawable.setBounds(1,1,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(drawable, null, null, null);
    }
}
