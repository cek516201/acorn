package com.example.step09gameview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class GameView extends View {
    //배경이미지 정보를 담을 Bitmap 객체
    Bitmap backImg;
    //화면의 폭과 높이
    int width, height;
    //배경이미지의 y 좌표
    int back1Y, back2Y;
    //유닛(드레곤, 적기) 의 크기를 저장할 필드
    int unitSize;
    //드레곤의 좌표를 저장할 필드
    int dragonX, dragonY;
    //드레곤 이미지 (임시)
    Bitmap dragonImg1;

    public GameView(Context context) {
        super(context);
    }

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    //화면을 주기적으로 갱신하기 위한 Handler 객체
    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            //화면 refresh
            invalidate(); //GameView 의 메소드를 호출해서 View 가 다시 그려지도록 한다
            // 10/1000 초 이후에 다시 Handler 객체에 메세지를 보낸다
            handler.sendEmptyMessageDelayed(0, 10);
        }
    };

    //초기화 메소드
    public void init() {
        //초기화 후에

        //원본 배경이미지 읽어들이기
        Bitmap backImg = BitmapFactory.decodeResource(getResources(), R.drawable.backbg);
        //배경이미지를 View 의 크기에 맞게 조절해서 필드에 저장
        this.backImg = Bitmap.createScaledBitmap(backImg, width, height, false);
        //드레곤 이미지 로딩
        Bitmap dragonImg1 =
                BitmapFactory.decodeResource(getResources(), R.drawable.unit1);
        this.dragonImg1 = Bitmap.createScaledBitmap(dragonImg1, unitSize, unitSize, false);

        //Handler 객체에 메세지를 보내서 지속적으로 View 가 다시 그려지도록 한다.
        handler.sendEmptyMessageDelayed(0, 10);
    }

    //화면(View) 구성 하는 메소드
    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        //배경 이미지 그리기
        canvas.drawBitmap(backImg, 0, back1Y, null);
        canvas.drawBitmap(backImg, 0, back2Y, null);
        //드레곤 이미지 그리기
        canvas.drawBitmap(dragonImg1, dragonX - unitSize / 2, dragonY - unitSize / 2, null);

        back1Y += 3;
        back2Y += 3;
        //만일 첫번째 배경이미지가 아래쪽 화면을 벋어났다면
        if (back1Y >= height) {
            //첫번째 배경이미지의 좌표를 다시 윗쪽으로 이동한다.
            back1Y = -height;
            back2Y = 0;
        }
        if (back2Y >= height) {
            back2Y = -height;
            back1Y = 0;
        }
    }

    //View 가 차지하는 크기 정보가 전달되는 메소드
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //화면의 폭과 높이를 필드에 저장한다 (이미지의 크기를 결정할때 필요)
        width = w;
        height = h;

        //배경이미지의 초기좌표
        back1Y = 0;
        back2Y = -height;
        //unitSize
        unitSize = width / 5;
        //드레곤의 초기 좌표 부여
        dragonX = width / 2; //좌우로 가운데 위치하게
        dragonY = height - unitSize / 2; //맨 아래쪽에 위치하게

        //초기화 메소드 호출
        init();
    }

    // View에 터치 이벤트 발생하면 호출되는 메소드
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        dragonX = (int) event.getX();
        dragonY = (int) event.getY();

        return true;
    }
}