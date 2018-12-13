package com.example.gufei.bigfitness;

import java.io.File;

/**
 * Created by GuFei_lyf on 2017/3/21
 *
 * 静态配置表
 *
 * 包括服务器地址,消息类型,返回消息类型,筛选下拉列表内容
 */

public interface Constants {

    long CACHE_SIZE = 10 * 1024 * 1024; // OkHttp 缓存大小 10M
    String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    long CONNECT_TIMEOUT = 10; // 连接超时时间设置
    String DATABASE_NAME = "myRealm.realm";//


//    String BASEURL = "http://192.168.51.101:8080/MaxFit/";//大勇
//    String BASEURL = "http://192.168.51.225:8444/MaxFit/";//self
//       String BASEURL = "http://192.168.51.189:8080/";//
//    String BASEURL = "http://flyfly4545.tunnel.qydev.com/MaxFit/";//self
//    String BASEURL = "http://abccd.tunnel.qydev.com/MaxFit/";//self
//    String BASEURL = "http://60.205.170.216/";//阿里
//    String BASEURL = "http://www.clfitsys.com/";//阿里域名
//    String BASEURL = "http://211.159.175.148/";//外网
//    String BASEURL = "http://123.207.246.64/";//外网/
//    String BASEURL = "http://www.clfitsys.com:8080/";//3天一换外网//
      //String BASEURL = "http://www.clfitsys.com:9081/"

    //String BASEURL = "http://www.18bai6.cn:9081/";//3天一换外网//
    String BASEURL = "http://www.clfitsys.com:9081/";
//    String IMAGURL= "http://www.18bai6.cn/";
    String IMAGURL= "https://www.clfitsys.com/";
    //String MEMBERURL = "http://www.18bai6.cn:8080/";//
    String MEMBERURL = "http://www.clfitsys.com:8080/";//下课网址下课网址
//    String BASEURL = "http://175.146.123.44:7777/";//3天一换外网/
//    String BASEURL="http://192.168.51.165:8080/MaxFit/";//张师傅
//String BASEURL = "http://192.168.51.189:7778/";//3天一换外网//
    int ACTIVITY_REQUEST_SELECT_PHOTO = 100;
    int ACTIVITY_REQUEST_TAKE_PICTURE = 101;
    int ACTIVITY_REQUEST_PREVIEW_PHOTO = 102;
    String RESULT_TYPE = "result_type";
    String RESULT_ID = "result_id";
    String RESULT_STRING = "result_string";
    String RESULT_TEL = "result_tel";
    String RESULT_APPID = "result_appid";
    String RESULT_SEX = "result_sex";
    String PUT_STR = "com.GuFei.pub_string";
    String ERRMESSAGES = "服务器请求失败";

    int ACTIVITY_ID_CUSTOMER = 400;  /**客户页面*/
    int ACTIVITY_ID_NON_CUSTOMER = 4002; /**过期会员页面*/
    int ACTIVITY_ID_MEMBERS = 4003;  /**会员页面*/
    int ACTIVITY_ID_PRIVATE_MEMBERS = 4004; /**私教会员页面*/
    int ACTIVITY_ID_REPORT = 4005;  /**体测记录*/
    int ACTIVITY_ID_REPORT_APPOINTMENT = 4006; /**预约记录*/
    int ACTIVITY_ID_CLASS_RECORD = 4007; /**课程记录*/
    int ACTIVITY_ID_RECORDS_GIVING = 4008;  /**赠送记录*/

    int RESULT_SUCCESS = 1;
    int RESULT_FAILED = 2;

    String ACCOUNTKEY = "account";/**用户名*/
    String PASSWRODKEY = "password";/**用户密码*/
    String DEVICECODEKEY = "deviceCode";/**设备号*/
    String USERIDKEY = "userid";/**用户ID*/
    String USERNAMEKEY = "username";/**用户名称*/
    String SEXKEY = "sex";/**用户性别*/
    String TOKENKEY = "token";/**设备号*/
    String CLUBIDKEY = "clubId";/**会所ID*/
    String PERSONTYPEKEY = "persontype";/**用户类别*/
    String USERLEVELKEY = "UserLevel";/**用户类别*/
    String CLUBLISTKEY = "clublist";/**用户类别*/
    String ISDERPARTMANAGERKEY = "isdepartmanager";/**经理标识*/
    String DEPARTIDKEY = "departId";/**部门id*/
    String LOGINKEY = "LoginId";/**登录标志*/
    String CLIENTID = "clientid";/**推送*/

