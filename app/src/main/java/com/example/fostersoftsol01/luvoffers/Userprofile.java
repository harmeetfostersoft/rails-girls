package com.example.fostersoftsol01.luvoffers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.fostersoftsol01.luvoffers.button.ButtonSemiBold;
import com.example.fostersoftsol01.luvoffers.textview.TextViewSemiBold;

import de.hdodenhof.circleimageview.CircleImageView;

public class Userprofile extends AppCompatActivity {
    SharedPreferences sharedprefrence;
    CircleImageView user_pic,galaary_pic;
    EditTextLight update_email,update_Dob,update_location;
    TextViewSemiBold update_name;
    ButtonSemiBold update_button;
    String get_u_id,get_u_email,get_u_dob,get_u_location,get_u_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        sharedprefrence = getSharedPreferences("ak", Context.MODE_PRIVATE);
        get_u_id = sharedprefrence.getString("user_id","" );
        get_u_name = sharedprefrence.getString("full_name","" );
        get_u_email = sharedprefrence.getString("email","" );
        get_u_dob = sharedprefrence.getString("date_of_birth","" );
        get_u_location = sharedprefrence.getString("location","" );

        user_pic=(CircleImageView)findViewById(R.id.updateImageView);
        galaary_pic=(CircleImageView)findViewById(R.id.updateimgIcon);
        update_email=(EditTextLight)findViewById(R.id.editUEmail);
        update_Dob=(EditTextLight)findViewById(R.id.edit_dob);
        update_location=(EditTextLight)findViewById(R.id.editlocation);
        update_name=(TextViewSemiBold)findViewById(R.id.editfullname);
        update_button=(ButtonSemiBold)findViewById(R.id.btneditSubmit);

        setDataOnText();



        galaary_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opengallary=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(opengallary,"Open Gallary"),1);
            }
        });

    }

    private void setDataOnText() {

        update_name.setText(get_u_name);
        update_email.setText(get_u_email);
        update_Dob.setText(get_u_dob);
        update_location.setText(get_u_location);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK)
        {
            user_pic.setImageURI(data.getData());
//            str= Uri.parse(data.getData().toString());
        }



    }
}
