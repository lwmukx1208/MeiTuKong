package org.fireking.meitukong;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.fireking.meitukong.bean.MainCategoryBean;
import org.fireking.meitukong.model.UrlConst;
import org.fireking.meitukong.persenter.MainPersenter;
import org.fireking.meitukong.persenter.impl.MainPersenterImpl;
import org.fireking.meitukong.ui.adapter.MainPagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MainPagerAdapter mMainPagerAdapter;

    private MainPersenter mainPersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        mainPersenter = new MainPersenterImpl();
        List<MainCategoryBean> beans = mainPersenter.getCategory();

        mTabLayout = (TabLayout) this.findViewById(R.id.tabs);
        mViewPager = (ViewPager) this.findViewById(R.id.pager);

        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        for (MainCategoryBean bean : beans) {
            mTabLayout.addTab(mTabLayout.newTab().setText(bean.getName()));
        }

        mTabLayout.setTabTextColors(getResources().getColor(R.color.divider), getResources().getColor(R.color.icons));
        mMainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), beans);
        mViewPager.setAdapter(mMainPagerAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
    }
}
