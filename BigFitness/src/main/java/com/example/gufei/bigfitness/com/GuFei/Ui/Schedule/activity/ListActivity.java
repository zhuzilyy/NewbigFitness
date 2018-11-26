package com.example.gufei.bigfitness.com.GuFei.Ui.Schedule.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.RecyclerviewBase.CommonAdapter;
import com.example.gufei.bigfitness.base.RecyclerviewBase.ViewHolder;
import com.example.gufei.bigfitness.base.SimpleBaseActivity;
import com.example.gufei.bigfitness.com.GuFei.Model.local.AppointmentListByDateForOrderBean;
import com.example.gufei.bigfitness.com.GuFei.Model.local.Schedule;
import com.example.gufei.bigfitness.com.GuFei.Ui.CustomerManagement.ReservationRecord.ReservationRecordActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.Members.ReservationRecord.ReservationRecordMembersActivity;
import com.example.gufei.bigfitness.util.SpUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.DEPARTIDKEY;
import static com.example.gufei.bigfitness.Constants.ISDERPARTMANAGERKEY;
import static com.example.gufei.bigfitness.Constants.PUT_STR;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.GlideImageLoader.displayCircleImage;
import static com.example.gufei.bigfitness.util.LoadImage.loadIntoUseFitWidth;

public class ListActivity extends SimpleBaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerView;
//    @BindView(R.id.swiperefreshlayoutid)
//    SwipeRefreshLayout swipeRefreshLayout;

    private CommonAdapter<Schedule.ResultBean.DataBean> commonAdapter;
    String UserName;
    int UserId;
    String token;
    int ClubId;
    int IsDepartManager;
    int DepartId;

    @Override
    protected int getLayout() {
        return R.layout.activity_list;
    }

    @Override
    protected void initData() {

        toolbar.setNavigationIcon(R.mipmap.left);

        setToolBar(toolbar, "");
        final Intent intent = getIntent();
        tvTitle.setText("多条预约");
        btnComplete.setVisibility(View.GONE);
        ArrayList<Schedule.ResultBean.DataBean> list = (ArrayList<Schedule.ResultBean.DataBean>) intent.getSerializableExtra("param");
        UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");
        UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);
        token = (String) SpUtil.get(mContext, TOKENKEY, "");
        ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);
        IsDepartManager = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);
        DepartId = (int) SpUtil.get(mContext, DEPARTIDKEY, 0);


        commonAdapter = new CommonAdapter<Schedule.ResultBean.DataBean>(R.layout.card_schedule_list, mContext, list) {
            @Override
            protected void convert(ViewHolder holder, final Schedule.ResultBean.DataBean dataBean, int position) {


                holder.setText(R.id.text_create_name, UserName);
                TextView textName = (TextView) holder.getView(R.id.text_class);
                Button btn1 = (Button) holder.getView(R.id.btn1);
                Button btn2 = (Button) holder.getView(R.id.btn2);
                Button btn3 = (Button) holder.getView(R.id.btn3);
                btn1.setVisibility(View.GONE);
                btn2.setVisibility(View.GONE);
                btn3.setVisibility(View.GONE);
                textName.setText(dataBean.getTitle());
                SpannableStringBuilder builder = new SpannableStringBuilder(textName.getText().toString());
                String[] arr = dataBean.getTitle().split("：");
                ForegroundColorSpan redSpan = new ForegroundColorSpan(0xFF63cd2b);
                builder.setSpan(redSpan, 0, arr.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//                holder.setImage(R.id.img_head).setImageResource(R.mipmap.highseasmembermanage_women);
//                loadIntoUseFitWidth(context, dataBean.getHeaderURL(), R.mipmap.head_img, holder.setImage(R.id.img_head));//头像
                displayCircleImage(context, dataBean.getHeaderURL(), holder.setImage(R.id.img_head), R.mipmap.head_img);//头像
                String tmepStr = "预约开始时间:" + dataBean.getStartTime() + "\n";
                tmepStr += "预约结束时间:" + dataBean.getEndTime() + "\n";
//                tmepStr+="预约结果:"+dataBean.getAppointmentResultName()+"\n";
                tmepStr += "备注:" + dataBean.getContent() + "\n";
                holder.setText(R.id.text_content, tmepStr);
                textName.setText(builder);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent;
                        if (dataBean.getAppType().equals("3")) {

                            intent = new Intent(context, ReservationRecordActivity.class);
                        } else {

                            intent = new Intent(context, ReservationRecordMembersActivity.class);
                        }

                        intent.putExtra(PUT_STR + "Id", String.valueOf(dataBean.getMemberId()));

//                        intent.putExtra(PUT_STR + "Name", listBean.getMemberName());
//                        intent.putExtra(PUT_STR + "Type", CustomerType);

                        intent.putExtra(PUT_STR + "AppointmentType", dataBean.getAppType());
                        intent.putExtra(PUT_STR + "AppointmentId", String.valueOf(dataBean.getAppointmentId()));

                        startActivity(intent);


                    }
                });
            }
        };

        commonAdapter.setShowFooter(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(commonAdapter);
//        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//
//        recyclerView.setLayoutManager(layoutManager);
//
//        //设置进度条的颜色
//        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark);
//
//
//        //设置进度条的大小样式
//        swipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
    }
}
