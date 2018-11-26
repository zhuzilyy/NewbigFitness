package com.example.gufei.bigfitness.com.GuFei.NetWork;

import com.example.gufei.bigfitness.com.GuFei.Model.local.AddSumReportBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AddressBookBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppPreloadDicBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentByIdBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentByIdForMemberBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentListByDateBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentListByDateForOrderBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentListByMonthBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentListForMemberIdBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentresultBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CardInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CardListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CompleteLessonListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.ContactListForCustomerBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerAppointmentListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerIntroducerBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerSourceBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.HistoryPlanListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonListByMemberIdBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonListForDropBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonListForMemberBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonTeacherListForMemberBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LoginBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberAppointmentListAllBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberAppointmentListByMemberIDBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberBodyReportListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberNumReportBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberWardrobeInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MemberwardrobeListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MessageslistBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MonthAddSumReportBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MonthMemberLessonSumReportBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MonthMemberRankingBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MonthSalesReportByLabelIdBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MonthTeacherLessonRankingBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MonthTeacherRankingBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MultimediaBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MyInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PersonListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PublicSeaBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PublicSeaListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PublicSeaMemberBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PushUserMessageInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.ReportMonthComeSumBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.Schedule;
import com.example.gufei.bigfitness.com.GuFei.Model.local.SineForMainPageBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.StarEvaluateBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TeacherInfoBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainActionDropListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainPositionDropListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TrainingPlanBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.UserInfo;
import com.example.gufei.bigfitness.com.GuFei.Model.local.appMemberNumReportDetailListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.comeSumReportBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.reportForDayBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.reportForMonthBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.reportMemberCardSaleSumBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.reportMonthMemberCardSaleSumBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.tDailyMemberLessonSumReportBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import static com.example.gufei.bigfitness.Constants.BASEURL;

/**
 * Created by GuFei_lyf on 2017/3/21
 * 外部接口类
 */

public interface ApiBak {


    String baseUrl = BASEURL;

    /**登录*/
    @GET("appUser/appLogin")
    rx.Observable<LoginBean> login(
            @Query("Account") String mUserName,
            @Query("Pwd") String mPassWord,
            @Query("DeviceCode") String mDeviceCode

    );


    /**获取个人信息*/
    @GET("appMy/getMyInfo")
    rx.Observable<MyInfoBean> getMyInfo(
            @Query("UserId") int userid,
            @Query("token") String token
//
//            @Field("Account") String userName,
//            @Field("Pwd") String passWord,
//            @Field("DeviceCode") String deviceCode
    );


    /**获取通讯录*/
    @GET("appAddressBook/getAddressBookList")
    rx.Observable<AddressBookBean> getAddressBook(

            @Query("UserId") int userid,
            @Query("token") String token,
            @Query("SearchKey") String Searchkey,
            @Query("ClubId") int clubid

    );



    /**获取预加载*/
    @GET("appPreloaded/appPreloadDic")
    rx.Observable<AppPreloadDicBean> getappPreloadDic(

            @Query("UserId") int userid,
            @Query("token") String token,
            @Query("ClubId") int clubid,
            @Query("IsDepartManager") String IsDepartManager,
            @Query("DepartId") String DepartId

    );

    /**获取客户来源*/

    @GET("appPreloaded/getCustomerSource")
    rx.Observable<CustomerSourceBean> getCustomerSource(

            @Query("UserId") int userid,
            @Query("token") String token,
            @Query("ClubId") int clubid,
            @Query("Name") String Name

    );

    /**获取介绍人*/
    @GET("appPreloaded/getCustomerIntroducer")
    rx.Observable<CustomerIntroducerBean> getCustomerIntroducer(

            @Query("UserId") int userid,
            @Query("token") String token,
            @Query("ClubId") int clubid,
            @Query("Name") String Name

    );


    /**获取通知列表*/
    @GET("appPushUserMessage/getPushUserMessageList")
    rx.Observable<MessageslistBean> getPushUserMessageList(

            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("CurrentPage") int CurrentPage,
            @Query("MsgTypeId") String MsgTypeId


    );


    /**获取系统通知详情*/
    @GET("appPushUserMessage/getPushUserMessageInfo")
    rx.Observable<PushUserMessageInfoBean> getPushUserMessageInfo(
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("MessageId") int MessageId


    );


    /**系统消息批量设置已读*/
    @GET("appPushUserMessage/updateAllPushUserMessageReadType")
    rx.Observable<CodeBean> updateAllPushUserMessageReadType(

            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("MsgTypeId") String MsgTypeId
    );


    /**系统消息已读批量删除*/
    @GET("appPushUserMessage/delAllPushUserMessageRead")
    rx.Observable<CodeBean> delAllPushUserMessageRead(

            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("MsgTypeId") String MsgTypeId
    );



    /**获取主页通知列表*/
    @GET("appAppointment/appWaitappointList")
    rx.Observable<MainMsgBean> getMainList(

            @Query("UserId") int userid,
            @Query("token") String token,
            @Query("ClubId") int clubid

    );

    //
    /**客户电话*/
    @GET("appCustomer/customerCheckByTel")
    rx.Observable<CodeBean> getCustomerCheckByTel(
            @Query("UserId") int userid,
            @Query("token") String token,
            @Query("ClubId") int clubid,
            @Query("Tel") String Tel
    );


