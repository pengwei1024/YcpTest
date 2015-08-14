package com.ycp.yuanchuangpai.test.fragment.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;


/**
 * Created by pengwei08 on 2015/4/21.
 */
public class BaseFragment extends Fragment {

    private HttpUtils httpUtils;
    private AlertDialog.Builder builder;

    /**
     * 获取控件
     * @param parent
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T getViewById(View parent, int id){
        return (T) parent.findViewById(id);
    }

    /**
     * 设置标题
     * @param title
     */
    protected void setTitle(String title){
        getActivity().setTitle(title);
    }

    /**
     * 启动Activity
     * @param cla
     */
    protected void startActivity(Class<? extends Activity> cla){
        Intent it = new Intent(getActivity(), cla);
        startActivity(it);
    }


    /////////////////提示框/////////////////////////////
    /**
     * 弹出选择菜单
     * @param items
     * @param listener
     */
    protected AlertDialog showDialogMenu(String[] items, AdapterView.OnItemClickListener listener){
        Context context = getActivity();
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        ListView listView = new ListView(context);
        listView.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,
                items));
        listView.setOnItemClickListener(listener);
        builder.setView(listView);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
        return dialog;
    }

    /**
     * 弹出提示框
     *
     * @param title          标题
     * @param message        内容
     * @param negativeButton 左按钮
     * @param positiveButton 右按钮
     * @param listener       事件监听
     */
    protected void showDialog(String title, String message, String negativeButton, String positiveButton,
                              DialogInterface.OnClickListener listener) {
        builder = new AlertDialog.Builder(getActivity());
        if (!isEmptyString(title)) {
            builder.setTitle(title);
        }
        if (!isEmptyString(message)) {
            builder.setMessage(message);
        }
        if (!isEmptyString(negativeButton)) {
            builder.setNegativeButton(negativeButton, listener);
        }
        if (!isEmptyString(positiveButton)) {
            builder.setPositiveButton(positiveButton, listener);
        }
        builder.create().show();
    }

    /**
     * 弹出提示框(两个按钮)
     *
     * @param message        内容
     * @param negativeButton 左按钮
     * @param positiveButton 右按钮
     * @param listener       事件监听
     */
    protected void showDialog(String message, String negativeButton, String positiveButton,
                              DialogInterface.OnClickListener listener) {
        showDialog("", message, negativeButton, positiveButton, listener);
    }

    /**
     * 弹出提示框(一个按钮)
     *
     * @param message        内容
     * @param negativeButton 左按钮
     * @param listener       事件监听
     */
    protected void showDialog(String message, String negativeButton,
                              DialogInterface.OnClickListener listener) {
        showDialog(message, negativeButton, "", listener);
    }

    /**
     * 弹出框提示
     * @param message 内容
     * @param listener 事件监听
     */
    protected void showDialog(String message,
                              DialogInterface.OnClickListener listener) {
        if (message.endsWith("?") || message.endsWith("？")) {
            showDialog(message, "是", "否", listener);
        } else {
            showDialog(message, "确定", listener);
        }
    }


    ///////////////////网络请求封装//////////////////////
    /**
     * get请求
     * @param url
     * @param params
     * @param requestCode
     */
    protected void getRequest(String url, RequestParams params, int requestCode){
        sendRequest(HttpRequest.HttpMethod.GET, url, params, requestCode);
    }

    /**
     * post请求
     * @param url
     * @param params
     * @param requestCode
     */
    protected void postRequest(String url, RequestParams params, int requestCode){
        sendRequest(HttpRequest.HttpMethod.POST, url, params, requestCode);
    }

    /**
     * 发送请求
     * @param method
     * @param url
     * @param params
     * @param requestCode
     */
    private void sendRequest(HttpRequest.HttpMethod method, String url, RequestParams params, final int requestCode){
        getHttpUtils().send(method, url, params, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                onRequestCallBack(requestCode, responseInfo.result, true);
            }

            @Override
            public void onFailure(HttpException error, String msg) {
                onRequestCallBack(requestCode, msg, false);
            }
        });
    }

    /**
     * 获得HttpUtil对象
     * @return
     */
    protected HttpUtils getHttpUtils(){
        if(httpUtils == null){
            httpUtils = new HttpUtils();
        }
        return httpUtils;
    }


    /**
     * 请求结果处理
     * @param requestCode 请求码
     * @param result 返回内容
     * @param success 是否请求成功
     */
    protected void onRequestCallBack(int requestCode, String result, boolean success){

    }


    /**
     * 字符串是否为空
     * @param str
     * @return
     */
    protected boolean isEmptyString(String str){
        return TextUtils.isEmpty(str);
    }

    /**
     * 对象是否为空
     * @param o
     * @return
     */
    protected boolean isNull(Object o){
        return o == null;
    }

    /**
     * toast提示
     * @param msg
     */
    protected void showToast(String msg){
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }
    protected void showToast(int msg){
        Toast.makeText(getActivity(), getActivity().getString(msg), Toast.LENGTH_LONG).show();
    }

}

