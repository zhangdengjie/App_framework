package com.zdj.app.common.holder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.zdj.app.R;
import com.zdj.app.vo.response.MainInfo;

/**
 * Created by dengjie on 2015/12/27.
 */
public class MainViewholder extends BaseViewHolder<MainInfo> {

    TextView name;
    TextView telephone;

    public MainViewholder(ViewGroup parent) {
        super(parent, R.layout.item_contact);
        name = $(R.id.tv_name);
        telephone = $(R.id.tv_telephone);
    }

    @Override
    public void setData(MainInfo data) {
        super.setData(data);
        name.setText(data.name);
        telephone.setText(data.telephone);
    }
}
