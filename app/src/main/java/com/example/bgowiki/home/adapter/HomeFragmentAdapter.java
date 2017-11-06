package com.example.bgowiki.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.bgowiki.R;
import com.example.bgowiki.bean.Sevent_name;

public class HomeFragmentAdapter extends RecyclerView.Adapter {

    private  Context mcontext;
    private  Sevent_name name;
    private  LayoutInflater mLayoutInflater;
    private int currentType ;
    public static final int sevent = 0;

    public HomeFragmentAdapter(Context mcontext, Sevent_name name) {
        this.mcontext = mcontext ;
        this.name =name;
        mLayoutInflater = LayoutInflater.from(mcontext);
    }

    /***
     *  *相当于getView  相当于创建ViewHolder方法
     *
             * @param parent
     * @param viewType 当前类型
     * @return
             */
//
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new Sevent_nameViewHolder(mcontext,mLayoutInflater.inflate(R.layout.sevent,null));
    }

    /***
     *相当于getview中的绑定数据模块
     */


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


    }

    /**
    *得到类型
    * */
    @Override
    public int getItemViewType(int position) {
        return sevent;
    }

    @Override
    public int getItemCount() {
        return 1;
    }

     class Sevent_nameViewHolder extends RecyclerView.ViewHolder {
        private Context mcontext;

        public Sevent_nameViewHolder(Context mcontext, View view) {
            super(view);
        }
    }
}
