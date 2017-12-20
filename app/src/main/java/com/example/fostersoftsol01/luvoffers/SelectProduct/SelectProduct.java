package com.example.fostersoftsol01.luvoffers.SelectProduct;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fostersoftsol01.luvoffers.MainActivity;
import com.example.fostersoftsol01.luvoffers.R;
import com.example.fostersoftsol01.luvoffers.Util.Constent;

import java.util.ArrayList;

public class SelectProduct extends AppCompatActivity {


    private ImageView imgSwipe,imgYes,imgNo,imgInstred;
    private Button btnSkip;

    public static boolean is_all,is_skip;

    ArrayList<Integer> array_image = new ArrayList<Integer>();
    public static ArrayList<Integer> al_intrested_images = new ArrayList<Integer>();

    int index=0;
    int count=0;
    SharedPreferences sharedpreferences;
    String strGreggs="",strCosta="",strNext="",strMCD="",strMS="",strDebe=""
            ,strClintion="",strTesco="";

    public TextView tvBrandName,tvSkip;

    ArrayList<String> array_name = new ArrayList<String>();
    ArrayList<String> all_name = new ArrayList<String>();
//    String[] str = new String[10];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_product);

        array_image.add(R.drawable.greggs_main_new);
        array_image.add(R.drawable.costa_new);
        array_image.add(R.drawable.next);
        array_image.add(R.drawable.mc_d_new);
        array_image.add(R.drawable.ms_new);
        array_image.add(R.drawable.debehans_new);
        array_image.add(R.drawable.clintion_new);
        array_image.add(R.drawable.tesco);


        array_name.add("GREGGS");
        array_name.add("COSTA COFFEE");
        array_name.add("NEXT");
        array_name.add("MCDONALDS");
        array_name.add("M & S");
        array_name.add("DEBENHAMS");
        array_name.add("CLINTON CARDS");
        array_name.add("TESCO EXTRA");




//        str[0] = "GREGGS";
//        str[1] = "COSTA";
//        str[2] = "NEXT";
//        str[3] = "MCDONALDS";
//        str[4] = "M & S";
//        str[5] = "DEBENHAMS";
//        str[6] = "CLINTON";
//        str[7] = "TESCO EXTRA";


        imgSwipe = (ImageView)findViewById(R.id.imgSwipe);
        imgYes = (ImageView)findViewById(R.id.imgYes);
        imgNo = (ImageView)findViewById(R.id.imgNo);
        imgInstred = (ImageView)findViewById(R.id.imgInstred);

        tvBrandName = (TextView)findViewById(R.id.tvBrandName);

        tvSkip = (TextView)findViewById(R.id.tvSkip);
//        btnAll = (Button)findViewById(R.id.btnAll);

        sharedpreferences = getApplicationContext().getSharedPreferences(Constent.MY_PREF, Context.MODE_PRIVATE);

        strGreggs = sharedpreferences.getString(Constent.GREGGS, Constent.NO_VALUE);
        strCosta = sharedpreferences.getString(Constent.COSTA, Constent.NO_VALUE);
        strNext = sharedpreferences.getString(Constent.NEXT, Constent.NO_VALUE);
        strMCD = sharedpreferences.getString(Constent.MCDONALDS, Constent.NO_VALUE);
        strMS = sharedpreferences.getString(Constent.MS, Constent.NO_VALUE);
        strDebe = sharedpreferences.getString(Constent.DEBENHAMS, Constent.NO_VALUE);
        strClintion = sharedpreferences.getString(Constent.CLINTON, Constent.NO_VALUE);
        strTesco = sharedpreferences.getString(Constent.TESCOEXTRA, Constent.NO_VALUE);

        String Grees,costa,next,mcd,ms,debe,clintion,tesco;

