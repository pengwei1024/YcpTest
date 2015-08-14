package com.ycp.yuanchuangpai.test.helper;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

/**
 * 版本管理
 * 
 * @author pengwei
 * 
 */
public class VersionHelper {

	/**
	 * 获取当前版本名称
	 * 
	 * @param context
	 * @return
	 * @throws NameNotFoundException
	 */
	public static String getVersion(Context context) {
		PackageManager packageManager = context.getPackageManager();
		PackageInfo packInfo;
		try {
			packInfo = packageManager.getPackageInfo(context.getPackageName(),
					0);
			String version = packInfo.versionName;
			return version;
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return "1.0.0";
		}

	}

}