    /**添加客户信息*/
    @POST("appCustomer/insertCustomerInfo")
    @FormUrlEncoded
    rx.Observable<CodeBean> addCustomer(

            @Field("UserId") int UserId,
            @Field("token") String token,
            @Field("ClubId") int ClubId,
            @Field("UserName") String UserName,
            @Field("CustomerName") String CustomerName,
            @Field("IntentId") String IntentId,
            @Field("IntroduceMemberId") String IntroduceMemberId,
            @Field("LabelId") String LabelId,
            @Field("OwnManagerId") String OwnManagerId,
            @Field("Remark") String Remark,
            @Field("Sex") String Sex,
            @Field("SourceId") String SourceId,
            @Field("Tel") String Tel,
            @Field("presalemembercardtypeid") String Presalemembercardtypeid,
            @Field("presalemoney") String Presalemoney


    );


    /**修改客户信息*/
    @GET("appCustomer/insertCustomerInfo")
    rx.Observable<CodeBean> EditCustomer(
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("UserName") String UserName,
            @Query("CustomerName") String CustomerName,
            @Query("IntentId") String IntentId,
            @Query("IntroduceMemberId") String IntroduceMemberId,
            @Query("LabelId") String LabelId,
            @Query("OwnManagerId") String OwnManagerId,
            @Query("Remark") String Remark,
            @Query("Sex") String Sex,
            @Query("SourceId") String SourceId,
            @Query("Tel") String Tel,
            @Query("presalemembercardtypeid") String Presalemembercardtypeid,
            @Query("presalemoney") String Presalemoney,
            @Query("CustomerId") String CustomerId
    );


    /**修改密码*/
    @GET("appMy/updateUserPwd")
    rx.Observable<CodeBean> changePsw(

            @Query("UserId") int userid,
            @Query("token") String token,
            @Query("ClubId") int clubid,
            @Query("UserName") String UserName,
            @Query("OldPwd") String OldPwd,
            @Query("NewPwd") String NewPwd

    );



    /**获取客户列表*/
    @GET("appCustomer/getCustomerList")
    rx.Observable<CustomerListBean> getCustomerList(

            @Query("UserName") String UserName,
            @Query("UserId") int UserId,
            @Query("DepartId") int DepartId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("IsDepartManager") int IsDepartManager,
            @Query("CurrentPage") int CurrentPage,
            @Query("type") int type,
            @Query("SearchKey") String SearchKey,
            @Query("Sex") String Sex,
            @Query("IntentId") String IntentId,
            @Query("SourceId") String SourceId,
            @Query("StartCreateTime") String StartCreateTime,
            @Query("EndCreateTime") String EndCreateTime,
            @Query("CreateUserId") String CreateUserId,
            @Query("IntroduceMemberId") String IntroduceMemberId,
            @Query("LabelId") String LabelId,
            @Query("OwnManagerId") String OwnManagerId,
            @Query("StartLastContactTime") String StartLastContactTime,
            @Query("EndLastContactTime") String EndLastContactTime,
            @Query("sort") String sort,
            @Query("order") String order
    );



    /**获取过期会员列表*/
    @GET("appMember/getNoMemberList")
    rx.Observable<CustomerListBean> getNoMemberList(

            @Query("UserName") String UserName,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("IsDepartManager") int IsDepartManager,
            @Query("CurrentPage") int CurrentPage,
            @Query("type") int type,
            @Query("SearchKey") String SearchKey,
            @Query("Sex") String Sex,
            @Query("IntentId") String IntentId,
            @Query("SourceId") String SourceId,
            @Query("StartCreateTime") String StartCreateTime,
            @Query("EndCreateTime") String EndCreateTime,
            @Query("CreateUserId") String CreateUserId,
            @Query("IntroduceMemberId") String IntroduceMemberId,
            @Query("LabelId") String LabelId,
            @Query("OwnManagerId") String OwnManagerId,
            @Query("StartLastContactTime") String StartLastContactTime,
            @Query("EndLastContactTime") String EndLastContactTime,
            @Query("POSTeacherId") String POSTeacherId,
            @Query("OwnTeacherId") String OwnTeacherId,
            @Query("sort") String sort,
            @Query("order") String order

    );


    /**获取会员列表*/
    @GET("appMember/getMemberList")
    rx.Observable<CustomerListBean> getMemberList(

            @Query("UserName") String UserName,
            @Query("UserId") int UserId,
            @Query("DepartId") int DepartId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("IsDepartManager") int IsDepartManager,
            @Query("CurrentPage") int CurrentPage,
            @Query("type") int type,
            @Query("SearchKey") String SearchKey,
            @Query("MemberCardTypeId") String MemberCardTypeId,
            @Query("Sex") String Sex,
            @Query("IntentId") String IntentId,
            @Query("SourceId") String SourceId,
            @Query("StartCreateTime") String StartCreateTime,
            @Query("EndCreateTime") String EndCreateTime,
            @Query("CreateUserId") String CreateUserId,
            @Query("IntroduceMemberId") String IntroduceMemberId,
            @Query("LabelId") String LabelId,
            @Query("OwnManagerId") String OwnManagerId,
            @Query("OwnTeacherId") String OwnTeacherId,
            @Query("POSTeacherId") String POSTeacherId,
            @Query("StartExpireTime") String StartExpireTime,
            @Query("EndExpireTime") String EndExpireTime,
            @Query("StartLastContactTime") String StartLastContactTime,
            @Query("EndLastContactTime") String EndLastContactTime,
            @Query("personType") String personType,
            @Query("sort") String sort,
            @Query("order") String order

    );


    /**获取会员详情*/
    @GET("appMember/getMemberInfo")
    rx.Observable<MemberInfoBean> getMemberInfo(

            @Query("UserName") String UserName,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("MemberId") int MemberId


    );


