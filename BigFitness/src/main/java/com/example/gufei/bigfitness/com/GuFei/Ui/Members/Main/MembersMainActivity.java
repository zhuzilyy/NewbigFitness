package com.example.gufei.bigfitness.com.GuFei.Ui.Members.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerList.CustomerListActivity;
import com.example.gufei.bigfitness.util.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


import static com.example.gufei.bigfitness.Constants.ACTIVITY_ID_MEMBERS;
import static com.example.gufei.bigfitness.Constants.ACTIVITY_ID_PRIVATE_MEMBERS;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;

public class MembersMainActivity extends AppCompatActivity {


    @BindView(R.id.customer_acquisition_btn)
    LinearLayout customerAcquisitionBtn;
    @BindView(R.id.customer_list_btn)
    LinearLayout customerListBtn;
    @BindView(R.id.non_members_list_btn)
    LinearLayout nonMembersListBtn;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
//    @BindView(R.id.department_customer_btn)
//    LinearLayout departmentCustomerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members_main);
        ButterKnife.bind(this);
        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
        tvTitle.setText("会员管理");


    }

    @OnClick({R.id.customer_acquisition_btn, R.id.customer_list_btn, R.id.non_members_list_btn})
    public void onClick(View view) {
        Intent intent;

        String personType = (String) SpUtil.get(this, PERSONTYPEKEY, "");
        switch (view.getId()) {

            case R.id.customer_acquisition_btn:


                intent = new Intent(MembersMainActivity.this, CustomerListActivity.class);
                intent.putExtra("com.example.gufei.bigfitness.com.GuFei.Ui.main.type", ACTIVITY_ID_MEMBERS);
                startActivity(intent);
                break;
            case R.id.customer_list_btn:



                if (personType.equals("会籍")){

                    Toast.makeText(this,"会籍无权查看私教会员",Toast.LENGTH_SHORT).show();

                }else{

                    intent = new Intent(MembersMainActivity.this, CustomerListActivity.class);
                    intent.putExtra("com.example.gufei.bigfitness.com.GuFei.Ui.main.type", ACTIVITY_ID_PRIVATE_MEMBERS);
                    startActivity(intent);
                }



                break;
            case R.id.non_members_list_btn:

//                intent = new Intent(MembersMainActivity.this, CustomerListActivity.class);
//                intent.putExtra("com.example.gufei.bigfitness.com.GuFei.Ui.main.type", ACTIVITY_ID_NON_CUSTOMER);
//                startActivity(intent);
                break;

        }
    }
    protected void setToolBar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                if (fm != null && fm.getBackStackEntryCount() > 0) {
                    fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                } else {
                    finish();
                }
            }
        });
    }
}
