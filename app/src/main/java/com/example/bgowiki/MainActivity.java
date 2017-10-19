package com.example.bgowiki;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import cn.bmob.v3.Bmob;
import com.example.bgowiki.Fragment.Adress;
import com.example.bgowiki.Fragment.Frd;
import com.example.bgowiki.Fragment.Setting;
import com.example.bgowiki.Fragment.Sevent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments;
    // TAB

    private LinearLayout mTabSevent;
    private LinearLayout mTabFrd;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSetting;

    private ImageButton mSevemtImg;
    private ImageButton mFrdImg;
    private ImageButton mAddressImg;
    private ImageButton mSettingImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        initEvents();
        reselect(0);

    }

    private void initEvents() {
        mTabSevent.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int currentItem = mViewPager.getCurrentItem();
                resetImg();
                switch (currentItem) {
                    case 0:
                        mSevemtImg.setImageResource(R.drawable.tab_weixin_pressed);
                        break;
                    case 1:
                        mFrdImg.setImageResource(R.drawable.tab_find_frd_pressed);
                        break;
                    case 2:
                        mAddressImg.setImageResource(R.drawable.tab_address_pressed);
                        break;
                    case 3:
                        mSettingImg.setImageResource(R.drawable.tab_settings_pressed);
                        break;
                    default:
                        break;


                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void initView() {

        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

        mTabSevent = (LinearLayout) findViewById(R.id.id_tab_sevent);
        mTabAddress = (LinearLayout) findViewById(R.id.id_tab_address);
        mTabFrd = (LinearLayout) findViewById(R.id.id_tab_frd);
        mTabSetting = (LinearLayout) findViewById(R.id.id_tab_settings);

        mSevemtImg = (ImageButton) findViewById(R.id.id_tab_sevent_img);
        mAddressImg = (ImageButton) findViewById(R.id.id_tab_address_img);
        mFrdImg = (ImageButton) findViewById(R.id.id_tab_frd_img);
        mSettingImg = (ImageButton) findViewById(R.id.id_tab_settings_img);

        mFragments = new ArrayList<Fragment>();

        Fragment mTab01 = new Sevent();
        Fragment mTab02 = new Frd();
        Fragment mTab03 = new Adress();
        Fragment mTab04 = new Setting();

        mFragments.add(mTab01);
        mFragments.add(mTab02);
        mFragments.add(mTab03);
        mFragments.add(mTab04);

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        };
        mViewPager.setAdapter(mAdapter);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_tab_sevent:
                reselect(0);
                break;
            case R.id.id_tab_frd:
                reselect(1);
                break;
            case R.id.id_tab_address:
                reselect(2);
                break;
            case R.id.id_tab_settings:
                reselect(3);
                break;
            default:
                break;
        }
    }

    private void reselect(int i) {
        resetImg();
        switch (i) {
            case 0:
                mSevemtImg.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                mFrdImg.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 2:
                mAddressImg.setImageResource(R.drawable.tab_address_pressed);
            case 3:
                mSettingImg.setImageResource(R.drawable.tab_settings_pressed);
                break;
            default:
                break;

        }
        mViewPager.setCurrentItem(i);


    }

    //将图标变暗
    private void resetImg() {

        mSevemtImg.setImageResource(R.drawable.tabweixinnormal);
        mFrdImg.setImageResource(R.drawable.tab_find_frd_normal);
        mAddressImg.setImageResource(R.drawable.tab_address_normal);
        mSettingImg.setImageResource(R.drawable.tab_settings_normal);
    }
}