    /**获取公海列表*/
    @GET("appPublicsea/appPublicSeaCustomerList")
//    @FormUrlEncoded
    rx.Observable<PublicSeaBean> appPublicSeaCustomerList(

//            @Query("UserName") String UserName  ,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("CurrentPage") int CurrentPage,
            @Query("StartDate") String StartDate,
            @Query("EndDate") String EndDate,
            @Query("PublicSeaId") String PublicSeaId,
            @Query("sort") String sort,
            @Query("order") String order
    );


    //获取公海列表搜索
    @POST("appPublicsea/appPublicSeaCustomerList")
    @FormUrlEncoded
    rx.Observable<PublicSeaBean> appPublicSeaCustomerList2(

//            @Query("UserName") String UserName  ,
            @Field("UserId") int UserId,
            @Field("token") String token,
            @Field("ClubId") int ClubId,
            @Field("CurrentPage") int CurrentPage,
            @Field("KeyWord") String word
    );


    /**获取公海会员列表*/
    @GET("appPublicsea/appPublicSeaMemberList")
//    @FormUrlEncoded
    rx.Observable<PublicSeaMemberBean> appPublicSeaMemberList(

//            @Query("UserName") String UserName  ,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("CurrentPage") int CurrentPage,
            @Query("StartAbandonTime") String StartDate,
            @Query("EndAbandonTime") String EndDate,
            @Query("PublicSeaId") String PublicSeaId,
            @Query("sort") String sort,
            @Query("order") String order
    );


    /**获取公海会员列表搜索*/
    @POST("appPublicsea/appPublicSeaMemberList")
    @FormUrlEncoded
    rx.Observable<PublicSeaMemberBean> appPublicSeaMemberList2(

//            @Query("UserName") String UserName  ,
            @Field("UserId") int UserId,
            @Field("token") String token,
            @Field("ClubId") int ClubId,
            @Field("CurrentPage") int CurrentPage,
            @Field("KeyWord") String word
    );

    //
    /**获取私教会员列表*/
    @GET("appMember/getLessonMemberList")
//    @FormUrlEncoded
    rx.Observable<CustomerListBean> getLessonMemberList(

            @Query("UserName") String UserName,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("IsDepartManager") int IsDepartManager,
            @Query("CurrentPage") int CurrentPage,
            @Query("type") int type,
            @Query("DepartId") int DepartId,
            @Query("SearchKey") String SearchKey,
            @Query("LessonType") String LessonType,
            @Query("Sex") String Sex,
            @Query("IntentId") String IntentId,
            @Query("SourceId") String SourceId,
            @Query("LessonName") String LessonName,
            @Query("LessonId") String LessonId,
            @Query("SaleTeacherId") String SaleTeacherId,
            @Query("LessonTeacherId") String LessonTeacherId,
            @Query("LabelId") String LabelId,
            @Query("OwnManagerId") String OwnManagerId,
            @Query("OwnTeacherId") String OwnTeacherId,
            @Query("POSTeacherId") String POSTeacherId,
            @Query("StartStopTime") String StartStopTime,
            @Query("EndStopTime") String EndStopTime,
            @Query("StartLastContactTime") String StartLastContactTime,
            @Query("EndLastContactTime") String EndLastContactTime,
            @Query("personType") String personType,
            @Query("sort") String sort,
            @Query("order") String order
    );

    //
    /**获取客户详情*/
    @GET("appCustomer/getCustomerInfoById")
    rx.Observable<CustomerInfoBean> getCustomerInfoById(

            @Query("UserName") String UserName,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("CustomerId") String CustomerId

    );


    /**客户公海捞取*/
    @GET("appPublicsea/appGainCustomer")
    rx.Observable<CodeBean> appGainCustomer(
            @Query("UserId") int UserId,
            @Query("UserName") String UserName,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("CustomerId") String CustomerId
    );

    //
    /**变更公海类别*/
    @GET("appPublicsea/appUpdateCustomerPublicSeaType")
    rx.Observable<CodeBean> appUpdateCustomerPublicSeaType(

            @Query("UserId") int UserId,
            @Query("UserName") String UserName,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("CustomerId") String CustomerId,
            @Query("NewPublicSeaId") String NewPublicSeaId
    );


    //
    /**获取 客户跟进记录*/
    @GET("appAppointment/getContactListForCustomer")
    rx.Observable<ContactListForCustomerBean> getContactListForCustomer(
            @Query("UserName") String UserName,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("CustomerId") String CustomerId,
            @Query("PersonType") String PersonType
    );

    //
    /**获取 客户预约记录*/
    @GET("appAppointment/getCustomerAppointmentListAll")
    rx.Observable<CustomerAppointmentListBean> getCustomerAppointmentListAll(

            @Query("UserName") String UserName,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("CustomerId") String CustomerId,
            @Query("PersonType") String PersonType
    );
//    //获取 预约详情
//    @GET("/appAppointment/getAppointmentById")
//    rx.Observable<AppointmentBean> getAppointmentById(
//
//            @Query("UserName") String UserName  ,
//            @Query("UserId") int UserId  ,
//            @Query("token") String token  ,
//            @Query("ClubId") int ClubId  ,
//            @Query("CustomerId") String CustomerId,
//            @Query ("AppointmentId") String AppointmentId
//
//    );


    //
    /**获取预约详情*/
    @GET("appAppointment/getAppointmentById")
    rx.Observable<AppointmentByIdBean> getAppointmentById(
            @Query("UserName") String UserName,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("AppointmentId") String AppointmentId,
            @Query("CustomerId") String CustomerId
    );


