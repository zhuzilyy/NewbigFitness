package com.example.gufei.bigfitness.com.GuFei.Component;

import com.example.gufei.bigfitness.com.GuFei.Moudel.FragmentModule;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.com.GuFei.Ui.AddressList.AddressListFragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.AddressList.AddressListFragMentPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.AddressList.AddressListFragMentPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.AddressList.AddressListFragMent_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index1.Index1FragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index1.Index1FragMentPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index1.Index1FragMentPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index1.Index1FragMent_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index2.Index2FragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index2.Index2FragMentPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index2.Index2FragMentPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index2.Index2FragMent_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index3.Index3FragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index3.Index3FragMentPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index3.Index3FragMentPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index3.Index3FragMent_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index4.Index4FragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index4.Index4FragMentPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index4.Index4FragMentPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Charts.FragMent.Index4.Index4FragMent_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.History.TrainingPlanListHistoryFragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.History.TrainingPlanListHistoryFragMentPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.History.TrainingPlanListHistoryFragMentPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.History.TrainingPlanListHistoryFragMent_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.Today.TrainingPlanListTodayFragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.Today.TrainingPlanListTodayFragMentPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.Today.TrainingPlanListTodayFragMentPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.TrainingPlan.FragMent.Today.TrainingPlanListTodayFragMent_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.Index.IndexFragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.Index.IndexFragMentPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.Index.IndexFragMentPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.Index.IndexFragMent_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.SelectList.SelectListFragent;
import com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.SelectList.SelectListFragent_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.SelectList.SelectListPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.FragMent.SelectList.SelectListPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.IndexFragment;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.IndexFragment_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.IndexPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.IndexPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.Mon.MonFragment;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.Mon.MonFragment_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.Mon.MonPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.Mon.MonPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.day.DayFragment;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.day.DayFragment_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.day.DayPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.day.DayPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.list.LIstPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.list.LIstPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.list.ListFragment;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.list.ListFragment_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.week.WeekFragment;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.week.WeekFragment_MembersInjector;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.week.WeekPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.Fragment.week.WeekPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.main.MyCenterMainFragMent;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.main.MyCenterMainFragMentPresenter;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.main.MyCenterMainFragMentPresenter_Factory;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.main.MyCenterMainFragMent_MembersInjector;
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
public final class DaggerFragmentComponent implements FragmentComponent {
  private Provider<Api> getApiProvider;

  private Provider<SelectListPresenter> selectListPresenterProvider;

  private MembersInjector<SelectListFragent> selectListFragentMembersInjector;

  private Provider<IndexFragMentPresenter> indexFragMentPresenterProvider;

  private MembersInjector<IndexFragMent> indexFragMentMembersInjector;

  private Provider<AddressListFragMentPresenter> addressListFragMentPresenterProvider;

  private MembersInjector<AddressListFragMent> addressListFragMentMembersInjector;

  private Provider<MyCenterMainFragMentPresenter> myCenterMainFragMentPresenterProvider;

  private MembersInjector<MyCenterMainFragMent> myCenterMainFragMentMembersInjector;

  private Provider<TrainingPlanListTodayFragMentPresenter>
      trainingPlanListTodayFragMentPresenterProvider;

  private MembersInjector<TrainingPlanListTodayFragMent>
      trainingPlanListTodayFragMentMembersInjector;

  private Provider<TrainingPlanListHistoryFragMentPresenter>
      trainingPlanListHistoryFragMentPresenterProvider;

  private MembersInjector<TrainingPlanListHistoryFragMent>
      trainingPlanListHistoryFragMentMembersInjector;

  private Provider<MonPresenter> monPresenterProvider;

  private MembersInjector<MonFragment> monFragmentMembersInjector;

  private Provider<IndexPresenter> indexPresenterProvider;

  private MembersInjector<IndexFragment> indexFragmentMembersInjector;

  private Provider<DayPresenter> dayPresenterProvider;

  private MembersInjector<DayFragment> dayFragmentMembersInjector;

  private Provider<LIstPresenter> lIstPresenterProvider;

  private MembersInjector<ListFragment> listFragmentMembersInjector;

  private Provider<WeekPresenter> weekPresenterProvider;

