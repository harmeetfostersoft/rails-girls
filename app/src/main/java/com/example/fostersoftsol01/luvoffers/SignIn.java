package com.example.fostersoftsol01.luvoffers;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.appevents.AppEventsLogger;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.fostersoftsol01.luvoffers.SelectProduct.SelectProduct;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.R.attr.data;
import static android.R.attr.password;





public class SignIn extends AppCompatActivity implements View.OnClickListener {

    private Button btnGmail,btnFacebook,btnLogin;
    LoginButton fblogin_button;
    private AlertDialog dialogPasword, dialogOTP, dialogEmail,dialogFacebook;
    TextView tvforgotPass,tvRegister;
    EditTextLight login_email,login_password,edtNewPass,edtConfPass;
    String get_email,get_password;
    String get_mobile_id;
    SharedPreferences sharedprefrence;

    EditTextLight edtemail,edtOTP;
    EditTextLight fb_edt_email,fb_edt_dob,fb_edt_location;
    String get_fb_edt_email,get_fb_edt_dob,get_fb_edt_location;
    String get_edt_email;
    String strUserId;
    String get_user_email;
   AccessToken token;
    String get_edt_otp;
    String strnewpassword,strcnfrnpassword;
     private CallbackManager callbackManager;
    private  ProfileTracker profiletracker;
    private  AccessTokenTracker accesstockentracker;
    String fname,lname,fimage,fid;
    RelativeLayout relativeLayout;
    TextView textview;
    //Profile profile;

    //private AccessTokenTracker accessTokenTracker;

    String fbname, profile_pic,fbemail,fbmibile,fblastname,fbid;
    private static final int  fbsign =1;

    //String get_fullname,get_date,get_ulocation,get_uemail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_sign_in);
        sharedprefrence = getSharedPreferences("ak", Context.MODE_PRIVATE);
        strUserId = sharedprefrence.getString("user_id","" );
        get_user_email = sharedprefrence.getString("email","" );
//        Toast.makeText(SignIn.this, get_user_email, Toast.LENGTH_SHORT).show();
//        Toast.makeText(SignIn.this, strUserId, Toast.LENGTH_SHORT).show();

        keybordHide();
        relativeLayout=(RelativeLayout)findViewById(R.id.relative);

        fblogin_button=(LoginButton)findViewById(R.id.fblogin_button);
        btnFacebook =(Button)findViewById(R.id.btnFacebook);
        btnGmail =(Button)findViewById(R.id.btnGmail);
        btnLogin =(Button)findViewById(R.id.btnLogin);
        login_email=(EditTextLight)findViewById(R.id.edtloginEmail);
        login_password=(EditTextLight)findViewById(R.id.edtloginPassword);


        //LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));
//        fblogin_button.registerCallback(callbackManager, new FacebookCallback<LoginResult>() { ... });

        tvforgotPass = (TextView)findViewById(R.id.tvforgotPass);
        tvRegister = (TextView)findViewById(R.id.tvRegister);
        clicklistener();


//        tvforgotPass.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showDialog();
//            }
//        });

//        tvRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                startActivity(new Intent(SignIn.this,Register.class));
////                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://julienhuebardgroup.wixsite.com/luvoffer/sign-up"));
////                startActivity(browserIntent);
//                 finish();
//
//            }
//        });
//
//        btnFacebook.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(SignIn.this,SelectProduct.class));
//                finish();
//            }
//        });
//
//        btnGmail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(SignIn.this,SelectProduct.class));
//                finish();
//            }
//        });
//
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(SignIn.this,SelectProduct.class));
//                finish();
//            }
//        });
    }
    public void clicklistener()
    {
        tvforgotPass.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        btnFacebook.setOnClickListener(this);
        btnGmail.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        fblogin_button.setOnClickListener(this);

//        fblogin_button.setReadPermissions("public_profile");
//        fblogin_button.setReadPermissions("email");
//        fblogin_button.setReadPermissions("user_birthday");
        callbackManager = CallbackManager.Factory.create();
        accesstockentracker=new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

            }
        };
        profiletracker=new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
               nextActivity(currentProfile);
            }
        };
        accesstockentracker.startTracking();
        profiletracker.startTracking();
    }


    @Override
    public void onClick(View v) {
        if(v==tvforgotPass)
        {
            showDialog();
        }
        if(v==tvRegister)
        {



           startActivity(new Intent(SignIn.this,Register.class));
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://julienhuebardgroup.wixsite.com/luvoffer/sign-up"));
//                startActivity(browserIntent);
                 finish();
        }
        if(v==btnFacebook)
        {
            fblogin_button.performClick();
            signinfacebook();
            //LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));
//            startActivity(new Intent(SignIn.this,SelectProduct.class));
//              finish();
        }
        if(v==btnGmail)
        {
            startActivity(new Intent(SignIn.this,SelectProduct.class));
            finish();
        }
        if(v==btnLogin)
        {
            get_email=login_email.getText().toString().trim();
            get_password=login_password.getText().toString().trim();
            get_mobile_id= Settings.Secure.getString(getBaseContext().getContentResolver(), Settings.Secure.ANDROID_ID);
            if(login_email.getText().toString().trim().length()==0)
            {
                Snackbar snackbar = Snackbar
                        .make(relativeLayout, "Enter Email Id", Snackbar.LENGTH_LONG)
                        .setAction("", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            }
                        });

                snackbar.show();
            }
            else if(login_password.getText().toString().trim().length()==0)
            {
                Snackbar snackbar = Snackbar
                        .make(relativeLayout, "Enter Password", Snackbar.LENGTH_LONG)
                        .setAction("", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            }
                        });

                snackbar.show();
            }
            else
            {
                new BackGroundWorker().execute(get_email, get_password,get_mobile_id);

            }