    //
    /**添加客户预约*/
    @GET("appAppointment/appAddCustomerAppoint")
    rx.Observable<CodeBean> appAddCustomerAppoint(

            @Query("UserName") String UserName,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("AppointmentTypeId") String AppointmentTypeId,
            @Query("Content") String Content,
            @Query("CustomerId") String CustomerId,
            @Query("EndTime") String EndTime,
            @Query("StartTime") String StartTime,
            @Query("Tipinterval") String Tipinterval,
            @Query("Tipstarttime") String Tipstarttime,
            @Query("AppointmentId") String AppointmentId
    );

    //
    /**添加跟进*/
    @POST("appAppointment/saveCustomerContact")
    @FormUrlEncoded
    rx.Observable<CodeBean> saveCustomerContact(

            @Field("UserName") String UserName,
            @Field("UserId") int UserId,
            @Field("token") String token,
            @Field("ClubId") int ClubId,
            @Field("AppointmentId") String AppointmentId,
            @Field("ContactContent") String ContactContent,
            @Field("CustomerId") String CustomerId,
            @Field("imgsrc") String imgsrc
    );


    //
    /**退出登录*/
    @GET("appUser/logoff")
    rx.Observable<CodeBean> outLogin(

            @Query("UserId") int userid,
            @Query("token") String token,
            @Query("ClubId") int clubid,
            @Query("UserName") String UserName
    );


    //
    /**获取教练评价*/
    @POST("appMy/getMyStarEvaluate")
    @FormUrlEncoded
    rx.Observable<StarEvaluateBean> getMyStarEvaluate(

            @Field(" UserId") int UserId,
            @Field("token") String token,
            @Field("CurrentPage") int CurrentPage,
            @Field("EvaluateStar") String EvaluateStar
    );


    //
    /**获取个人信息*/
    @GET("appMy/getUserInfo")
    rx.Observable<UserInfo> getUserInfo(

            @Query("UserId") int UserId,

            @Query("token") String token
    );


    //
    /**获取教练信息*/
    @GET("appMy/getTeacherInfo")
    rx.Observable<TeacherInfoBean> getTeacherInfo(

            @Query("UserId") int UserId,

            @Query("token") String token
    );


    //
    /**获取媒体列表*/
    @POST("appMy/getMyUserTeacherResList")
    @FormUrlEncoded
    rx.Observable<MultimediaBean> getMyUserTeacherResList(

            @Field("UserId") int UserId,

            @Field("token") String token
    );

    //
    /**客户抛入公海*/
    @GET("appPublicsea/appThrowCustomerPublicSea")
//    @FormUrlEncoded
    rx.Observable<CodeBean> appThrowCustomerPublicSea(

            @Query("UserId") int UserId,
            @Query("UserName") String UserName,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("CustomerId") String CustomerId,
            @Query("PublicSeaId") String PublicSeaId,
            @Query("InPublicSeaCause") String InPublicSeaCause
    );

    //
    /**会员抛入公海*/
    @GET("appPublicsea/appThrowMemberPublicSea")
//    @FormUrlEncoded
    rx.Observable<CodeBean> appThrowMemberPublicSea(

            @Query("UserId") int UserId,
            @Query("UserName") String UserName,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("MemberId") String MemberId,
            @Query("PublicSeaId") String PublicSeaId,
            @Query("InPublicSeaCause") String InPublicSeaCause
    );

    //
    /**公海客户详情*/
    @GET("appPublicsea/getCustomerInfoById")
//    @FormUrlEncoded
    rx.Observable<PublicSeaListBean> getPublicseaCustomerInfoById(


            @Query("UserName") String UserName,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("CustomerId") String CustomerId


    );

    //
    /**保存客户预约结果*/
    @GET("appAppointment/saveAppointmentResultForCustomer")
//    @FormUrlEncoded
    rx.Observable<CodeBean> saveAppointmentResultForCustomer(

            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("UserName") String UserName,
            @Query("AppointmentId") String AppointmentId,
            @Query("AppointmentResultId") String AppointmentResultId,
            @Query("appType") String appType

    );

    //
    /**获取预约结果数据*/
    @GET("appPreloaded/getAppointmentresult")
//    @FormUrlEncoded
    rx.Observable<AppointmentresultBean> getAppointmentresult(
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("AppointmentTypeId") String AppointmentTypeId

    );

    //
    /**客户更改会籍*/
    @GET("appPublicsea/appUpdateOwnManagerId")
//    @FormUrlEncoded
    rx.Observable<CodeBean> appUpdateOwnManagerId(

            @Query("UserId") int UserId,
            @Query("UserName") String UserName,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("CustomerId") String CustomerId,
            @Query("NewOwnmanagerId") String NewOwnmanagerId
    );

    //
    /**会员更改会籍*/
    @GET("appMember/updateMemberOwnManagerBatch")
//    @FormUrlEncoded
    rx.Observable<CodeBean> updateMemberOwnManagerBatch(

            @Query("UserId") int UserId,
            @Query("UserName") String UserName,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("MemberId") String MemberId,
            @Query("OwnManagerId") String OwnManagerId
    );


    //
    /**客户公海捞取*/
    @GET("appPublicsea/appGainCustomer")
//    @FormUrlEncoded
    rx.Observable<CodeBean> appGainCustomer(

            @Query("UserId") int UserId,
            @Query("UserName") String UserName,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("CustomerId") String CustomerId,
            @Query("PublicSeaId") String PublicSeaId,
            @Query("InPublicSeaCause") String InPublicSeaCause
    );

