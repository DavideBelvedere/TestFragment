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

public class PizzaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.pizza_view, container, false);
    }
}
