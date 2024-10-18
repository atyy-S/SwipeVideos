package com.example.swipevideo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /**
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final ViewPager2 videoViewPager= findViewById(R.id.videosViewPager);

//video that will be play
        List<videoItem> videoItemList = new ArrayList<>();
        videoItem videoDog =new videoItem();
        videoDog.videoURL="https://firebasestorage.googleapis.com/v0/b/video-b326b.appspot.com/o/95a841343acd4baca572868543f610b4.MP4?alt=media&token=02733d76-8df6-433b-93b5-ec8ccfa4661";
        videoDog.videoTitle="Cute dog";
        videoDog.videoDescription=" Dancing dog";
        videoDog.videoId="#19922711";
        videoItemList.add(videoDog);

        videoItem videoChrist =new videoItem();
        videoChrist.videoURL="https://firebasestorage.googleapis.com/v0/b/video-b326b.appspot.com/o/v0f044gc0000cqr1hcfog65ip4bnq4h0.MP4?alt=media&token=f12ca426-9831-49a3-a775-c70df9ae9acd";
        videoChrist.videoTitle="The choosen edit";
        videoChrist.videoDescription=" The reason why Jesus didn't heal little John";
        videoChrist.videoId="#19922109";
        videoItemList.add(videoChrist);

        videoItem videoHP=new videoItem();
        videoHP.videoURL="https://firebasestorage.googleapis.com/v0/b/video-b326b.appspot.com/o/v10044g50000cphdou7og65j1g4e1qog.MP4?alt=media&token=99d50953-ba0f-4a22-b9f2-22999c11de0e";
        videoHP.videoTitle="Draco";
        videoHP.videoDescription="Draco edit";
        videoHP.videoId="#19931201";
        videoItemList.add(videoHP);

        videoItem videoHP2=new videoItem();
        videoHP2.videoURL="https://firebasestorage.googleapis.com/v0/b/video-b326b.appspot.com/o/v10044g50000cphdou7og65j1g4e1qog.MP4?alt=media&token=99d50953-ba0f-4a22-b9f2-22999c11de0e";
        videoHP2.videoTitle="Draco";
        videoHP2.videoDescription="Draco edit number 2";
        videoHP2.videoId="#19920404";
        videoItemList.add(videoHP2);

        videoViewPager.setAdapter(new videoAdapter(videoItemList));

    }
}