    //
    /**上传体测报告*/
    @POST("appMember/saveMemberBodyReport")
    @FormUrlEncoded
    rx.Observable<CodeBean> saveMemberBodyReport(

            @Field("UserName") String UserName,
            @Field("UserId") int UserId,
            @Field("token") String token,
            @Field("ClubId") int ClubId,
            @Field("MemberId") String MemberId,
            @Field("ImageData") String ImageData,
            @Field("ReportTime") String ReportTime

    );

    //
    /**上课记录*/
    @GET("appLesson/getCompleteLessonList")
    rx.Observable<CompleteLessonListBean> getCompleteLessonList(
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("MemberId") String MemberId,
            @Query("CurrentPage") int CurrentPage,
            @Query("LessonType") String LessonType,
            @Query("LessonName") String LessonName,
            @Query("TeacherId") String TeacherId,
            @Query("StartDate") String StartDate,
            @Query("EndDate") String EndDate

    );

    //
    /**上课详情*/
    @POST("appLesson/getLessonInfoFromApponitment")
    @FormUrlEncoded
    rx.Observable<LessonInfoBean> getLessonInfoFromApponitment(
            @Field("UserId") int UserId,
            @Field("token") String token,
            @Field("ClubId") int ClubId,
            @Field("MemberId") String MemberId,
            @Field("LessonType") String LessonType,
            @Field("AppointmentId") String AppointmentId
    );


    //
    /**课程列表*/
    @GET("appLesson/getLessonListByMemberId")
    rx.Observable<LessonListByMemberIdBean> getLessonListByMemberId(
            @Query("UserName") String UserName,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("MemberId") String MemberId,
            @Query("Status") String Status
    );


    /**训练计划测试*/
    @GET("TrainingPlan")
    rx.Observable<TrainingPlanBean> getTrainingPlanList();


    /**修改信息*/
    @POST("appMy/updateMyUserInfo")
    @FormUrlEncoded
    rx.Observable<CodeBean> updateUserInfo(
            @Field("UserId") String UserId,
            @Field("ClubId") String ClubId,
            @Field("token") String token,
            @Field("HeaderURL") String HeaderURL,
            @Field("UserName") String UserName,
            @Field("Sex") String Sex,
            @Field("Age") String Age,
            @Field("Tel") String Tel,
            @Field("Email") String Email,
            @Field("IdCard") String IdCard);

    //
    /**修改教练信息*/
    @POST("appMy/updateTeacherInfo")
    @FormUrlEncoded
    rx.Observable<CodeBean> updateTeacherInfo(
            @Field("UserId") int UserId,
            @Field("token") String token,
            @Field("ClubId") int ClubId,
            @Field("UserName") String UserName,
            @Field("Height") String Height,
            @Field("Weight") String Weight);


    //
    /**私教课程下拉*/
    @GET("appLesson/getLessonListForDrop")
    rx.Observable<LessonListForDropBean> getLessonListForDrop(
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("LessonType") String LessonType
    );

    //
    /** App查看会员私教课上课教练列表(全部)*/
    @GET("appLesson/getLessonTeacherListForMember")
    rx.Observable<LessonTeacherListForMemberBean> getLessonTeacherListForMember(
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("MemberId") String MemberId,
            @Query("Id") String Id
    );


    //
    /**体测列表*/
    @GET("appMember/getMemberBodyReportList")
    rx.Observable<MemberBodyReportListBean> getMemberBodyReportList(

            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("MemberId") String MemberId,
            @Query("sort") String Sort,
            @Query("order") String order
    );

    //
    /**衣柜列表*/
    @GET("appMember/getMemberwardrobeList")
    rx.Observable<MemberwardrobeListBean> getMemberwardrobeList(

            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("MemberId") String MemberId,
            @Query("Status") String Status
    );

    //
    /**衣柜详情*/
    @GET("appMember/getMemberWardrobeInfo")
    rx.Observable<MemberWardrobeInfoBean> getMemberWardrobeInfo(

            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("WardrobeId") int WardrobeId,
            @Query("MemberId") String MemberId
    );

    //
    /**私教课列表*/
    @GET("appLesson/getLessonListForMember")
    rx.Observable<LessonListForMemberBean> getLessonListForMember(
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("MemberId") String MemberId
    );


  //


    //
    /**私教会员列表/变更上课教练*/
    @GET("appMember/updateMemberLessonTeacher")
    rx.Observable<CodeBean> updateMemberLessonTeacher(
            @Query("UserId") int UserId,
            @Query("UserName") String UserName,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("Id") String Id,
            @Query("TeacherId") String TeacherId


    );

    /** 公海变更跟进教练*/
    @GET("appMember/updateMemberOwnTeacherBatch")
    rx.Observable<CodeBean> updateMemberOwnTeacherBatch(
            @Query("UserId") int UserId,
            @Query("UserName") String UserName,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("Id") String Id,
            @Query("TeacherId") String TeacherId


    );

    //
    /**添加修改预约*/
    @GET("appAppointment/saveMemberAppiontment")
    rx.Observable<CodeBean> saveMemberAppiontment(


            @Query("UserName") String UserName,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("appointType") String appointType,
            @Query("AppointmentTypeId") String AppointmentTypeId,
            @Query("Content") String Content,
            @Query("MemberId") String MemberId,
            @Query("EndTime") String EndTime,
            @Query("StartTime") String StartTime,
            @Query("Tipinterval") String Tipinterval,
            @Query("Tipstarttime") String Tipstarttime,
            @Query("LessonId") String LessonId,
            @Query("PlanInfo") String PlanInfo,
            @Query("AppointmentId") String AppointmentId


    );

