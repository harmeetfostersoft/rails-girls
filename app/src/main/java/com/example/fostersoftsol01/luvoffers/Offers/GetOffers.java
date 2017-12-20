//package com.example.fostersoftsol01.luvoffers.Offers;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//
//import com.example.fostersoftsol01.luvoffers.R;
//
//public class GetOffers extends AppCompatActivity {
//
//    private Button btnOffers;
//    private RelativeLayout relativeViewOffer,relativeViewTimer;
//    private ImageView imgBack,imgBackTimer;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_get_offers);
//
//        relativeViewOffer =(RelativeLayout)findViewById(R.id.relativeViewOffer);
//        relativeViewTimer =(RelativeLayout)findViewById(R.id.relativeViewTimer);
//
//        btnOffers = (Button)findViewById(R.id.btnOffers);
//        imgBack = (ImageView)findViewById(R.id.imgBack);
//        imgBackTimer = (ImageView)findViewById(R.id.imgBackTimer);
//
//
//
//        btnOffers.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//        imgBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//    }
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        this.finish();
//    }
//}
