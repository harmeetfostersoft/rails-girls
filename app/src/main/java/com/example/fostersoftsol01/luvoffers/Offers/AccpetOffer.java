package com.example.fostersoftsol01.luvoffers.Offers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fostersoftsol01.luvoffers.MainActivity;
import com.example.fostersoftsol01.luvoffers.R;
import com.example.fostersoftsol01.luvoffers.Util.Constent;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.example.fostersoftsol01.luvoffers.Util.Constent.TIME_COUNT;

public class AccpetOffer extends AppCompatActivity {


    private Button btnOffers;
    private TextView tvcheckTime,tvHours,tvMint,tvSec,tvContinue;
    String date_time;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    EditText et_hours;
    private Handler handler;

    SharedPreferences sharedpreferences;
    SharedPreferences.Editor mEditor;
    RelativeLayout relativeViewOffer,relativeViewTimer;
    private int mSec=01,mMint=59,mHour=23,mMiliSec=113;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accpet_offer);

        sharedpreferences = getApplicationContext().getSharedPreferences(Constent.MY_PREF, Context.MODE_PRIVATE);
        String strTime = sharedpreferences.getString(Constent.TIME_COUNT, Constent.NO_VALUE);
        String Time = Constent.TIME_COUNT.toString();

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Constent.TIME_COUNT, Time);

        editor.commit();

        Log.e("Time", Time);
        findIds();
        sharedpreferences = getApplicationContext().getSharedPreferences(Constent.MY_PREF, Context.MODE_PRIVATE);
        mEditor = sharedpreferences.edit();

//        getName();
//        try {
//            String str_value = sharedpreferences.getString("data", "");
//            if (str_value.matches("")) {
//                et_hours.setEnabled(true);
//                btnOffers.setEnabled(true);
//                tvcheckTime.setText("");
//
//            } else {
//
//                if (sharedpreferences.getBoolean("finish", false)) {
//                    et_hours.setEnabled(true);
//                    btnOffers.setEnabled(true);
//                    tvcheckTime.setText("");
//                } else {
//
//                    et_hours.setEnabled(false);
//                    btnOffers.setEnabled(false);
//                    tvcheckTime.setText(str_value);
//                }
//            }
//        } catch (Exception e) {

       // }


        btnOffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(getApplicationContext(),et_hours+"",Toast.LENGTH_SHORT).show();

                relativeViewTimer.setVisibility(View.VISIBLE);
                tvContinue.setVisibility(View.VISIBLE);
                relativeViewOffer.setVisibility(View.GONE);
                countDownStart();

//                if (et_hours.getText().toString().length() > 0) {
//
//                    int int_hours = Integer.valueOf(et_hours.getText().toString());
//
//                    if (int_hours<=24) {
//
//
//                        et_hours.setEnabled(false);
//                        btnOffers.setEnabled(false);
//
//                        calendar = Calendar.getInstance();
//                        simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
//                        date_time = simpleDateFormat.format(calendar.getTime());
//
//                        mEditor.putString("data", date_time).commit();
//                        mEditor.putString("hours", et_hours.getText().toString()).commit();
//
////                        Intent intent_service = new Intent(getApplicationContext(), Timer_Service.class);
////                        startService(intent_service);
//                    }else {
//                        Toast.makeText(getApplicationContext(),"Please select the value below 24 hours",Toast.LENGTH_SHORT).show();
//                    }
/*
                    mTimer = new Timer();
                    mTimer.scheduleAtFixedRate(new TimeDisplayTimerTask(), 5, NOTIFY_INTERVAL);*/
//                } else {
//                    Toast.makeText(getApplicationContext(), "Please select value", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }

    private void findIds() {

        btnOffers = (Button) findViewById(R.id.btnOffers);
        tvcheckTime = (TextView) findViewById(R.id.tvcheckTime);
        tvHours = (TextView) findViewById(R.id.tvHrs);
        tvContinue = (TextView) findViewById(R.id.tvContinue);
        tvMint = (TextView) findViewById(R.id.tvMin);
        tvSec = (TextView) findViewById(R.id.tvSec);
        et_hours = (EditText) findViewById(R.id.et_hours);
        relativeViewOffer = (RelativeLayout) findViewById(R.id.relativeViewOffer);
        relativeViewTimer = (RelativeLayout) findViewById(R.id.relativeViewTimer);

        tvContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccpetOffer.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                 finish();

            }
        });
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String str_time = intent.getStringExtra("time");
            tvcheckTime.setText(str_time);
        }
    };
    @Override
    protected void onResume() {
        super.onResume();
//        registerReceiver(broadcastReceiver,new IntentFilter(Timer_Service.str_receiver));
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        unregisterReceiver(broadcastReceiver);
//    }

    private void getName() {
        sharedpreferences = getApplicationContext().getSharedPreferences(Constent.MY_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        if (sharedpreferences.contains(TIME_COUNT)) {
            tvcheckTime.setText(sharedpreferences.getString(TIME_COUNT, ""));
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);
    }
    // //////////////COUNT DOWN START/////////////////////////
    public void countDownStart() {
        handler = new Handler();

        handler.postDelayed(runnable, 0);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (handler!=null)
           handler.removeCallbacks(runnable);
    }

//
//    runnable = new Runnable() {
//        @Override
//        public void run() {
//            handler.postDelayed(runnable, 0);
//            try {
//                if (mSec==0)
//                {
//                    mSec = 59;
//                    mMint =mMint-1;
//                }
//                if (mMint==0)
//                {
//                    mMint=59;
//                    mHour = mHour-1;
//                }
//                if (mHour==0)
//                {
//                    mHour = 23;
//                    mSec = 59;
//                    mMint = 59;
//                }
//
//                mSec = mSec - 1;
//
//                tvHours.setText("" + mHour);
//                tvMint.setText("" +  mMint);
//                tvSec.setText("" +  mSec);
//
//                handler.removeCallbacks(runnable);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            handler.post(runnable);
            try {
                if (mMiliSec==0)
                {
                    mMiliSec = 113;
                    mSec = mSec +1;
                }
                if (mSec==59)
                {
                    mSec = 01;
                    mMint =mMint-1;
                }
                if (mMint==0)
                {
                    mMint=59;
                    mHour = mHour-1;
                }
                if (mHour==0)
                {
                    mHour = 23;
                    mSec = 59;
                    mMint = 59;
                }

                mMiliSec = mMiliSec - 1;

                tvHours.setText("" + mHour);
                tvMint.setText("" +  mMint);
                if(mSec<10)
                     tvSec.setText("0" +  mSec);
                else
                    tvSec.setText("" +  mSec);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
}