    //
    /**根据会员id选择预约类型*/
    @GET("appAppointment/getAppointmentListForMemberId")
    rx.Observable<AppointmentListForMemberIdBean> getAppointmentListForMemberId(


            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("MemberId") String MemberId,
            @Query("personType") String personType


    );

    //    // 根据会员ID获取会员卡列表
//    @GET("appCard/getCardListByMemberId")
//    rx.Observable<CardListBean> getCardListByMemberId(
//            @Query("UserName") String UserName,
//            @Query("UserId") String UserId,
//            @Query("token") String token,
//            @Query("ClubId") String ClubId,
//            @Query("MemberId") String MemberId,
//            @Query("Status") String Status
//
//    );
    //
    /**根据会员ID获取会员卡列表*/
    @POST("appCard/getCardListByMemberId")
    @FormUrlEncoded
    rx.Observable<CardListBean> getCardListByMemberId(
            @Field("UserName") String UserName,
            @Field("UserId") String UserId,
            @Field("token") String token,
            @Field("ClubId") String ClubId,
            @Field("MemberId") String MemberId,
            @Field("Status") String Status

    );


    //
    /**根据会员卡ID获取会员卡详情*/
    @GET("appCard/getCardInfoByMemberCardId")
    rx.Observable<CardInfoBean> getCardInfoByMemberCardId(
            @Query("UserName") String UserName,
            @Query("UserId") String UserId,
            @Query("token") String token,
            @Query("ClubId") String ClubId,
            @Query("MemberCardId") String MemberCardId
    );

    //
    /**获取锻炼部位*/
    @GET("appMember/getTrainPositionDropList")
    rx.Observable<TrainPositionDropListBean> getTrainPositionDropList(

            @Query("UserName") String UserName,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId
    );

    //
    /**获取锻炼部位对应的动作*/
    @GET("appMember/getTrainActionDropList")
    rx.Observable<TrainActionDropListBean> getTrainActionDropList(

            @Query("UserName") String UserName,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("PositionId") String PositionId
    );


    //
    /**保存锻炼部位*/
    @GET("appMember/saveTrainPosition")
    rx.Observable<CodeBean> saveTrainPosition(

            @Query("UserName") String UserName,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("PositionName") String PositionName
    );


    //
    /**保存锻炼动作*/
    @GET("appMember/saveTrainAction")
    rx.Observable<CodeBean> saveTrainAction(


            @Query("UserName") String UserName,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("ActionName") String ActionName,
            @Query("PositionId") String PositionId
    );


    //
    /** 会员跟进信息列表（无翻页）*/
    @GET("appMember/getMemberAppointmentListByMemberID")
    rx.Observable<MemberAppointmentListByMemberIDBean> getMemberAppointmentListByMemberID(
            @Query("UserName") String UserName,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("IsDepartManager") String IsDepartManager,
            @Query("MemberId") String MemberId,
            @Query("PersonType") String PersonType


    );


    //
    /**查看会员预约列表（无翻页）*/
    @GET("appAppointment/getMemberAppointmentListAll")
    rx.Observable<MemberAppointmentListAllBean> getMemberAppointmentListAll(

            @Query("UserName") String UserName,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("MemberId") String MemberId,
            @Query("PersonType") String PersonType


    );

    //
    /**查看会员预约详情（普通）*/
    @GET("appAppointment/getAppointmentByIdForMember")
    rx.Observable<AppointmentByIdForMemberBean> getAppointmentByIdForMember(
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("AppointmentId") String AppointmentId,
            @Query("appType") String appType,
            @Query("MemberId") String MemberId


    );

    //
    /**获取训练计划历史记录*/
    @GET("appMember/getHistoryPlanList")
    rx.Observable<HistoryPlanListBean> getHistoryPlanList(

            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("MemberId") String MemberId,
            @Query("AppointmentId") String AppointmentId,
            @Query("LessonId") String LessonId,
            @Query("CurrentPage") int CurrentPage
    );

    //
    /**保存会员预约结果*/
    @GET("appAppointment/saveAppointmentResultForMember")
    rx.Observable<CodeBean> saveAppointmentResultForMember(
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("UserName") String UserName,
            @Query("AppointmentId") String AppointmentId,
            @Query("AppointmentResultId") String AppointmentResultId,
            @Query("appType") String appType

    );

    //
    /**保存会员跟进信息*/
    @POST("appMember/insertMemberAppointmentByMemberID")

    @FormUrlEncoded
    rx.Observable<CodeBean> insertMemberAppointmentByMemberID(

            @Field("UserName") String UserName,
            @Field("UserId") int UserId,
            @Field("token") String token,
            @Field("ClubId") int ClubId,
            @Field("AppointmentId") String AppointmentId,
            @Field("ContactContent") String ContactContent,
            @Field("MemberId") String MemberId,
            @Field("imgsrc") String imgsrc


    );

    //
    /**查看预约列表（上下翻页）*/
    @GET("appAppointment/getAppointmentListByDateForOrder")
    rx.Observable<AppointmentListByDateForOrderBean> getAppointmentListByDateForOrder(

            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("IsDepartManager") String IsDepartManager,
            @Query("date") String date,
            @Query("doType") String doType,
            @Query("CurrentPage") int CurrentPage


    );

