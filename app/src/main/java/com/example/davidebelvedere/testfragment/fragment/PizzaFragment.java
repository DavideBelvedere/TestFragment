package com.example.davidebelvedere.testfragment.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.davidebelvedere.testfragment.R;
import com.example.davidebelvedere.testfragment.logic.Utility;
import com.example.davidebelvedere.testfragment.logic.UtilityFragment;
import com.example.davidebelvedere.testfragment.ui.adapter.CustomAdapter;


/**
 * Created by davidebelvedere on 22/02/18.
 */

public class PizzaFragment extends Fragment {
    UtilityFragment mCallback;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.pizza_view, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        CustomAdapter customAdapter = new CustomAdapter(getActivity(), Utility.getDataSourceItemList());
        ListView listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(customAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                mCallback.setListener(position);
            }
        });

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
}
