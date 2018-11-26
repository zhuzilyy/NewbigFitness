package com.example.gufei.bigfitness.com.GuFei.Ui.AddressList;


import android.text.TextUtils;

import java.util.ArrayList;
/**
 * Created by Administrator on 2017/8/4.
 * 通讯类的Bean
 */

public class PhoneBean {
    /**
     * 名字首字母
     */
    private String headChar;
    /**
     * 电话
     */
    private String tel;
    /**
     * 部门
     */
    private String officeName;
    /**
     * 名字
     */
    private String name;
    /**
     * 字母名字
     */
    private String name_en;

    /**
     * 头像图片
     */
    private String headimg;

    /**
     * 职位
     */
    private String position;
    /**
     * 职位
     */
    private String sex;

    /**
     * 是否是标题
     */
    private int type;

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHeadChar() {
        return headChar;
    }

    public String getName() {
        return name;
    }

    public String getName_en() {
        return name_en;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
        name_en = getPinYin(name);//获取字母名称
        name_en = name_en.toUpperCase();//把小写字母换成大写字母
        if (!TextUtils.isEmpty(name_en)) {
            char head = name_en.charAt(0);
            if (head < 'A' || head > 'Z') {
                head = '#';
            }
            headChar = head + "";
        }
    }

    /**
     * 汉字转换拼音，字母原样返回，都转换为小写
     */
    public String getPinYin(String input) {
        ArrayList<HanziToPinyin.Token> tokens = HanziToPinyin.getInstance().get(input);
        StringBuilder sb = new StringBuilder();
        if (tokens != null && tokens.size() > 0) {
            for (HanziToPinyin.Token token : tokens) {
                if (token.type == HanziToPinyin.Token.PINYIN) {
                    sb.append(token.target);
                } else {
                    sb.append(token.source);
                }
            }
        }
        return sb.toString().toLowerCase();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }
}
