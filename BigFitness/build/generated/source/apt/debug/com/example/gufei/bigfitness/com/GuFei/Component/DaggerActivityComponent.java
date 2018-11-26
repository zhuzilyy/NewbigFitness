package com.example.gufei.bigfitness.com.GuFei.Component;

import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.com.GuFei.Ui.AddressList.AddressDetails.AddressDetailsActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.AddressList.AddressDetails.AddressDetailsActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.AddressList.AddressDetails.AddressDetailsActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.AddressList.AddressDetails.AddressDetailsActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.ChartsMainActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.ChartsMainActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.ChartsMainActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.ChartsMainActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.List.ChartsListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.List.ChartsListActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.List.ChartsListActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.List.ChartsListActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddAppointment.AddAppointmentActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddAppointment.AddAppointmentActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddAppointment.AddAppointmentActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddAppointment.AddAppointmentActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddCustomer.CustomerInfo.CustomerAddCollectionActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddCustomer.CustomerInfo.CustomerAddCollectionActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddCustomer.CustomerInfo.CustomerAddCollectionActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddCustomer.CustomerInfo.CustomerAddCollectionActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddFollow.AddFollowActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddFollow.AddFollowActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddFollow.AddFollowActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddFollow.AddFollowActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AppointmentRecord.AppointmentRecordActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AppointmentRecord.AppointmentRecordActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AppointmentRecord.AppointmentRecordActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AppointmentRecord.AppointmentRecordActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerInfo.CustomerInfoCollectionActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerInfo.CustomerInfoCollectionActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerInfo.CustomerInfoCollectionPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerInfo.CustomerInfoCollectionPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerInfoAdd.CustomerInfoAddCollectionActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerInfoAdd.CustomerInfoAddCollectionActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerInfoAdd.CustomerInfoAddCollectionPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerInfoAdd.CustomerInfoAddCollectionPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerList.CustomerListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerList.CustomerListActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerList.CustomerListPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerList.CustomerListPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.EditCustomer.CustomerEditCollectionActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.EditCustomer.CustomerEditCollectionActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.EditCustomer.CustomerEditCollectionActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.EditCustomer.CustomerEditCollectionActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.LessonInfoDetails.GroupLesson.GroupLesssonActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.LessonInfoDetails.GroupLesson.GroupLesssonActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.LessonInfoDetails.GroupLesson.GroupLesssonActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.LessonInfoDetails.GroupLesson.GroupLesssonActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.LessonInfoDetails.PrivateLessson.PrivateLesssonActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.LessonInfoDetails.PrivateLessson.PrivateLesssonActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.LessonInfoDetails.PrivateLessson.PrivateLesssonActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.LessonInfoDetails.PrivateLessson.PrivateLesssonActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.Record.FollowUpRecordActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.Record.FollowUpRecordActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.Record.FollowUpRecordActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.Record.FollowUpRecordActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.ReservationRecord.ReservationRecordActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.ReservationRecord.ReservationRecordActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.ReservationRecord.ReservationRecordActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.ReservationRecord.ReservationRecordActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.SiteSelection.SiteSelectionActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.SiteSelection.SiteSelectionActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.SiteSelection.SiteSelectionActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.SiteSelection.SiteSelectionActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.Add.TrainingPlanAddActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.Add.TrainingPlanAddActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.Add.TrainingPlanAddActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.Add.TrainingPlanAddActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.List.TrainingPlanListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.List.TrainingPlanListActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.List.TrainingPlanListActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.List.TrainingPlanListActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Filter.FilterListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Filter.FilterListActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Filter.FilterListActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Filter.FilterListActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.GeneralComponent.Query.QueryActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.GeneralComponent.Query.QueryActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.GeneralComponent.Query.QueryActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.GeneralComponent.Query.QueryActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddAppointment.AddMebersAppointmentActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddAppointment.AddMebersAppointmentActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddAppointment.AddMebersAppointmentActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddAppointment.AddMebersAppointmentActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddFollow.AddMembersFollowActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddFollow.AddMembersFollowActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddFollow.AddMembersFollowActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddFollow.AddMembersFollowActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddReport.AddReportActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddReport.AddReportActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddReport.AddReportActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AddReport.AddReportActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AppointmentDetails.AppointmentDetailsActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AppointmentDetails.AppointmentDetailsActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AppointmentDetails.AppointmentDetailsActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AppointmentDetails.AppointmentDetailsActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AppointmentRecord.MembersAppointmentRecordActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AppointmentRecord.MembersAppointmentRecordActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AppointmentRecord.MembersAppointmentRecordActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.AppointmentRecord.MembersAppointmentRecordActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.Course.Details.CourseDetailsActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.Course.Details.CourseDetailsActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.Course.Details.CourseDetailsActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.Course.Details.CourseDetailsActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.Course.List.CourseListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.Course.List.CourseListActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.Course.List.CourseListActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.Course.List.CourseListActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.CourseAppointmentAdd.CourseAppointmentAddActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.CourseAppointmentAdd.CourseAppointmentAddActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.CourseAppointmentAdd.CourseAppointmentAddActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.CourseAppointmentAdd.CourseAppointmentAddActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.EditAppointment.EditMebersAppointmentActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.EditAppointment.EditMebersAppointmentActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.EditAppointment.EditMebersAppointmentActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.EditAppointment.EditMebersAppointmentActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonInfo.LessonInfoActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonInfo.LessonInfoActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonInfo.LessonInfoActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonInfo.LessonInfoActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonList.LessonListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonList.LessonListActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonList.LessonListActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonList.LessonListActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonReportDocuments.LessonReportDocumentsListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonReportDocuments.LessonReportDocumentsListActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonReportDocuments.LessonReportDocumentsListActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.LessonReportDocuments.LessonReportDocumentsListActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.MedicalReportDocuments.MedicalReportDocumentsListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.MedicalReportDocuments.MedicalReportDocumentsListActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.MedicalReportDocuments.MedicalReportDocumentsListActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.MedicalReportDocuments.MedicalReportDocumentsListActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.MembersInfo.MembersInfoActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.MembersInfo.MembersInfoActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.MembersInfo.MembersInfoActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.MembersInfo.MembersInfoActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.MembersInfoDetails.MembersInfoDetailsActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.MembersInfoDetails.MembersInfoDetailsActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.MembersInfoDetails.MembersInfoDetailsActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.MembersInfoDetails.MembersInfoDetailsActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.Private.LessonInfo.LessonInfoPrivateActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.Private.LessonInfo.LessonInfoPrivateActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.Private.LessonInfo.LessonInfoPrivateActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.Private.LessonInfo.LessonInfoPrivateActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.Record.MembersFollowUpRecordActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.Record.MembersFollowUpRecordActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.Record.MembersFollowUpRecordActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.Record.MembersFollowUpRecordActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.ReservationRecord.ReservationRecordMembersActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.ReservationRecord.ReservationRecordMembersActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.ReservationRecord.ReservationRecordMembersActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.ReservationRecord.ReservationRecordMembersActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.TeacherFilter.TeacherFilterListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.TeacherFilter.TeacherFilterListActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.TeacherFilter.TeacherFilterListActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.TeacherFilter.TeacherFilterListActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardinfo.CardInfoActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardinfo.CardInfoActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardinfo.CardInfoPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardinfo.CardInfoPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardinfo.TimeCard.TimeCardInfoActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardinfo.TimeCard.TimeCardInfoActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardinfo.TimeCard.TimeCardInfoActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardinfo.TimeCard.TimeCardInfoActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardlist.CardListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardlist.CardListActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardlist.CardListPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.cardlist.CardListPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.Details.PublicSeaInfoActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.Details.PublicSeaInfoActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.Details.PublicSeaInfoActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.Details.PublicSeaInfoActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.List.PublicSeaListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.List.PublicSeaListActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.List.PublicSeaListPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.List.PublicSeaListPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.searchlist.PublicSeaSearchListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.searchlist.PublicSeaSearchListActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.searchlist.PublicSeaSearchListPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.PublicSea.searchlist.PublicSeaSearchListPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Scan.ScanActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Scan.ScanActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Scan.ScanActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Scan.ScanActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.AddAppointment.AddAppointmentScheduleActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.AddAppointment.AddAppointmentScheduleActivityActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.AddAppointment.AddAppointmentScheduleActivityActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.AddAppointment.AddAppointmentScheduleActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.ReservationRecord.ReservationRecordScheduleActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.ReservationRecord.ReservationRecordScheduleActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.ReservationRecord.ReservationRecordScheduleActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.ReservationRecord.ReservationRecordScheduleActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.ScheduleActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.ScheduleActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.ScheduleActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.ScheduleActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.ScheduleAddAppointment.ScheduleAddAppointmentActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.ScheduleAddAppointment.ScheduleAddAppointmentActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.ScheduleAddAppointment.ScheduleAddAppointmentActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.ScheduleAddAppointment.ScheduleAddAppointmentActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Messages.MessagesListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Messages.MessagesListActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Messages.MessagesListActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Messages.MessagesListActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.appraise.AppraiseActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.appraise.AppraiseActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.appraise.AppraiseActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.appraise.AppraiseActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.coach.CoachInfoActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.coach.CoachInfoActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.coach.CoachInfoActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.coach.CoachInfoActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.img_video_list.ImgVideoListActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.img_video_list.ImgVideoListActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.img_video_list.ImgVideoListActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.img_video_list.ImgVideoListActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.personainfo.PersonalInfoActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.personainfo.PersonalInfoActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.personainfo.PersonalInfoActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.personainfo.PersonalInfoActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.seting.SetingActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.seting.SetingActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.seting.SetingActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.seting.SetingActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.welcome.WelcomeActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.welcome.WelcomeActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.welcome.WelcomeActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.welcome.WelcomeActivity_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.main.MainActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.main.MainActivityPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.main.MainActivityPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.main.MainActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerActivityComponent implements ActivityComponent {
  private Provider<Api> getApiProvider;

  private Provider<MainActivityPresenter> mainActivityPresenterProvider;

  private MembersInjector<MainActivity> mainActivityMembersInjector;

  private Provider<LoginActivityPresenter> loginActivityPresenterProvider;

  private MembersInjector<LoginActivity> loginActivityMembersInjector;

  private Provider<MessagesListActivityPresenter> messagesListActivityPresenterProvider;

  private MembersInjector<MessagesListActivity> messagesListActivityMembersInjector;

  private Provider<ImgVideoListActivityPresenter> imgVideoListActivityPresenterProvider;

  private MembersInjector<ImgVideoListActivity> imgVideoListActivityMembersInjector;

  private Provider<CustomerInfoCollectionPresenter> customerInfoCollectionPresenterProvider;

  private MembersInjector<CustomerInfoCollectionActivity>
      customerInfoCollectionActivityMembersInjector;

  private Provider<CustomerListPresenter> customerListPresenterProvider;

  private MembersInjector<CustomerListActivity> customerListActivityMembersInjector;

  private Provider<QueryActivityPresenter> queryActivityPresenterProvider;

  private MembersInjector<QueryActivity> queryActivityMembersInjector;

  private Provider<AppraiseActivityPresenter> appraiseActivityPresenterProvider;

  private MembersInjector<AppraiseActivity> appraiseActivityMembersInjector;

  private Provider<FollowUpRecordActivityPresenter> followUpRecordActivityPresenterProvider;

  private MembersInjector<FollowUpRecordActivity> followUpRecordActivityMembersInjector;

  private Provider<AddAppointmentActivityPresenter> addAppointmentActivityPresenterProvider;

  private MembersInjector<AddAppointmentActivity> addAppointmentActivityMembersInjector;

  private Provider<AddFollowActivityPresenter> addFollowActivityPresenterProvider;

  private MembersInjector<AddFollowActivity> addFollowActivityMembersInjector;

  private Provider<TrainingPlanListActivityPresenter> trainingPlanListActivityPresenterProvider;

  private MembersInjector<TrainingPlanListActivity> trainingPlanListActivityMembersInjector;

  private Provider<TrainingPlanAddActivityPresenter> trainingPlanAddActivityPresenterProvider;

  private MembersInjector<TrainingPlanAddActivity> trainingPlanAddActivityMembersInjector;

  private Provider<CourseAppointmentAddActivityPresenter>
      courseAppointmentAddActivityPresenterProvider;

  private MembersInjector<CourseAppointmentAddActivity> courseAppointmentAddActivityMembersInjector;

  private Provider<SiteSelectionActivityPresenter> siteSelectionActivityPresenterProvider;

  private MembersInjector<SiteSelectionActivity> siteSelectionActivityMembersInjector;

  private Provider<AppointmentDetailsActivityPresenter> appointmentDetailsActivityPresenterProvider;

  private MembersInjector<AppointmentDetailsActivity> appointmentDetailsActivityMembersInjector;

  private Provider<CourseListActivityPresenter> courseListActivityPresenterProvider;

  private MembersInjector<CourseListActivity> courseListActivityMembersInjector;

  private Provider<MedicalReportDocumentsListActivityPresenter>
      medicalReportDocumentsListActivityPresenterProvider;

  private MembersInjector<MedicalReportDocumentsListActivity>
      medicalReportDocumentsListActivityMembersInjector;

  private Provider<AddressDetailsActivityPresenter> addressDetailsActivityPresenterProvider;

  private MembersInjector<AddressDetailsActivity> addressDetailsActivityMembersInjector;

  private Provider<SetingActivityPresenter> setingActivityPresenterProvider;

  private MembersInjector<SetingActivity> setingActivityMembersInjector;

  private Provider<PersonalInfoActivityPresenter> personalInfoActivityPresenterProvider;

  private MembersInjector<PersonalInfoActivity> personalInfoActivityMembersInjector;

  private Provider<CoachInfoActivityPresenter> coachInfoActivityPresenterProvider;

  private MembersInjector<CoachInfoActivity> coachInfoActivityMembersInjector;

  private Provider<FilterListActivityPresenter> filterListActivityPresenterProvider;

  private MembersInjector<FilterListActivity> filterListActivityMembersInjector;

  private Provider<CustomerInfoAddCollectionPresenter> customerInfoAddCollectionPresenterProvider;

  private MembersInjector<CustomerInfoAddCollectionActivity>
      customerInfoAddCollectionActivityMembersInjector;

  private Provider<ReservationRecordActivityPresenter> reservationRecordActivityPresenterProvider;

  private MembersInjector<ReservationRecordActivity> reservationRecordActivityMembersInjector;

  private Provider<AppointmentRecordActivityPresenter> appointmentRecordActivityPresenterProvider;

  private MembersInjector<AppointmentRecordActivity> appointmentRecordActivityMembersInjector;

  private Provider<PublicSeaListPresenter> publicSeaListPresenterProvider;

  private MembersInjector<PublicSeaListActivity> publicSeaListActivityMembersInjector;

  private Provider<PublicSeaInfoActivityPresenter> publicSeaInfoActivityPresenterProvider;

  private MembersInjector<PublicSeaInfoActivity> publicSeaInfoActivityMembersInjector;

  private Provider<PublicSeaSearchListPresenter> publicSeaSearchListPresenterProvider;

  private MembersInjector<PublicSeaSearchListActivity> publicSeaSearchListActivityMembersInjector;

  private Provider<MembersFollowUpRecordActivityPresenter>
      membersFollowUpRecordActivityPresenterProvider;

  private MembersInjector<MembersFollowUpRecordActivity>
      membersFollowUpRecordActivityMembersInjector;

  private Provider<CustomerAddCollectionActivityPresenter>
      customerAddCollectionActivityPresenterProvider;

  private MembersInjector<CustomerAddCollectionActivity>
      customerAddCollectionActivityMembersInjector;

  private Provider<AddReportActivityPresenter> addReportActivityPresenterProvider;

  private MembersInjector<AddReportActivity> addReportActivityMembersInjector;

  private Provider<LessonReportDocumentsListActivityPresenter>
      lessonReportDocumentsListActivityPresenterProvider;

  private MembersInjector<LessonReportDocumentsListActivity>
      lessonReportDocumentsListActivityMembersInjector;

  private Provider<LessonInfoActivityPresenter> lessonInfoActivityPresenterProvider;

  private MembersInjector<LessonInfoActivity> lessonInfoActivityMembersInjector;

  private Provider<MembersInfoActivityPresenter> membersInfoActivityPresenterProvider;

  private MembersInjector<MembersInfoActivity> membersInfoActivityMembersInjector;

  private Provider<CourseDetailsActivityPresenter> courseDetailsActivityPresenterProvider;

  private MembersInjector<CourseDetailsActivity> courseDetailsActivityMembersInjector;

  private Provider<LessonInfoPrivateActivityPresenter> lessonInfoPrivateActivityPresenterProvider;

  private MembersInjector<LessonInfoPrivateActivity> lessonInfoPrivateActivityMembersInjector;

  private Provider<MembersInfoDetailsActivityPresenter> membersInfoDetailsActivityPresenterProvider;

  private MembersInjector<MembersInfoDetailsActivity> membersInfoDetailsActivityMembersInjector;

  private Provider<CustomerEditCollectionActivityPresenter>
      customerEditCollectionActivityPresenterProvider;

  private MembersInjector<CustomerEditCollectionActivity>
      customerEditCollectionActivityMembersInjector;

  private Provider<AddMebersAppointmentActivityPresenter>
      addMebersAppointmentActivityPresenterProvider;

  private MembersInjector<AddMebersAppointmentActivity> addMebersAppointmentActivityMembersInjector;

  private Provider<CardListPresenter> cardListPresenterProvider;

  private MembersInjector<CardListActivity> cardListActivityMembersInjector;

  private Provider<CardInfoPresenter> cardInfoPresenterProvider;

  private MembersInjector<CardInfoActivity> cardInfoActivityMembersInjector;

  private Provider<TimeCardInfoActivityPresenter> timeCardInfoActivityPresenterProvider;

  private MembersInjector<TimeCardInfoActivity> timeCardInfoActivityMembersInjector;

  private Provider<ReservationRecordMembersActivityPresenter>
      reservationRecordMembersActivityPresenterProvider;

  private MembersInjector<ReservationRecordMembersActivity>
      reservationRecordMembersActivityMembersInjector;

  private Provider<ScheduleActivityPresenter> scheduleActivityPresenterProvider;

  private MembersInjector<ScheduleActivity> scheduleActivityMembersInjector;

  private Provider<MembersAppointmentRecordActivityPresenter>
      membersAppointmentRecordActivityPresenterProvider;

  private MembersInjector<MembersAppointmentRecordActivity>
      membersAppointmentRecordActivityMembersInjector;

  private Provider<EditMebersAppointmentActivityPresenter>
      editMebersAppointmentActivityPresenterProvider;

  private MembersInjector<EditMebersAppointmentActivity>
      editMebersAppointmentActivityMembersInjector;

  private Provider<AddMembersFollowActivityPresenter> addMembersFollowActivityPresenterProvider;

  private MembersInjector<AddMembersFollowActivity> addMembersFollowActivityMembersInjector;

  private Provider<LessonListActivityPresenter> lessonListActivityPresenterProvider;

  private MembersInjector<LessonListActivity> lessonListActivityMembersInjector;

  private Provider<ScheduleAddAppointmentActivityPresenter>
      scheduleAddAppointmentActivityPresenterProvider;

  private MembersInjector<ScheduleAddAppointmentActivity>
      scheduleAddAppointmentActivityMembersInjector;

  private Provider<ScanActivityPresenter> scanActivityPresenterProvider;

  private MembersInjector<ScanActivity> scanActivityMembersInjector;

  private Provider<ReservationRecordScheduleActivityPresenter>
      reservationRecordScheduleActivityPresenterProvider;

  private MembersInjector<ReservationRecordScheduleActivity>
      reservationRecordScheduleActivityMembersInjector;

  private Provider<AddAppointmentScheduleActivityActivityPresenter>
      addAppointmentScheduleActivityActivityPresenterProvider;

  private MembersInjector<AddAppointmentScheduleActivity>
      addAppointmentScheduleActivityMembersInjector;

  private Provider<TeacherFilterListActivityPresenter> teacherFilterListActivityPresenterProvider;

  private MembersInjector<TeacherFilterListActivity> teacherFilterListActivityMembersInjector;

  private Provider<WelcomeActivityPresenter> welcomeActivityPresenterProvider;

  private MembersInjector<WelcomeActivity> welcomeActivityMembersInjector;

  private Provider<ChartsMainActivityPresenter> chartsMainActivityPresenterProvider;

  private MembersInjector<ChartsMainActivity> chartsMainActivityMembersInjector;

  private Provider<ChartsListActivityPresenter> chartsListActivityPresenterProvider;

  private MembersInjector<ChartsListActivity> chartsListActivityMembersInjector;

  private Provider<PrivateLesssonActivityPresenter> privateLesssonActivityPresenterProvider;

  private MembersInjector<PrivateLesssonActivity> privateLesssonActivityMembersInjector;

  private Provider<GroupLesssonActivityPresenter> groupLesssonActivityPresenterProvider;

  private MembersInjector<GroupLesssonActivity> groupLesssonActivityMembersInjector;

  private DaggerActivityComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
    initialize2(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.getApiProvider =
        new Factory<Api>() {
          private final AppComponent appComponent = builder.appComponent;

          @Override
          public Api get() {
            return Preconditions.checkNotNull(
                appComponent.getApi(), "Cannot return null from a non-@Nullable component method");
          }
        };

    this.mainActivityPresenterProvider =
        MainActivityPresenter_Factory.create(
            MembersInjectors.<MainActivityPresenter>noOp(), getApiProvider);

    this.mainActivityMembersInjector =
        MainActivity_MembersInjector.create(mainActivityPresenterProvider);

    this.loginActivityPresenterProvider =
        LoginActivityPresenter_Factory.create(
            MembersInjectors.<LoginActivityPresenter>noOp(), getApiProvider);

    this.loginActivityMembersInjector =
        LoginActivity_MembersInjector.create(loginActivityPresenterProvider);

    this.messagesListActivityPresenterProvider =
        MessagesListActivityPresenter_Factory.create(
            MembersInjectors.<MessagesListActivityPresenter>noOp(), getApiProvider);

    this.messagesListActivityMembersInjector =
        MessagesListActivity_MembersInjector.create(messagesListActivityPresenterProvider);

    this.imgVideoListActivityPresenterProvider =
        ImgVideoListActivityPresenter_Factory.create(
            MembersInjectors.<ImgVideoListActivityPresenter>noOp(), getApiProvider);

    this.imgVideoListActivityMembersInjector =
        ImgVideoListActivity_MembersInjector.create(imgVideoListActivityPresenterProvider);

    this.customerInfoCollectionPresenterProvider =
        CustomerInfoCollectionPresenter_Factory.create(
            MembersInjectors.<CustomerInfoCollectionPresenter>noOp(), getApiProvider);

    this.customerInfoCollectionActivityMembersInjector =
        CustomerInfoCollectionActivity_MembersInjector.create(
            customerInfoCollectionPresenterProvider);

    this.customerListPresenterProvider =
        CustomerListPresenter_Factory.create(
            MembersInjectors.<CustomerListPresenter>noOp(), getApiProvider);

    this.customerListActivityMembersInjector =
        CustomerListActivity_MembersInjector.create(customerListPresenterProvider);

    this.queryActivityPresenterProvider =
        QueryActivityPresenter_Factory.create(
            MembersInjectors.<QueryActivityPresenter>noOp(), getApiProvider);

    this.queryActivityMembersInjector =
        QueryActivity_MembersInjector.create(queryActivityPresenterProvider);

    this.appraiseActivityPresenterProvider =
        AppraiseActivityPresenter_Factory.create(
            MembersInjectors.<AppraiseActivityPresenter>noOp(), getApiProvider);

    this.appraiseActivityMembersInjector =
        AppraiseActivity_MembersInjector.create(appraiseActivityPresenterProvider);

    this.followUpRecordActivityPresenterProvider =
        FollowUpRecordActivityPresenter_Factory.create(
            MembersInjectors.<FollowUpRecordActivityPresenter>noOp(), getApiProvider);

    this.followUpRecordActivityMembersInjector =
        FollowUpRecordActivity_MembersInjector.create(followUpRecordActivityPresenterProvider);

    this.addAppointmentActivityPresenterProvider =
        AddAppointmentActivityPresenter_Factory.create(
            MembersInjectors.<AddAppointmentActivityPresenter>noOp(), getApiProvider);

    this.addAppointmentActivityMembersInjector =
        AddAppointmentActivity_MembersInjector.create(addAppointmentActivityPresenterProvider);

    this.addFollowActivityPresenterProvider =
        AddFollowActivityPresenter_Factory.create(
            MembersInjectors.<AddFollowActivityPresenter>noOp(), getApiProvider);

    this.addFollowActivityMembersInjector =
        AddFollowActivity_MembersInjector.create(addFollowActivityPresenterProvider);

    this.trainingPlanListActivityPresenterProvider =
        TrainingPlanListActivityPresenter_Factory.create(
            MembersInjectors.<TrainingPlanListActivityPresenter>noOp(), getApiProvider);

    this.trainingPlanListActivityMembersInjector =
        TrainingPlanListActivity_MembersInjector.create(trainingPlanListActivityPresenterProvider);

    this.trainingPlanAddActivityPresenterProvider =
        TrainingPlanAddActivityPresenter_Factory.create(
            MembersInjectors.<TrainingPlanAddActivityPresenter>noOp(), getApiProvider);

    this.trainingPlanAddActivityMembersInjector =
        TrainingPlanAddActivity_MembersInjector.create(trainingPlanAddActivityPresenterProvider);

    this.courseAppointmentAddActivityPresenterProvider =
        CourseAppointmentAddActivityPresenter_Factory.create(
            MembersInjectors.<CourseAppointmentAddActivityPresenter>noOp(), getApiProvider);

    this.courseAppointmentAddActivityMembersInjector =
        CourseAppointmentAddActivity_MembersInjector.create(
            courseAppointmentAddActivityPresenterProvider);

    this.siteSelectionActivityPresenterProvider =
        SiteSelectionActivityPresenter_Factory.create(
            MembersInjectors.<SiteSelectionActivityPresenter>noOp(), getApiProvider);

    this.siteSelectionActivityMembersInjector =
        SiteSelectionActivity_MembersInjector.create(siteSelectionActivityPresenterProvider);

    this.appointmentDetailsActivityPresenterProvider =
        AppointmentDetailsActivityPresenter_Factory.create(
            MembersInjectors.<AppointmentDetailsActivityPresenter>noOp(), getApiProvider);

    this.appointmentDetailsActivityMembersInjector =
        AppointmentDetailsActivity_MembersInjector.create(
            appointmentDetailsActivityPresenterProvider);

    this.courseListActivityPresenterProvider =
        CourseListActivityPresenter_Factory.create(
            MembersInjectors.<CourseListActivityPresenter>noOp(), getApiProvider);

    this.courseListActivityMembersInjector =
        CourseListActivity_MembersInjector.create(courseListActivityPresenterProvider);

    this.medicalReportDocumentsListActivityPresenterProvider =
        MedicalReportDocumentsListActivityPresenter_Factory.create(
            MembersInjectors.<MedicalReportDocumentsListActivityPresenter>noOp(), getApiProvider);

    this.medicalReportDocumentsListActivityMembersInjector =
        MedicalReportDocumentsListActivity_MembersInjector.create(
            medicalReportDocumentsListActivityPresenterProvider);

    this.addressDetailsActivityPresenterProvider =
        AddressDetailsActivityPresenter_Factory.create(
            MembersInjectors.<AddressDetailsActivityPresenter>noOp(), getApiProvider);

    this.addressDetailsActivityMembersInjector =
        AddressDetailsActivity_MembersInjector.create(addressDetailsActivityPresenterProvider);

    this.setingActivityPresenterProvider =
        SetingActivityPresenter_Factory.create(
            MembersInjectors.<SetingActivityPresenter>noOp(), getApiProvider);

    this.setingActivityMembersInjector =
        SetingActivity_MembersInjector.create(setingActivityPresenterProvider);

    this.personalInfoActivityPresenterProvider =
        PersonalInfoActivityPresenter_Factory.create(
            MembersInjectors.<PersonalInfoActivityPresenter>noOp(), getApiProvider);

    this.personalInfoActivityMembersInjector =
        PersonalInfoActivity_MembersInjector.create(personalInfoActivityPresenterProvider);

    this.coachInfoActivityPresenterProvider =
        CoachInfoActivityPresenter_Factory.create(
            MembersInjectors.<CoachInfoActivityPresenter>noOp(), getApiProvider);

    this.coachInfoActivityMembersInjector =
        CoachInfoActivity_MembersInjector.create(coachInfoActivityPresenterProvider);

    this.filterListActivityPresenterProvider =
        FilterListActivityPresenter_Factory.create(
            MembersInjectors.<FilterListActivityPresenter>noOp(), getApiProvider);

    this.filterListActivityMembersInjector =
        FilterListActivity_MembersInjector.create(filterListActivityPresenterProvider);

    this.customerInfoAddCollectionPresenterProvider =
        CustomerInfoAddCollectionPresenter_Factory.create(
            MembersInjectors.<CustomerInfoAddCollectionPresenter>noOp(), getApiProvider);

    this.customerInfoAddCollectionActivityMembersInjector =
        CustomerInfoAddCollectionActivity_MembersInjector.create(
            customerInfoAddCollectionPresenterProvider);

    this.reservationRecordActivityPresenterProvider =
        ReservationRecordActivityPresenter_Factory.create(
            MembersInjectors.<ReservationRecordActivityPresenter>noOp(), getApiProvider);

    this.reservationRecordActivityMembersInjector =
        ReservationRecordActivity_MembersInjector.create(
            reservationRecordActivityPresenterProvider);

    this.appointmentRecordActivityPresenterProvider =
        AppointmentRecordActivityPresenter_Factory.create(
            MembersInjectors.<AppointmentRecordActivityPresenter>noOp(), getApiProvider);

    this.appointmentRecordActivityMembersInjector =
        AppointmentRecordActivity_MembersInjector.create(
            appointmentRecordActivityPresenterProvider);

    this.publicSeaListPresenterProvider =
        PublicSeaListPresenter_Factory.create(
            MembersInjectors.<PublicSeaListPresenter>noOp(), getApiProvider);

    this.publicSeaListActivityMembersInjector =
        PublicSeaListActivity_MembersInjector.create(publicSeaListPresenterProvider);

    this.publicSeaInfoActivityPresenterProvider =
        PublicSeaInfoActivityPresenter_Factory.create(
            MembersInjectors.<PublicSeaInfoActivityPresenter>noOp(), getApiProvider);

    this.publicSeaInfoActivityMembersInjector =
        PublicSeaInfoActivity_MembersInjector.create(publicSeaInfoActivityPresenterProvider);

    this.publicSeaSearchListPresenterProvider =
        PublicSeaSearchListPresenter_Factory.create(
            MembersInjectors.<PublicSeaSearchListPresenter>noOp(), getApiProvider);

    this.publicSeaSearchListActivityMembersInjector =
        PublicSeaSearchListActivity_MembersInjector.create(publicSeaSearchListPresenterProvider);

    this.membersFollowUpRecordActivityPresenterProvider =
        MembersFollowUpRecordActivityPresenter_Factory.create(
            MembersInjectors.<MembersFollowUpRecordActivityPresenter>noOp(), getApiProvider);

    this.membersFollowUpRecordActivityMembersInjector =
        MembersFollowUpRecordActivity_MembersInjector.create(
            membersFollowUpRecordActivityPresenterProvider);

    this.customerAddCollectionActivityPresenterProvider =
        CustomerAddCollectionActivityPresenter_Factory.create(
            MembersInjectors.<CustomerAddCollectionActivityPresenter>noOp(), getApiProvider);

    this.customerAddCollectionActivityMembersInjector =
        CustomerAddCollectionActivity_MembersInjector.create(
            customerAddCollectionActivityPresenterProvider);

    this.addReportActivityPresenterProvider =
        AddReportActivityPresenter_Factory.create(
            MembersInjectors.<AddReportActivityPresenter>noOp(), getApiProvider);

    this.addReportActivityMembersInjector =
        AddReportActivity_MembersInjector.create(addReportActivityPresenterProvider);

    this.lessonReportDocumentsListActivityPresenterProvider =
        LessonReportDocumentsListActivityPresenter_Factory.create(
            MembersInjectors.<LessonReportDocumentsListActivityPresenter>noOp(), getApiProvider);

    this.lessonReportDocumentsListActivityMembersInjector =
        LessonReportDocumentsListActivity_MembersInjector.create(
            lessonReportDocumentsListActivityPresenterProvider);

    this.lessonInfoActivityPresenterProvider =
        LessonInfoActivityPresenter_Factory.create(
            MembersInjectors.<LessonInfoActivityPresenter>noOp(), getApiProvider);

    this.lessonInfoActivityMembersInjector =
        LessonInfoActivity_MembersInjector.create(lessonInfoActivityPresenterProvider);

    this.membersInfoActivityPresenterProvider =
        MembersInfoActivityPresenter_Factory.create(
            MembersInjectors.<MembersInfoActivityPresenter>noOp(), getApiProvider);

    this.membersInfoActivityMembersInjector =
        MembersInfoActivity_MembersInjector.create(membersInfoActivityPresenterProvider);

    this.courseDetailsActivityPresenterProvider =
        CourseDetailsActivityPresenter_Factory.create(
            MembersInjectors.<CourseDetailsActivityPresenter>noOp(), getApiProvider);

    this.courseDetailsActivityMembersInjector =
        CourseDetailsActivity_MembersInjector.create(courseDetailsActivityPresenterProvider);

    this.lessonInfoPrivateActivityPresenterProvider =
        LessonInfoPrivateActivityPresenter_Factory.create(
            MembersInjectors.<LessonInfoPrivateActivityPresenter>noOp(), getApiProvider);

    this.lessonInfoPrivateActivityMembersInjector =
        LessonInfoPrivateActivity_MembersInjector.create(
            lessonInfoPrivateActivityPresenterProvider);

    this.membersInfoDetailsActivityPresenterProvider =
        MembersInfoDetailsActivityPresenter_Factory.create(
            MembersInjectors.<MembersInfoDetailsActivityPresenter>noOp(), getApiProvider);

    this.membersInfoDetailsActivityMembersInjector =
        MembersInfoDetailsActivity_MembersInjector.create(
            membersInfoDetailsActivityPresenterProvider);

    this.customerEditCollectionActivityPresenterProvider =
        CustomerEditCollectionActivityPresenter_Factory.create(
            MembersInjectors.<CustomerEditCollectionActivityPresenter>noOp(), getApiProvider);

    this.customerEditCollectionActivityMembersInjector =
        CustomerEditCollectionActivity_MembersInjector.create(
            customerEditCollectionActivityPresenterProvider);

    this.addMebersAppointmentActivityPresenterProvider =
        AddMebersAppointmentActivityPresenter_Factory.create(
            MembersInjectors.<AddMebersAppointmentActivityPresenter>noOp(), getApiProvider);

    this.addMebersAppointmentActivityMembersInjector =
        AddMebersAppointmentActivity_MembersInjector.create(
            addMebersAppointmentActivityPresenterProvider);

    this.cardListPresenterProvider =
        CardListPresenter_Factory.create(
            MembersInjectors.<CardListPresenter>noOp(), getApiProvider);

    this.cardListActivityMembersInjector =
        CardListActivity_MembersInjector.create(cardListPresenterProvider);

    this.cardInfoPresenterProvider =
        CardInfoPresenter_Factory.create(
            MembersInjectors.<CardInfoPresenter>noOp(), getApiProvider);

    this.cardInfoActivityMembersInjector =
        CardInfoActivity_MembersInjector.create(cardInfoPresenterProvider);

    this.timeCardInfoActivityPresenterProvider =
        TimeCardInfoActivityPresenter_Factory.create(
            MembersInjectors.<TimeCardInfoActivityPresenter>noOp(), getApiProvider);

    this.timeCardInfoActivityMembersInjector =
        TimeCardInfoActivity_MembersInjector.create(timeCardInfoActivityPresenterProvider);

    this.reservationRecordMembersActivityPresenterProvider =
        ReservationRecordMembersActivityPresenter_Factory.create(
            MembersInjectors.<ReservationRecordMembersActivityPresenter>noOp(), getApiProvider);

    this.reservationRecordMembersActivityMembersInjector =
        ReservationRecordMembersActivity_MembersInjector.create(
            reservationRecordMembersActivityPresenterProvider);

    this.scheduleActivityPresenterProvider =
        ScheduleActivityPresenter_Factory.create(
            MembersInjectors.<ScheduleActivityPresenter>noOp(), getApiProvider);

    this.scheduleActivityMembersInjector =
        ScheduleActivity_MembersInjector.create(scheduleActivityPresenterProvider);

    this.membersAppointmentRecordActivityPresenterProvider =
        MembersAppointmentRecordActivityPresenter_Factory.create(
            MembersInjectors.<MembersAppointmentRecordActivityPresenter>noOp(), getApiProvider);

    this.membersAppointmentRecordActivityMembersInjector =
        MembersAppointmentRecordActivity_MembersInjector.create(
            membersAppointmentRecordActivityPresenterProvider);

    this.editMebersAppointmentActivityPresenterProvider =
        EditMebersAppointmentActivityPresenter_Factory.create(
            MembersInjectors.<EditMebersAppointmentActivityPresenter>noOp(), getApiProvider);

    this.editMebersAppointmentActivityMembersInjector =
        EditMebersAppointmentActivity_MembersInjector.create(
            editMebersAppointmentActivityPresenterProvider);

    this.addMembersFollowActivityPresenterProvider =
        AddMembersFollowActivityPresenter_Factory.create(
            MembersInjectors.<AddMembersFollowActivityPresenter>noOp(), getApiProvider);

    this.addMembersFollowActivityMembersInjector =
        AddMembersFollowActivity_MembersInjector.create(addMembersFollowActivityPresenterProvider);

    this.lessonListActivityPresenterProvider =
        LessonListActivityPresenter_Factory.create(
            MembersInjectors.<LessonListActivityPresenter>noOp(), getApiProvider);

    this.lessonListActivityMembersInjector =
        LessonListActivity_MembersInjector.create(lessonListActivityPresenterProvider);

    this.scheduleAddAppointmentActivityPresenterProvider =
        ScheduleAddAppointmentActivityPresenter_Factory.create(
            MembersInjectors.<ScheduleAddAppointmentActivityPresenter>noOp(), getApiProvider);
  }

  @SuppressWarnings("unchecked")
  private void initialize2(final Builder builder) {

    this.scheduleAddAppointmentActivityMembersInjector =
        ScheduleAddAppointmentActivity_MembersInjector.create(
            scheduleAddAppointmentActivityPresenterProvider);

    this.scanActivityPresenterProvider =
        ScanActivityPresenter_Factory.create(
            MembersInjectors.<ScanActivityPresenter>noOp(), getApiProvider);

    this.scanActivityMembersInjector =
        ScanActivity_MembersInjector.create(scanActivityPresenterProvider);

    this.reservationRecordScheduleActivityPresenterProvider =
        ReservationRecordScheduleActivityPresenter_Factory.create(
            MembersInjectors.<ReservationRecordScheduleActivityPresenter>noOp(), getApiProvider);

    this.reservationRecordScheduleActivityMembersInjector =
        ReservationRecordScheduleActivity_MembersInjector.create(
            reservationRecordScheduleActivityPresenterProvider);

    this.addAppointmentScheduleActivityActivityPresenterProvider =
        AddAppointmentScheduleActivityActivityPresenter_Factory.create(
            MembersInjectors.<AddAppointmentScheduleActivityActivityPresenter>noOp(),
            getApiProvider);

    this.addAppointmentScheduleActivityMembersInjector =
        AddAppointmentScheduleActivity_MembersInjector.create(
            addAppointmentScheduleActivityActivityPresenterProvider);

    this.teacherFilterListActivityPresenterProvider =
        TeacherFilterListActivityPresenter_Factory.create(
            MembersInjectors.<TeacherFilterListActivityPresenter>noOp(), getApiProvider);

    this.teacherFilterListActivityMembersInjector =
        TeacherFilterListActivity_MembersInjector.create(
            teacherFilterListActivityPresenterProvider);

    this.welcomeActivityPresenterProvider =
        WelcomeActivityPresenter_Factory.create(
            MembersInjectors.<WelcomeActivityPresenter>noOp(), getApiProvider);

    this.welcomeActivityMembersInjector =
        WelcomeActivity_MembersInjector.create(welcomeActivityPresenterProvider);

    this.chartsMainActivityPresenterProvider =
        ChartsMainActivityPresenter_Factory.create(
            MembersInjectors.<ChartsMainActivityPresenter>noOp(), getApiProvider);

    this.chartsMainActivityMembersInjector =
        ChartsMainActivity_MembersInjector.create(chartsMainActivityPresenterProvider);

    this.chartsListActivityPresenterProvider =
        ChartsListActivityPresenter_Factory.create(
            MembersInjectors.<ChartsListActivityPresenter>noOp(), getApiProvider);

    this.chartsListActivityMembersInjector =
        ChartsListActivity_MembersInjector.create(chartsListActivityPresenterProvider);

    this.privateLesssonActivityPresenterProvider =
        PrivateLesssonActivityPresenter_Factory.create(
            MembersInjectors.<PrivateLesssonActivityPresenter>noOp(), getApiProvider);

    this.privateLesssonActivityMembersInjector =
        PrivateLesssonActivity_MembersInjector.create(privateLesssonActivityPresenterProvider);

    this.groupLesssonActivityPresenterProvider =
        GroupLesssonActivityPresenter_Factory.create(
            MembersInjectors.<GroupLesssonActivityPresenter>noOp(), getApiProvider);

    this.groupLesssonActivityMembersInjector =
        GroupLesssonActivity_MembersInjector.create(groupLesssonActivityPresenterProvider);
  }

  @Override
  public void inject(MainActivity mainActivity) {
    mainActivityMembersInjector.injectMembers(mainActivity);
  }

  @Override
  public void inject(LoginActivity loginActivity) {
    loginActivityMembersInjector.injectMembers(loginActivity);
  }

  @Override
  public void inject(MessagesListActivity messagesListActivity) {
    messagesListActivityMembersInjector.injectMembers(messagesListActivity);
  }

  @Override
  public void inject(ImgVideoListActivity imgVideoListActivity) {
    imgVideoListActivityMembersInjector.injectMembers(imgVideoListActivity);
  }

  @Override
  public void inject(CustomerInfoCollectionActivity customerInfoCollectionActivity) {
    customerInfoCollectionActivityMembersInjector.injectMembers(customerInfoCollectionActivity);
  }

  @Override
  public void inject(CustomerListActivity customerListActivity) {
    customerListActivityMembersInjector.injectMembers(customerListActivity);
  }

  @Override
  public void inject(QueryActivity queryActivity) {
    queryActivityMembersInjector.injectMembers(queryActivity);
  }

  @Override
  public void inject(AppraiseActivity appraiseActivity) {
    appraiseActivityMembersInjector.injectMembers(appraiseActivity);
  }

  @Override
  public void inject(FollowUpRecordActivity followUpRecordActivity) {
    followUpRecordActivityMembersInjector.injectMembers(followUpRecordActivity);
  }

  @Override
  public void inject(AddAppointmentActivity addAppointmentActivity) {
    addAppointmentActivityMembersInjector.injectMembers(addAppointmentActivity);
  }

  @Override
  public void inject(AddFollowActivity addFollowActivity) {
    addFollowActivityMembersInjector.injectMembers(addFollowActivity);
  }

  @Override
  public void inject(TrainingPlanListActivity trainingPlanListActivity) {
    trainingPlanListActivityMembersInjector.injectMembers(trainingPlanListActivity);
  }

  @Override
  public void inject(TrainingPlanAddActivity trainingPlanAddActivity) {
    trainingPlanAddActivityMembersInjector.injectMembers(trainingPlanAddActivity);
  }

  @Override
  public void inject(CourseAppointmentAddActivity courseAppointmentAddActivity) {
    courseAppointmentAddActivityMembersInjector.injectMembers(courseAppointmentAddActivity);
  }

  @Override
  public void inject(SiteSelectionActivity siteSelectionActivity) {
    siteSelectionActivityMembersInjector.injectMembers(siteSelectionActivity);
  }

  @Override
  public void inject(AppointmentDetailsActivity appointmentDetailsActivity) {
    appointmentDetailsActivityMembersInjector.injectMembers(appointmentDetailsActivity);
  }

  @Override
  public void inject(CourseListActivity courseListActivity) {
    courseListActivityMembersInjector.injectMembers(courseListActivity);
  }

  @Override
  public void inject(MedicalReportDocumentsListActivity medicalReportDocumentsListActivity) {
    medicalReportDocumentsListActivityMembersInjector.injectMembers(
        medicalReportDocumentsListActivity);
  }

  @Override
  public void inject(AddressDetailsActivity addressDetailsActivity) {
    addressDetailsActivityMembersInjector.injectMembers(addressDetailsActivity);
  }

  @Override
  public void inject(SetingActivity setingActivity) {
    setingActivityMembersInjector.injectMembers(setingActivity);
  }

  @Override
  public void inject(PersonalInfoActivity personalInfoActivity) {
    personalInfoActivityMembersInjector.injectMembers(personalInfoActivity);
  }

  @Override
  public void inject(CoachInfoActivity coachInfoActivity) {
    coachInfoActivityMembersInjector.injectMembers(coachInfoActivity);
  }

  @Override
  public void inject(FilterListActivity filterListActivity) {
    filterListActivityMembersInjector.injectMembers(filterListActivity);
  }

  @Override
  public void inject(CustomerInfoAddCollectionActivity customerInfoAddCollectionActivity) {
    customerInfoAddCollectionActivityMembersInjector.injectMembers(
        customerInfoAddCollectionActivity);
  }

  @Override
  public void inject(ReservationRecordActivity reservationRecordActivity) {
    reservationRecordActivityMembersInjector.injectMembers(reservationRecordActivity);
  }

  @Override
  public void inject(AppointmentRecordActivity appointmentRecordActivity) {
    appointmentRecordActivityMembersInjector.injectMembers(appointmentRecordActivity);
  }

  @Override
  public void inject(PublicSeaListActivity publicSeaListActivity) {
    publicSeaListActivityMembersInjector.injectMembers(publicSeaListActivity);
  }

  @Override
  public void inject(PublicSeaInfoActivity publicSeaInfoActivity) {
    publicSeaInfoActivityMembersInjector.injectMembers(publicSeaInfoActivity);
  }

  @Override
  public void inject(PublicSeaSearchListActivity publicSeaSearchListActivity) {
    publicSeaSearchListActivityMembersInjector.injectMembers(publicSeaSearchListActivity);
  }

  @Override
  public void inject(MembersFollowUpRecordActivity membersFollowUpRecordActivity) {
    membersFollowUpRecordActivityMembersInjector.injectMembers(membersFollowUpRecordActivity);
  }

  @Override
  public void inject(CustomerAddCollectionActivity customerAddCollectionActivity) {
    customerAddCollectionActivityMembersInjector.injectMembers(customerAddCollectionActivity);
  }

  @Override
  public void inject(AddReportActivity addReportActivity) {
    addReportActivityMembersInjector.injectMembers(addReportActivity);
  }

  @Override
  public void inject(LessonReportDocumentsListActivity lessonReportDocumentsListActivity) {
    lessonReportDocumentsListActivityMembersInjector.injectMembers(
        lessonReportDocumentsListActivity);
  }

  @Override
  public void inject(LessonInfoActivity lessonInfActivity) {
    lessonInfoActivityMembersInjector.injectMembers(lessonInfActivity);
  }

  @Override
  public void inject(MembersInfoActivity membersInfoActivity) {
    membersInfoActivityMembersInjector.injectMembers(membersInfoActivity);
  }

  @Override
  public void inject(CourseDetailsActivity courseDetailsActivity) {
    courseDetailsActivityMembersInjector.injectMembers(courseDetailsActivity);
  }

  @Override
  public void inject(LessonInfoPrivateActivity lessonInfoPrivateActivity) {
    lessonInfoPrivateActivityMembersInjector.injectMembers(lessonInfoPrivateActivity);
  }

  @Override
  public void inject(MembersInfoDetailsActivity membersInfoDetailsActivity) {
    membersInfoDetailsActivityMembersInjector.injectMembers(membersInfoDetailsActivity);
  }

  @Override
  public void inject(CustomerEditCollectionActivity customerEditCollectionActivity) {
    customerEditCollectionActivityMembersInjector.injectMembers(customerEditCollectionActivity);
  }

  @Override
  public void inject(AddMebersAppointmentActivity addMebersAppointmentActivity) {
    addMebersAppointmentActivityMembersInjector.injectMembers(addMebersAppointmentActivity);
  }

  @Override
  public void inject(CardListActivity cardListActivity) {
    cardListActivityMembersInjector.injectMembers(cardListActivity);
  }

  @Override
  public void inject(CardInfoActivity cardInfoActivity) {
    cardInfoActivityMembersInjector.injectMembers(cardInfoActivity);
  }

  @Override
  public void inject(TimeCardInfoActivity timeCardInfoActivity) {
    timeCardInfoActivityMembersInjector.injectMembers(timeCardInfoActivity);
  }

  @Override
  public void inject(ReservationRecordMembersActivity reservationRecordMembersActivity) {
    reservationRecordMembersActivityMembersInjector.injectMembers(reservationRecordMembersActivity);
  }

  @Override
  public void inject(ScheduleActivity scheduleActivity) {
    scheduleActivityMembersInjector.injectMembers(scheduleActivity);
  }

  @Override
  public void inject(MembersAppointmentRecordActivity membersAppointmentRecordActivity) {
    membersAppointmentRecordActivityMembersInjector.injectMembers(membersAppointmentRecordActivity);
  }

  @Override
  public void inject(EditMebersAppointmentActivity editMebersAppointmentActivity) {
    editMebersAppointmentActivityMembersInjector.injectMembers(editMebersAppointmentActivity);
  }

  @Override
  public void inject(AddMembersFollowActivity addMembersFollowActivity) {
    addMembersFollowActivityMembersInjector.injectMembers(addMembersFollowActivity);
  }

  @Override
  public void inject(LessonListActivity lessonListActivity) {
    lessonListActivityMembersInjector.injectMembers(lessonListActivity);
  }

  @Override
  public void inject(ScheduleAddAppointmentActivity scheduleAddAppointmentActivity) {
    scheduleAddAppointmentActivityMembersInjector.injectMembers(scheduleAddAppointmentActivity);
  }

  @Override
  public void inject(ScanActivity scanActivity) {
    scanActivityMembersInjector.injectMembers(scanActivity);
  }

  @Override
  public void inject(ReservationRecordScheduleActivity reservationRecordScheduleActivity) {
    reservationRecordScheduleActivityMembersInjector.injectMembers(
        reservationRecordScheduleActivity);
  }

  @Override
  public void inject(AddAppointmentScheduleActivity addAppointmentScheduleActivity) {
    addAppointmentScheduleActivityMembersInjector.injectMembers(addAppointmentScheduleActivity);
  }

  @Override
  public void inject(TeacherFilterListActivity addAppointmentScheduleActivity) {
    teacherFilterListActivityMembersInjector.injectMembers(addAppointmentScheduleActivity);
  }

  @Override
  public void inject(WelcomeActivity welcomeActivity) {
    welcomeActivityMembersInjector.injectMembers(welcomeActivity);
  }

  @Override
  public void inject(ChartsMainActivity chartsMainActivity) {
    chartsMainActivityMembersInjector.injectMembers(chartsMainActivity);
  }

  @Override
  public void inject(ChartsListActivity chartsListActivity) {
    chartsListActivityMembersInjector.injectMembers(chartsListActivity);
  }

  @Override
  public void inject(PrivateLesssonActivity privateLesssonActivity) {
    privateLesssonActivityMembersInjector.injectMembers(privateLesssonActivity);
  }

  @Override
  public void inject(GroupLesssonActivity groupLesssonActivity) {
    groupLesssonActivityMembersInjector.injectMembers(groupLesssonActivity);
  }

  public static final class Builder {
    private AppComponent appComponent;

    private Builder() {}

    public ActivityComponent build() {
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerActivityComponent(this);
    }

    public Builder appComponent(AppComponent appComponent) {
      this.appComponent = Preconditions.checkNotNull(appComponent);
      return this;
    }
  }
}
