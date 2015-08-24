package com.lhh.test.ld.lgamedemo;

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

    private  LTexture lt;
    private Sprites sprMgr = null;
    private Sprite sprite = null;

    private int x = 50;
    private int y = 250;

    public TestScreen(){
        super();
        lt = new LTexture("assets/gameover.png");
        sprite = new Sprite("assets/default_gift_color.png");

        sprite.setLocation(x, y);

        sprMgr = new Sprites();

        sprMgr.add(sprite);
    }

    @Override
    public void draw(GLEx glEx) {
//        glEx.setAlpha(0);
//        glEx.drawTexture(lt,0,0);
//        glEx.drawString("Hello",100,100);
        sprMgr.createUI(glEx);

        sprite.setLocation(  x , -- y);

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

    }

    @Override
    public void touchMove(LTouch lTouch) {

    }

    @Override
    public void touchDrag(LTouch lTouch) {

    }
}
