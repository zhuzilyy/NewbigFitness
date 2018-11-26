package com.example.gufei.bigfitness.com.GuFei.Ui.Filter;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentListForMemberIdBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentresultBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerIntroducerBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerSourceBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonListForDropBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonListForMemberBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.MainMsgBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PersonListBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface FilterListActivityContract {

    interface View extends BaseView {    void outLogin();

        void   succeed(LessonListForDropBean lessonListForDropBean);
        void   succeedAppointmentresult(AppointmentresultBean appointmentresultBean);
        void   succeedAppointmentListForMemberIdBean(AppointmentListForMemberIdBean appointmentListForMemberIdBean);
        void   succeedPersonListBean(PersonListBean personListBean);
        void   succeedCustomerIntroducerBean(CustomerIntroducerBean customerIntroducerBean);
        void   succeedCustomerSource(CustomerSourceBean customerSourceBean);
        void   succeedLessonListForMember(LessonListForMemberBean lessonListForMemberBean);

    }

    interface Presenter extends BasePresenter<View> {

        void updata( int UserId  ,String token  ,int ClubId  ,String LessonType);
        void getAppointmentresult( int UserId  ,String token  ,int ClubId  ,String AppointmentTypeId);
        void  getAppointmentListForMemberId( int UserId  ,String token  ,int ClubId  ,String MemberId  ,String personType);
        void  getPersonList(
                int UserId  ,String token  ,int ClubId  ,String appType  ,String personType,String NameOrTel,String IsMember);
        void  getLessonMemberListForContactTeacher(
                int UserId  ,String token  ,int ClubId  ,String appType  ,String personType,String NameOrTel);
        //补课预约 选择人员
        void  getMakeUpMemberListForContactTeacher(
                int UserId  ,String token  ,int ClubId  ,String appType  ,String personType,String NameOrTel, String IsMakeUp);
        void  getCustomerIntroducer(int userid, String token, int clubid,String Name);
        void getCustomerSource(int userid, String token, int clubid,String Name);
        //私教课列表
        void getLessonListForMember( int UserId  ,String token  ,int ClubId  ,String MemberId  );
        //补课列表
        void getMakeUpMemberLessonList( int UserId  ,String token  ,int ClubId  ,String MemberId  );

    }
}