  private MembersInjector<WeekFragment> weekFragmentMembersInjector;

  private Provider<Index1FragMentPresenter> index1FragMentPresenterProvider;

  private MembersInjector<Index1FragMent> index1FragMentMembersInjector;

  private Provider<Index2FragMentPresenter> index2FragMentPresenterProvider;

  private MembersInjector<Index2FragMent> index2FragMentMembersInjector;

  private Provider<Index3FragMentPresenter> index3FragMentPresenterProvider;

  private MembersInjector<Index3FragMent> index3FragMentMembersInjector;

  private Provider<Index4FragMentPresenter> index4FragMentPresenterProvider;

  private MembersInjector<Index4FragMent> index4FragMentMembersInjector;

  private DaggerFragmentComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
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

    this.selectListPresenterProvider =
        SelectListPresenter_Factory.create(
            MembersInjectors.<SelectListPresenter>noOp(), getApiProvider);

    this.selectListFragentMembersInjector =
        SelectListFragent_MembersInjector.create(selectListPresenterProvider);

    this.indexFragMentPresenterProvider =
        IndexFragMentPresenter_Factory.create(
            MembersInjectors.<IndexFragMentPresenter>noOp(), getApiProvider);

    this.indexFragMentMembersInjector =
        IndexFragMent_MembersInjector.create(indexFragMentPresenterProvider);

    this.addressListFragMentPresenterProvider =
        AddressListFragMentPresenter_Factory.create(
            MembersInjectors.<AddressListFragMentPresenter>noOp(), getApiProvider);

    this.addressListFragMentMembersInjector =
        AddressListFragMent_MembersInjector.create(addressListFragMentPresenterProvider);

    this.myCenterMainFragMentPresenterProvider =
        MyCenterMainFragMentPresenter_Factory.create(
            MembersInjectors.<MyCenterMainFragMentPresenter>noOp(), getApiProvider);

    this.myCenterMainFragMentMembersInjector =
        MyCenterMainFragMent_MembersInjector.create(myCenterMainFragMentPresenterProvider);

    this.trainingPlanListTodayFragMentPresenterProvider =
        TrainingPlanListTodayFragMentPresenter_Factory.create(
            MembersInjectors.<TrainingPlanListTodayFragMentPresenter>noOp(), getApiProvider);

    this.trainingPlanListTodayFragMentMembersInjector =
        TrainingPlanListTodayFragMent_MembersInjector.create(
            trainingPlanListTodayFragMentPresenterProvider);

    this.trainingPlanListHistoryFragMentPresenterProvider =
        TrainingPlanListHistoryFragMentPresenter_Factory.create(
            MembersInjectors.<TrainingPlanListHistoryFragMentPresenter>noOp(), getApiProvider);

    this.trainingPlanListHistoryFragMentMembersInjector =
        TrainingPlanListHistoryFragMent_MembersInjector.create(
            trainingPlanListHistoryFragMentPresenterProvider);

    this.monPresenterProvider =
        MonPresenter_Factory.create(MembersInjectors.<MonPresenter>noOp(), getApiProvider);

    this.monFragmentMembersInjector = MonFragment_MembersInjector.create(monPresenterProvider);

    this.indexPresenterProvider =
        IndexPresenter_Factory.create(MembersInjectors.<IndexPresenter>noOp(), getApiProvider);

    this.indexFragmentMembersInjector =
        IndexFragment_MembersInjector.create(indexPresenterProvider);

    this.dayPresenterProvider =
        DayPresenter_Factory.create(MembersInjectors.<DayPresenter>noOp(), getApiProvider);

    this.dayFragmentMembersInjector = DayFragment_MembersInjector.create(dayPresenterProvider);

    this.lIstPresenterProvider =
        LIstPresenter_Factory.create(MembersInjectors.<LIstPresenter>noOp(), getApiProvider);

    this.listFragmentMembersInjector = ListFragment_MembersInjector.create(lIstPresenterProvider);

    this.weekPresenterProvider =
        WeekPresenter_Factory.create(MembersInjectors.<WeekPresenter>noOp(), getApiProvider);

