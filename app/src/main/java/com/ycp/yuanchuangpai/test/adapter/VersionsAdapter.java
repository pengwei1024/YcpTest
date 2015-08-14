package com.ycp.yuanchuangpai.test.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.ycp.yuanchuangpai.test.R;
import com.ycp.yuanchuangpai.test.helper.ViewHolder;
import com.ycp.yuanchuangpai.test.model.VersionObject;

import java.util.List;

/**
 * Created by pengwei08 on 2015/7/3.
 */
public class VersionsAdapter extends CustomListAdapter<VersionObject.DataEntity> {

    public VersionsAdapter(Context context, List<VersionObject.DataEntity> list) {
        super(context, list);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.adapter_versions;
    }

    @Override
    public void setView(int position, View convertView, ViewGroup parent, VersionObject.DataEntity object) {
        TextView name = ViewHolder.get(convertView, R.id.version_name);
        name.setText(object.getVersion_name());
        SimpleDraweeView icon = ViewHolder.get(convertView, R.id.icon);
        icon.setImageURI(Uri.parse(object.getLogo_url()));

    }
}
