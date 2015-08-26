package com.lhh.test.ld.lgamedemo;

import android.graphics.Color;
import android.graphics.PointF;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

import loon.LTouch;
import loon.action.sprite.Sprite;
import loon.action.sprite.Sprites;
import loon.core.graphics.Screen;
import loon.core.graphics.device.LColor;
import loon.core.graphics.device.LFont;
import loon.core.graphics.opengl.GL;
import loon.core.graphics.opengl.GLEx;
import loon.core.graphics.opengl.LTexture;
import loon.core.timer.LTimerContext;

/**
 * Created by kascend on 2015/8/24.
 */
public class TestScreen extends Screen {

    private Sprites sprMgr = null;
    private Sprite sprite = null;
    private ArrayList<LTexture> lts;
//    LTexture lt ;
    private Random mRandom;

    private float string_x;
    private float string_y;


    public TestScreen(){
        super();
        lts = new ArrayList<>();
        for(int i = 0 ; i < 22; i ++){
            LTexture lt = new LTexture("assets/zhenzhu_" + (i+1) + ".png");
            lts.add(lt);
        }
//        lt = new LTexture("assets/400.jpg");
        sprite = new Sprite(lts,800);
        sprite.setLocation(150,600);

        sprMgr = new Sprites();
        mRandom = new Random();


        Log.v("screen",getWidth() + " : " + getHeight());
        new Thread(runnable).start();
        string_y = 600;
        string_x = getWidth();

    }

    private int flag = -3;

    @Override
    public void draw(GLEx glEx) {
//        glEx.setAlpha(0);
//        glEx.drawTexture(lt,20,getHalfHeight());
        glEx.setFont(LFont.getFont(50));
//        glEx.setBlendMode(GL.MODE_NONE);
        glEx.setAntiAlias(true);

//        glEx.drawString("红红送给带头大哥一颗珍珠", string_x, string_y,LColor.red);
        glEx.drawStyleString("红红送给带头大哥一颗珍珠", string_x, string_y, Color.RED,Color.WHITE,3);

        if(string_x <= 0){
            flag = 3;

        }else if(string_x >= getWidth()){
            flag = -3;
        }

        string_x = string_x + flag;

        sprMgr.createUI(glEx);
        sprite.createUI(glEx);
        for(int i = 0 ; i < sprMgr.size(); i ++){
            Sprite s = (Sprite)sprMgr.getSprite(i);
            float x = s.getX();
            float y = s.getY();
            if(y < 0 ){
                sprMgr.remove(i);
                continue;
            }
            PointF p = ((TestUtil)s.getTag()).evaluate();
            s.setLocation(p.x,p.y);
        }


        sprMgr.update(100);
        sprite.update(150);
    }

    @Override
    public void alter(LTimerContext lTimerContext) {

    }

    @Override
    public void touchDown(LTouch lTouch) {

    }

    @Override
    public void touchUp(LTouch lTouch) {
//        int x = mRandom.nextInt(getWidth());
//        PointF startP = new PointF(x,getHeight());
//        PointF endP = new PointF(x,0);
//        Sprite sprite = new Sprite("assets/paopao.png");
//        sprite.setLocation(startP.x, startP.y);
//
//        TestUtil tu = new TestUtil(getHeight(),getWidth(),startP,endP);
//        sprite.setTag(tu);
//        sprMgr.add(sprite);
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            while(true) {
                int x = mRandom.nextInt(getWidth());
                PointF startP = new PointF(x, getHeight());
                PointF endP = new PointF(x, 0);
                Sprite sprite = new Sprite("assets/paopao.png");
                sprite.setLocation(startP.x, startP.y);

                TestUtil tu = new TestUtil(getHeight(), getWidth(), startP, endP);
                sprite.setTag(tu);
                sprMgr.add(sprite);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
