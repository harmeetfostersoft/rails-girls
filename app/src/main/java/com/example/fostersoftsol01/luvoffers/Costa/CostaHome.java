package com.example.fostersoftsol01.luvoffers.Costa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fostersoftsol01.luvoffers.Offers.AccpetOffer;
import com.example.fostersoftsol01.luvoffers.R;
import com.example.fostersoftsol01.luvoffers.Testnavigation.BaseActivity;

public class CostaHome extends BaseActivity {

    private TextView tvOfferLink;
    private ImageView imgMenu,imgBack,imgCostaLink;
    LinearLayout navigationMenu;
    private Button btnOffers,btnLater;

    protected ListView mDrawerList;
    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_costa_home);

        getLayoutInflater().inflate(R.layout.activity_costa_home, frameLayout);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        navigationMenu = (LinearLayout)findViewById(R.id.navigationMenu);

        imgMenu = (ImageView)findViewById(R.id.imgMenu);

        btnOffers = (Button)findViewById(R.id.btnOffers);
        btnLater = (Button)findViewById(R.id.btnLater);

        btnOffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CostaHome.this, AccpetOffer.class));      }
        });

        btnLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(CostaHome.this,MainActivity.class));
                finish();
            }
        });


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

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

}
