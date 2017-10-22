package com.example.bgowiki.App;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.example.bgowiki.R;
import com.example.bgowiki.art.Fragment.artFragment;
import com.example.bgowiki.base.BaseFragment;
import com.example.bgowiki.codding.Fragment.coddingFragment;
import com.example.bgowiki.count.Fragment.countFragment;
import com.example.bgowiki.home.Fragment.SeventFragment;
import com.example.bgowiki.mine.Fragment.mineFragment;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {


    @Bind(R.id.frameLayout)
    FrameLayout frameLayout;
    @Bind(R.id.radioGroup)
    RadioGroup radioGroup;
    private ArrayList<BaseFragment> fragments;
    private int position;
    private BaseFragment mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragment();
        initListener();
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new SeventFragment());
        fragments.add(new coddingFragment());
        fragments.add(new artFragment());
        fragments.add(new countFragment());
        fragments.add(new mineFragment());
    }

    private void initListener() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.sevent:
                        position = 0;
                        break;
                    case R.id.codding:
                        position = 1;
                        break;
                    case R.id.art:
                        position = 2;
                        break;
                    case R.id.count:
                        position = 3;
                        break;
                    case R.id.mine:
                        position = 4;
                        break;
                }

                BaseFragment baseFragment = getFragment(position);
                switchFragment(mContext, baseFragment);
            }
        });

        radioGroup.check(R.id.sevent);

    }


    /**
     *
     * @param position
     * @return
     */
    private BaseFragment getFragment(int position) {
        if (fragments != null && fragments.size() > 0) {
            BaseFragment baseFragment = fragments.get(position);
            return baseFragment;
        }
        return null;
    }

    private void switchFragment(Fragment fromFragment, BaseFragment nextFragment) {
        if (mContext != nextFragment) {
            mContext = nextFragment;
            if (nextFragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //判断nextFragment是否添加
                if (!nextFragment.isAdded()) {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.add(R.id.frameLayout, nextFragment).commit();
                } else {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }

}
