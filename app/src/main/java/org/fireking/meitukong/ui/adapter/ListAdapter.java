package org.fireking.meitukong.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.fireking.meitukong.R;
import org.fireking.meitukong.bean.ITuBaBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangg on 16/1/5.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder> {

    public Context mContext;
    private List<ITuBaBean> mlist = new ArrayList<>();

    public ListAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListHolder(LayoutInflater.from(mContext).inflate(R.layout.item_list, null));
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        Picasso.with(mContext).load(mlist.get(position).getImg()).placeholder(R.mipmap.empty).error(R.mipmap.empty).into(holder.image);
        holder.desc.setText(mlist.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class ListHolder extends RecyclerView.ViewHolder {

        public TextView desc;
        public ImageView image;

        public ListHolder(View itemView) {
            super(itemView);
            desc = (TextView) itemView.findViewById(R.id.desc);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }

    /**
     * 替代数据
     */
    public void replace(List<ITuBaBean> list) {
        this.mlist = list;
        notifyDataSetChanged();
    }

    /**
     * 追加数据
     */
    public void append(List<ITuBaBean> list) {
        this.mlist.addAll(list);
        notifyDataSetChanged();
    }
}
