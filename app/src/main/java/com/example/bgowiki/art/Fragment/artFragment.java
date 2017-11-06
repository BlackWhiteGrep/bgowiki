package com.example.bgowiki.art.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.bgowiki.R;
import com.example.bgowiki.base.BaseFragment;
import com.example.bgowiki.bean.ChildData;
import com.example.bgowiki.bean.GroupData;

import java.util.ArrayList;
import java.util.List;

public class artFragment extends BaseFragment {

    private ExpandableListView listView;
    private MyExpandableListViewAdapter adapter;
    private List<GroupData> groupList;
    private List<List<ChildData>> childList;

    private String[] url;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.art_expandable_layout, container, false);
    }

    @Override
    public View initView() {
        return null;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ExpandableListView listView =  getActivity().findViewById(R.id.expandableListView);
        //设置 属性 GroupIndicator 去掉默认向下的箭头
        listView.setGroupIndicator(null);

        init();
        loadData();



    }

    private void init() {
        listView = (ExpandableListView) getActivity().findViewById(R.id.expandableListView);
        groupList = new ArrayList<>();
        childList = new ArrayList<>();
        adapter = new MyExpandableListViewAdapter(this, groupList, childList);
        listView.setAdapter(adapter);

        //重写OnGroupClickListener，实现当展开时，ExpandableListView不自动滚动
        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if (parent.isGroupExpanded(groupPosition)) {
                    parent.collapseGroup(groupPosition);
                } else {
                    //第二个参数false表示展开时是否触发默认滚动动画
                    parent.expandGroup(groupPosition, false);
                }
                //telling the listView we have handled the group click, and don't want the default actions.
                return true;
            }
        });
    }

    private void loadData() {

        url = new String[]{
                "http://cdn.duitang.com/uploads/item/201506/07/20150607125903_vFWC5.png",
                "http://upload.qqbody.com/ns/20160915/202359954jalrg3mqoei.jpg",
                "http://tupian.qqjay.com/tou3/2016/0726/8529f425cf23fd5afaa376c166b58e29.jpg",
                "http://cdn.duitang.com/uploads/item/201607/13/20160713094718_Xe3Tc.png",
                "http://img3.imgtn.bdimg.com/it/u=1808104956,526590423&fm=11&gp=0.jpg",
                "http://tupian.qqjay.com/tou3/2016/0725/5d6272a4acd7e21b2391aff92f765018.jpg"
        };

        List<String> group = new ArrayList<>();
        group.add("我的设备");
        group.add("我的好友");
        group.add("初中同学");
        group.add("高中同学");
        group.add("大学同学");

        for (int i = 0; i < group.size(); i++) {
            GroupData gd = new GroupData(group.get(i));
            groupList.add(gd);
        }

        for (int i = 0; i < group.size(); i++) {
            List<ChildData> list = new ArrayList<>();
            for (int j = 0; j < 2 * i + 2; j++) {
                ChildData cd ;

               switch (i){
                   case 0:
                       cd= new ChildData(url[1],"涛妹1","朝鲜火箭");
                       list.add(cd);
                       cd = new ChildData(url[1],"涛妹2","朝鲜火箭");
                       list.add(cd);
                       cd = new ChildData(url[1],"涛妹3","朝鲜火箭");
                       list.add(cd);
                       cd = new ChildData(url[1],"涛妹4","朝鲜火箭");
                       list.add(cd);
                       break;

                   case 1:
                       cd = new ChildData(url[1],"涛妹","朝鲜火箭");
                       list.add(cd);
                       cd = new ChildData(url[1],"涛妹","朝鲜火箭");
                       list.add(cd);
                       cd = new ChildData(url[1],"涛妹","朝鲜火箭");
                       list.add(cd);
                       cd = new ChildData(url[1],"涛妹","朝鲜火箭");
                       list.add(cd);
                       break;
                   case 2:
                       cd = new ChildData(url[1],"涛妹","朝鲜火箭");
                       list.add(cd);
                       cd = new ChildData(url[1],"涛妹","朝鲜火箭");
                       list.add(cd);
                       cd = new ChildData(url[1],"涛妹","朝鲜火箭");
                       list.add(cd);
                       cd = new ChildData(url[1],"涛妹","朝鲜火箭");
                       list.add(cd);
                       break;
                   case 3:
                       cd = new ChildData(url[1],"涛妹","朝鲜火箭");
                       list.add(cd);
                       cd = new ChildData(url[1],"涛妹","朝鲜火箭");
                       list.add(cd);
                       cd = new ChildData(url[1],"涛妹","朝鲜火箭");
                       list.add(cd);
                       cd = new ChildData(url[1],"涛妹","朝鲜火箭");
                       list.add(cd);
                       break;
                   case 4:
                       cd = new ChildData(url[1],"涛妹","朝鲜火箭");
                       list.add(cd);
                       cd = new ChildData(url[1],"涛妹","朝鲜火箭");
                       list.add(cd);
                       cd = new ChildData(url[1],"涛妹","朝鲜火箭");
                       list.add(cd);
                       cd = new ChildData(url[1],"涛妹","朝鲜火箭");
                       list.add(cd);
                       break;
                   case 5:
                       cd = new ChildData(url[1],"涛妹","朝鲜火箭");
                       list.add(cd);
                       cd = new ChildData(url[1],"涛妹","朝鲜火箭");
                       list.add(cd);
                       cd = new ChildData(url[1],"涛妹","朝鲜火箭");
                       list.add(cd);
                       cd = new ChildData(url[1],"涛妹","朝鲜火箭");
                       list.add(cd);
                       break;


               }
            }
            childList.add(list);
        }
    }
}









