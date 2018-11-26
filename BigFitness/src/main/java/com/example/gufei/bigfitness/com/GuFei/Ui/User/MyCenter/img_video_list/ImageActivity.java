package com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.img_video_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.gufei.bigfitness.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.gufei.bigfitness.util.LoadImage.loadIntoUseFitWidth;
/**
 * Created by Administrator on 2017/8/4.
 * 图片全屏显示页面
 */

public class ImageActivity extends AppCompatActivity {

    @BindView(R.id.imgView)
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        Boolean local = intent.getBooleanExtra("com.example.gufei.bigfitness.com.GuFei.local", false);
        if (local) {
            Glide
                    .with(this)
                    .load( intent.getStringExtra("com.example.gufei.bigfitness.com.GuFei.url"))
                    .fitCenter()
                    .error(R.mipmap.null_img)
                    .into(imgView);

        } else {
            loadIntoUseFitWidth(ImageActivity.this, intent.getStringExtra("com.example.gufei.bigfitness.com.GuFei.url"), R.mipmap.null_img, imgView);

        }

    }

    @OnClick(R.id.imgView)
    public void onViewClicked() {

        this.finish();
    }
}
