package com.example.bgowiki.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 基类
 */

public abstract class BaseFragment extends Fragment{
    protected Context mcontext;
    /**当fragment被创建时回掉**/

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mcontext = getActivity();
    }
    /**当视图被创建时回掉**/
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }
//让子类实现自己的视图
    public abstract View initView();


    /***
     * 当Activity被创建时回掉
     * */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDate();
    }

    /**
     * 绑定数据
     * 如果子页面没有数据联网请求数据，并且绑定到initView初始化的视图上
     * 如果有，直接绑定
     */

    public void initDate() {

    }
}
