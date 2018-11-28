package com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.AddCustomer.CustomerInfo.CustomerAddCollectionActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.CustomerList.CustomerListActivity;
import com.example.gufei.bigfitness.util.SpUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.Constants.ACTIVITY_ID_CUSTOMER;
import static com.example.gufei.bigfitness.Constants.ACTIVITY_ID_NON_CUSTOMER;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.ISDERPARTMANAGERKEY;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

public class CustomerMainActivity extends AppCompatActivity {
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
    private long lastClickTime;
    /**
     * switch of limit for click
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_main);
        ButterKnife.bind(this);
        toolbar.setNavigationIcon(R.mipmap.left);
        setToolBar(toolbar, "");
      tvTitle.setText("客户管理");

    }

    @OnClick({R.id.customer_acquisition_btn, R.id.customer_list_btn, R.id.non_members_list_btn})
    public void onClick(View view) {
        Intent intent;
        final String UserName = (String) SpUtil.get(this, USERNAMEKEY, "");

        final int UserId = (int) SpUtil.get(this, USERIDKEY, 0);

        final String token = (String) SpUtil.get(this, TOKENKEY, "");

        final int ClubId = (int) SpUtil.get(this, CLUBIDKEY, 0);

        int IsDepartManager = (int) SpUtil.get(this, ISDERPARTMANAGERKEY, 0);

        String UserType = (String) SpUtil.get(this, PERSONTYPEKEY, "");


        switch (view.getId()) {

            case R.id.customer_acquisition_btn:

                if (UserType.equals("会籍")) {

                    intent = new Intent(CustomerMainActivity.this, CustomerAddCollectionActivity.class);
                    startActivity(intent);

                } else {

                    s(this, "教练无权操作该功能!");
                }
                break;
            case R.id.customer_list_btn:

                intent = new Intent(CustomerMainActivity.this, CustomerListActivity.class);
                intent.putExtra("com.example.gufei.bigfitness.com.GuFei.Ui.main.type", ACTIVITY_ID_CUSTOMER);
                startActivity(intent);

                break;
            case R.id.non_members_list_btn:

                intent = new Intent(CustomerMainActivity.this, CustomerListActivity.class);
                intent.putExtra("com.example.gufei.bigfitness.com.GuFei.Ui.main.type", ACTIVITY_ID_NON_CUSTOMER);
                startActivity(intent);
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
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            if (isFastDoubleClick()) {
                return true;
            }
        }
        return super.dispatchTouchEvent(ev);
    }
    public boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        lastClickTime = time;
        return timeD <= 300;
    }
}
