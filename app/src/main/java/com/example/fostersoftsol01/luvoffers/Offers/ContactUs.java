package com.example.fostersoftsol01.luvoffers.Offers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.fostersoftsol01.luvoffers.EditTextLight;
import com.example.fostersoftsol01.luvoffers.R;
import com.example.fostersoftsol01.luvoffers.textview.TextViewSemiBold;

public class ContactUs extends AppCompatActivity {

    private Button btnSubmit;
    private ImageView imgMenu;

    protected ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    TextViewSemiBold feedback,email;
    EditTextLight message;
    String sfeedback,semail,smessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        feedback=(TextViewSemiBold)findViewById(R.id.edtfeedback);
        email=(TextViewSemiBold)findViewById(R.id.edtEmail);
        message=(EditTextLight)findViewById(R.id.edtMessage);

       // getLayoutInflater().inflate(R.layout.activity_contact_us, frameLayout);

        keybordHide();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);



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


        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sfeedback=feedback.getText().toString().trim();
                semail=email.getText().toString().trim();
                smessage=message.getText().toString().trim();


                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{semail});
                email.putExtra(Intent.EXTRA_SUBJECT, sfeedback);
                email.putExtra(Intent.EXTRA_TEXT, smessage);

//need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));
                 finish();
//                Toast.makeText(getApplicationContext(),"Under development",Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(ContactUs.this,MainActivity.class));

            }
        });
    }

    public void keybordHide(){
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
//        this.startActivity(intent);
    }
}

