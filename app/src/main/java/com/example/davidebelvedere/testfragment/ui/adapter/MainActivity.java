package com.example.davidebelvedere.testfragment.ui.adapter;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.davidebelvedere.testfragment.R;
import com.example.davidebelvedere.testfragment.data.Pizza;
import com.example.davidebelvedere.testfragment.fragment.DetailFragment;
import com.example.davidebelvedere.testfragment.fragment.PizzaFragment;
import com.example.davidebelvedere.testfragment.logic.Utility;
import com.example.davidebelvedere.testfragment.ui.activity.CustomAdapter;

public class MainActivity extends AppCompatActivity {
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utility.initDataSource(this);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            if (savedInstanceState == null) {
                //inizio creazione fragment
                PizzaFragment fragment = new PizzaFragment();
                fragmentTransaction.add(R.id.pizza_frame, fragment);
                fragmentTransaction.commit();
                //fine creazione fragment
            }
        } else {
            DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.pizza_fragment);
            detailFragment.updateView(0);
        }

    }
}
