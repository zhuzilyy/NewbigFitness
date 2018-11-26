package com.example.gufei.bigfitness.com.GuFei.Ui.AddressList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.gufei.bigfitness.App;
import com.example.gufei.bigfitness.R;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.gufei.bigfitness.util.GlideImageLoader.displayCircleImage;
import static com.example.gufei.bigfitness.util.GlideImageLoader.displayImage;
/**
 * Created by Administrator on 2017/8/4.
 * 通讯录适配器
 */



public class PhoneAdapter extends BaseAdapter implements PinnedSectionListView.PinnedSectionListAdapter {

    private LayoutInflater layoutInflater;
    /**
     * 数据集
     */
    private ArrayList<PhoneBean> list;
    /**
     * 首字母
     */
    public HashMap<String, Integer> map_IsHead;

    public PhoneAdapter(Context context, ArrayList<PhoneBean> list, HashMap<String, Integer> map_IsHead) {
        this.list = list;
        this.map_IsHead = map_IsHead;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }
    

    /**
     * 实现自定义listview的接口
     *
     */

    @Override
    public boolean isItemViewTypePinned(int viewType) {
        return viewType == AddressListFragMent.TITLE;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        switch (getItemViewType(i)) {
            case AddressListFragMent.ITEM:
                if (view == null) {
                    viewHolder = new ViewHolder();
                    view = layoutInflater.inflate(R.layout.item_phone_item, null);
                    viewHolder.txt = (TextView) view.findViewById(R.id.item_phone_txt_name);
                    viewHolder.headerimg = (ImageView) view.findViewById(R.id.head_img);

                    viewHolder.mOfficeName = (TextView) view.findViewById(R.id.item_phone_txt_position);
                    view.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) view.getTag();
                }

                //设置名字
                viewHolder.txt.setText(list.get(i).getName());
//                viewHolder.mName.setText(list.get(i).getName());
                viewHolder.mOfficeName.setText(list.get(i).getOfficeName());
//                displayImage(App.context,list.get(i).getHeadimg(), viewHolder.headerimg);
                displayCircleImage(App.context,list.get(i).getHeadimg(),(ImageView) viewHolder.headerimg,R.mipmap.privatememberinfor_03);
                break;
            case AddressListFragMent.TITLE:
                if (view == null) {
                    viewHolder = new ViewHolder();
                    view = layoutInflater.inflate(R.layout.item_phone_title, null);
                    viewHolder.txt = (TextView) view.findViewById(R.id.item_phone_txt_head);

                    view.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) view.getTag();
                }
                //设置标题
                viewHolder.txt.setText(list.get(i).getHeadChar());
                break;
        }
        return view;
    }


    private class ViewHolder {
        private TextView txt;

        private TextView mOfficeName;

        private ImageView headerimg;
    }

}
