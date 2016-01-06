package org.fireking.meitukong.model.impl;

import org.fireking.meitukong.bean.MainCategoryBean;
import org.fireking.meitukong.model.MainModel;
import org.fireking.meitukong.model.UrlConst;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangg on 16/1/3.
 */
public class MainModelImpl implements MainModel {

    public List<MainCategoryBean> getCategory() {
        List<MainCategoryBean> beans = new ArrayList<>();
        beans.add(new MainCategoryBean(UrlConst.MEINVTUPIAN, "美女图片"));
        beans.add(new MainCategoryBean(UrlConst.SEXYMEINV, "性感美女"));
        beans.add(new MainCategoryBean(UrlConst.SIWAMEINV, "丝袜美女"));
        beans.add(new MainCategoryBean(UrlConst.RIHANMEINV, "日韩美女"));
        beans.add(new MainCategoryBean(UrlConst.XIURENMOTE, "秀人模特"));
        beans.add(new MainCategoryBean(UrlConst.DONGMAN, "动漫美女"));
        beans.add(new MainCategoryBean(UrlConst.MODEL, "模特魅影"));
        beans.add(new MainCategoryBean(UrlConst.START, "美女明星"));
        beans.add(new MainCategoryBean(UrlConst.BELLE, "美女写着"));
        beans.add(new MainCategoryBean(UrlConst.MEINVTAOTU, "美女套图"));
        return beans;
    }
}
