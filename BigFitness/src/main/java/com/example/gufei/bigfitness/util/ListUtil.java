package com.example.gufei.bigfitness.util;

import android.content.Context;
import android.util.Log;

import com.example.gufei.bigfitness.com.GuFei.Model.Post.PostCustomerListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.FilterBean;
import com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.Index.IndexFragMent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by GuFei_lyf on 2017/5/2
 * 为会所,人员选择列表筛选过滤类
 * <p>
 * 在转换为Bean的同时 过滤掉不显示人员
 */

public class ListUtil {

    public static boolean useSet(Integer[] arr, Integer targetValue) {
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(arr));
        return set.contains(targetValue);
    }


    /**
     * list转换  Array to list
     * * @param arr array;
     *
     * @return list
     */
    public static ArrayList Arr2List(String[] arr) {

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            list.add(arr[i]);


        }
        return list;
    }


    /**
     * 筛选Bean转换  str to list  (带过滤)
     * * @param Str 预加载的数据字符串;
     *
     * @return list  List<bean>
     */
    public static List<FilterBean.FilterListBean> String2Bean(String Str) {


        List<FilterBean.FilterListBean> temp = (List<FilterBean.FilterListBean>) new Gson().fromJson(Str, new TypeToken<List<FilterBean.FilterListBean>>() {
        }.getType());
        List<FilterBean.FilterListBean> list = new ArrayList<FilterBean.FilterListBean>();


        if (!(temp.get(0).getIsShow() == null)) {
            //预处理 不显示人员
            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i).getIsShow().toString().equals("T")) {
                    list.add(temp.get(i));
                }
            }
        } else {

            list.addAll(temp);

        }
        return list;
    }

    /**
     * 筛选Bean转换  str to list  (全部显示)
     * * @param Str 预加载的数据字符串;
     *
     * @return list  List<bean>
     */
    public static List<FilterBean.FilterListBean> AllString2Bean(String Str) {


        List<FilterBean.FilterListBean> list = (List<FilterBean.FilterListBean>) new Gson().fromJson(Str, new TypeToken<List<FilterBean.FilterListBean>>() {
        }.getType());
/*        for (int i = 0; i < list.size(); i++) {
                if (!list.get(i).getIsShow().equals("T"))
                    list.remove(i);
            }*/
        return list;
    }


    /**
     * 筛选Bean转换  str to list  (全部显示)
     * * @param Str 预加载的数据字符串;
     *
     * @return list  List<bean>
     */
    public static List<FilterBean.FilterListBean> FAllString2Bean(String Str) {
        List<FilterBean.FilterListBean> Rlist = new ArrayList<FilterBean.FilterListBean>();
        FilterBean.FilterListBean FirstBean = new FilterBean.FilterListBean();
//        FirstBean.setID(999999);
//        FirstBean.setName("请选择");
//        Rlist.add(FirstBean);


        List<FilterBean.FilterListBean> list = (List<FilterBean.FilterListBean>) new Gson().fromJson(Str, new TypeToken<List<FilterBean.FilterListBean>>() {
        }.getType());
        for (int i = 0; i < list.size(); i++) {
            Rlist.add(list.get(i));
        }
        return Rlist;
    }


    /**
     * 筛选Bean转换  str to list  (带过滤)
     * * @param Str 预加载的数据字符串;
     *
     * @return list  List<bean>
     */
    public static List<FilterBean.FilterListBean> FString2Bean(String Str) {

        List<FilterBean.FilterListBean> Rlist = new ArrayList<FilterBean.FilterListBean>();
        FilterBean.FilterListBean FirstBean = new FilterBean.FilterListBean();
//        FirstBean.setID(999999);
//        FirstBean.setName("请选择");
//        Rlist.add(FirstBean);

        List<FilterBean.FilterListBean> temp = (List<FilterBean.FilterListBean>) new Gson().fromJson(Str, new TypeToken<List<FilterBean.FilterListBean>>() {
        }.getType());
        List<FilterBean.FilterListBean> list = new ArrayList<FilterBean.FilterListBean>();
        if (!(temp.get(0).getIsShow() == null)) {
            //预处理 不显示人员
            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i).getIsShow().toString().equals("T")) {
                    list.add(temp.get(i));
                }
            }
        } else {

            list.addAll(temp);

        }
        for (int i = 0; i < list.size(); i++) {
            Rlist.add(list.get(i));
        }
        return Rlist;
    }

    /**
     * json转换  obj to json  (带过滤)
     * * @param obj 预加载的数据字符串;
     *
     * @return list  List<bean>
     */
    public static String toJson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }


    /**
     * id集合 拼接为,连接字符串方法
     * * @param obj  list  ID集合;
     *
     * @return String  1,2,3,4;
     */


    public static String toidstring(List<String> obj) {

        String returnStr = "";

        List<String> tmp = new ArrayList<String>();

        for (int i = 0; i < obj.size(); i++) {
            String s = "";
            if (!obj.get(i).toString().equals("0")) {
                tmp.add(obj.get(i));
            }
        }
        for (int i = 0; i < tmp.size(); i++) {
            String s = ",";
            if (i == tmp.size() - 1) {
                s = "";
            }
            returnStr += tmp.get(i) + s;


        }


        return returnStr;
    }

    public static Map<String, String> check(Context mContext) {
        PostCustomerListBean postCustomerListBean=new PostCustomerListBean();

        Map<String, String> parameters = new HashMap<String, String>();

        if (null != parameters) {
        Class c = PostCustomerListBean.class;
        Method[] methods = c.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];

            String value = "";
            if (method.getName().startsWith("set")) {
                try {
                    method.invoke(postCustomerListBean,"");

                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            if (method.getName().equalsIgnoreCase("String")) {
                try {
                    try {
                        value = (String) method.invoke(postCustomerListBean);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            // 添加参数
            // 将方法名称转化为id，去除get，将方法首字母改为小写
            String param = method.getName().replaceFirst("get",
                    "");
            if (param.length() > 0) {
                String first = String.valueOf(param.charAt(0));

                param = first + param.substring(1);
            }
            parameters.put(param, value);


        }
        }

        return parameters;
    }

    /**
     *
     *
     * Map转换层Bean，使用泛型免去了类型转换的麻烦。
     * @param map
     * @return
     */
    public static PostCustomerListBean  map2Bean(Map<String, String> map) {
        PostCustomerListBean bean = null;
        Gson gson = new  Gson();
        bean =new PostCustomerListBean();
        String jsonStr = gson.toJson(map);
        bean = gson.fromJson(jsonStr, PostCustomerListBean.class);
        return bean;
    }
}