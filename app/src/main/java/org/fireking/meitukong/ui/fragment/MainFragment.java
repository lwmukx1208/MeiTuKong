package org.fireking.meitukong.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.fireking.meitukong.R;
import org.fireking.meitukong.bean.ITuBaBean;
import org.fireking.meitukong.persenter.IListPersenter;
import org.fireking.meitukong.persenter.impl.ListPersenterImpl;
import org.fireking.meitukong.supports.SpacesItemDecoration;
import org.fireking.meitukong.ui.adapter.ListAdapter;
import org.fireking.meitukong.ui.view.IListView;

import java.util.List;

public class MainFragment extends Fragment implements IListView {

    private static final String ARG_PARAM1 = "cate";

    private int pageNo = 0;

    private String mCategory;

    private Context mContext;

    private IListPersenter mIListPersenter;

    private RecyclerView recycle;

    private ListAdapter mListAdapter;

    public MainFragment() {
    }

    public static MainFragment newInstance(String param1) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        while (mContext == null) {
            if (getActivity() != null) {
                mContext = getActivity();
            }
        }
        if (getArguments() != null) {
            mCategory = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mIListPersenter = new ListPersenterImpl(mContext, this);

        recycle = (RecyclerView) getView().findViewById(R.id.recycle);
        mListAdapter = new ListAdapter(mContext);
        recycle.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        recycle.setAdapter(mListAdapter);

        SpacesItemDecoration decoration=new SpacesItemDecoration(8);
        recycle.addItemDecoration(decoration);

        mIListPersenter.getList(pageNo, mCategory);
    }

    @Override
    public void showLoading() {
        Toast.makeText(mContext, "加载中!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {
        Toast.makeText(mContext, "加载失败!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {
        Toast.makeText(mContext, "隐藏加载!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void setList(List<ITuBaBean> list) {
        mListAdapter.append(list);
    }
}
