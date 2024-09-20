package com.example.step09gameview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameActivity extends AppCompatActivity {
    SoundManager sManager;
    public static final int SOUND_LAZER = 1;
    public static final int SOUND_SHOOT = 2;
    public static final int SOUND_BIRDDIE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //GameView 객체를 생성해서
        GameView gView = new GameView(this);
        //GameView 로 화면을 모두 채운다.
        setContentView(gView);

        sManager = new SoundManager(this);
        gView.soundManager = sManager;
    }

    // onCreate() 다음으로 호출
    @Override
    protected void onStart() {
        super.onStart();
        sManager.addSound(SOUND_LAZER, R.raw.laser1);
        sManager.addSound(SOUND_SHOOT, R.raw.shoot1);
        sManager.addSound(SOUND_BIRDDIE, R.raw.birddie);
    }

    @Override
    protected void onStop() {
        super.onStop();
        sManager.release();
    }
}