    int CUSTOMERTAGID = 9001;/**客户标签ID*/
    int CUSTOMERINTENTID = 9002;/**客户意向ID*/
    int CARDTYPEID = 9003;/**证件类型ID*/
    int WARDROBETYPEID = 9004;/**衣柜类型ID*/
    int MEMBERINTENTID = 9005;/**会员意向ID*/
    int MANGERLISTID = 9006;/**会籍顾问ID*/
    int POSTEACHERLISTID = 9007;/**pos教练ID*/
    int CONTACTTEACHERLISTID = 9008;/**跟进教练ID*/
    int LESSONTEACHERLISTID = 9009;/**上课教练ID*/
    int SALETEACHERLISTID = 9010;/**签约教练ID*/
    int PUBLICSEATYPEID = 9011;/**公海类别ID*/
    int CREATEUSERLISTID = 9012;/**采集人ID*/
    int ALLMEMBERCARDTYPEID = 9013;/**    搜索条件 卡类型ID     会员卡类型*/
    int SALEMEMBERCARDTYPEID = 9014;/**   采集信息 卡类型ID  会员卡类型*/
    int CUSTOMERAPPOINTMENTTYPEID = 9015;/**    客户预约类别ID*/
    int MEMBERAPPOINTMENTTYPEBYID = 9016;/**  根据会员id预约类别ID*/
    int CUSTOMERSOURCEID = 9017;/**  会员来源ID*/
    int CUSTOMERINTRODUCERID = 9018;/**  介绍人类别*/
    int PERSONTYPEID = 9019;/** 登录身份*/
    int IDENTIFICATIONID = 9020;/**  标识类别*/
    int CLASSTYPEID = 9021;/**  课程类型*/
    int CLASSNAMEID = 9022;/** 课程名称*/
    int APPOINTMENTRESULTID = 9023;/** 预约详情结果*/
    int CUSTOMERTYPEID = 9024;/**客户类型*/
    int MEMBERAPPOINTMENTTYPEID = 9025;/**  会员预约类别ID*/
    int PERSONLISTID = 9026;/**身份选择预约人员*/
    int IDTYPEID = 9027;/**身份选择预约人员*/
    int LESSONMEMBERLISTID = 9028;/**续课预约选择预约人员*/
    int LESSONLISTBYMEMBERKEY = 9029;/**  根据会员id预约类别ID*/
    int LESSONTEACHERBYMEMBERKEY = 9030;/**  根据会员id预约类别ID*/
    int LESSONTBYMEMBERKEY = 9031;/**  根据会员id获取私教课*/
    int NOMEMBERID = 9032;/**  非会员ID*/
    int MAKEUPCLASSID = 9033;/**补课预约选择预约人员*/
    int MAKEUPCLASSKEY = 9034;/**  补课预约获取补课*/
    int REFRESHID = 9999;/**  返回刷新*/
    int TPREFRESHID = 9998;/**  修改健身返回刷新*/


    String CUSTOMERTAGKEY = "customertag";/**客户标签(ID,Name)  ,*/
    String CUSTOMERINTENTKEY = "customerintent";/**客户意向(ID,Name)  ,*/
    String CARDTYPEKEY = "cardtype";/**证件类型(ID,Name)  ,*/
    String WARDROBETYPEKEY = "wardrobetype";/**衣柜类型(ID,Name)  ,*/
    String MEMBERINTENTKEY = "memberintent";/**会员意向(ID,Name)  ,*/
    String MANGERLISTKEY = "mangerlist";/**会籍顾问(ID,Name)  ,*/
    String POSTEACHERLISTKEY = "posteacherlist";/**pos教练(ID,Name)  ,*/
    String CONTACTTEACHERLISTKEY = "contactteacherlist";/**跟进教练(ID,Name)  ,*/
    String LESSONTEACHERLISTKEY = "lessonteacherlist";/**上课教练(ID,Name)  ,*/
    String SALETEACHERLISTKEY = "saleteacherlist";/**签约教练(ID,Name),*/
    String PUBLICSEATYPEKEY = "publicseatype";/**公海类别(ID,Name),*/
    String CREATEUSERLISTKEY = "createuserlist ";/**采集人*/
    String ALLMEMBERCARDTYPEKEY = "allmembercardtype";/**    搜索条件 卡类型*/
    String SALEMEMBERCARDTYPEKEY = "salemembercardtype";/**   采集信息 卡类型*/
    String CUSTOMERAPPOINTMENTTYPEKEY = "customerappointmenttype";/**    客户预约类别*/
    String MEMBERAPPOINTMENTTYPEKEY = "memberappointmenttype";/**  会员预约类别*/
    String CUSTOMERSOURCEKEY = "customersourcekey";/**  会员来源类别*/
    String CUSTOMERINTRODUCERKEY = "customerintroducerkey";/**  介绍人类别*/
    String IDENTIFICATIONKEY = "identificationkey";/**  介绍人类别*/
    String APPOINTMENTRESULTKEY = "appointmentresultkey";/** 预约结果类别*/
    String TRAININGPLANKEY = "trainingplankey";/** 训练计划KEY*/
    /**    String MEMBERAPPOINTMENTTYPEKEY = "memberappointmenttypekey";/**  会员预约类别*/
    String CUSTOMERTYPEKEY = "customertypekey";/**客户类型*/
    String OWNERKEY = "";
    String STATUSKEY = "";

