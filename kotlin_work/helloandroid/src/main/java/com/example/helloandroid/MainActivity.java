package com.example.helloandroid;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// 액티비티는 화면 하나를 제어하는 컨트롤러
public class MainActivity extends AppCompatActivity {
    // MainActivity가 활성화될때 onCrate() 메소드가 호출된다
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        // setContentView 메소드를 호출하면서 화면 구성을 어떤 xml 문서를 전개해서 구성할지 알려준다
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void send(View v) {
        Log.d("MainActivity", "click button");
        Toast.makeText(this, "버튼 누름", Toast.LENGTH_SHORT).show();
    }
}