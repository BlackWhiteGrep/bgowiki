package com.example.bgowiki.art.Fragment;

/**
 * Created by jin on 2017/11/1.
 */

import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bgowiki.R;
import com.example.bgowiki.bean.ChildData;
import com.example.bgowiki.bean.GroupData;

import java.util.List;

class MyExpandableListViewAdapter implements ExpandableListAdapter {
        private artFragment context;
        private List<GroupData> groupData;
        private List<List<ChildData>> childData;

     MyExpandableListViewAdapter(artFragment context, List<GroupData> groupData, List<List<ChildData>> childData) {
            this.context = context;
            this.groupData = groupData;
            this.childData = childData;
     }


     @Override
        public void registerDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver observer) {

        }

        //获取分组个数
        @Override
        public int getGroupCount() {
            int ret = 0;
            if (groupData != null) {
                ret = groupData.size();
            }
            return ret;
        }

        //获取groupPosition分组，子列表数量
        @Override
        public int getChildrenCount(int groupPosition) {
            int ret = 0;
            if (childData != null) {
                ret = childData.get(groupPosition).size();
            }
            return ret;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groupData.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return childData.get(groupPosition).get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    class Group_CheckBox_Click implements View.OnClickListener {
        private int groupPosition;

        Group_CheckBox_Click(int groupPosition) {
            this.groupPosition = groupPosition;
        }

        public void onClick(View v) {
            groupData.get(groupPosition).toggle();
            // 注意，一定要通知 ExpandableListView 資料已經改變，ExpandableListView 會重新產生畫面
        }
    }

        @Override
        public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            GroupViewHolder holder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(context.getContext()).inflate(R.layout.art_parent_item, null);
                holder = new GroupViewHolder();
                holder.tv_name = (TextView) convertView.findViewById(R.id.tv_group_name);
                holder.ckbArt= convertView.findViewById(R.id.ckbArt);
                convertView.setTag(holder);
            } else {
                holder = (GroupViewHolder) convertView.getTag();
            }
            GroupData groupData = this.groupData.get(groupPosition);
            holder.tv_name.setText(groupData.getName());
            // 重新產生 CheckBox 時，將存起來的 isChecked 狀態重新設定
            holder.ckbArt.setChecked(groupData.getChecked());

            // 點擊 CheckBox 時，將狀態存起來
            holder.ckbArt.setOnClickListener(new Group_CheckBox_Click(groupPosition));
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            ChildViewHolder holder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(context.getContext()).inflate(R.layout.art_child_item, null);
                holder = new ChildViewHolder();
                holder.img = (ImageView) convertView.findViewById(R.id.img_child_head);
                holder.tv_name = (TextView) convertView.findViewById(R.id.tv_child_name);
                holder.tv_content = (TextView) convertView.findViewById(R.id.tv_child_content);
                convertView.setTag(holder);
            } else {
                holder = (ChildViewHolder) convertView.getTag();
            }
            ChildData childData = this.childData.get(groupPosition).get(childPosition);
            Glide.with(context).load(childData.getUrl()).placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher).into(holder.img);
            holder.tv_name.setText(childData.getName());
            holder.tv_content.setText(childData.getContent());
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        @Override
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public void onGroupExpanded(int groupPosition) {

        }

        @Override
        public void onGroupCollapsed(int groupPosition) {

        }

        @Override
        public long getCombinedChildId(long groupId, long childId) {
            return 0;
        }

        @Override
        public long getCombinedGroupId(long groupId) {
            return 0;
        }

        class GroupViewHolder {
            ImageView img;
            TextView tv_name, tv_num;
            CheckBox ckbArt;
        }

        class ChildViewHolder {
            ImageView img;
            TextView tv_name, tv_content;
        }


 }

