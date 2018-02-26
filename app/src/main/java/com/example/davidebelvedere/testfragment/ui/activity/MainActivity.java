package com.example.davidebelvedere.testfragment.ui.activity;

import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.davidebelvedere.testfragment.R;
import com.example.davidebelvedere.testfragment.fragment.DetailFragment;
import com.example.davidebelvedere.testfragment.fragment.PizzaFragment;
import com.example.davidebelvedere.testfragment.logic.Utility;
import com.example.davidebelvedere.testfragment.logic.UtilityFragment;
import com.example.davidebelvedere.testfragment.ui.adapter.CustomAdapter;

public class MainActivity extends AppCompatActivity implements UtilityFragment {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utility.initDataSource(this);
        setContentView(R.layout.activity_main);
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

            DetailFragment detailFragment = new DetailFragment();
            fragmentTransaction.add(R.id.detail_frame_land, detailFragment);

            PizzaFragment pizzaFragment = new PizzaFragment();
            fragmentTransaction.add(R.id.pizza_frame_land, pizzaFragment);

            fragmentTransaction.commit();
            detailFragment.updateView(0);



        }

    }

    @Override
    public void setListener(int position) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Bundle bundle = new Bundle();
            bundle.putString("Posizione", "" + position);
            DetailFragment detailFragment = new DetailFragment();
            detailFragment.setArguments(bundle);


            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.pizza_frame, detailFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else {

            Bundle bundle = new Bundle();
            bundle.putString("Posizione", "" + position);
            DetailFragment detailFragment = new DetailFragment();
            detailFragment.setArguments(bundle);


            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.detail_frame_land, detailFragment);
            transaction.addToBackStack(null);
            transaction.commit();

            detailFragment.updateView(position);
        }
    }


}
