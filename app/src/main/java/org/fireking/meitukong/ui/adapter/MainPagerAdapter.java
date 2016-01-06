package org.fireking.meitukong.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.fireking.meitukong.bean.MainCategoryBean;
import org.fireking.meitukong.ui.fragment.MainFragment;

import java.util.List;

/**
 * Created by wangg on 16/1/3.
 */
public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private List<MainCategoryBean> mMainCategorys;

    public MainPagerAdapter(FragmentManager fm, List<MainCategoryBean> beans) {
        super(fm);
        mMainCategorys = beans;
    }

    @Override
    public Fragment getItem(int position) {
        return MainFragment.newInstance(mMainCategorys.get(position).getCategory());
    }

    @Override
    public int getCount() {
        return mMainCategorys.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mMainCategorys.get(position).getName();
    }
}
