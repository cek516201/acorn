package com.example.step10reactapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.step10reactapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding 객체 얻어오기
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // viwe binding  객체가 리턴해주는 view로 화면 구성하기
        setContentView(binding.getRoot());
        // 버튼을 눌렀을 때 실행할 함수 등록
        binding.enterBtn.setOnClickListener(view -> {
            // 액티비티 이동을 위한 Intent 객체 생성
            Intent intent = new Intent(this, ReactActivity.class);
            // 액티비티 이동하기
            startActivity(intent);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // zoom_in 애니메이션 로딩
        Animation zoom_in = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        // ImageView에 zoom_in 애니메이션 적용하기
        binding.imageView.startAnimation(zoom_in);
    }
}