    //
    /**根据月份查看本月日程标识*/
    @GET("appAppointment/getAppointmentListByMonth")
    rx.Observable<AppointmentListByMonthBean> getAppointmentListByMonth(


            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("IsDepartManager") String IsDepartManager,
            @Query("date") String date


    );

    //
    /**根据日期查看日程安排*/
    @GET("appAppointment/getAppointmentListByDate")
    rx.Observable<AppointmentListByDateBean> getAppointmentListByDate(


            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("IsDepartManager") String IsDepartManager,
            @Query("date") String date


    );

    //
    /**日程预约根据预约类型与身份选择预约人员*/
    @GET("appAppointment/getPersonList")
    rx.Observable<PersonListBean> getPersonList(


            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("appType") String appType,
            @Query("personType") String personType,
            @Query("NameOrTel") String NameOrTel,
            @Query("isMember") String IsMember


    );

    //
    /**日程预约根据预约类型为续费预约 选择预约人员*/
    @GET("appAppointment/getLessonMemberListForContactTeacher")
    rx.Observable<PersonListBean> getLessonMemberListForContactTeacher(


            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("appType") String appType,
            @Query("personType") String personType,
            @Query("NameOrTel") String NameOrTel


    );

    //
    /**查看日（周）预约情况*/
    @GET("appAppointment/getAppointmentListByDateForGroup")
    rx.Observable<Schedule> getSechedule(

            @Query("UserId") String UserId,
            @Query("token") String token,
            @Query("ClubId") String ClubId,
            @Query("IsDepartManager") String IsDepartManager,
            @Query("date") String date,
            @Query("dateType") String dateType

    );

    //
    /**App主页查看是否有未查看预约*/
    @GET("appPushUserMessage/getSineForMainPage")
    rx.Observable<SineForMainPageBean> getSineForMainPage(
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId
    );


//
    /**变更会员意向*/
    @GET("appMember/updateMemberIntentId")
    rx.Observable<CodeBean> updateMemberIntentId(

            @Query("UserId") int UserId,
            @Query("UserName") String UserName,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("MemberId") String MemberId,
            @Query("IntentId") String IntentId
    );



    /**更新会员信息*/
    @GET("appMember/updateMemberInfo")
    rx.Observable<CodeBean> updateMemberInfo(
            @Query("UserId") int UserId,
            @Query("UserName") String UserName,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("MemberId") String MemberId,
            @Query("Birthday") String Birthday,
            @Query("CarBrand") String CarBrand,
            @Query("CardNo") String CardNo,
            @Query("CardTypeId") String CardTypeId,
            @Query("Career") String Career,
            @Query("CarType") String CarType,
            @Query("Country") String Country,
            @Query("EmergencyPersonName") String EmergencyPersonName,
            @Query("EmergencyTel") String EmergencyTel,
            @Query("FitnessExperience") String FitnessExperience,
            @Query("FitnessRequest") String FitnessRequest,
            @Query("HomeAddress") String HomeAddress,
            @Query("HomeTel") String HomeTel,
            @Query("WorkCompany") String WorkCompany,
            @Query("WorkAddress") String WorkAddress,
            @Query("Nation") String Nation,
//            @Query("IsMarriaged") String IsMarriaged,
            @Query("InCome") String InCome,
//            @Query("InformationSource") String InformationSource,
            @Query("CarNo") String CarNo
//            @Query("Remark") String Remark


    );


    //
    /**日报表 汇总*/
    @GET("appReport/reportForDay")
    rx.Observable<reportForDayBean> reportForDay(
            @Query("IsDepartManager") String IsDepartManager,
            @Query("personType") String personType,
            @Query("ClubList") String ClubList,
            @Query("UserLevel") String UserLevel,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("SearchData") String SearchData,
            @Query("ReadUserId") String ReadUserId
    );

    //
    /**日报表*/
    @GET("appReport/reportMemberCardSaleSum")
    rx.Observable<reportMemberCardSaleSumBean> reportMemberCardSaleSum(
            @Query("IsDepartManager") String IsDepartManager,
            @Query("personType") String personType,
            @Query("ClubList") String ClubList,
            @Query("UserLevel") String UserLevel,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("SearchData") String SearchData
    );

    //
    /**日剩客报表*/
    @GET("appReport/getDailyMemberLessonSumReport")
    rx.Observable<tDailyMemberLessonSumReportBean> getDailyMemberLessonSumReport(
            @Query("IsDepartManager") String IsDepartManager,
            @Query("personType") String personType,
            @Query("ClubList") String ClubList,
            @Query("UserLevel") String UserLevel,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("SearchData") String SearchData
    );

    //
    /**日客流量统计*/
    @GET("appReport/comeSumReport")
    rx.Observable<comeSumReportBean> comeSumReport(
            @Query("IsDepartManager") String IsDepartManager,
            @Query("personType") String personType,
            @Query("ClubList") String ClubList,
            @Query("UserLevel") String UserLevel,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("SearchData") String SearchData
    );

    //
    /**日新增人员统计*/
    @GET("appReport/getAddSumReport")
    rx.Observable<AddSumReportBean> getAddSumReport(
            @Query("IsDepartManager") String IsDepartManager,
            @Query("personType") String personType,
            @Query("ClubList") String ClubList,
            @Query("UserLevel") String UserLevel,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("SearchData") String SearchData
    );

    //reportForMonth
    /**月报表*/
    @GET("appReport/reportForMonth")
    rx.Observable<reportForMonthBean> reportForMonth(
            @Query("IsDepartManager") String IsDepartManager,
            @Query("personType") String personType,
            @Query("ClubList") String ClubList,
            @Query("UserLevel") String UserLevel,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("SearchData") String SearchData,
            @Query("ReadUserId") String ReadUserId
    );

