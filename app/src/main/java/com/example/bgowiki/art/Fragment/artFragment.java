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

        final ExpandableListView listView =  getActivity().findViewById(R.id.expandableListView);

        listView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                for (int i = 0; i < adapter.getGroupCount(); i++) {
                    if (groupPosition != i) {
                        listView.collapseGroup(i);
                    }
                }
            }
        });
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
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/875258874006d36280175404a0745b8d.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/693241f740f006d480bf88320876f4c7.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/2881152f40646b1d801094545cd6e591.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/d4853de440b0529280e1a8f4a60b2bb8.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/463e1cee40002aaf80269e9a7d5fbc46.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/9e5424724054aa4e80f3c95061c3a723.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/b6d76704409c681d807c1909ae7f20a9.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/e2b8e6ab403d16078065409a3f98e05a.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/a2cd602d403be8ad8054527aa90bef87.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/e6c255204046edbe80a74a1387c5957e.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/4b83b846406dc70180fe75a2a5825e33.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/b11a854c408e701b8079f0225f26c9f6.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/b739777340dfabdc80497c5f66c69965.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/bd54679140869c8980bad1e6f270c5fd.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/d5d4a27040037010801ad090c7575ada.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/7a819543408b1739802e22cd552bb7ef.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/4e9c94994026829f8079ced4568ba78b.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/e090baad400f95e080a9f7467f7c30d0.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/0a5cfb62408ab0be80fc93b1a96e01cc.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/f787ba3040d0c38180ffceb96206d4b9.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/010db57c40107d518010ab2ee2ffa066.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/0a68427e40702df780f20929c63b477c.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/e55a347840be6248806f077392e1a098.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/e2d03c6e4097226a806e1fcdcaab1d7c.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/1e6e31104090e01c8053423ffa8bac11.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/044323ca402eb55e802f6788582d2071.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/6bebd1a2408e4d5080b3f2f4cb4d041b.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/1fdc1bf8403208c68030f51a08a30fb0.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/52f8acf140c4fc1080a7b9de3084c956.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/e9690a094057ecc380947952660702c2.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/c24b5ece4043242d80e9f28fac4734da.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/a12bc1c9402d126e80e1ec6bb08d5a8f.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/5b0e6c2540d579fd803c87fa2282570a.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/1c06916e40e6385580dc56970ea40057.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/e2a12d5d4087a6cb806118e433d7b5ef.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/c279e83c40bb8d70808ad5519d47c9f0.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/e7edd3c040599084809ea081162cc087.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/dbdcd2174069c15180501b3a748c42d2.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/160f37ab408ef8f4805e4ebfd5905342.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/49c07a314016f32080b85a96d742da07.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/8942ccdc40cf037380a774c493de37c7.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/0a7e1d8e404cfa8c801fe5884d08fda4.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/dfdcfcae40c162fa80aaeecf5c6ab419.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/492f19fa4014ad6f805042d5b8316a9b.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/ccd3208b40da756880e376c9c314bc2b.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/94bef5be40f5f247809aaa7b0f122d17.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/2c0100ed400e24c980d7b45e064bb808.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/e118a1ff40c7c92e80e0019a02c09740.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/593481bd402b38608062d77804f323cb.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/3eb424414001ebaa80ee18f134b58ee0.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/bbf7acf0408243a680c4024e6f8a8b31.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/fe29ea9d409fc1d88023b4b7f1d0d402.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/c080ebe040948e3c80e14408c6b28425.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/0e4d4b6b4049db4b80d88e8f4d6675da.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/8470a5c940e0ce73802c8eed6af82ae6.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/1f1ee9cd4038c01e8029e205218615a0.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/ae85b61d4048f5ce80506fa9de1cfd16.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/e396a6da4061b32380ad889a5a90c084.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/d4c7fad140c31c398088531cb1375701.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/828fc91c40ee0d80808c0b7dbc3bdcff.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/502a4b5f4008c40680f063e9218b59a6.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/3c7cf12440204437802c4f2a20acd6d0.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/aa6ee4a540796bd780e04ce29fe17fd2.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/274e581e403a5d1e801e1358a845018e.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/edb8653a40aa3749808fb584811de250.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/2f49fbc340b98d2480b6a9bc406eba63.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/cbd5a7ce40e88203805336d11a7c328b.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/cd8f34404041c3338067cfbc58bc17cf.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/0d9fb60f4017a51b80aab4793d6451be.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/27fc0e964001c043802141723587db35.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/cde110764040f4ca80ea3a45d298a3bc.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/3491fcae404a51d080a699981238579c.jpg",
                "http://bmob-cdn-14604.b0.upaiyun.com/2017/11/02/cde110764040f4ca80ea3a45d298a3bc.jpg"
        };

        List<String> group = new ArrayList<>();
        //0
        group.add("魔伊联动");
        //1
        group.add("尼禄祭再临");
        //2
        group.add("万圣节2015复刻");
        //3
        group.add("万圣节2016");
        //4
        group.add("圣诞节2015复刻");
        //5
        group.add("圣诞节2016");
        //6
        group.add("月神祭复刻");
        //7
        group.add("监狱塔复刻");
        //8
        group.add("情人节复刻");
        //9
        group.add("本能寺复刻");
        //10
        group.add("明治维新");
        //11
        group.add("CCC联动");
        //12
        group.add("罗生门复刻");
        //13
        group.add("鬼岛复刻");
        //14
        group.add("泳装2016复刻");
        //15
        group.add("泳装2017");
        //16
        group.add("万圣节2017复刻");
        //17
        group.add("尼禄祭2017");

        for (int i = 0; i < group.size(); i++) {
            GroupData gd = new GroupData(group.get(i));
            groupList.add(gd);
        }

        for (int i = 0; i < group.size(); i++) {
            List<ChildData> list = new ArrayList<>();
            //for (int j = 0; j < 2 * i + 2; j++) {
                ChildData cd ;

            switch (i){
                //魔伊联动
                case 0:
                    cd= new ChildData(url[58],"英雄之证*15","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[56],"凶骨*15","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[57],"龙之牙*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[4],"愚者之锁*30","现有:0活动(0)");
                    list.add(cd);
                    cd= new ChildData(url[59],"世界树之种*30","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[61],"八连双晶*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[67],"蛇之宝玉*15","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[70],"凤凰羽毛*20","现有:0活动(0)");
                    list.add(cd);
                    cd= new ChildData(url[66],"无间齿轮*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[65],"禁断书页*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[63],"人工生命体幼体*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[64],"陨蹄铁*10","现有:0活动(0)");
                    list.add(cd);
                    cd= new ChildData(url[2],"大骑士勋章*15","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[69],"混沌之爪*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[60],"蛮神心脏*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[72],"龙之逆鳞*10","现有:0活动(0)");
                    list.add(cd);
                    cd= new ChildData(url[5],"精灵根*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[8],"战马的幼角*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[7],"血之泪石*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[6],"黑兽脂*10","现有:0活动(0)");
                    list.add(cd);
                    cd= new ChildData(url[3],"封魔之灯*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"智慧之圣甲虫像*15","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[62],"传承结晶*2","现有:0活动(0)");
                    list.add(cd);
                    break;

                //尼禄祭再临
                case 1:
                    cd = new ChildData(url[58],"英雄之证*30","现有:0(活动0)");
                    list.add(cd);
                    cd = new ChildData(url[71],"虚影之尘*30","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[61],"八连双晶*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[67],"蛇之宝玉*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[70],"凤凰羽毛*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[0],"追忆的贝壳*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[69],"混沌之爪*20","现有:0(活动0)");
                    list.add(cd);
                    cd = new ChildData(url[60],"蛮神心脏*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[72],"龙之逆鳞*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[5],"精灵根*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[8],"战马的幼角*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[7],"血之泪石*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[6],"黑兽脂*5","现有:0(活动0)");
                    list.add(cd);
                    cd = new ChildData(url[3],"封魔之灯*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"智慧之圣甲虫像*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[62],"传承结晶*2","现有:0活动(0)");
                    list.add(cd);
                    break;
                //万圣节2015复刻
                case 2:
                    cd = new ChildData(url[56],"凶骨*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[57],"龙之牙*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[68],"鬼魂提灯*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[65],"禁断书页*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[63],"人工生命体幼体*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[72],"龙之逆鳞*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[62],"传承结晶*4","现有:0活动(0)");
                    list.add(cd);
                    break;
                //万圣节2016
                case 3:
                    cd = new ChildData(url[58],"英雄之证*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[57],"龙之牙*30","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[4],"愚者之锁*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[67],"蛇之宝玉*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[70],"凤凰羽毛*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[60],"蛮神心脏*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[72],"龙之逆鳞*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[7],"血之泪石*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[6],"黑兽脂*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[3],"封魔之灯*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"智慧之圣甲虫像*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[62],"传承结晶*2","现有:0活动(0)");
                    list.add(cd);
                    break;
                //圣诞节2015复刻
                case 4:
                    cd = new ChildData(url[58],"英雄之证*40","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[56],"凶骨*40","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[57],"龙之牙*40","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[71],"虚影之尘*40","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[59],"世界树之种*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[67],"蛇之宝玉*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[72],"龙之逆鳞*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[62],"传承结晶*2","现有:0活动(0)");
                    list.add(cd);
                    break;
                //圣诞节2016
                case 5:
                    cd = new ChildData(url[58],"英雄之证*30","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[56],"凶骨*24","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[71],"虚影之尘*24","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[59],"世界树之种*30","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[67],"蛇之宝玉*18","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[70],"凤凰羽毛*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[0],"追忆的贝壳*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[60],"蛮神心脏*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[72],"龙之逆鳞*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[5],"精灵根*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[8],"战马的幼角*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[7],"血之泪石*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"智慧之圣甲虫像*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[62],"传承结晶*1","现有:0活动(0)");
                    list.add(cd);
                    break;
                //月神祭复刻
                case 6:
                    cd = new ChildData(url[1],"万死毒针*30","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[67],"蛇之宝玉*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[70],"凤凰羽毛*50","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[65],"禁断书页*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[69],"混沌之爪*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[60],"蛮神心脏*13","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[62],"传承结晶*1","现有:0活动(0)");
                    list.add(cd);
                    break;
                //监狱塔复刻
                case 7:
                    cd = new ChildData(url[58],"英雄之证*21","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[56],"凶骨*27","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[57],"龙之牙*4","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[71],"虚影之尘*12","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[68],"鬼魂提灯*6","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[61],"八连双晶*4","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[66],"无间齿轮*2","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[63],"人工生命体幼体*7","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[69],"混沌之爪*4","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[60],"蛮神心脏*7","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[62],"传承结晶*2","现有:0活动(0)");
                    list.add(cd);
                    break;
                //情人节复刻
                case 8:
                    cd = new ChildData(url[57],"龙之牙*30","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[66],"无间齿轮*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[2],"大骑士勋章*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[72],"龙之逆鳞*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[6],"黑兽脂*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"原初产毛*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"咒兽胆石*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[62],"传承结晶*2","现有:0活动(0)");
                    list.add(cd);
                    break;
                //本能寺复刻
                case 9:
                    cd = new ChildData(url[71],"虚影之尘*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"万死毒针*30","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[61],"八连双晶*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[70],"凤凰羽毛*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[66],"无间齿轮*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[65],"禁断书页*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[63],"人工生命体幼体*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[64],"陨蹄铁*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[69],"混沌之爪*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[60],"蛮神心脏*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[72],"龙之逆鳞*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[62],"传承结晶*2","现有:0活动(0)");
                    list.add(cd);
                    break;
                //明治维新
                case 10:
                    cd = new ChildData(url[58],"英雄之证*30","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[4],"愚者之锁*30","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"魔术髓液*30","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[68],"鬼魂提灯*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[2],"大骑士勋章*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[60],"蛮神心脏*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[5],"精灵根*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[7],"血之泪石*15","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[3],"封魔之灯*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"智慧之圣甲虫像*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"原初产毛*15","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"咒兽胆石*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[62],"传承结晶*2","现有:0活动(0)");
                    list.add(cd);
                    break;
                //CCC联动
                case 11:
                    cd = new ChildData(url[58],"英雄之证*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[56],"凶骨*30","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[57],"龙之牙*30","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[71],"虚影之尘*19","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"魔术髓液*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[59],"世界树之种*30","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[61],"八连双晶*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[70],"凤凰羽毛*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[65],"禁断书页*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[64],"陨蹄铁*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[2],"大骑士勋章*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[0],"追忆的贝壳*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[69],"混沌之爪*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[60],"蛮神心脏*13","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[72],"龙之逆鳞*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[5],"精灵根*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"战马打的幼角*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[6],"黑兽脂*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[3],"封魔之灯*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"智慧之圣甲虫像*9","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"原初产毛*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"咒兽胆石*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[62],"传承结晶*3","现有:0活动(0)");
                    list.add(cd);
                    break;
                //罗生门复刻
                case 12:
                    cd = new ChildData(url[56],"凶骨*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[57],"龙之牙*25","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[71],"虚影之尘*25","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[59],"世界树之种*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[68],"鬼魂提灯*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[61],"八连双晶*25","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[67],"蛇之宝玉*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[70],"凤凰羽毛*7","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[66],"无间齿轮*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[65],"禁断书页*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[63],"人工生命体幼体*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[64],"陨蹄铁*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[69],"混沌之爪*26","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[60],"蛮神心脏*17","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[72],"龙之逆鳞*25","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[5],"精灵根*12","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[8],"战马的幼角*2","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[7],"血之泪石*27","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[6],"黑兽脂*15","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"智慧之圣甲虫像*2","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"咒兽胆石*2","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[62],"传承结晶*5","现有:0活动(0)");
                    list.add(cd);
                    break;
                //鬼岛复刻
                case 13:
                    cd = new ChildData(url[56],"凶骨*39","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[57],"龙之牙*30","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[71],"虚影之尘*30","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"万死毒针*30","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[68],"鬼魂提灯*23","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[61],"八连双晶*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[67],"蛇之宝玉*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[70],"凤凰羽毛*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[66],"无间齿轮*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[65],"禁断书页*8","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[63],"人工生命体幼体*24","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[2],"大骑士勋章*2","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[69],"混沌之爪*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[60],"蛮神心脏*12","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[72],"龙之逆鳞*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[5],"精灵根*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[8],"战马的幼角*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[7],"血之泪石*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[6],"黑兽脂*2","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"原初产毛*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[62],"传承结晶*4","现有:0活动(0)");
                    list.add(cd);
                    break;
                //泳装2016复刻
                case 14:
                    cd = new ChildData(url[58],"英雄之证*30","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[56],"凶骨*30","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[57],"龙之牙*4","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[71],"虚影之尘*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[4],"愚者之锁*30","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[59],"世界树之种*37","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[68],"鬼魂提灯*21","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[61],"八连双晶*21","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[67],"蛇之宝玉*2","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[70],"凤凰羽毛*22","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[65],"禁断书页*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[64],"陨蹄铁*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[2],"大骑士勋章*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[0],"追忆的贝壳*65","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[69],"混沌之爪*30","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[60],"蛮神心脏*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[72],"龙之逆鳞*11","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[5],"精灵根*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[8],"战马的幼角*21","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[6],"黑兽脂*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[3],"封魔之灯*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"智慧之圣甲虫像*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"奇奇神酒*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[62],"传承结晶*4","现有:0活动(0)");
                    list.add(cd);
                    break;
                //泳装2017
                case 15:
                    cd = new ChildData(url[58],"英雄之证*30","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[56],"凶骨*40","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[71],"虚影之尘*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[4],"愚者之锁*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"万死毒针*30","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"魔术髓液*40","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[68],"鬼魂提灯*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[61],"八连双晶*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[67],"蛇之宝玉*25","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[70],"凤凰羽毛*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[66],"无间齿轮*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[65],"禁断书页*25","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[63],"人工生命体幼体*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[64],"陨蹄铁*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[2],"大骑士勋章*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[0],"追忆的贝壳*40","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[60],"蛮神心脏*9","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[72],"龙之逆鳞*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[5],"精灵根*8","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[8],"战马的幼角*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[7],"血之泪石*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[6],"黑兽脂*25","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[3],"封魔之灯*25","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"智慧之圣甲虫像*12","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"原初产毛*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"咒兽胆石*21","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"奇奇神酒*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[62],"传承结晶*2","现有:0活动(0)");
                    list.add(cd);
                    break;
                //万圣节2017复刻
                case 16:
                    cd = new ChildData(url[58],"英雄之证*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[57],"龙之牙*30","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[4],"愚者之锁*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[67],"蛇之宝玉*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[70],"凤凰羽毛*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[2],"大骑士勋章*3","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[60],"蛮神心脏*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[72],"龙之逆鳞*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[7],"血之泪石*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[6],"黑兽脂*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[3],"封魔之灯*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"智慧之圣甲虫像*10","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[62],"传承结晶*4","现有:0活动(0)");
                    list.add(cd);
                    break;
                //尼禄祭2017
                case 17:
                    cd = new ChildData(url[58],"虚影之尘*30","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[57],"世界树之种*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[4],"八连双晶*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[67],"凤凰羽毛*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[70],"无间齿轮*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[2],"人工生命体幼体*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[60],"陨蹄铁*20","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[72],"混沌之爪*25","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[7],"蛮神心脏*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[6],"龙之逆鳞*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[3],"精灵根*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[1],"战马的幼角*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[62],"血之泪石*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[58],"黑兽脂*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[57],"封魔之灯*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[4],"智慧之圣甲虫像*15","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[67],"原初产毛*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[70],"咒兽胆石*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[2],"奇奇神酒*5","现有:0活动(0)");
                    list.add(cd);
                    cd = new ChildData(url[60],"传承结晶*3","现有:0活动(0)");
                    list.add(cd);
                    break;


               }

            childList.add(list);
        }
    }
}









