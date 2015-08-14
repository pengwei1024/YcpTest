package com.ycp.yuanchuangpai.test.model;

import java.util.List;

/**
 * Created by pengwei08 on 2015/7/3.
 * 历史版本基类
 */
public class VersionObject {

    private int total;
    private int errno;
    private List<DataEntity> data;
    private int end_state;

    public void setTotal(int total) {
        this.total = total;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public void setEnd_state(int end_state) {
        this.end_state = end_state;
    }

    public int getTotal() {
        return total;
    }

    public int getErrno() {
        return errno;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public int getEnd_state() {
        return end_state;
    }

    public class DataEntity {
        /**
         * uid : 4597293
         * version_name : 5.0.0
         * rsa_md5 : c51386333258d6e2347461de44581a95
         * apk_md5 : 7cbeb71fd80fdfe92f2eaa6699bc457d
         * apkid : com.ycp.yuanchuangpai
         * is_inscreen_ad : 0
         * pdown_url : pdown://http://shouji.360tpcdn.com/150611/7cbeb71fd80fdfe92f2eaa6699bc457d/com.ycp.yuanchuangpai_500.apk|p2=e127e364aad7ab3f10d392bcde46f3dc5dd350cd|b2=4164690|b5=手机助手|p4=3600
         * signature_md5 : c7fd2e84019e892a8d3c017c1457e5e9
         * pid : 7234971
         * is_authority : 1
         * version_code : 500
         * os_version : 8
         * size : 4164690
         * id : 783022
         * down_url : http://shouji.360tpcdn.com/150611/7cbeb71fd80fdfe92f2eaa6699bc457d/com.ycp.yuanchuangpai_500.apk
         * is_offerwall : 0
         * is_push_ad : 0
         * is_ad : 0
         * name : 缘创派
         * create_time : 2015-06-11 18:06:12
         * logo_url : http://p19.qhimg.com/t018d7c5fbf24414fdf.png
         */
        private String uid;
        private String version_name;
        private String rsa_md5;
        private String apk_md5;
        private String apkid;
        private String is_inscreen_ad;
        private String pdown_url;
        private String signature_md5;
        private String pid;
        private int is_authority;
        private String version_code;
        private String os_version;
        private String size;
        private String id;
        private String down_url;
        private String is_offerwall;
        private String is_push_ad;
        private String is_ad;
        private String name;
        private String create_time;
        private String logo_url;

        public void setUid(String uid) {
            this.uid = uid;
        }

        public void setVersion_name(String version_name) {
            this.version_name = version_name;
        }

        public void setRsa_md5(String rsa_md5) {
            this.rsa_md5 = rsa_md5;
        }

        public void setApk_md5(String apk_md5) {
            this.apk_md5 = apk_md5;
        }

        public void setApkid(String apkid) {
            this.apkid = apkid;
        }

        public void setIs_inscreen_ad(String is_inscreen_ad) {
            this.is_inscreen_ad = is_inscreen_ad;
        }

        public void setPdown_url(String pdown_url) {
            this.pdown_url = pdown_url;
        }

        public void setSignature_md5(String signature_md5) {
            this.signature_md5 = signature_md5;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public void setIs_authority(int is_authority) {
            this.is_authority = is_authority;
        }

        public void setVersion_code(String version_code) {
            this.version_code = version_code;
        }

        public void setOs_version(String os_version) {
            this.os_version = os_version;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setDown_url(String down_url) {
            this.down_url = down_url;
        }

        public void setIs_offerwall(String is_offerwall) {
            this.is_offerwall = is_offerwall;
        }

        public void setIs_push_ad(String is_push_ad) {
            this.is_push_ad = is_push_ad;
        }

        public void setIs_ad(String is_ad) {
            this.is_ad = is_ad;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public void setLogo_url(String logo_url) {
            this.logo_url = logo_url;
        }

        public String getUid() {
            return uid;
        }

        public String getVersion_name() {
            return version_name;
        }

        public String getRsa_md5() {
            return rsa_md5;
        }

        public String getApk_md5() {
            return apk_md5;
        }

        public String getApkid() {
            return apkid;
        }

        public String getIs_inscreen_ad() {
            return is_inscreen_ad;
        }

        public String getPdown_url() {
            return pdown_url;
        }

        public String getSignature_md5() {
            return signature_md5;
        }

        public String getPid() {
            return pid;
        }

        public int getIs_authority() {
            return is_authority;
        }

        public String getVersion_code() {
            return version_code;
        }

        public String getOs_version() {
            return os_version;
        }

        public String getSize() {
            return size;
        }

        public String getId() {
            return id;
        }

        public String getDown_url() {
            return down_url;
        }

        public String getIs_offerwall() {
            return is_offerwall;
        }

        public String getIs_push_ad() {
            return is_push_ad;
        }

        public String getIs_ad() {
            return is_ad;
        }

        public String getName() {
            return name;
        }

        public String getCreate_time() {
            return create_time;
        }

        public String getLogo_url() {
            return logo_url;
        }
    }
}
