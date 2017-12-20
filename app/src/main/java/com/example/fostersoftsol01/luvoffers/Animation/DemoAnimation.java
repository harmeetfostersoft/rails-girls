package com.example.fostersoftsol01.luvoffers.Animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.fostersoftsol01.luvoffers.R;

public class DemoAnimation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_animation);

        final Button button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    final Animation myAnim = AnimationUtils.loadAnimation(DemoAnimation.this, R.anim.bounce);
                    button.startAnimation(myAnim);
                }

        });
    }
}