        Grees = Constent.GREGGS.toString();
        costa = Constent.COSTA.toString();
        next = Constent.NEXT.toString();
        mcd = Constent.MCDONALDS.toString();
        ms = Constent.MS.toString();
        debe = Constent.DEBENHAMS.toString();
        clintion = Constent.CLINTON.toString();
        tesco = Constent.TESCOEXTRA.toString();

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Constent.GREGGS, Grees);
        editor.putString(Constent.COSTA, costa);
        editor.putString(Constent.NEXT, next);
        editor.putString(Constent.MCDONALDS, mcd);
        editor.putString(Constent.MS, ms);
        editor.putString(Constent.DEBENHAMS, debe);
        editor.putString(Constent.CLINTON, clintion);
        editor.putString(Constent.TESCOEXTRA, tesco);


        editor.commit();





//        getName();

        imgYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if (index<array_name.size())
//                {
//
//                    tvBrandName.setText(array_name.get(index));
//                    index++;
//                }

//                if (count < array_name.size()){
//                    tvBrandName.setText(array_name.get(count));
//                count++;
//            }
//                    else
//
//            {
//                count = 0;
//            }
                al_intrested_images.add(array_image.get(index));
                index++;
                if(index<array_image.size()){
                    if(index==array_image.size())
                    {
                        tvBrandName.setText(array_name.get(index -1));
//                        al_intrested_images.add(array_image.get(index > 0  ? index-1 : 0 ));

                        imgSwipe.setImageResource(array_image.get(index-1));

                    }

                    else{
                        tvBrandName.setText(array_name.get(index ));
                        imgSwipe.setImageResource(array_image.get(index));
                    }

                }
//                if (index<array_name.size())
//                {
//
//                    all_name.add(array_name.get(index ));
//                    index++;
//
//                    if(index==array_name.size())
//                    {
////                        al_intrested_images.add(array_image.get(index > 0  ? index-1 : 0 ));
//
//                        tvBrandName.setText(array_name.get(index-1));
//
//                    }
//
//                    else{
//
//                        tvBrandName.setText(array_name.get(index-1));
//                    }
//
//                }
                else
                    {
                        startActivity(new Intent(SelectProduct.this,MainActivity.class));
                        finish();
                    }
            }
        });

        imgNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getName();
                index++;
                if(index<array_image.size()){
                    if(index==array_image.size())
                    {
                        tvBrandName.setText(array_name.get(index-1));
                        imgSwipe.setImageResource(array_image.get(index-1));
                    }
                    else
                    {
                        tvBrandName.setText(array_name.get(index));
                        imgSwipe.setImageResource(array_image.get(index));
                    }

                }
                else
                {
                    if(al_intrested_images.size()<=0)
                    is_skip = true;
                    startActivity(new Intent(SelectProduct.this,MainActivity.class));
                    finish();
                }

            }
        });
        Log.e( "value", String.valueOf(imgInstred));



        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                is_skip=true;
                startActivity(new Intent(SelectProduct.this, MainActivity.class));
                finish();
            }
        });
//        btnAll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                is_all=true;
//                startActivity(new Intent(SelectProduct.this, MainActivity.class));
//            }
//        });
        imgSwipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(SelectProduct.this, MainActivity.class));
            }
        });
    }


    private void getName()
    {
        sharedpreferences = getApplicationContext().getSharedPreferences(Constent.MY_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        if (sharedpreferences.contains(Constent.GREGGS)) {
            tvBrandName.setText(sharedpreferences.getString(Constent.GREGGS, ""));
        }
        else if (sharedpreferences.contains(Constent.COSTA)) {
            tvBrandName.setText(sharedpreferences.getString(Constent.COSTA, ""));
        }
        else if (sharedpreferences.contains(Constent.NEXT)) {
            tvBrandName.setText(sharedpreferences.getString(Constent.NEXT, ""));
        }


        editor.commit();

    }


    @Override
    protected void onResume() {
          al_intrested_images.clear();
          is_all=false;
          is_skip=false;
        super.onResume();
    }
}
