package com.example.fostersoftsol01.luvoffers.Animation;

import android.view.MotionEvent;
import android.view.View;

import com.example.fostersoftsol01.luvoffers.RecycleViewAdapter;

/**
 * Created by fostersoftsol01 on 19/5/17.
 */

public class ScrollTouchListener implements View.OnTouchListener {

    private boolean touching = false;
    private boolean scrolling = false;
    private double x = 0;
    private double y = 0;

    private double scrollPositionX = 0;
    private double scrollPositionY = 0;


    @Override
    public boolean onTouch(View view, MotionEvent event) {


        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x = event.getX();
                y = event.getY();
                touching = true;
                return true;

            case MotionEvent.ACTION_UP:
                touching = false;
                if(scrolling) {
                    scrolling = false;
                    onScrollEnded(scrollPositionX, scrollPositionY);
                } else {
                    onClick(x, y);
                }
                return true;

            case MotionEvent.ACTION_MOVE:
                double newX = event.getX();
                double newY = event.getY();

                double difX =  x - newX;
                double difY =  y - newY;

                if (scrolling) {
                    performScroll(difX, difY);
                } else if(difX > 0 || difY > 0)  {
                    scrolling = true;
                    onScrollStarted(scrollPositionX, scrollPositionY);
                    performScroll(difX, difY);
                }

                x = newX;
                y = newY;
                return true;

            default:
                return false;
        }
    }

    public void onScrollStarted(double scrollPositionX, double scrollPositionY) {

    }

    public void onScroll(double scrollPositionX, double scrollPositionY, double deltaX, double deltaY) {

    }

    public void onScrollEnded(double scrollPositionX, double scrollPositionY) {

    }

    public void onClick(double x, double y) {

    }

    private void performScroll(double difX, double difY) {
        scrollPositionX += difX;
        scrollPositionY += difY;

        onScroll(scrollPositionX, scrollPositionY, difX, difY);
    }

    public double getScrollPositionX() {
        return scrollPositionX;
    }

    public void setScrollPositionX(double scrollPositionX) {
        this.scrollPositionX = scrollPositionX;
    }

    public double getScrollPositionY() {
        return scrollPositionY;
    }

    public void setScrollPositionY(double scrollPositionY) {
        this.scrollPositionY = scrollPositionY;
    }

}
