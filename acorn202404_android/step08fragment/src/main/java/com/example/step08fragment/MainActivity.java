package com.example.step08fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements MyFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 버튼의 참조값
        Button resetBtn = findViewById(R.id.resetBtn);

        // FragmentManager 객체의 참조값 얻어오기
        FragmentManager fm = getSupportFragmentManager();
        // MyFragment 객체의 참조값
        MyFragment fragment1 = (MyFragment) fm.findFragmentById(R.id.fragment1);
        MyFragment fragment2 = (MyFragment) fm.findFragmentById(R.id.fragment2);

        resetBtn.setOnClickListener(v -> {
            fragment1.reset();
            fragment2.reset();
        });

        // 이동버튼을 눌렀을 때 SubActivity로 이동하기
        Button moveBtn = findViewById(R.id.moveBtn);
        moveBtn.setOnClickListener(v -> {
            Intent i = new Intent(this, SubActivity.class);
            startActivity(i);
        });
    }

    @Override
    public void setMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}