    int TIME_BEGIN_ID = 1301; /** 开始时间*/
    int TIME_END_ID = 1302; /** 结束时间*/
    int TIME_REMIND_ID = 1303; /**提醒时间*/
    int TIME_INTERVAL_ID = 1304; /**提醒时间*/

    int TYPE_CLERK = 0;/**职员ID*/
    int TYPE_MANAGER = 1;/**经理ID*/


    String[] CUSTOMER_ORDER_DATAS = {"最后跟进时间", "采集提交时间", "客户姓名排序"};

    String[] CHART_LIST_ORDER_DATAS = {"最后跟进时间", "办卡时间", "有效期(结束时间)","会员姓名排序"};
    String[] MERBERS_ORDER_DATAS = {"会员姓名排序", "采集提交时间", "最后跟进时间"};
    String[] PRIVATE_ORDER_DATAS = {"会员姓名排序", "课程购买时间", "最后跟进时间","课程到期时间"};
    String[] PUBLIC_SEA_ORDER_DATAS = {"抛入时间排序", "客户名称排序"};
    String[] DEPARTMENT_DATAS = {"我的", "部门"};
    String[] CERVIX_DATAS = {"操作时间", "生成时间"};
    String[] REPORT_DATAS = {"最后跟进时间", "有效期", "办卡时间", "会员姓名排序"};
    String[] TEACHER_REPORT_DATAS =  {"最后跟进时间", "课程购买时间", "课程到期时间", "会员姓名排序"};


    String[] CUSTOMER_ORDER_Interface_DATAS = {"LastContactTime", "CreateTime", "CustomerName"};
    String[] MERBERS_ORDER_Interface_DATAS = {"MemberName", "CreateTime","LastContactTime", "ExpireTime"};

    String[] CHART_LIST_ORDER_DATAS_Interface_DATAS = {"LastContactTime", "CreateTime", "LastContactTime","MemberName"};
    String[] PRIVATE_Interface_DATAS = {"MemberName", "CreateTime", "LastContactTime"};
    String[] PUBLIC_SEA_ORDER_Interface_DATAS = {"InPublicSeaTime", "CustomerName"};
    String[] PUBLIC_SEA_MEMBERS_ORDER_Interface_DATAS = {"AbandonTime", "MemberName"};
    String[] CERVIX_Interface_DATAS = {"ReportTime", "CreateTime"};
    String[] REPORT_Interface_DATAS = {"LastContactTime", "mls.CreateTime", "ExpireTime","MemberName"};
    String[] TEACHER_Interface_DATAS =  {"LastContactTime", "mls.CreateTime", "ExpireTime", "MemberName"};



    //  public final String[] CUSTOMER_ORDER_DATAS= { "最后跟进时间", "采集提交时间","客户姓名排序"};
    //  public final String[] CUSTOMER_ORDER_DATAS= { "最后跟进时间", "采集提交时间","客户姓名排序"};
    //  public final String[] CUSTOMER_ORDER_DATAS= { "最后跟进时间", "采集提交时间","客户姓名排序"};
    //  public final String[] CUSTOMER_ORDER_DATAS= { "最后跟进时间", "采集提交时间","客户姓名排序"};
    //  public final String[] CUSTOMER_ORDER_Interface_DATAS= { "LastContactTime", "CreateTime","CustomerName"};
    //  public final String[] CUSTOMER_ORDER_Interface_DATAS= { "LastContactTime", "CreateTime","CustomerName"};
    //  public final String[] CUSTOMER_ORDER_Interface_DATAS= { "LastContactTime", "CreateTime","CustomerName"};
    //  public final String[] CUSTOMER_ORDER_Interface_DATAS= { "LastContactTime", "CreateTime","CustomerName"};
    //  public final String[] CUSTOMER_ORDER_Interface_DATAS= { "LastContactTime", "CreateTime","CustomerName"};


    //  String CUSTOMER_ORDER="最后跟进时间, 采集提交时间,客户姓名排序";
    //
    //
    //  String CUSTOMER_ORDER_Interface= "LastContactTime,CreateTime,CustomerName";

    //
    //app下载地址
    String APP_DOWNLOAD_URL = "https://www.clfitsys.com/BigFitness-Coach.apk";
    //新版本app的检查地址
    String UPDATE_CHECK_URL = "http://www.clfitsys.com:8080/appVersion/getNewestVersion";

}
