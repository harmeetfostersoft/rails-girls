package com.example.fostersoftsol01.luvoffers;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.fostersoftsol01.luvoffers.SelectProduct.SelectProduct;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Register extends AppCompatActivity {

    private Button btnSubmit;
    EditTextLight Fullname,Date_of_birth,Location,Email,Password,ConfirmPassword;
    String Rfullname,Rdate,Rlocation,Remail,Rpassword,Rconfirmpassword,get_mobile_id,Ruser_type;
    SharedPreferences sharedprefrence;
    String guserid;
    RelativeLayout relativeLayout1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        relativeLayout1=(RelativeLayout)findViewById(R.id.relate);
        keybordHide();
        RegisterId();



        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rfullname=Fullname.getText().toString().trim();
                Rdate=Date_of_birth.getText().toString().trim();
                Rlocation=Location.getText().toString().trim();
                Remail=Email.getText().toString().trim();
                Rpassword=Password.getText().toString().trim();
                Rconfirmpassword=ConfirmPassword.getText().toString().trim();
                Ruser_type="user";
                get_mobile_id= Settings.Secure.getString(getBaseContext().getContentResolver(), Settings.Secure.ANDROID_ID);



                if (Fullname.getText().toString().trim().length() ==0) {
                    Snackbar snackbar = Snackbar
                            .make(relativeLayout1, "Enter First Name", Snackbar.LENGTH_LONG)
                            .setAction("", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                }
                            });

                    snackbar.show();
                } else if (Date_of_birth.getText().toString().trim().length() ==0) {
                    Snackbar snackbar = Snackbar
                            .make(relativeLayout1, "Enter Date Of Birth", Snackbar.LENGTH_LONG)
                            .setAction("", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                }
                            });

                    snackbar.show();
                }else if (Location.getText().toString().trim().length() ==0) {
                    Snackbar snackbar = Snackbar
                            .make(relativeLayout1, "Enter Your Location", Snackbar.LENGTH_LONG)
                            .setAction("", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                }
                            });

                    snackbar.show();
                }
                else if (Email.getText().toString().trim().length() ==0) {
                    Snackbar snackbar = Snackbar
                            .make(relativeLayout1, "Enter Your Email Id", Snackbar.LENGTH_LONG)
                            .setAction("", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                }
                            });

                    snackbar.show();
                }
                else if (Password.getText().toString().trim().length() ==0 ) {
                    Snackbar snackbar = Snackbar
                            .make(relativeLayout1, "Enter Your Password", Snackbar.LENGTH_LONG)
                            .setAction("", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                }
                            });

                    snackbar.show();
                }
                else if (Password.getText().toString().trim().length() ==0 ) {
                    Snackbar snackbar = Snackbar
                            .make(relativeLayout1, "Enter  Confirm Password", Snackbar.LENGTH_LONG)
                            .setAction("", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                }
                            });

                    snackbar.show();
                }
                else if (Password.getText().toString().trim().length() ==0 ) {
                    Snackbar snackbar = Snackbar
                            .make(relativeLayout1, "Enter Your Password", Snackbar.LENGTH_LONG)
                            .setAction("", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                }
                            });

                    snackbar.show();
                }
                else if (ConfirmPassword.getText().toString().trim().length() <6 ) {
                    Snackbar snackbar = Snackbar
                            .make(relativeLayout1, "Enter Confirm Password WithIn 6 to 8", Snackbar.LENGTH_LONG)
                            .setAction("", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                }
                            });

                    snackbar.show();
                }
                else if (Password.getText().toString().trim() != ConfirmPassword.getText().toString().trim()) {
                    Snackbar snackbar = Snackbar
                            .make(relativeLayout1, "Enter Same Password", Snackbar.LENGTH_LONG)
                            .setAction("", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                }
                            });

                    snackbar.show();
                }
                else
                {
                    new Get_data().execute();
                }





//                Intent intent = new Intent(getBaseContext(), SelectProduct.class);
////                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
                //Toast.makeText(getApplicationContext(),"Under Development",Toast.LENGTH_SHORT).show();

            }
        });

       }
    public void RegisterId()
    {
        Fullname=(EditTextLight)findViewById(R.id.edtFullName);
        Date_of_birth=(EditTextLight)findViewById(R.id.edtDate);
        Location=(EditTextLight)findViewById(R.id.edtLocation);
        Email=(EditTextLight)findViewById(R.id.edtEmail);
        Password=(EditTextLight)findViewById(R.id.edtPassword);
        ConfirmPassword=(EditTextLight)findViewById(R.id.edtConfrimPass);
    }
    public void keybordHide(){
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }
    public class Get_data extends AsyncTask<Void, Void, Void> {
        String success;
        String message;
        ProgressDialog pDialog;

        @Override

        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Register.this);
            pDialog.setTitle("Contacting Servers");
            pDialog.setMessage("Registering ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... params) {


            String url, urlprm = null;
            url = "http://fostersoftsolutions.com/shoparound/signup.php";
            try {
                urlprm = "&full_name=" + URLEncoder.encode(Rfullname, "UTF-8") + "&date_of_birth=" + URLEncoder.encode(Rdate, "UTF-8") + "&location=" + URLEncoder.encode(Rlocation, "UTF-8") + "&email=" + URLEncoder.encode(Remail, "UTF-8") + "&password=" + URLEncoder.encode(Rpassword, "UTF-8") + "&device_id=" + URLEncoder.encode(get_mobile_id, "UTF-8") + "&user_type=" + URLEncoder.encode(Ruser_type, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            JSONParserClient jason = new JSONParserClient();
            try {
                JSONObject obj1 = jason.makaHTTPRequest(url, urlprm);
                success = obj1.getString("status");
                 message=obj1.getString("message");
                Ruser_type =  obj1.getString("user_type");

                guserid = obj1.getString("user_id");
                        String gfullname = obj1.getString("full_name");
                        String gdate = obj1.getString("date_of_birth");
                        String gemail = obj1.getString("email");
                        String glocation = obj1.getString("location");
                        String gdevice_id=obj1.getString("device_id");

                //Toast.makeText(Register.this, gfullname, Toast.LENGTH_SHORT).show();

                sharedprefrence = getSharedPreferences("hh", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedprefrence.edit();

                        editor.putString("user_id", guserid);
                        editor.putString("full_name", gfullname);
                        editor.putString("date_of_birth", gdate);
                        editor.putString("email", gemail);
                        editor.putString("location", glocation);
                        editor.putString("device_id", gdevice_id);



                    editor.commit();


            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {


            super.onPostExecute(aVoid);

            //Toast.makeText(Register.this, "Success"+message, Toast.LENGTH_SHORT).show();
            if(success.equals("1")){
                //Toast.makeText(Register.this, "Success"+success, Toast.LENGTH_SHORT).show();
                Toast.makeText(Register.this, message, Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Register.this,SignIn.class);

                startActivity(i);

            }
            else{
                Toast.makeText(Register.this, "Connect with internet", Toast.LENGTH_SHORT).show();
            }
            pDialog.dismiss();

        }
    }
}
