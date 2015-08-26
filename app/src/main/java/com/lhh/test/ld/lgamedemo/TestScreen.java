package com.lhh.test.ld.lgamedemo;

import android.graphics.PointF;
import android.util.Log;

import loon.LTouch;
import loon.action.sprite.Sprite;
import loon.action.sprite.Sprites;
import loon.core.graphics.Screen;
import loon.core.graphics.device.LColor;
import loon.core.graphics.opengl.GLEx;
import loon.core.graphics.opengl.LTexture;
import loon.core.timer.LTimerContext;

/**
 * Created by kascend on 2015/8/24.
 */
public class TestScreen extends Screen {

    private Sprites sprMgr = null;
    private Sprite sprite = null;

    private int x = 50;
    private int y = 250;

    private PointF startP, endP;


    public TestScreen(){
        super();

        startP = new PointF(getHalfWidth(),getHeight());
        endP = new PointF(0,0);

        sprMgr = new Sprites();

        Log.v("screen",getWidth() + " : " + getHeight());

    }

    @Override
    public void draw(GLEx glEx) {
//        glEx.setAlpha(0);
//        glEx.drawTexture(lt,0,0);
//        glEx.drawString("Hello",100,100);
        sprMgr.createUI(glEx);
        for(int i = 0 ; i < sprMgr.size(); i ++){
            Sprite s = (Sprite)sprMgr.getSprite(i);
            PointF p = ((TestUtil)s.getTag()).evaluate(startP,endP);
            s.setLocation(p.x,p.y);
        }


        sprMgr.update(100);
    }

    @Override
    public void alter(LTimerContext lTimerContext) {

    }

    @Override
    public void touchDown(LTouch lTouch) {

    }

    @Override
    public void touchUp(LTouch lTouch) {
        Sprite sprite = new Sprite("assets/default_gift_color.png");
        sprite.setLocation(x, y);
        TestUtil tu = new TestUtil(getHeight(),getWidth());
        sprite.setTag(tu);
        sprMgr.add(sprite);
    }

    @Override
    public void touchMove(LTouch lTouch) {

    }

    @Override
    public void touchDrag(LTouch lTouch) {

    }
}