//            startActivity(new Intent(SignIn.this,SelectProduct.class));

        }

    }
    private void signinfacebook() {
        FacebookCallback<LoginResult> callback=new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Profile profile=Profile.getCurrentProfile();
                nextActivity(profile);
                Toast.makeText(SignIn.this, "Login....", Toast.LENGTH_SHORT).show();






            }

            @Override
            public void onCancel() {
                LoginManager.getInstance().logOut();
                

            }

            @Override
            public void onError(FacebookException error) {

            }
        };
        fblogin_button.setReadPermissions("user_friends");
        fblogin_button.registerCallback(callbackManager,callback);



//        fblogin_button.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                AccessToken accessToken = loginResult.getAccessToken();
//
////                textview.setText("Login success  \n"  +
////                loginResult.getAccessToken().getUserId() +
////               "\n"+loginResult.getAccessToken().getToken());
//                String dat=("Login success  \n"  +
//                        loginResult.getAccessToken().getUserId() +
//                        "\n"+loginResult.getAccessToken().getToken());
//                Toast.makeText(SignIn.this, dat, Toast.LENGTH_SHORT).show();
//
//
//                Profile profile = Profile.getCurrentProfile();
//                fbname=profile.getFirstName();
//                profile_pic=profile.getProfilePictureUri(200,200).toString();
//                fblastname=profile.getLastName();
//                fbid=profile.getId();
//
//                Toast.makeText(SignIn.this,fbname, Toast.LENGTH_SHORT).show();
//
//
//            }
//
//            @Override
//            public void onCancel() {
//
//            }
//
//            @Override
//            public void onError(FacebookException error) {
//
//            }
//        });
//        profileTracker.startTracking();


    }
    @Override
    protected void onResume()
    {
        super.onResume();
        Profile profile=Profile.getCurrentProfile();
        nextActivity(profile);

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        accesstockentracker.stopTracking();
        profiletracker.stopTracking();
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

          fbprofileDialog();

        Toast.makeText(this, fname, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, lname, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, fimage, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, fid, Toast.LENGTH_SHORT).show();
//                    l.putExtra("ll",name);
//                    l.putExtra("im",profile_pic);
            //startActivityForResult(l, fbsign);




    }

   private void nextActivity(Profile profile)
   {
       if(profile != null)
       {
            fname=profile.getName();
            lname=profile.getLastName();
            fimage=profile.getProfilePictureUri(200,200).toString();
            fid=profile.getId();

       }
   }
   private void fbprofileDialog()
   {
       AlertDialog.Builder builder ;
       builder = new AlertDialog.Builder(SignIn.this);
       LayoutInflater inflater = ((Activity) SignIn.this).getLayoutInflater();
       View v = inflater.inflate(R.layout.fbprofiledialog, null);
       builder.setView(v);

       fb_edt_email = (EditTextLight) v.findViewById(R.id.useremail);
       fb_edt_location = (EditTextLight) v.findViewById(R.id.userlocation);
       fb_edt_dob = (EditTextLight) v.findViewById(R.id.userdob);
       Button btnSubmit = (Button) v.findViewById(R.id.usersubmit);

       btnSubmit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //get_edt_email=edtemail.getText().toString();

              // new Get_forgot_password().execute(get_edt_email);
               get_fb_edt_email=fb_edt_email.getText().toString().trim();
               get_fb_edt_dob=fb_edt_dob.getText().toString().trim();
               get_fb_edt_location=fb_edt_location.getText().toString().trim();

               Intent i=new Intent(SignIn.this,SelectProduct.class);
               startActivity(i);
//                if (edtPhoneNo.getText().toString().trim().length() < 10) {
//                    edtPhoneNo.setError("Enter vailed Number");
//                }
//                else
//                {
//                    forgotPasswordMobile();
//                    showOTPDialog();
//
//
//                }

           }
       });
       dialogFacebook= builder.create();
       dialogFacebook.show();
   }

    private void showDialog()
    {
        AlertDialog.Builder builder ;
        builder = new AlertDialog.Builder(SignIn.this);
        LayoutInflater inflater = ((Activity) SignIn.this).getLayoutInflater();
        View v = inflater.inflate(R.layout.password_forget, null);
        builder.setView(v);

        edtemail = (EditTextLight) v.findViewById(R.id.edtPhoneNo);
        Button btnSubmit = (Button) v.findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_edt_email=edtemail.getText().toString();

          new Get_forgot_password().execute(get_edt_email);


//                if (edtPhoneNo.getText().toString().trim().length() < 10) {
//                    edtPhoneNo.setError("Enter vailed Number");
//                }
//                else
//                {
//                    forgotPasswordMobile();
//                    showOTPDialog();
//
//
//                }

            }
        });
        dialogEmail= builder.create();
        dialogEmail.show();
    }

    private void showOTPDialog()
    {
        dialogEmail.dismiss();
        AlertDialog.Builder builder ;
        builder = new AlertDialog.Builder(SignIn.this);
        LayoutInflater inflater = ((Activity) SignIn.this).getLayoutInflater();
        View v = inflater.inflate(R.layout.otp_page, null);
        builder.setView(v);

        edtOTP = (EditTextLight) v.findViewById(R.id.edtOTP);
        Button btnSubmit = (Button) v.findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_edt_otp=edtOTP.getText().toString().trim();

                if (edtOTP.getText().toString().trim().length() < 4) {
                    edtOTP.setError("Enter vailed OTP");
                }

                else
                {
                    new Get_otp().execute(strUserId,get_user_email,get_edt_otp);
//                    otpToken();
//                    showPasswordChangeDialog();
                }

            }
        });
        dialogOTP= builder.create();
        dialogOTP.show();
    }


    private void showPasswordChangeDialog()
    {
        dialogOTP.dismiss();
        AlertDialog.Builder builder ;
        builder = new AlertDialog.Builder(SignIn.this);
        LayoutInflater inflater = ((Activity) SignIn.this).getLayoutInflater();
        View v = inflater.inflate(R.layout.change_password_new, null);
        builder.setView(v);

       edtNewPass = (EditTextLight) v.findViewById(R.id.edtNewPass);
        edtConfPass = (EditTextLight) v.findViewById(R.id.edtConfPass);
        Button btnSubmit = (Button) v.findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Toast.makeText(getApplicationContext(),"Under Development",Toast.LENGTH_SHORT).show();
                strnewpassword = edtNewPass.getText().toString().trim();
                strcnfrnpassword= edtConfPass.getText().toString().trim();

                if (edtNewPass.getText().toString().trim().length() < 6) {
                    edtNewPass.setError("Enter Password between 6 to 8 digit");
                } else if (edtConfPass.getText().toString().trim().length() < 6) {
                    edtConfPass.setError("Enter Password between 6 to 8 digit");
                } else if(!(edtNewPass.getText().toString().equals(edtConfPass.getText().toString()))) {
                    edtConfPass.setError("Enter Same Password");
                }
                else
                {
                     //final_password=edtConfPass.getText().toString().trim();
                    changePassowrd();
                    startActivity(new Intent(SignIn.this,SignIn.class));
                    dialogPasword.dismiss();
                }

            }
        });
        dialogPasword= builder.create();
        dialogPasword.show();
    }

