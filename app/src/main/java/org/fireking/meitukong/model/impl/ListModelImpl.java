package org.fireking.meitukong.model.impl;

import android.content.Context;

import org.fireking.meitukong.bean.ITuBaBean;
import org.fireking.meitukong.model.IListModel;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by wangg on 16/1/5.
 */
public class ListModelImpl implements IListModel {

    private Context mContext;

    public ListModelImpl(Context context) {
        this.mContext = context;
    }

    @Override
    public void getList(int pageNo, String type, FindListener<ITuBaBean> listener) {
        BmobQuery<ITuBaBean> query = new BmobQuery<ITuBaBean>();
        query.addWhereEqualTo("type", type);
        query.setLimit(30);
        query.setSkip(pageNo * 30);
        query.findObjects(mContext, listener);
    }
}
