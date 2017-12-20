package com.example.fostersoftsol01.luvoffers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.example.fostersoftsol01.luvoffers.Animation.Accordion;
import com.example.fostersoftsol01.luvoffers.Animation.DemoAnimation;
import com.example.fostersoftsol01.luvoffers.Animation.ScrollTouchListener;

import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Created by fostersoftsol01 on 3/5/17.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewHolder>  {

    private List<ItemObject> itemList;
    private Context context;
    Animation animSlideUp;

    private boolean touching = false;
    private boolean scrolling = false;
    private double x = 0;
    private double y = 0;

    private double scrollPositionX = 0;
    private double scrollPositionY = 0;





    private double scrollProgress = 0.0;
    private double topViewScaleFactor = 2.0;
    private double collapsedViewHeight = 200.0;
    private double expandedViewHeight = 700.0;
    private double scrollProgressPerView = expandedViewHeight;



    //ScrollTouchListener scrollTouchListener = new ScrollTouchListener();;


    public RecycleViewAdapter(Context context, List<ItemObject> itemList) {
        this.itemList = itemList;
        this.context = context;

    }

//    public RecycleViewAdapter(Accordion accordion) {
//
//    }

//    public RecycleViewAdapter(ScrollTouchListener scrollTouchListener) {
//
////        scrollTouchListener = new ScrollTouchListener();
//
//       // scrollTouchListener.onTouch();
//        scrollTouchListener.getScrollPositionX();
//        scrollTouchListener.getScrollPositionY();
//        scrollTouchListener.setScrollPositionX(1.0);
//        scrollTouchListener.setScrollPositionY(1.0);
//        scrollTouchListener.onScroll(1.0,0.2,1.0,0.2);
//        scrollTouchListener.onScrollStarted(0.2,1.0);
//        scrollTouchListener.onScrollEnded(0.2,1.0);
//        scrollTouchListener.onClick(0.2,1.0);
//
//    }

//    public RecycleViewAdapter(MainActivity mainActivity) {
//
//    }

    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, null);
        RecycleViewHolder rcv = new RecycleViewHolder(layoutView);



        return rcv;

     }

    @Override
    public void onBindViewHolder(RecycleViewHolder holder, int position) {

        holder.tvHeaderTitle.setText(itemList.get(position).getName());
        holder.tvHeaderSubTitle.setText(itemList.get(position).getSubValue());
        holder.tvSubText.setText(itemList.get(position).getSubValueText());
        holder.imgHeader.setImageResource(itemList.get(position).getPhoto());

//        final Animation myAnim = AnimationUtils.loadAnimation(context, R.anim.bounce);
//        holder.imgHeader.startAnimation(myAnim);




//        onTouch();


//        if(position==visibleChildCount/2)
//        {
//            int visibleChildCount = (listView1.getLastVisiblePosition() - listView1.getFirstVisiblePosition()) + 1;
//        }

//        animate();
//        animSlideUp.getFillBefore();
//        animSlideUp.getFillAfter();

    }



    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

//    private void animate() {
////        ImageView imageView = (ImageView)findViewById(R.id.imgHeader);
//        ScaleAnimation scale = new ScaleAnimation((float)1.0, (float)1.5, (float)1.0, (float)1.5);
//        scale.setFillAfter(true);
//        scale.setDuration(500);
//       // imgHeader.startAnimation(scale);
//    }

//    public boolean onTouch(View view, MotionEvent event) {
//
//
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                x = event.getX();
//                y = event.getY();
//                touching = true;
//                return true;
//
//            case MotionEvent.ACTION_UP:
//                touching = false;
//                if(scrolling) {
//                    scrolling = false;
//                    onScrollEnded(scrollPositionX, scrollPositionY);
//                } else {
//                    onClick(x, y);
//                }
//                return true;
//
//            case MotionEvent.ACTION_MOVE:
//                double newX = event.getX();
//                double newY = event.getY();
//
//                double difX =  x - newX;
//                double difY =  y - newY;
//
//                if (scrolling) {
//                    performScroll(difX, difY);
//                } else if(difX > 0 || difY > 0)  {
//                    scrolling = true;
//                    onScrollStarted(scrollPositionX, scrollPositionY);
//                    performScroll(difX, difY);
//                }
//
//                x = newX;
//                y = newY;
//                return true;
//
//            default:
//                return false;
//        }
//    }
//    public void onScrollStarted(double scrollPositionX, double scrollPositionY) {
//
//    }
//
//    public void onScroll(double scrollPositionX, double scrollPositionY, double deltaX, double deltaY) {
//
//    }
//
//    public void onScrollEnded(double scrollPositionX, double scrollPositionY) {
//
//    }
//
//    public void onClick(double x, double y) {
//
//    }
//    private void performScroll(double difX, double difY) {
//        scrollPositionX += difX;
//        scrollPositionY += difY;
//
//        onScroll(scrollPositionX, scrollPositionY, difX, difY);
//    }
//
//    public double getScrollPositionX() {
//        return scrollPositionX;
//    }
//
//    public void setScrollPositionX(double scrollPositionX) {
//        this.scrollPositionX = scrollPositionX;
//    }
//
//    public double getScrollPositionY() {
//        return scrollPositionY;
//    }
//
//    public void setScrollPositionY(double scrollPositionY) {
//        this.scrollPositionY = scrollPositionY;
//    }

//    animSlideUp = AnimationUtils.loadAnimation(getApplicationContext(),
//    R.anim.slide_up);
//        animSlideUp.setAnimationListener(this);


//    @Override
//    public int getItemCount() {
//        return this.itemList.size();
//    }
//
//    @Override
//    public void onAnimationStart(Animation animation) {
//
//    }
//
//    @Override
//    public void onAnimationEnd(Animation animation) {
//
//    }
//
//    @Override
//    public void onAnimationRepeat(Animation animation) {
//
//    }
}
