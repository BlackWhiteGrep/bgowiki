package com.example.bgowiki.art.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.bgowiki.R;
import com.example.bgowiki.base.BaseFragment;
import com.example.bgowiki.bean.ArtContentEntity;

import java.util.ArrayList;
import java.util.List;

public class artFragment extends BaseFragment {
    private ExpandableListView EvExpandableListView;
    private List<String> father_List;// 父层数据
    private List<List<ArtContentEntity>> list_Son;// 子层数据
    private int[] img = { R.drawable.ic_launcher };

   /* private Map<String, List<String>> dataset = new HashMap<>();
    private String[] parentList = new String[]{"first", "second", "third"};
    private List<String> childrenList1 = new ArrayList<>();
    private List<String> childrenList2 = new ArrayList<>();
    private List<String> childrenList3 = new ArrayList<>();
    private MyExpandableListViewAdapter adapter;*/

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

        EvExpandableListView = getActivity().findViewById(R.id.EvExpandableListView);

        list_Son = new ArrayList<>();
        ArtContentEntity contentEntity01 = new ArtContentEntity();
        contentEntity01.setArtInfo("This is a test1!");
        contentEntity01.setCount("1111");
        contentEntity01.setImage(img[0]);
        contentEntity01.setType(1);

        List<ArtContentEntity> son_List01 = new ArrayList<>();
        son_List01.add(contentEntity01);

        // 添加子目录数据
        list_Son.add(son_List01);

        // 添加父目录数据
        father_List = new ArrayList<>();
        father_List.add("TEST1");

        // 数据适配
        ContentAdapter adapter = new ContentAdapter(this, father_List, list_Son);
        EvExpandableListView.setAdapter(adapter);

        /*initialData();
        adapter = new MyExpandableListViewAdapter();
        EvExpandableListView.setAdapter(adapter);*/

    }

    /*private void initialData() {
        childrenList1.add(parentList[0] + "-" + "first\n涛妹");
        childrenList1.add(parentList[0] + "-" + "second");
        childrenList1.add(parentList[0] + "-" + "third");
        childrenList2.add(parentList[1] + "-" + "first");
        childrenList2.add(parentList[1] + "-" + "second");
        childrenList2.add(parentList[1] + "-" + "third");
        childrenList3.add(parentList[2] + "-" + "first");
        childrenList3.add(parentList[2] + "-" + "second");
        childrenList3.add(parentList[2] + "-" + "third");
        dataset.put(parentList[0], childrenList1);
        dataset.put(parentList[1], childrenList2);
        dataset.put(parentList[2], childrenList3);*/
    }

            /*private class MyExpandableListViewAdapter extends BaseExpandableListAdapter {

//  获得某个父项的某个子项
        @Override
        public Object getChild(int parentPos, int childPos) {
            return dataset.get(parentList[parentPos]).get(childPos);
    }

        //  获得父项的数量
        @Override
        public int getGroupCount() {
            return dataset.size();
        }

        //  获得某个父项的子项数目
        @Override
        public int getChildrenCount(int parentPos) {
            return dataset.get(parentList[parentPos]).size();
        }

        //  获得某个父项
        @Override
        public Object getGroup(int parentPos) {
            return dataset.get(parentList[parentPos]);
        }

        //  获得某个父项的id
        @Override
        public long getGroupId(int parentPos) {
            return parentPos;
        }

        //  获得某个父项的某个子项的id
        @Override
        public long getChildId(int parentPos, int childPos) {
            return childPos;
        }

        //  按函数的名字来理解应该是是否具有稳定的id，这个方法目前一直都是返回false，没有去改动过
        @Override
        public boolean hasStableIds() {
            return false;
        }

        //  获得父项显示的view
        @Override
        public View getGroupView(int parentPos, boolean b, View view, ViewGroup viewGroup) {

            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.art_parent_item, null);
            }
            view.setTag(R.layout.art_parent_item, parentPos);
            view.setTag(R.layout.art_child_item, -1);
            TextView text =  view.findViewById(R.id.parent_title);
            text.setText(parentList[parentPos]);
            return view;
        }

        //  获得子项显示的view
        @Override
        public View getChildView(int parentPos, int childPos, boolean b, View view, ViewGroup viewGroup) {
            if (view == null) {

                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.art_child_item, null);
            }
            view.setTag(R.layout.art_parent_item, parentPos);
            view.setTag(R.layout.art_child_item, childPos);
            TextView text =  view.findViewById(R.id.child_title);
            text.setText(dataset.get(parentList[parentPos]).get(childPos));
            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), "点到了内置的textview", Toast.LENGTH_SHORT).show();
                }
            });
            return view;
        }

        //  子项是否可选中，如果需要设置子项的点击事件，需要返回true
        @Override
        public boolean isChildSelectable(int i, int i1) {
            return false;
        }


    }*/







