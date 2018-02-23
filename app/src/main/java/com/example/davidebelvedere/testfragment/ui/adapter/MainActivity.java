package com.example.davidebelvedere.testfragment.ui.adapter;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
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

        //inizio creazione fragment
        PizzaFragment fragment = new PizzaFragment();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        fragmentTransaction.add(R.id.pizza_frame, fragment);
        fragmentTransaction.commit();
        //fine creazione fragment




// Create new fragment and transaction

    }
}
