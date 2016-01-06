package org.fireking.meitukong.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wangg on 16/1/5.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder>{


    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ListHolder extends RecyclerView.ViewHolder{

        public ListHolder(View itemView) {
            super(itemView);
        }
    }
}
