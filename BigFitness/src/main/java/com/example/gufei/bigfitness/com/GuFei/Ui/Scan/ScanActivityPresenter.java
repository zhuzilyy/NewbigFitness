package com.example.gufei.bigfitness.com.GuFei.Ui.Scan;

import com.example.gufei.bigfitness.App;
import com.example.gufei.bigfitness.base.RxPresenter;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppPreloadDicBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerIntroducerBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.CustomerSourceBean;
import com.example.gufei.bigfitness.com.GuFei.NetWork.Api;
import com.example.gufei.bigfitness.util.RxUtil;
import com.example.gufei.bigfitness.util.SpUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

import static com.example.gufei.bigfitness.Constants.ALLMEMBERCARDTYPEKEY;
import static com.example.gufei.bigfitness.Constants.CARDTYPEKEY;
import static com.example.gufei.bigfitness.Constants.CONTACTTEACHERLISTKEY;
import static com.example.gufei.bigfitness.Constants.CREATEUSERLISTKEY;
import static com.example.gufei.bigfitness.Constants.CUSTOMERAPPOINTMENTTYPEKEY;
import static com.example.gufei.bigfitness.Constants.CUSTOMERINTENTKEY;
import static com.example.gufei.bigfitness.Constants.CUSTOMERINTRODUCERKEY;
import static com.example.gufei.bigfitness.Constants.CUSTOMERSOURCEKEY;
import static com.example.gufei.bigfitness.Constants.CUSTOMERTAGKEY;
import static com.example.gufei.bigfitness.Constants.IDENTIFICATIONKEY;
import static com.example.gufei.bigfitness.Constants.LESSONTEACHERLISTKEY;
import static com.example.gufei.bigfitness.Constants.MANGERLISTKEY;
import static com.example.gufei.bigfitness.Constants.MEMBERINTENTKEY;
import static com.example.gufei.bigfitness.Constants.POSTEACHERLISTKEY;
import static com.example.gufei.bigfitness.Constants.PUBLICSEATYPEKEY;
import static com.example.gufei.bigfitness.Constants.SALEMEMBERCARDTYPEKEY;
import static com.example.gufei.bigfitness.Constants.SALETEACHERLISTKEY;
import static com.example.gufei.bigfitness.Constants.WARDROBETYPEKEY;
import static com.example.gufei.bigfitness.util.ListUtil.toJson;

/**
 * Created by GuFei_lyf on 2017/3/22
 */

public class ScanActivityPresenter extends RxPresenter<ScanActivityContract.View> implements ScanActivityContract.Presenter {


    private Api api;


    @Inject
    public ScanActivityPresenter(Api api) {
        this.api = api;
    }


}