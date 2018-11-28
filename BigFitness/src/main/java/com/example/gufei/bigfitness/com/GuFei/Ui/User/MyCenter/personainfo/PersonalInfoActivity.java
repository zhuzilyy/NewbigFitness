package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.personainfo;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.base.Base2Activity;
import com.example.gufei.bigfitness.com.GuFei.Model.local.UserInfo;
import com.example.gufei.bigfitness.com.GuFei.Ui.PopView.ScreeningList.SpinnerPopContract;
import com.example.gufei.bigfitness.com.GuFei.Ui.PopView.SpinnerPopupWindow;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.Login.LoginActivity;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.coach.CoachInfoActivity;
import com.example.gufei.bigfitness.util.CustomHelper;
import com.example.gufei.bigfitness.util.SPUtils;
import com.example.gufei.bigfitness.util.SpUtil;
import com.example.gufei.bigfitness.util.ToastUtil;
import com.jph.takephoto.model.TImage;
import com.jph.takephoto.model.TResult;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.App.context;
import static com.example.gufei.bigfitness.Constants.CLUBIDKEY;
import static com.example.gufei.bigfitness.Constants.DEPARTIDKEY;
import static com.example.gufei.bigfitness.Constants.ISDERPARTMANAGERKEY;
import static com.example.gufei.bigfitness.Constants.PERSONTYPEKEY;
import static com.example.gufei.bigfitness.Constants.TOKENKEY;
import static com.example.gufei.bigfitness.Constants.USERIDKEY;
import static com.example.gufei.bigfitness.Constants.USERNAMEKEY;
import static com.example.gufei.bigfitness.util.BitmapUtil.Bitmap2StrByBase64;
import static com.example.gufei.bigfitness.util.GlideImageLoader.displayCircleImage;
import static com.example.gufei.bigfitness.util.ToastUtil.s;

/**
 * Created by Administrator on 2017/8/4.
 * 个人信息页面
 */

public class PersonalInfoActivity extends Base2Activity<PersonalInfoActivityPresenter> implements PersonalInfoActivityContract.View, SpinnerPopContract {

    @BindView(R.id.main_title)
    TextView mainTitle;
    @BindView(R.id.head_img_iv)
    ImageView headImgIv;
    @BindView(R.id.head_img_right)
    ImageView headImgRight;
    @BindView(R.id.head_text)
    TextView headText;
    @BindView(R.id.head_img_btn)
    RelativeLayout headImgBtn;
    @BindView(R.id.user_name_text)
    EditText userNameText;
    @BindView(R.id.head_name_btn)
    RelativeLayout headNameBtn;
    @BindView(R.id.user_sex_text)
    TextView userSexText;
    @BindView(R.id.head_sex_btn)
    RelativeLayout headSexBtn;
    @BindView(R.id.user_age_text)
    EditText userAgeText;
    @BindView(R.id.head_age_btn)
    RelativeLayout headAgeBtn;
    @BindView(R.id.user_tel_text)
    EditText userTelText;
    @BindView(R.id.head_tel_btn)
    RelativeLayout headTelBtn;
    @BindView(R.id.user_id_text)
    EditText userIdText;
    @BindView(R.id.head_id_btn)
    RelativeLayout headIdBtn;
    @BindView(R.id.user_mail_text)
    EditText userMailText;
    @BindView(R.id.head_mail_btn)
    RelativeLayout headMailBtn;
    @BindView(R.id.head_user_id_text)
    TextView headUserIdText;
    @BindView(R.id.head_user_id_btn)
    RelativeLayout headUserIdBtn;
    @BindView(R.id.head_user_type_text)
    TextView headUserTypeText;
    @BindView(R.id.head_user_type_btn)
    RelativeLayout headUserTypeBtn;
    @BindView(R.id.head_club_text)
    TextView headClubText;
    @BindView(R.id.head_club_btn)
    RelativeLayout headClubBtn;
    @BindView(R.id.head_department_text)
    TextView headDepartmentText;
    @BindView(R.id.head_department_btn)
    RelativeLayout headDepartmentBtn;
    @BindView(R.id.head_position_text)
    TextView headPositionText;
    @BindView(R.id.head_position_btn)
    RelativeLayout headPositionBtn;
    @BindView(R.id.head_role_text)
    TextView headRoleText;
    @BindView(R.id.head_role_btn)
    RelativeLayout headRoleBtn;
    @BindView(R.id.head_have_text)
    TextView headHaveText;
    @BindView(R.id.head_have_btn)
    RelativeLayout headHaveBtn;
    @BindView(R.id.head_drop_text)
    TextView headDropText;
    @BindView(R.id.head_drop_btn)
    RelativeLayout headDropBtn;
    @BindView(R.id.info_coach_btn)
    ImageView info_coach_btn;
    @BindView(R.id.btn_edit)
    TextView btnEdit;
    @BindView(R.id.btn_back)
    ImageView btnBack;

