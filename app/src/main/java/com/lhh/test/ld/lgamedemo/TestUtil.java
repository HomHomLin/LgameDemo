package com.lhh.test.ld.lgamedemo;

import android.graphics.PointF;

import java.util.Random;

/**
 * Created by kascend on 2015/8/25.
 */
public class TestUtil {
    private int mHeight;//控件的高度
    private int mWidth;//控间的宽度
    private Random mRandom;
    private PointF pointF1;
    private PointF pointF2;
    private float time = 0;

    public TestUtil(int height, int width){
        mHeight = height;
        mWidth = width;
        time = 0;
        mRandom = new Random();
        pointF1 = getPointF(2);
        pointF2 = getPointF(1);

    }
    /**
     * 获取间断点
     * @param scale
     */
    public PointF getPointF(int scale) {

        PointF pointF = new PointF();
        pointF.x = mRandom.nextInt((mWidth - 100));
        pointF.y = mRandom.nextInt((mHeight - 100))/scale;
        return pointF;
    }

    public PointF evaluate(PointF startValue,
                           PointF endValue) {

        float timeLeft = 1.0f - time;

        PointF point = new PointF();

        //PointF point0 = startValue;

        //PointF point3 = endValue;

        float time1 = timeLeft * timeLeft * timeLeft;
        float time2 = 3 * timeLeft * timeLeft * time;
        float time3 = 3 * timeLeft * time * time;
        float time4 = time * time * time;
        point.x = time1 * (startValue.x)
                + time2 * (pointF1.x)
                + time3 * (pointF2.x)
                + time4 * (endValue.x);

        point.y = time1 * (startValue.y)
                + time2 * (pointF1.y)
                + time3 * (pointF2.y)
                + time4 * (endValue.y);
        time = time + 0.01f;
        return point;
    }
}
