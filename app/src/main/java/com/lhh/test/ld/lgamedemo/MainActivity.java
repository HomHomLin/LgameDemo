package com.lhh.test.ld.lgamedemo;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import loon.LGame;


public class MainActivity extends LGame{

    GiftScreen ts;

    ArrayList<GiftScreen> mGiftScreen;

    @Override
    public void onMain() {

        mGiftScreen = new ArrayList<>();

        View view = this.inflate(R.layout.activity_main);
        this.getFrameLayout().addView(view);

        WindowManager windowManager = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
        final int mScreenWidth = windowManager.getDefaultDisplay().getWidth();
        final int mScreenHeight = windowManager.getDefaultDisplay().getHeight();

        this.initialization(mScreenWidth,mScreenHeight,true,LMode.Fill,false);

        ts = new GiftScreen(this,5);
//        LTexture lt = new LTexture("assets/gameover.png");
//        ts.setBackground(lt);

        this.setScreen(ts);

        this.setDestroy(false);//不强制关闭整个app

//        this.setFPS(30);

        this.setShowFPS(true);

        this.setShowLogo(false);

//        this.gameView().getView().setVisibility(View.GONE);


//
//        ((GLSurfaceView)this.gameView().getView()).setZOrderOnTop(true);
//        ((GLSurfaceView)this.gameView().getView()).setEGLConfigChooser(8, 8, 8, 8, 16, 0);
//        ((GLSurfaceView)this.gameView().getView()).getHolder().setFormat(PixelFormat.TRANSLUCENT);

        this.showScreen();
        Button btn = (Button)findViewById(R.id.main_test);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ts.setRunning(true);
                MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                MainActivity.this.gameView().getView().setLayoutParams(new RelativeLayout.LayoutParams(mScreenHeight,mScreenWidth));
                maxScreen(mScreenHeight,mScreenWidth);
            }
        });


//        ((TextView)this.findViewById(R.id.tv)).setText("hello");

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){

        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onGameResumed() {

    }

    @Override
    public void onGamePaused() {

    }
}