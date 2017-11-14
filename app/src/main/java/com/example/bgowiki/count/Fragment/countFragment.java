package com.example.bgowiki.count.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.example.bgowiki.R;
import com.example.bgowiki.adapter.BaseAdapterHelper;
import com.example.bgowiki.adapter.QuickAdapter;
import com.example.bgowiki.base.BaseFragment;
import com.example.bgowiki.bean.Material_calculate;
import com.example.bgowiki.codding.Fragment.bean.material;
import com.example.bgowiki.home.bean.Sevent;
import com.example.bgowiki.utils.MakeMapToList;
import com.example.bgowiki.utils.SealMap;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.Serializable;
import java.util.EventListener;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class countFragment extends BaseFragment {
    private TextView textView;
    private QuickAdapter<Material_calculate> materialQuickAdapter;
    private List<Material_calculate> TotalList;
    private ListView lv_show_count;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.count,container,false);
        lv_show_count = view.findViewById(R.id.lv_materia_show);
        initBundle();
     //   init();
        return view;
    }


    private void initBundle() {
        Bundle bundle = getActivity().getIntent().getExtras();
        if(bundle!=null){
            SealMap map = (SealMap) bundle.get("map");
            Map<String,Integer> Total = map.getMap();
            MakeMapToList makeMapToList = new MakeMapToList();
            TotalList = makeMapToList.MakeMapToList(Total);
            System.out. println(TotalList);
        }
    }

    @Override
    public View initView() {
        return textView;
    }

    @Override
    public void initDate() {
        super.initDate();

    }

    private void init() {
        materialQuickAdapter.addAll(TotalList);
        materialQuickAdapter = new QuickAdapter<Material_calculate>(getContext(),R.layout.erey_count) {
            @Override
            protected void convert(BaseAdapterHelper helper, Material_calculate item) {
                helper.setText(R.id.lv_material_name,item.getMaterial());
                helper.setText(R.id.lv_need_material, String.valueOf(item.getMaterial_count()));
            }
        };
        lv_show_count.setAdapter(materialQuickAdapter);
    }


}
