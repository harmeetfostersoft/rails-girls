package com.example.fostersoftsol01.luvoffers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fostersoftsol01.luvoffers.Animation.Accordion;
import com.example.fostersoftsol01.luvoffers.ClintionCards.ClintionHome;
import com.example.fostersoftsol01.luvoffers.Costa.CostaHome;
import com.example.fostersoftsol01.luvoffers.Debenhams.DebenhamsHome;
import com.example.fostersoftsol01.luvoffers.GreggsBakery.GreggsHome;
import com.example.fostersoftsol01.luvoffers.MS.MsHome;
import com.example.fostersoftsol01.luvoffers.McDonalds.McDonaldsHome;
import com.example.fostersoftsol01.luvoffers.Next.NextHome;
import com.example.fostersoftsol01.luvoffers.Tesco.TescoHome;

/**
 * Created by fostersoftsol01 on 3/5/17.
 */

public class RecycleViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView tvHeaderTitle,tvHeaderSubTitle,tvSubText;
    public ImageView imgHeader;
    private final Context context;


    public RecycleViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        itemView.setOnClickListener(this);


        tvHeaderTitle = (TextView)itemView.findViewById(R.id.tvHeaderTitle);
        tvHeaderSubTitle = (TextView)itemView.findViewById(R.id.tvHeaderSubTitle);
        tvSubText = (TextView)itemView.findViewById(R.id.tvSubText);
        imgHeader = (ImageView)itemView.findViewById(R.id.imgHeader);
    }

    @Override
    public void onClick(View view) {

        final Intent intent;
        switch (getAdapterPosition()){
            case 0:
                intent =  new Intent(context, GreggsHome.class);
                break;
            case 1:
                intent =  new Intent(context, CostaHome.class);
                break;
            case 2:
                intent =  new Intent(context, NextHome.class);
                break;
            case 3:
                intent =  new Intent(context, McDonaldsHome.class);
                break;
            case 4:
                intent =  new Intent(context, MsHome.class);
                break;
            case 5:
                intent =  new Intent(context, DebenhamsHome.class);
                break;
            case 6:
                intent =  new Intent(context, ClintionHome.class);
                break;
            case 7:
                intent =  new Intent(context, TescoHome.class);
                break;
            default:
                intent =  new Intent(context, GreggsHome.class);
                break;
        }
        context.startActivity(intent);

       // Toast.makeText(view.getContext(), "Position = " + getPosition(), Toast.LENGTH_SHORT).show();
    }
}