    private String header;
    private String userName;
    private String sex;
    private String tel;
    private String age;
    private String mail;
    private String idCard;
    private File file;
    private int  REQUEST_CAMERA=10010;
    private List<String> mDatas;
    private CustomHelper
            customHelper;
    private int ItemSelected = 0;
    private File pic = null;
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_personal_info;
    }

    @Override
    protected void initView() {

        String s = (String) SpUtil.get(mContext, PERSONTYPEKEY, "");

        if (s.equals("会籍")) {
            info_coach_btn.setVisibility(View.GONE);
        }

    }

    @Override
    protected void initData() {
        int userid = (int) SpUtil.get(mContext, USERIDKEY, 0);
        String token = (String) SpUtil.get(mContext, TOKENKEY, "");
        mPresenter.getUserInfo(userid, token);
        customHelper = CustomHelper.of(null, this);
    }
    private void showDailogTakePicture() {
        //        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final Dialog dialog = new Dialog(this, R.style.ButtomDialog);
        dialog.getWindow().setBackgroundDrawableResource(R.color.transparent);

        View view = View.inflate(this, R.layout.dialog_setting_head_imag, null);

        // dialog.setView(view);// 将自定义的布局文件设置给dialog
        dialog.setContentView(view);
        //        Window dialogWindow = dialog.getWindow();

        TextView tvPhonoAlbum = (TextView) view.findViewById(R.id.tv_phono_album);
        TextView tvCancel = (TextView) view.findViewById(R.id.tv_cancel);
        TextView tvTakePicture = (TextView) view.findViewById(R.id.tv_take_picture);
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        tvPhonoAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                SPUtils.put(PersonalInfoActivity.this, "type", "0");
                customHelper.onClick(null, getTakePhoto());
            }
        });
        tvTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                SPUtils.put(PersonalInfoActivity.this, "type", "1");
                customHelper.onClick(null, getTakePhoto());

            }
        });

        Window dialogWindow = dialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        dialog.show();
        //获取当前Activity所在的窗体
        //        Window dialogWindow = dialog.getWindow();
        //设置Dialog从窗体底部弹出
        //        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager m = this.getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高度
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        //        p.height = (int) (d.getHeight() * 0.8); // 高度设置为屏幕的0.6，根据实际情况调整
        p.width = (int) (d.getWidth() * 0.9); // 宽度设置为屏幕的0.65，根据实际情况调整
        p.y = 20;//设置Dialog距离底部的距离
        dialogWindow.setAttributes(p);
    }
    private void showImg(ArrayList<TImage> images) {
        pic = new File(images.get(0).getCompressPath());
        Glide.with(this).load(pic).into(headImgIv);
        header = Bitmap2StrByBase64(images.get(0).getCompressPath());
    }

    @Override
    public void takeCancel() {
        super.takeCancel();
    }

    @Override
    public void takeFail(TResult result, String msg) {
        super.takeFail(result, msg);
    }

    @Override
    public void takeSuccess(TResult result) {
        super.takeSuccess(result);
        showImg(result.getImages());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        if (requestCode == 0 && resultCode == 0) {
            String name = data.getStringExtra("name");

        }
    }

    @OnClick({R.id.btn_back, R.id.btn_edit, R.id.info_coach_btn, R.id.head_img_iv, R.id.head_img_btn, R.id.head_name_btn, R.id.head_sex_btn, R.id.head_age_btn, R.id.head_tel_btn, R.id.head_id_btn, R.id.head_mail_btn, R.id.head_user_id_btn, R.id.head_user_type_btn, R.id.head_club_btn, R.id.head_department_btn, R.id.head_position_btn, R.id.head_role_btn, R.id.head_have_btn, R.id.head_drop_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.info_coach_btn:
                Intent intent = new Intent(PersonalInfoActivity.this, CoachInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.head_img_iv:
                break;
            case R.id.head_img_btn:


                if (btnEdit.getText().toString().equals("完成")) {
                    showDailogTakePicture();
//                    // 头像
//                    Album.startAlbum(this, ACTIVITY_REQUEST_SELECT_PHOTO
//                            , 1                                                          // 指定选择数量。
//                            , ContextCompat.getColor(this, R.color.colorPrimary)        // 指定Toolbar的颜色。
//                            , ContextCompat.getColor(this, R.color.colorPrimaryDark));  // 指定状态栏的颜色。
                }
                break;
            case R.id.head_name_btn:
                //                // 名称

                break;
            case R.id.head_sex_btn:

                if (btnEdit.getText().toString().equals("完成")) {
                    // 性别
                    mDatas = new ArrayList<String>();
                    mDatas.add("男");
                    mDatas.add("女");


                    SpinnerPopupWindow s = new SpinnerPopupWindow.Builder(this)
                            .setmLayoutManager(null)
                            .setmAdapter(new SpinnerAdapter())
                            .setOutsideTouchable(true)
                            .setTitleText("性别")

                            .setmSpinnerPopContract(this)
                            .setmHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                            .setmWidth(ViewGroup.LayoutParams.MATCH_PARENT).build();
                    s.setTitleshow(true);
                    s.showPopCenter();

//                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
//                    @Override
//                    public void onDismiss() {
//                        backgroundAlpha(1f);
//                    }
//                });
                    backgroundAlpha(0.5f);
                }
                break;
            case R.id.head_age_btn:
                // 年龄
                break;
            case R.id.head_tel_btn:
                // 电话
                break;
            case R.id.head_id_btn:
                break;
            case R.id.head_mail_btn:
                // 邮箱
                break;
            case R.id.head_user_id_btn:
                // 身份证
                break;
            case R.id.head_user_type_btn:
                break;
            case R.id.head_club_btn:
                break;
            case R.id.head_department_btn:
                break;
            case R.id.head_position_btn:
                break;
            case R.id.head_role_btn:
                break;
            case R.id.head_have_btn:
                break;
            case R.id.head_drop_btn:
                break;
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_edit:
                //提交修改
                if (btnEdit.getText().toString().equals("完成")) {
                    // 修改提交
                    String UserName = (String) SpUtil.get(mContext, USERNAMEKEY, "");

                    int UserId = (int) SpUtil.get(mContext, USERIDKEY, 0);

                    String token = (String) SpUtil.get(mContext, TOKENKEY, "");

                    int ClubId = (int) SpUtil.get(mContext, CLUBIDKEY, 0);

                    int IsDepartManager = (int) SpUtil.get(mContext, ISDERPARTMANAGERKEY, 0);

                    int DepartId = (int) SpUtil.get(mContext, DEPARTIDKEY, 0);


                    sex = userSexText.getText().toString().equals("男") ? "1" : "0";
                    UserName = userNameText.getText().toString();
                    age = userAgeText.getText().toString();
                    tel = userTelText.getText().toString();
                    mail = userMailText.getText().toString();
                    idCard = userIdText.getText().toString();
                    btnEdit.setText("编辑");

                    mPresenter.updateUserInfo(String.valueOf(UserId),
                            String.valueOf(ClubId),
                            token,
                            header,
                            UserName,
                            sex,
                            age,
                            tel,
                            mail,
                            idCard);
                } else {

                    btnEdit.setText("完成");
                    userSexText.setEnabled(true);
                    userNameText.setEnabled(true);
                    userAgeText.setEnabled(true);
                    userTelText.setEnabled(true);
                    userMailText.setEnabled(true);
                    userIdText.setEnabled(true);

                }
                break;
        }
    }

    /*
    *
    * 更改头像回调
    * */
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == 100) {
//            if (resultCode == RESULT_OK) { // 判断是否成功。
//                // 拿到用户选择的图片路径List：
//                List<String> pathList = Album.parseResult(data);
//                header = "";
////                for (int i = 0; i < pathList.size(); i++) {
//
//                header = Bitmap2StrByBase64(pathList.get(0));
//
//                BitmapFactory.Options options = new BitmapFactory.Options();
//                options.inSampleSize = 2;
//                Bitmap bm = BitmapFactory.decodeFile(pathList.get(0), options);
//                headImgIv.setImageBitmap(bm);
//
//            } else if (resultCode == RESULT_CANCELED) { // 用户取消选择。
//                // 根据需要提示用户取消了选择。
//            }
//        }
//    }
    /**
     * 使用相机
     */
//    private void useCamera() {
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
//                + "/test/" + System.currentTimeMillis() + ".jpg");
//        file.getParentFile().mkdirs();
//
//        //改变Uri  com.xykj.customview.fileprovider注意和xml中的一致
//        Uri uri = FileProvider.getUriForFile(this, "com.xykj.customview.fileprovider", file);
//        //添加权限
//        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
//        startActivityForResult(intent, REQUEST_CAMERA);
//    }
    @Override
    public void complete() {
        ToastUtil.s(this, "修改成功");
        userNameText.setEnabled(false);
        userSexText.setEnabled(false);
        userAgeText.setEnabled(false);
        userTelText.setEnabled(false);
        userMailText.setEnabled(false);
        userIdText.setEnabled(false);
        finish();
    }

    @Override
    public void succeed(UserInfo userInfo) {

//        displayImage(PersonalInfoActivity.this, userInfo.getResult().getHeaderURL(), headImgIv);
        displayCircleImage(mContext  , userInfo.getResult().getHeaderURL(),  headImgIv,R.mipmap.privatememberinfor_03);
        userNameText.setText(String.valueOf(userInfo.getResult().getUserName()));
        userSexText.setText(String.valueOf(userInfo.getResult().getSex()));
        userAgeText.setText(String.valueOf(userInfo.getResult().getAge()));
        userTelText.setText(String.valueOf(userInfo.getResult().getTel()));
        userIdText.setText(String.valueOf(userInfo.getResult().getIDCard()));
        userMailText.setText(String.valueOf(userInfo.getResult().getEmail()));
        headUserIdText.setText(String.valueOf(userInfo.getResult().getJobNumber()));
        headUserTypeText.setText(String.valueOf(userInfo.getResult().getPersonType()));
        headClubText.setText(String.valueOf(userInfo.getResult().getClubName()));
        headDepartmentText.setText(String.valueOf(userInfo.getResult().getDepartName()));
        headPositionText.setText(String.valueOf(userInfo.getResult().getOfficeName()));
//        headRoleText.setText(userInfo.getResult().getR);
        headHaveText.setText(String.valueOf(userInfo.getResult().getCustomerLimit()));
        headDropText.setText(String.valueOf(userInfo.getResult().getProtectDays()));
//        loadIntoUseFitWidth(context, userInfo.getResult().getHeaderURL(), R.mipmap.null_img, headImgIv);
//        info_coach_btn.setText();

        btnEdit.setText("编辑");
        SpUtil.put(mContext, USERNAMEKEY, String.valueOf(userInfo.getResult().getUserName()));

        userSexText.setEnabled(false);
        userNameText.setEnabled(false);
        userAgeText.setEnabled(false);
        userTelText.setEnabled(false);
        userMailText.setEnabled(false);
        userIdText.setEnabled(false);
    }


    @Override
    public void showEmpty() {

    }

    @Override
    public void outLogin() {
        s(this, "您的帐号在其他设备登录");

        Intent intent = new Intent(context, LoginActivity.class);
        remove();
        startActivity(intent);
        finish();

    }


    @Override
    public void Loading() {

    }

    @Override
    public void dismiss() {
        backgroundAlpha(1f);
    }

    class SpinnerAdapter extends RecyclerView.Adapter<SpinnerAdapter.MyViewHolder> {
        @Override
        public SpinnerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            SpinnerAdapter.MyViewHolder holder = new SpinnerAdapter.MyViewHolder(LayoutInflater.from(PersonalInfoActivity.
                    this).inflate(R.layout.item_edit_pop, parent,
                    false));

            return holder;
        }

        @Override
        public void onBindViewHolder(final SpinnerAdapter.MyViewHolder holder, final int position) {

            holder.tv.setText(mDatas.get(position));

            holder.tv.setTag(position);


            if (position == ItemSelected) {

                holder.selected_btn.setVisibility(View.VISIBLE);
            } else {
                holder.selected_btn.setVisibility(View.INVISIBLE);
            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ItemSelected = position;

                    userSexText.setText(mDatas.get(position));
                    notifyDataSetChanged();


                }
            });


        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;
            ImageView selected_btn;
//            ImageView downBtn;

            public MyViewHolder(final View view) {
                super(view);

                tv = (TextView) view.findViewById(R.id.content_text);

                selected_btn = (ImageView) view.findViewById(R.id.selected_btn);
//                downBtn = (ImageView) view.findViewById(R.id.down_btn);


            }
        }
    }


}
