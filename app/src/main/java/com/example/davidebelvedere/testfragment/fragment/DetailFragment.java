package com.example.davidebelvedere.testfragment.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.davidebelvedere.testfragment.R;

/**
 * Created by davidebelvedere on 22/02/18.
 */

public class DetailFragment extends Fragment {
    public DetailFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.detail_list, container, false);
    }
}
