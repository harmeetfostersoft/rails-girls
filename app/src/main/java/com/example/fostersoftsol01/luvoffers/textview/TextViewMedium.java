package com.example.fostersoftsol01.luvoffers.textview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by Owner on 5/22/2017.
 */

public class TextViewMedium extends android.support.v7.widget.AppCompatTextView {

        public TextViewMedium(Context context) {
            super(context);
            Typeface face=Typeface.createFromAsset(context.getAssets(), "fonts/Montserrat-Medium.otf");
            this.setTypeface(face);
        }

        public TextViewMedium(Context context, AttributeSet attrs) {
            super(context, attrs);
            Typeface face=Typeface.createFromAsset(context.getAssets(), "fonts/Montserrat-Medium.otf");
            this.setTypeface(face);
        }

        public TextViewMedium(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            Typeface face=Typeface.createFromAsset(context.getAssets(), "fonts/Montserrat-Medium.otf");
            this.setTypeface(face);
        }

        protected void onDraw (Canvas canvas) {
            super.onDraw(canvas);


        }

    }
