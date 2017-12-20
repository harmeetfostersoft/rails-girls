package com.example.fostersoftsol01.luvoffers.Offers;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.fostersoftsol01.luvoffers.R;

public class HowItWork extends AppCompatActivity {

    private Button btnThanks;
    private ImageView imgMenu;

    protected ListView mDrawerList;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_it_work);

       // getLayoutInflater().inflate(R.layout.activity_how_it_work, frameLayout);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);


        imgMenu = (ImageView)findViewById(R.id.imgMenu);
        btnThanks = (Button)findViewById(R.id.btnThanks);



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

        btnThanks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"Under Development",Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(HowItWork.this,MainActivity.class));
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
//        this.startActivity(intent);
    }
}