public void keybordHide(){
    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
}


    public class BackGroundWorker extends AsyncTask<Object, Object, Object> {





        ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(SignIn.this);
            pDialog.setTitle("Contacting Servers");
            pDialog.setMessage("Registering ...");
            //pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }


        @Override
        protected Object doInBackground(Object[] params) {

            //String type = (String) params[0];
            //String user_id= (String) params[0];
            String user_name = (String) params[0];
            String pass_word = (String) params[1];
            String device_id= (String) params[2];
            String login_url = "http://fostersoftsolutions.com/shoparound/login.php";

            try {
                URL url = new URL(login_url);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(pass_word, "UTF-8") + "&" + URLEncoder.encode("device_id", "UTF-8") + "=" + URLEncoder.encode(device_id, "UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                    String result = "";
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        result += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            pDialog.dismiss();

            Toast.makeText(getBaseContext(), "" + o, Toast.LENGTH_LONG).show();



            try {

                //Toast.makeText(SignIn.this, "welcome", Toast.LENGTH_SHORT).show();
                JSONObject j = new JSONObject(String.valueOf(o));
                String success = j.getString("status");
                String guserid = j.getString("user_id");
                String gemail = j.getString("email");
                String gdate = j.getString("date_of_birth");
                String glocation = j.getString("location");
                String gfullname = j.getString("full_name");

                if (success.equals("1")) {
                    String message = j.getString("message");

                   // Toast.makeText(SignIn.this, gemail, Toast.LENGTH_SHORT).show();

                    if (message.equals("null")) {
                        Toast.makeText(SignIn.this, "Invalid Username/Password.", Toast.LENGTH_SHORT).show();
                    } else {
                       // JSONObject jsonObject = j.getJSONObject("message");
//                        String guserid = j.getString("user_id");
//                        String gfullname = j.getString("full_name");
//                        String gdate = j.getString("date_of_birth");
//                        String gemail = j.getString("email");
//                        String glocation = j.getString("location");
//                        String gdevice_id=j.getString("device_id");

                        if (j.getString("user_type").equals("user"))
                        {
                            startActivity(new Intent(SignIn.this,SelectProduct.class));
                        }
//
//


//                        Toast.makeText(loginpage.this, " " + guserid + " " + gfirstname + "" + glastname, Toast.LENGTH_SHORT).show();
//                        Intent i = new Intent(loginpage.this, navigation_view.class);
//                        startActivity(i);
                        sharedprefrence = getSharedPreferences("ak", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedprefrence.edit();

                        editor.putString("user_id", guserid);
                        editor.putString("full_name", gfullname);
                        editor.putString("date_of_birth", gdate);
                        editor.putString("email", gemail);
                        editor.putString("location", glocation);
//                        editor.putString("device_id", gdevice_id);



                        editor.commit();
                        }

                } else {
                    Toast.makeText(SignIn.this, "Failed to Connect Server", Toast.LENGTH_SHORT).show();

                }


                //Toast.makeText(context," "+success+" "+name+" "+fname+" "+gname+" "+qname+" "+ename+" ", Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {

               // Toast.makeText(SignIn.this, "Error", Toast.LENGTH_SHORT).show();
                Snackbar snackbar = Snackbar
                        .make(relativeLayout, "Enter Valid Email or Password", Snackbar.LENGTH_LONG)
                        .setAction("", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            }
                        });

                snackbar.show();
                e.printStackTrace();

            }




        }
    }

    public class Get_forgot_password extends AsyncTask<Object, Object, Object> {


        ProgressDialog pf = new ProgressDialog(SignIn.this);


        ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(SignIn.this);
            pDialog.setTitle("Contacting Servers");
            pDialog.setMessage("Registering ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }


        @Override
        protected Object doInBackground(Object[] params) {

            //String type = (String) params[0];
            //String user_id= (String) params[0];
           // String user_name = (String) params[0];
            String pass_word = (String) params[0];

            String login_url = "http://fostersoftsolutions.com/shoparound/forgot_password.php";

            try {
                URL url = new URL(login_url);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(pass_word, "UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                    String result = "";
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        result += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            pDialog.dismiss();

            Toast.makeText(getBaseContext(), "" + o, Toast.LENGTH_LONG).show();



            try {

               // Toast.makeText(SignIn.this, "welcome", Toast.LENGTH_SHORT).show();
                JSONObject j = new JSONObject(String.valueOf(o));
                String success = j.getString("status");
               String get_user_id=j.getString("user_id");

                //Toast.makeText(SignIn.this, get_user_id, Toast.LENGTH_SHORT).show();
                if (success.equals("1")) {
                    String message = j.getString("message");
                    if (message.equals("null")) {
                        Toast.makeText(SignIn.this, "Invalid Username/Password.", Toast.LENGTH_SHORT).show();
                    } else {
                        // JSONObject jsonObject = j.getJSONObject("message");
//                        String guserid = j.getString("user_id");
//                        String gfullname = j.getString("full_name");
//                        String gdate = j.getString("date_of_birth");
//                        String gemail = j.getString("email");
//                        String glocation = j.getString("location");
//                        String gdevice_id=j.getString("device_id");

//                        if (j.getString("user_type").equals("user"))
//                        {
//                            startActivity(new Intent(SignIn.this,SelectProduct.class));
//                        }
//
                                 showOTPDialog();


//                        Toast.makeText(loginpage.this, " " + guserid + " " + gfirstname + "" + glastname, Toast.LENGTH_SHORT).show();
//                        Intent i = new Intent(loginpage.this, navigation_view.class);
//                        startActivity(i);
//                        sharedprefrence = getSharedPreferences("akh", Context.MODE_PRIVATE);
//                        SharedPreferences.Editor editor = sharedprefrence.edit();

 //                       editor.putString("user_id", get_user_id);
//                        editor.putString("full_name", gfullname);
//                        editor.putString("date_of_birth", gdate);
//                        editor.putString("email", gemail);
//                        editor.putString("location", glocation);
//                        editor.putString("device_id", gdevice_id);



          //                  editor.commit();
                    }

                } else {
                    Toast.makeText(SignIn.this, "Failed to Connect Server", Toast.LENGTH_SHORT).show();

                }


                //Toast.makeText(context," "+success+" "+name+" "+fname+" "+gname+" "+qname+" "+ename+" ", Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {

                Toast.makeText(SignIn.this, "Error", Toast.LENGTH_SHORT).show();
                e.printStackTrace();

            }




        }
    }



    public class Get_otp extends AsyncTask<Object, Object, Object> {





        ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(SignIn.this);
            pDialog.setTitle("Contacting Servers");
            pDialog.setMessage("Registering ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }


        @Override
        protected Object doInBackground(Object[] params) {

            //String type = (String) params[0];
            String suser_id= (String) params[0];
             String suser_email = (String) params[1];
            String suser_token = (String) params[2];

            String login_url = "http://fostersoftsolutions.com/shoparound/otp.php";

            try {
                URL url = new URL(login_url);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("user_id", "UTF-8") + "=" + URLEncoder.encode(suser_id, "UTF-8") + "&" + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(suser_email, "UTF-8") + "&" + URLEncoder.encode("token", "UTF-8") + "=" + URLEncoder.encode(suser_token, "UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                    String result = "";
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        result += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return result;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            pDialog.dismiss();

            Toast.makeText(getBaseContext(), "" + o, Toast.LENGTH_LONG).show();



            try {

                //Toast.makeText(SignIn.this, "welcome", Toast.LENGTH_SHORT).show();
                JSONObject j = new JSONObject(String.valueOf(o));
                String success = j.getString("status");
                String get_user_id=j.getString("user_id");
                //Toast.makeText(SignIn.this, get_user_id, Toast.LENGTH_SHORT).show();
                if (success.equals("1")) {
                    String message = j.getString("message");
                    if (message.equals("null")) {
                        Toast.makeText(SignIn.this, "Invalid Username/Password.", Toast.LENGTH_SHORT).show();
                    } else {
                        // JSONObject jsonObject = j.getJSONObject("message");

                        showPasswordChangeDialog();



                    }

                } else {
                    Toast.makeText(SignIn.this, "Failed to Connect Server", Toast.LENGTH_SHORT).show();

                }


                //Toast.makeText(context," "+success+" "+name+" "+fname+" "+gname+" "+qname+" "+ename+" ", Toast.LENGTH_SHORT).show();
            } catch (JSONException e) {

                //Toast.makeText(SignIn.this,"Code not matched", Toast.LENGTH_SHORT).show();
                Snackbar snackbar = Snackbar
                        .make(relativeLayout, "Enter Valied OTP", Snackbar.LENGTH_LONG)
                        .setAction("", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            }
                        });

                snackbar.show();

                e.printStackTrace();

            }




        }
    }


    public void changePassowrd()
    {


        Log.e("password",strnewpassword);
        Log.e("password",strcnfrnpassword);

        final StringRequest stringRequest = new StringRequest(Request.Method.POST, Constant.URL_CHANGE_PASSWORD,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("res>", response);


                        try {
                            JSONObject jsonObjectMobile = new JSONObject(response);
                            String streemail="";

                            streemail = jsonObjectMobile.getString(Constant.Key_email);

                            sharedprefrence = getApplicationContext().getSharedPreferences("akh", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedprefrence.edit();
                            editor.putString(Constant.Key_password, streemail);


                            editor.commit();


                             Toast.makeText(SignIn.this,response , Toast.LENGTH_LONG).show();

                            Log.e("Phone",streemail);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        //  Toast.makeText(Login.this,response , Toast.LENGTH_LONG).show();
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(SignIn.this,error.toString(),Toast.LENGTH_LONG ).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put(Constant.Key_user_id, strUserId);
               // map.put(Constant.Key_password, strnewpassword);
                map.put(Constant.Key_email,get_edt_email);
                map.put(Constant.Key_password,strcnfrnpassword);
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


}
