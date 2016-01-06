package org.fireking.meitukong.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by wangg on 16/1/5.
 */
public class ITuBaBean extends BmobObject {

    /**
     * 跳转地址
     */
    private String url;
    /**
     * 类型
     */
    private String type;
    /**
     * 图片地址
     */
    private String img;
    /**
     * 描述信息
     */
    private String desc;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
