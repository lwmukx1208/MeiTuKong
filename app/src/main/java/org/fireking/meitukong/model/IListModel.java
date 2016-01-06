package org.fireking.meitukong.model;

import org.fireking.meitukong.bean.ITuBaBean;

import cn.bmob.v3.listener.FindListener;

/**
 * Created by wangg on 16/1/5.
 */
public interface IListModel {

    /**
     * 获取指定类型的内容列表
     */
    public void getList(int pageNo, String type, FindListener<ITuBaBean> listener);
}
