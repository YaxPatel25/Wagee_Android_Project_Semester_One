package com.example.wagee_android_project_semester_one;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.SharedPreferences;

import com.example.wagee_android_project_semester_one.placeholder.Employee_Name;

/**
 * A fragment representing a list of Items.
 */
public class EmployeeNameListFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    SharedPreferences sharedPreferences;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EmployeeNameListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static EmployeeNameListFragment newInstance(int columnCount) {
        EmployeeNameListFragment fragment = new EmployeeNameListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

        sharedPreferences = getContext().getSharedPreferences("PAYMENT",MODE_PRIVATE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        String darkMode = sharedPreferences.getString("DARKMODE",null );

        if(darkMode == "true") {
            container.setBackgroundColor(Color.BLACK);
        }else if(darkMode == "false"){
            container.setBackgroundColor(Color.WHITE);
        }
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new EmployeeNameListRecyclerViewAdapter(Employee_Name.ITEMS));
        }
        return view;
    }
}