    //
    /**月销售报表*/
    @GET("appReport/reportMonthMemberCardSaleSum")
    rx.Observable<reportMonthMemberCardSaleSumBean> reportMonthMemberCardSaleSum(
            @Query("IsDepartManager") String IsDepartManager,
            @Query("personType") String personType,
            @Query("ClubList") String ClubList,
            @Query("UserLevel") String UserLevel,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("SearchData") String SearchData
    );

    //
    /**月销售来源统计*/
    @GET("appReport/getMonthSalesReportByLabelId")
    rx.Observable<MonthSalesReportByLabelIdBean> getMonthSalesReportByLabelId(
            @Query("IsDepartManager") String IsDepartManager,
            @Query("personType") String personType,
            @Query("ClubList") String ClubList,
            @Query("UserLevel") String UserLevel,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("SearchData") String SearchData
    );

    //
    /**私教会员消课月度统计（会籍不统计）*/
    @GET("appReport/getMonthMemberLessonSumReport")
    rx.Observable<MonthMemberLessonSumReportBean> getMonthMemberLessonSumReport(
            @Query("IsDepartManager") String IsDepartManager,
            @Query("personType") String personType,
            @Query("ClubList") String ClubList,
            @Query("UserLevel") String UserLevel,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("SearchData") String SearchData
    );

    //
    /**客流量月度统计*/
    @GET("appReport/getReportMonthComeSum")
    rx.Observable<ReportMonthComeSumBean> getReportMonthComeSum(
            @Query("IsDepartManager") String IsDepartManager,
            @Query("personType") String personType,
            @Query("ClubList") String ClubList,
            @Query("UserLevel") String UserLevel,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("SearchData") String SearchData
    );

    //
    /**月新增人员统计*/
    @GET("appReport/getMonthAddSumReport")
    rx.Observable<MonthAddSumReportBean> getMonthAddSumReport(
            @Query("IsDepartManager") String IsDepartManager,
            @Query("personType") String personType,
            @Query("ClubList") String ClubList,
            @Query("UserLevel") String UserLevel,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("SearchData") String SearchData
    );

    /**总数表
     *
     * 	TeacherId	教练id(可以为空)
     ManagerId	会籍id(可以为空)
     * */
    @GET("appReport/getMemberNumReport")
    rx.Observable<MemberNumReportBean> getMemberNumReport(
            @Query("IsDepartManager") String IsDepartManager,
            @Query("personType") String personType,
            @Query("ClubList") String ClubList,
            @Query("UserLevel") String UserLevel,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("TeacherId") String TeacherId,
            @Query("ManagerId") String ManagerId,
            @Query("SearchData") String SearchData
    );

    //
    /**会籍销售月排行*/
    @GET("appReport/getMonthMemberRanking")
    rx.Observable<MonthMemberRankingBean> getMonthMemberRanking(
            @Query("IsDepartManager") String IsDepartManager,
            @Query("personType") String personType,
            @Query("ClubList") String ClubList,
            @Query("UserLevel") String UserLevel,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("SearchData") String SearchData
    );

    //
    /**教练私教课销售月排行*/
    @GET("appReport/getMonthTeacherRanking")
    rx.Observable<MonthTeacherRankingBean> getMonthTeacherRanking(
            @Query("IsDepartManager") String IsDepartManager,
            @Query("personType") String personType,
            @Query("ClubList") String ClubList,
            @Query("UserLevel") String UserLevel,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("SearchData") String SearchData
    );

    //
    /**教练私教课月上课排行*/
    @GET("appReport/getMonthTeacherLessonRanking")
    rx.Observable<MonthTeacherLessonRankingBean> getMonthTeacherLessonRanking(
            @Query("IsDepartManager") String IsDepartManager,
            @Query("personType") String personType,
            @Query("ClubList") String ClubList,
            @Query("UserLevel") String UserLevel,
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("SearchData") String SearchData
    );


    //
    /**教练私教课月上课排行*/
    @GET("appReport/appMemberNumReportDetailList")
    rx.Observable<appMemberNumReportDetailListBean> appMemberNumReportDetailList(
            @Query("UserId") int UserId,
            @Query("token") String token,
            @Query("ClubId") int ClubId,
            @Query("IsDepartManager") int IsDepartManager,
            @Query("departId") int departId,
            @Query("ClubList") String ClubList,
            @Query("UserLevel") String UserLevel,
            @Query("CurrentPage") int CurrentPage,
            @Query("Type") int Type,
            @Query("sort") String sort,
            @Query("order") String order,
            @Query("TeacherId") String TeacherId,
            @Query("ManagerId") String ManagerId,
            @Query("Sex") String Sex,
            @Query("StartCardCreateTime") String StartCardCreateTime,
            @Query("EndCardCreateTime") String EndCardCreateTime,
            @Query("StartLastContactTime") String StartLastContactTime,
            @Query("EndLastContactTime") String EndLastContactTime,
            @Query("StartExpireTime") String StartExpireTime,
            @Query("EndExpireTime") String EndExpireTime,
            @Query("StartLessonCreateTime") String StartLessonCreateTime,
            @Query("EndLessonCreateTime") String EndLessonCreateTime,
            @Query("StartLessonStopTime") String StartLessonStopTime,
            @Query("EndLessonStopTime") String EndLessonStopTime,
            @Query("StartLessonBalance") String StartLessonBalance,
            @Query("EndLessonBalance") String EndLessonBalance

    );


}
