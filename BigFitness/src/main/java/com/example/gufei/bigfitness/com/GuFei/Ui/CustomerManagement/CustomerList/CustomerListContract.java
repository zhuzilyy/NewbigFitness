package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerList;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerListBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.TeacherInfoBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface CustomerListContract {

    interface View extends BaseView {

        void outLogin();

        void succeed(CustomerListBean customerListBean);

        void PublicSeasucceed(String Msg);

    }

    interface Presenter extends BasePresenter<View> {

        void getCustomerList(

                String UserName,
                int UserId,
                int DepartId,
                String token,
                int ClubId,
                int IsDepartManager,
                int CurrentPage,
                int type,
                String SearchKey,
                String Sex,
                String IntentId,
                String SourceId,
                String StartCreateTime,
                String EndCreateTime,
                String CreateUserId,
                String IntroduceMemberId,
                String LabelId,
                String OwnManagerId,
                String StartLastContactTime,
                String EndLastContactTime,
                String sort,
                String order);


        void getNoMemberList(

                String UserName,
                int UserId,
                int DepartId,
                String token,
                int ClubId,
                int IsDepartManager,
                int CurrentPage,
                int type,
                String SearchKey,
                String Sex,
                String IntentId,
                String SourceId,
                String StartCreateTime,
                String EndCreateTime,
                String CreateUserId,
                String IntroduceMemberId,
                String LabelId,
                String OwnManagerId,
                String StartLastContactTime,
                String EndLastContactTime,
                String POSTeacherId,
                String OwnTeacherId,
                String sort,
                String order);


        void getMemberList(

                String UserName,
                int UserId,
                int DepartId,
                String token,
                int ClubId,
                int IsDepartManager,
                int CurrentPage,
                int type,
                String SearchKey,
                String MemberCardTypeId,
                String Sex,
                String IntentId,
                String SourceId,
                String StartCreateTime,
                String EndCreateTime,
                String CreateUserId,
                String IntroduceMemberId,
                String LabelId,
                String OwnManagerId,
                String OwnTeacherId,
                String POSTeacherId,
                String StartExpireTime,
                String EndExpireTime,
                String StartLastContactTime,
                String EndLastContactTime,
                String personType,
                String sort,
                String order);

        void getLessonMemberList(

                String UserName  ,
                int UserId  ,
                String token  ,
                int ClubId  ,
                int IsDepartManager  ,
                int CurrentPage  ,
                int type  ,
                int DepartId  ,
                String SearchKey  ,
                String LessonType  ,
                String Sex  ,
                String IntentId  ,
                String SourceId  ,
                String LessonName  ,
                String LessonId  ,
                String SaleTeacherId  ,
                String LessonTeacherId  ,
                String LabelId  ,
                String OwnManagerId  ,
                String OwnTeacherId  ,
                String POSTeacherId  ,
                String StartStopTime  ,
                String EndStopTime  ,
                String StartLastContactTime  ,
                String EndLastContactTime  ,
                String personType  ,
                String sort  ,
                String order);

        void appThrowCustomerPublicSea(


                int UserId,
                String UserName,
                String token,
                int ClubId,
                String CustomerId,
                String PublicSeaId
                , String InPublicSeaCause);


        void appThrowMemberPublicSea(


                int UserId,
                String UserName,
                String token,
                int ClubId,
                String CustomerId,
                String PublicSeaId
                , String InPublicSeaCause);

        void appGainCustomer(


                int UserId,
                String UserName,
                String token,
                int ClubId,
                String CustomerId,
                String PublicSeaId
                , String InPublicSeaCause);

        void appUpdateOwnManagerId(

                int UserId,
                String UserName,
                String token,
                int ClubId,
                String CustomerId,
                String NewOwnmanagerId);



    void updateMemberOwnManagerBatch(

                int UserId,
                String UserName,
                String token,
                int ClubId,
                String MemberId,
                String OwnManagerId);

   void updateLessonMemberOwnTeacherBatch(

                int UserId,
                String UserName,
                String token,
                int ClubId,
                String Id,
                String TeacherId);

    void updateMemberOwnTeacherBatch(

            int UserId,
            String UserName,
            String token,
            int ClubId,
            String CustomerId,
            String TeacherId);
    }

}
