package com.lhh.test.ld.lgamedemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

import loon.LTouch;
import loon.action.sprite.Label;
import loon.action.sprite.Sprite;
import loon.action.sprite.Sprites;
import loon.core.graphics.Screen;
import loon.core.graphics.device.LColor;
import loon.core.graphics.device.LFont;
import loon.core.graphics.device.LImage;
import loon.core.graphics.opengl.GL;
import loon.core.graphics.opengl.GLEx;
import loon.core.graphics.opengl.LTexture;
import loon.core.timer.LTimerContext;

/**
 * Created by linhonghong on 2015/8/24.
 */
public class GiftScreen extends Screen {

    private Sprites mSprMgr = null;
    private Sprite mSprite = null;//主珍珠动画
    LTexture lt ;
    private Random mRandom;

    private float string_x;
    private float string_y;
    private LTexture font;

    private boolean isRunning = true;

    public void setRunning(boolean isRunning){
        this.isRunning = isRunning;
        if(isRunning){
            initData();
        }else{
            mSprMgr.clear();
        }
    }

    public boolean isRunning(){
        return isRunning;
    }

    public Context mContext;

    public int mStr;


    public void initData(){
        mSprite.setCurrentFrameIndex(0);
        string_y = 600;
        string_x = getWidth();
        flag = -3;
    }


    public GiftScreen(Context context, int str){
        super();
        mStr = str;
        mContext = context;
        ArrayList<LTexture> lts = new ArrayList<>();
        for(int i = 0 ; i < 22; i ++){
            LTexture lt = new LTexture("assets/zhenzhu_" + (i+1) + ".png");
            lts.add(lt);
        }
        lt = new LTexture("assets/paopao.png");
        mSprite = new Sprite(lts,800);
        mSprite.setLocation(150,600);

        mSprMgr = new Sprites();
        mRandom = new Random();


        Log.v("screen",getWidth() + " : " + getHeight());
        new Thread(runnable).start();
        string_y = 600;
        string_x = getWidth();
        initBitmap();
        font = new LTexture(limage);
        initData();

    }

    private LImage limage;

    public void initBitmap() {
        String mstrTitle = "这是第" + mStr + "个场景";
        Bitmap bmp = Bitmap.createBitmap(1000, 150, Bitmap.Config.ARGB_8888);
        Canvas canvasTemp = new Canvas(bmp);
        canvasTemp.drawColor(Color.TRANSPARENT);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);

        String familyName = "宋体";
        Typeface font = Typeface.create(familyName, Typeface.BOLD);
        p.setTypeface(font);

        p.setTextSize(52);

        p.setColor(Color.parseColor("#ff5959"));
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(8);
        canvasTemp.drawText(mstrTitle, 0, 100, p);

        p.setColor(Color.WHITE);
        p.setStyle(Paint.Style.FILL);
        canvasTemp.drawText(mstrTitle, 0, 100, p);


        limage = new LImage(bmp);
    }

    private int flag = -3;

    @Override
    public void draw(GLEx glEx) {
        if(isRunning) {

            string_x = string_x + flag;

            mSprMgr.createUI(glEx);
            mSprite.createUI(glEx);
            for (int i = 0; i < mSprMgr.size(); i++) {
                Sprite s = (Sprite) mSprMgr.getSprite(i);
//                float x = s.getX();
                float y = s.getY();
                if (y < 0) {
                    mSprMgr.remove(i);
                    s = null;
                    continue;
                }
                PointF p = ((TestUtil) s.getTag()).evaluate();
                s.setLocation(p.x, p.y);
                s.update(100);
            }


//            sprMgr.update(100);
            mSprite.update(150);
            glEx.drawTexture(font, string_x, string_y);
            if (string_x <= 0) {
                flag = 3;
//                isRunning = false;

            } else if (string_x >= getWidth()) {
                flag = -3;
            }
        }
    }

    @Override
    public void alter(LTimerContext lTimerContext) {

    }

    @Override
    public void touchDown(LTouch lTouch) {

    }

    @Override
    public void touchUp(LTouch lTouch) {

    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            while(true) {
                if(isRunning) {

                    Log.i("test", "paopao");
                    int x = mRandom.nextInt(getWidth());
                    PointF startP = new PointF(x, getHeight());
                    PointF endP = new PointF(x, 0);
                    Sprite sprite = new Sprite(lt);
                    sprite.setLocation(startP.x, startP.y);

                    TestUtil tu = new TestUtil(getHeight(), getWidth(), startP, endP);
                    sprite.setTag(tu);
                    mSprMgr.add(sprite);
                    waitTime(150);
                }
            }
        }
    };

    @Override
    public void touchMove(LTouch lTouch) {

    }

    @Override
    public void touchDrag(LTouch lTouch) {

    }
}
