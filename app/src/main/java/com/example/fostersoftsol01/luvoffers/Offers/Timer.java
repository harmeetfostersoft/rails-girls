package com.example.fostersoftsol01.luvoffers.Offers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fostersoftsol01.luvoffers.MainActivity;
import com.example.fostersoftsol01.luvoffers.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Timer extends AppCompatActivity {

    private TextView tvcheckTime,tvContinue;
    private ImageView imgMenu;

    protected ListView mDrawerList;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

       // getLayoutInflater().inflate(R.layout.activity_timer, frameLayout);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        tvcheckTime  = (TextView)findViewById(R.id.tvcheckTime);
        tvContinue  = (TextView)findViewById(R.id.tvContinue);
        getCurrentDate();


        imgMenu = (ImageView)findViewById(R.id.imgMenu);

        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mDrawerLayout.isDrawerOpen(mDrawerList)){
                    mDrawerLayout.closeDrawer(mDrawerList);
                }else {
                    mDrawerLayout.openDrawer(mDrawerList);
                }
            }
        });
        tvContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Timer.this,MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                finish();
            }
        });
    }
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        this.finish();
//    }


    public void getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("yyyy / MM / dd ");
        String strDate = "" + mdformat.format(calendar.getTime());
        tvcheckTime.setText(strDate);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i=new Intent(this,MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        finish();
    }


}
