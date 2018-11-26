package com.example.gufei.bigfitness.com.GuFei.Ui.Members.TeacherFilter;

import com.example.gufei.bigfitness.base.BasePresenter;
import com.example.gufei.bigfitness.base.BaseView;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentListForMemberIdBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentresultBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CodeBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerIntroducerBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerSourceBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonListByMemberIdBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonListForDropBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.LessonTeacherListForMemberBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.PersonListBean;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public interface TeacherFilterListActivityContract {

    interface View extends BaseView {    void outLogin();


        void   succeedLessonListByMember(LessonListByMemberIdBean lessonListByMemberIdBean);
        void   succeedLessonTeacherListForMember(LessonTeacherListForMemberBean lessonTeacherListForMemberBean);
        void succeedEdit(CodeBean codeBean);


    }

    interface Presenter extends BasePresenter<View> {


        void getLessonListByMemberId(String UserName,int UserId, String token, int ClubId, String MemberId, String Status);
        void getLessonTeacherListForMember(int UserId, String token, int ClubId, String MemberId,String Id);
        void updateMemberLessonTeacher(

                int UserId,
                String UserName,
                String token,
                int ClubId,
                String CustomerId,
                String TeacherId);

    }
}
