package com.lhh.test.ld.lgamedemo;

import android.content.Context;
import android.graphics.PixelFormat;
import android.opengl.GLSurfaceView;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import loon.LGame;
import loon.LSetting;
import loon.LSystem;
import loon.core.graphics.opengl.LTexture;


public class MainActivity extends LGame{

    @Override
    public void onMain() {

        View view = this.inflate(R.layout.activity_main);
        this.getFrameLayout().addView(view);

        WindowManager windowManager = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
        int mScreenWidth = windowManager.getDefaultDisplay().getWidth();
        int mScreenHeight = windowManager.getDefaultDisplay().getHeight();

        this.initialization(mScreenWidth,mScreenHeight,true,LMode.Fill);




        TestScreen ts = new TestScreen();
//        LTexture lt = new LTexture("assets/gameover.png");
//        ts.setBackground(lt);

        this.setScreen(ts);

//        this.setFPS(50);

        this.setShowFPS(true);

        this.setShowLogo(false);

//
//        ((GLSurfaceView)this.gameView().getView()).setZOrderOnTop(true);
//        ((GLSurfaceView)this.gameView().getView()).setEGLConfigChooser(8, 8, 8, 8, 16, 0);
//        ((GLSurfaceView)this.gameView().getView()).getHolder().setFormat(PixelFormat.TRANSLUCENT);

        this.showScreen();

//        ((TextView)this.findViewById(R.id.tv)).setText("hello");

    }

    @Override
    public void onGameResumed() {

    }

    @Override
    public void onGamePaused() {

    }
}