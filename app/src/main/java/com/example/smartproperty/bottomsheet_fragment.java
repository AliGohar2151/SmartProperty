package com.example.smartproperty;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link bottomsheet_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class bottomsheet_fragment extends BottomSheetDialogFragment {



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    String selectedCity;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public interface OnCitySelectedListener {
        void onCitySelected(String city);
    }

    private OnCitySelectedListener listener;

    public void setOnCitySelectedListener(OnCitySelectedListener listener) {
        this.listener = listener;
    }


    public bottomsheet_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment buttomsheet_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static bottomsheet_fragment newInstance(String param1, String param2) {
        bottomsheet_fragment fragment = new bottomsheet_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottomsheet_fragment, container, false);

        ListView listView = view.findViewById(R.id.city_listview);
        String[] cities = getResources().getStringArray(R.array.pakistani_cities);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, cities);
        listView.setAdapter(adapter);
        
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               selectedCity=parent.getItemAtPosition(position).toString();
               if (listener != null) {
                   listener.onCitySelected(selectedCity);
               }
               dismiss();
           }
       });



        return view;
    }
}