package org.fireking.meitukong.persenter.impl;

import org.fireking.meitukong.bean.MainCategoryBean;
import org.fireking.meitukong.model.MainModel;
import org.fireking.meitukong.model.impl.MainModelImpl;
import org.fireking.meitukong.persenter.MainPersenter;

import java.util.List;

/**
 * Created by wangg on 16/1/3.
 */
public class MainPersenterImpl implements MainPersenter {

    private MainModel mainModel;

    public MainPersenterImpl() {
        mainModel = new MainModelImpl();
    }

    @Override
    public List<MainCategoryBean> getCategory() {
        return mainModel.getCategory();
    }
}
