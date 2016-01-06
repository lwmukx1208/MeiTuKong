package org.fireking.meitukong.ui.fragment;


import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.fireking.meitukong.R;
import org.fireking.meitukong.bean.ITuBaBean;
import org.fireking.meitukong.persenter.IListPersenter;
import org.fireking.meitukong.persenter.impl.ListPersenterImpl;
import org.fireking.meitukong.supports.SpacesItemDecoration;
import org.fireking.meitukong.ui.adapter.ListAdapter;
import org.fireking.meitukong.ui.view.IListView;

import java.util.List;

import static android.support.v7.widget.RecyclerView.*;

public class MainFragment extends Fragment implements IListView {

    private static final String ARG_PARAM1 = "cate";

    private int pageNo = 0;

    private String mCategory;

    private Context mContext;

    private IListPersenter mIListPersenter;

    private RecyclerView recycle;

    private ListAdapter mListAdapter;

    private RelativeLayout loadingview;

    private RelativeLayout loadingerrorlayout;
    private TextView loadingerror;
    private Typeface typeface;

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
        typeface = Typeface.createFromAsset(mContext.getAssets(), "fonts/tjfsh.ttf");

        recycle = (RecyclerView) getView().findViewById(R.id.recycle);
        loadingview = (RelativeLayout) getView().findViewById(R.id.loadingview);
        loadingerrorlayout = (RelativeLayout) getView().findViewById(R.id.loadingerrorlayout);
        loadingerror = (TextView) getView().findViewById(R.id.loadingerror);
        loadingerror.setTypeface(typeface);

        mListAdapter = new ListAdapter(mContext);
        recycle.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        recycle.setAdapter(mListAdapter);
        recycle.addOnScrollListener(new OnScrollListener() {
            //用来标记是否正在向最后一个滑动，既是否向右滑动或向下滑动
            boolean isSlidingToLast = false;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                StaggeredGridLayoutManager manager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
                // 当不滚动时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //获取最后一个完全显示的ItemPosition
                    int[] lastVisibleItem = manager.findLastVisibleItemPositions(null);
                    int totalItemCount = manager.getItemCount();

                    // 判断是否滚动到底部，并且是向右滚动
                    if (lastVisibleItem[0] == (totalItemCount - 1) && isSlidingToLast) {
                        //加载更多功能的代码
                        mIListPersenter.getList(pageNo, mCategory);
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //dx用来判断横向滑动方向，dy用来判断纵向滑动方向
                if (dy > 0) {
                    //大于0表示，正在向下滚动
                    isSlidingToLast = true;
                } else {
                    //小于等于0 表示停止或向上滚动
                    isSlidingToLast = false;
                }
            }
        });

        SpacesItemDecoration decoration = new SpacesItemDecoration(8);
        recycle.addItemDecoration(decoration);

        mIListPersenter.getList(pageNo, mCategory);
    }

    @Override
    public void showLoading() {
        if (pageNo == 0)
            loadingview.setVisibility(View.VISIBLE);
        else {

        }
    }

    @Override
    public void showError() {
        if (pageNo == 0) {
            loadingerrorlayout.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(mContext, "数据加载失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void hideLoading() {
        if (pageNo == 0)
            loadingview.setVisibility(View.GONE);
    }

    @Override
    public void showEmpty() {
        if (pageNo == 0) {
            loadingerror.setText("没有找到相关数据!");
            loadingerrorlayout.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(mContext, "没有更多数据!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setList(List<ITuBaBean> list) {
        if (list.size() == 30) {
            pageNo++;
        }
        loadingview.setVisibility(View.GONE);
        mListAdapter.append(list);
    }
}
