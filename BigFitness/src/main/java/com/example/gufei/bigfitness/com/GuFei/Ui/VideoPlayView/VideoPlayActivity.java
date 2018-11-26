package com.example.gufei.bigfitness.com.GuFei.Ui.VideoPlayView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.gufei.bigfitness.R;
import com.example.gufei.bigfitness.com.GuFei.Ui.User.MyCenter.img_video_list.ImageActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.gufei.bigfitness.util.LoadImage.loadIntoUseFitWidth;
/**
 * Created by Administrator on 2017/8/4.
 * 视频 播放页面
 */
public class VideoPlayActivity extends AppCompatActivity {

    @BindView(R.id.view_play_viodeo)
    VideoView viewPlayViodeo;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);        // 隐藏标题栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);  // 隐藏状态栏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_video_play);
        ButterKnife.bind(this);

//        toolbar.setNavigationIcon(R.mipmap.left);
//
//        toolbar.setTitle("");


        Intent intent = getIntent();



        //本地的视频 需要在手机SD卡根目录添加一个 fl1234.mp4 视频
//        String videoUrl1 = Environment.getExternalStorageDirectory().getPath()+"/fl1234.mp4" ;

        //网络视频
        String videoUrl =  intent.getStringExtra("com.example.gufei.bigfitness.com.GuFei.url");

        Uri uri = Uri.parse(videoUrl);


        //设置视频控制器
        viewPlayViodeo.setMediaController(new MediaController(this));

        //播放完成回调
        viewPlayViodeo.setOnCompletionListener(new MyPlayerOnCompletionListener());

        //设置视频路径
        viewPlayViodeo.setVideoURI(uri);

        //开始播放视频
        viewPlayViodeo.start();

    }
    /**
     * 播放状态
     * 提示播放完成
     * */
    class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
            Toast.makeText(VideoPlayActivity.this, "播放完成了", Toast.LENGTH_SHORT).show();
        }
    }
}
