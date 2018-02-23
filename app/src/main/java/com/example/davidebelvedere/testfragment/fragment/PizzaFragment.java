package com.example.davidebelvedere.testfragment.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.davidebelvedere.testfragment.R;
import com.example.davidebelvedere.testfragment.data.Pizza;
import com.example.davidebelvedere.testfragment.logic.Utility;
import com.example.davidebelvedere.testfragment.ui.activity.CustomAdapter;
import com.example.davidebelvedere.testfragment.ui.adapter.MainActivity;


/**
 * Created by davidebelvedere on 22/02/18.
 */

public class PizzaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.pizza_view, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Utility.initDataSource(getActivity());


        CustomAdapter customAdapter = new CustomAdapter(getActivity(), Utility.getDataSourceItemList());
        ListView listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pizza selectedItem = Utility.getDataSourceItemList().get(position);


                Bundle bundle = new Bundle();
                bundle.putString("NomePizza", selectedItem.getName());
                DetailFragment detailFragment = new DetailFragment();
                detailFragment.setArguments(bundle);



                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.pizza_frame, detailFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
    }
}
