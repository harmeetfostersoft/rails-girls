package com.example.fostersoftsol01.luvoffers.Util;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by fostersoftsol01 on 18/5/17.
 */

public class Constent {
    public Context context;
    public static final String MY_PREF = "mypref";
    public static final String NO_VALUE = "no value";
    public static final String GREGGS = "GREGGS";
    public static final String COSTA = "COSTA COFFEE";
    public static final String NEXT = "NEXT";
    public static final String MCDONALDS = "MCDONALDS";
    public static final String MS = "M & S";
    public static final String DEBENHAMS = "DEBENHAMS";
    public static final String CLINTON = "CLINTON";
    public static final String TESCOEXTRA = "TESCO EXTRA";

    public static final String TIME_COUNT = "24";
    public Constent(Context context)
    {
     this.context = context;
    }
    public void setFontLight(TextView textView)
    {
        Typeface type = Typeface.createFromAsset(context.getAssets(),"fonts/Montserrat-Light.otf");
        textView.setTypeface(type);
    }
    public void setFontExtraBold(TextView textView)
    {
        Typeface type = Typeface.createFromAsset(context.getAssets(),"fonts/Montserrat-ExtraBold.otf");
        textView.setTypeface(type);
    }
    public void setFontExtraLight(TextView textView)
    {
        Typeface type = Typeface.createFromAsset(context.getAssets(),"fonts/Montserrat-ExtraLight.otf");
        textView.setTypeface(type);
    }
    public void setFontBold(TextView textView)
    {
        Typeface type = Typeface.createFromAsset(context.getAssets(),"fonts/Montserrat-Bold.otf");
        textView.setTypeface(type);
    }
    public void setFontMedium(TextView textView)
    {
        Typeface type = Typeface.createFromAsset(context.getAssets(),"fonts/Montserrat-Medium.otf");
        textView.setTypeface(type);
    }
    public void setFontRegular(TextView textView)
    {
        Typeface type = Typeface.createFromAsset(context.getAssets(),"fonts/Montserrat-Regular.otf");
        textView.setTypeface(type);
    }
    public void setFontSemiBold(TextView textView)
    {
        Typeface type = Typeface.createFromAsset(context.getAssets(),"fonts/Montserrat-SemiBold.otf");
        textView.setTypeface(type);
    }
}
