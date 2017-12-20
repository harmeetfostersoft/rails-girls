package com.example.fostersoftsol01.luvoffers.Animation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fostersoftsol01.luvoffers.R;

/**
 * Created by fostersoftsol01 on 20/5/17.
 */

public class SampleFragment extends Fragment {

    public SampleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sample, container, false);
    }
}
