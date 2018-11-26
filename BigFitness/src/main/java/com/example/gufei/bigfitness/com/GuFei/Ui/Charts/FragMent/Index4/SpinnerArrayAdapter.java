package com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index4;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;

/**
 * 项目名称：NewbigFitness
 * 类描述：
 * 创建人：apple
 * 创建时间：2017/12/22 下午2:34
 * 修改人：apple
 * 修改时间：2017/12/22 下午2:34
 * 修改备注：
 */
public class SpinnerArrayAdapter extends ArrayAdapter<String> {
    private Context mContext;
    private String [] mStringArray;
    public SpinnerArrayAdapter(Context context, String[] stringArray) {
        super(context, android.R.layout.simple_spinner_item, stringArray);
        mContext = context;
        mStringArray=stringArray;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        //修改Spinner展开后的字体颜色
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(android.R.layout.simple_spinner_dropdown_item, parent,false);
        }

        //此处text1是Spinner默认的用来显示文字的TextView
        TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
        tv.setText(mStringArray[position]);
        tv.setTextSize(12f);
          tv.setTextColor(mContext.getResources().getColor(R.color.gray));

        return convertView;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 修改Spinner选择后结果的字体颜色
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(android.R.layout.simple_spinner_item, parent, false);
        }

        //此处text1是Spinner默认的用来显示文字的TextView
        TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
        tv.setText(mStringArray[position]);
        tv.setTextSize(12f);
        tv.setTextColor(mContext.getResources().getColor(R.color.gray));
        return convertView;
    }




}
