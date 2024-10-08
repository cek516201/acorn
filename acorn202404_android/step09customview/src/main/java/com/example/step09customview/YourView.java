package com.example.step09customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

// Custom View 만들기
// 1. View 클래스를 상속받는다
// 2. 생성자 정의하기
// 3. onDraw() 메소드를 오버라이드해서 화면을 구성한다

public class YourView extends View {
    int x = 10;
    Paint p;
    int textWidth;
    int viewWidth;

    // layout xml 없이 단독으로 화면 전체를 채울때
    public YourView(Context context) {
        super(context);
        init();
    }

    public YourView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            x += 5;
            if (x >= viewWidth) {
                x = -textWidth;
            }

            invalidate();
            handler.sendEmptyMessageDelayed(0, 10);
        }
    };

    public void init() {
        handler.sendEmptyMessageDelayed(0, 10);

        // 글자 출력하기
        p = new Paint();
        p.setColor(Color.RED);
        p.setTextSize(100);
        // 글자의 넓이 알아내기
        textWidth = (int) p.measureText("Hello");
    }

    // 매개변수로 전달되는 Canvas 객체를 이용해서 그림을 그리면 그린 내용이 화면에 나타난다
    // 그림 -> 글자, 도형, 페인트, 이미지 ...
    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        canvas.drawColor(Color.YELLOW);

        canvas.drawText("Hello", x, 110, p);
    }

    // View가 최초 화면에 출력될때 호출되고 View의 크기가 변경될때 다시 호출된다
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        viewWidth = w;
    }
}