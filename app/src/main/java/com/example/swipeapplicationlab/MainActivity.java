package com.example.swipeapplicationlab;

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

        /**
         * the VideoPager2 obeject that will display the videos
         */
        final ViewPager2 videoViewPager = findViewById(R.id.videosViewPager);

        /**
         * A List that will contain all of the swipable videos
         */
        List<VideoItem> videoItemsList = new ArrayList<>();

        /**
         * The block of code that pulls the video from Firebase Storage,
         * and sets the title and description of the video associated with the link.
         * Afterwards it adds the new VideoItem object into the list
         * There is a block of code for every video that can be viewed.
         */
        VideoItem dbEdit1 = new VideoItem();

        dbEdit1.videoURL = "https://firebasestorage.googleapis.com/v0/b/video-app-6029f.appspot.com/o/182b35d1b24a9e27911f478526802e62.mp4?alt=media&token=5b926510-63c5-4004-9f03-699c97f096db";
        dbEdit1.videoTitle = "Strangers";
        dbEdit1.videoDescription = "Dragonball Super edit to Kendrick Lamar - Duckworth";

        videoItemsList.add(dbEdit1);


        VideoItem dbEdit2 = new VideoItem();

        dbEdit2.videoURL = "https://firebasestorage.googleapis.com/v0/b/video-app-6029f.appspot.com/o/1bb436fc1352515d9cfffe8f7a1a344b.mp4?alt=media&token=74b3c122-d2ed-47d9-b195-e52ac00ab39d";
        dbEdit2.videoTitle = "SpiritBomb";
        dbEdit2.videoDescription = "Dragonball Z edit of the Super Spirit Bomb from Namek";

        videoItemsList.add(dbEdit2);


        VideoItem wiseQuestGiver = new VideoItem();

        wiseQuestGiver.videoURL = "https://firebasestorage.googleapis.com/v0/b/video-app-6029f.appspot.com/o/29060aaa892f433ed1006bb0edc0f2ef.mp4?alt=media&token=01e1ad22-186a-43f0-a939-5543a4809c69";
        wiseQuestGiver.videoTitle = "Guest Giver";
        wiseQuestGiver.videoDescription = "A wise old quest giver stands ready to send you on your next journey";

        videoItemsList.add(wiseQuestGiver);

        videoViewPager.setAdapter(new VideoAdapter(videoItemsList));

        VideoItem dbEdit3 = new VideoItem();

        dbEdit3.videoURL = "https://firebasestorage.googleapis.com/v0/b/video-app-6029f.appspot.com/o/d0e4df6193851790c19a5b7bf3d6d513.mp4?alt=media&token=f59b7d68-cbc8-4f8f-88b9-4e17d65a7d47";
        dbEdit3.videoTitle = "Final Dragonball Edit";
        dbEdit3.videoDescription = "I kept getting dragonball edits im sorry";

        videoItemsList.add(dbEdit3);


    }
}