    this.weekFragmentMembersInjector = WeekFragment_MembersInjector.create(weekPresenterProvider);

    this.index1FragMentPresenterProvider =
        Index1FragMentPresenter_Factory.create(
            MembersInjectors.<Index1FragMentPresenter>noOp(), getApiProvider);

    this.index1FragMentMembersInjector =
        Index1FragMent_MembersInjector.create(index1FragMentPresenterProvider);

    this.index2FragMentPresenterProvider =
        Index2FragMentPresenter_Factory.create(
            MembersInjectors.<Index2FragMentPresenter>noOp(), getApiProvider);

    this.index2FragMentMembersInjector =
        Index2FragMent_MembersInjector.create(index2FragMentPresenterProvider);

    this.index3FragMentPresenterProvider =
        Index3FragMentPresenter_Factory.create(
            MembersInjectors.<Index3FragMentPresenter>noOp(), getApiProvider);

    this.index3FragMentMembersInjector =
        Index3FragMent_MembersInjector.create(index3FragMentPresenterProvider);

    this.index4FragMentPresenterProvider =
        Index4FragMentPresenter_Factory.create(
            MembersInjectors.<Index4FragMentPresenter>noOp(), getApiProvider);

    this.index4FragMentMembersInjector =
        Index4FragMent_MembersInjector.create(index4FragMentPresenterProvider);
  }

  @Override
  public void inject(SelectListFragent selectListFragent) {
    selectListFragentMembersInjector.injectMembers(selectListFragent);
  }

  @Override
  public void inject(IndexFragMent indexFragment) {
    indexFragMentMembersInjector.injectMembers(indexFragment);
  }

  @Override
  public void inject(AddressListFragMent addressListFragMent) {
    addressListFragMentMembersInjector.injectMembers(addressListFragMent);
  }

  @Override
  public void inject(MyCenterMainFragMent myCenterMainFragMent) {
    myCenterMainFragMentMembersInjector.injectMembers(myCenterMainFragMent);
  }

  @Override
  public void inject(TrainingPlanListTodayFragMent trainingPlanListTodayFragMent) {
    trainingPlanListTodayFragMentMembersInjector.injectMembers(trainingPlanListTodayFragMent);
  }

  @Override
  public void inject(TrainingPlanListHistoryFragMent trainingPlanListHistoryFragMent) {
    trainingPlanListHistoryFragMentMembersInjector.injectMembers(trainingPlanListHistoryFragMent);
  }

  @Override
  public void inject(MonFragment monFragment) {
    monFragmentMembersInjector.injectMembers(monFragment);
  }

  @Override
  public void inject(IndexFragment indexFragment) {
    indexFragmentMembersInjector.injectMembers(indexFragment);
  }

  @Override
  public void inject(DayFragment dayFragment) {
    dayFragmentMembersInjector.injectMembers(dayFragment);
  }

  @Override
  public void inject(ListFragment listFragment) {
    listFragmentMembersInjector.injectMembers(listFragment);
  }

  @Override
  public void inject(WeekFragment weekFragment) {
    weekFragmentMembersInjector.injectMembers(weekFragment);
  }

  @Override
  public void inject(Index1FragMent index1FragMent) {
    index1FragMentMembersInjector.injectMembers(index1FragMent);
  }

  @Override
  public void inject(Index2FragMent index2FragMent) {
    index2FragMentMembersInjector.injectMembers(index2FragMent);
  }

  @Override
  public void inject(Index3FragMent index3FragMent) {
    index3FragMentMembersInjector.injectMembers(index3FragMent);
  }

  @Override
  public void inject(Index4FragMent index4FragMent) {
    index4FragMentMembersInjector.injectMembers(index4FragMent);
  }

  public static final class Builder {
    private AppComponent appComponent;

    private Builder() {}

    public FragmentComponent build() {
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerFragmentComponent(this);
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://google.github.io/dagger/unused-modules.
     */
    @Deprecated
    public Builder fragmentModule(FragmentModule fragmentModule) {
      Preconditions.checkNotNull(fragmentModule);
      return this;
    }

    public Builder appComponent(AppComponent appComponent) {
      this.appComponent = Preconditions.checkNotNull(appComponent);
      return this;
    }
  }
}
