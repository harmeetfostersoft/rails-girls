package com.example.fostersoftsol01.luvoffers.Animation;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.fostersoftsol01.luvoffers.R;
import com.example.fostersoftsol01.luvoffers.RecycleViewAdapter;

/**
 * Created by fostersoftsol01 on 16/5/17.
 */

public class Accordion extends LinearLayout {

    private static final String LOG_TAG = Accordion.class.getSimpleName();

    private double scrollProgress = 0.0;
    private double topViewScaleFactor = 2.0;
    private double collapsedViewHeight = 200.0;
    private double expandedViewHeight = 700.0;
    private double scrollProgressPerView = expandedViewHeight;

//    RecycleViewAdapter adapter = new RecycleViewAdapter(this);


    private final ScrollTouchListener touchListener = new ScrollTouchListener() {
        @Override
        protected void onScroll(float x, float y) {
            scrollProgress += y;
            if(scrollProgress < 0.0) {
                scrollProgress = 0.0;
            }

            int viewCount = getChildCount();
            double maxScrollProgress = (viewCount - 1) * scrollProgressPerView + 1;
            if(scrollProgress > maxScrollProgress) {
                scrollProgress = maxScrollProgress;
            }

            Log.i(LOG_TAG, String.format("Scroll Progress: %f", scrollProgress));

            updateChildViews();
        }
    };

    public Accordion(Context context) {
        super(context);

        this.setOnTouchListener(this.touchListener);
    }

    public Accordion(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.setOnTouchListener(this.touchListener);
    }

    public Accordion(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        this.setOnTouchListener(this.touchListener);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        updateChildViews();
    }

    public void updateChildViews() {
        int viewCount = getChildCount();
        double progress = scrollProgress;
        double overflow = 0;
        for(int i = 0; i < viewCount; i++) {
            View child = getChildAt(i);
            if(child != null) {
                if(progress >= scrollProgressPerView) {
                    progress -= scrollProgressPerView;
                    child.setVisibility(View.GONE);
                    setChildHeight(child, 0);
                } else if (progress > 0) {
                    setChildHeight(child, expandedViewHeight - progress);
                    overflow = progress;
                    child.setVisibility(View.VISIBLE);
                    progress = 0;
                } else {
                    if(overflow > 0) {
                        double height = collapsedViewHeight + overflow;
                        if(height > expandedViewHeight) {
                            height = expandedViewHeight;
                        }
                        setChildHeight(child, height);
                        overflow = 0;
                    } else {
                        setChildHeight(child, i > 0 ? collapsedViewHeight : expandedViewHeight);
                    }
                    child.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    private void setChildHeight(View child, double height) {
        child.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)height));
    }

    public static abstract class ScrollTouchListener implements OnTouchListener {

        private static final String LOG_TAG = ScrollTouchListener.class.getSimpleName();

        private boolean scrolling = false;
        private float x = 0;
        private float y = 0;

        @Override
        public boolean onTouch(View view, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    x = event.getX();
                    y = event.getY();
                    scrolling = true;
                    return true;

                case MotionEvent.ACTION_UP:
                    scrolling = false;
                    return true;

                case MotionEvent.ACTION_MOVE:
                    if (scrolling) {
                        float newX = event.getX();
                        float newY = event.getY();

                        float difX =  x - newX;
                        float difY =  y - newY;
                        onScroll(difX, difY);

                        x = newX;
                        y = newY;
                    }
                    return true;

                default:
                    return false;
            }
        }

        protected abstract void onScroll(float x, float y);
    }

}
