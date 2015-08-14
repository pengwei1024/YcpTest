/*
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */
package com.ycp.yuanchuangpai.test.helper;

import android.widget.LinearLayout;

/**
 * Created by pengwei on 15/3/2.
 */
public class LayoutParamsHelper {

    /**
     * 全屏
     *
     * @return
     */
    public static LinearLayout.LayoutParams getLinearLayoutParamMatch() {
        return new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
    }

    /**
     * 自适应
     *
     * @return
     */
    public static LinearLayout.LayoutParams getLinearLayoutParamWrap() {
        return new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
    }

}
