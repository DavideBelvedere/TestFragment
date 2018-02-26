package com.example.davidebelvedere.testfragment.fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.davidebelvedere.testfragment.R;
import com.example.davidebelvedere.testfragment.data.Pizza;
import com.example.davidebelvedere.testfragment.logic.Utility;
import com.example.davidebelvedere.testfragment.logic.UtilityFragment;
import com.example.davidebelvedere.testfragment.ui.adapter.CustomAdapter;

import static com.example.davidebelvedere.testfragment.logic.Utility.getPizzaFromPosition;

/**
 * Created by davidebelvedere on 22/02/18.
 */

public class DetailFragment extends Fragment {
    TextView nomePizza;
    TextView descPizza;


    private CustomAdapter customAdapter;
    private UtilityFragment mCallback;
    public DetailFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.detail_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            int position = Integer.parseInt(getArguments().getString("Posizione"));
            Pizza selectedPizza = Utility.getPizzaFromPosition(position);
            nomePizza = (TextView) view.findViewById(R.id.nomePizza);
            descPizza = (TextView) view.findViewById(R.id.descrizionePizza);


            nomePizza.setText(selectedPizza.getName());
            descPizza.setText(selectedPizza.getDesc());

            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                Button backButton = (Button) view.findViewById(R.id.backButton);
                backButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getFragmentManager().popBackStack();
                    }
                });
            }
        }


    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (UtilityFragment) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
    }

    public void updateView(int position) {
        Pizza p = Utility.getPizzaFromPosition(position);
        nomePizza = (TextView) getView().findViewById(R.id.nomePizza);
        descPizza = (TextView) getView().findViewById(R.id.descrizionePizza);
        nomePizza.setText(p.getName());
        descPizza.setText(p.getDesc());
    }
}