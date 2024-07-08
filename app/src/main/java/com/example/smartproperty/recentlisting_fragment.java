package com.example.smartproperty;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class recentlisting_fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private projects_adapter adapter;
    private List<projects_model> recentListingsList;
    private Context context;

    public recentlisting_fragment() {
        // Required empty public constructor
    }

    public static recentlisting_fragment newInstance(String param1, String param2) {
        recentlisting_fragment fragment = new recentlisting_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        // Initialize your data with random recent listings
        recentListingsList = generateRandomRecentListings(5); // Change 10 to the number of items you want

        // Adapter initialization and setup
        adapter = new projects_adapter(context, recentListingsList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recentlisting_fragment, container, false);

        recyclerView = view.findViewById(R.id.recent_recycler_view);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<projects_model> generateRandomRecentListings(int count) {
        List<projects_model> recentListings = new ArrayList<>();
        Random random = new Random();

        String[] titles = {
                "Luxury Apartment in Downtown",
                "Spacious Villa with Garden",
                "Modern Townhouse with Garage",
                "Cozy Studio in Urban Setting",
        };

        String[] descriptions = {
                "Beautifully designed apartment with panoramic views of the city skyline.",
                "Large villa featuring multiple bedrooms, garden, and swimming pool, 6 bed rooms with attache bathroom.",
                "Newly built townhouse with modern amenities and private garage.",
                "Compact studio apartment perfect for young professionals.",

        };

        String[] demands = {
                "400,000",
                "650,000",
                "500,000",
                "300,000",

        };

        String[] locations = {
                "Downtown, Islamabad",
                "Bahria Town, Lahore",
                "Clifton, Karachi",
                "F-10, Islamabad",

        };

        String[] type = {
                "Rent",
                "Sell",
                "Rent",
                "Sell",

        };

        int[] images = {
                R.drawable.project_placeholder,
                R.drawable.project_placeholder,
                R.drawable.project_placeholder,
                R.drawable.project_placeholder,
        };

        for (int i = 0; i < count; i++) {
            int randomIndex = random.nextInt(titles.length);
            projects_model recentListing = new projects_model(
                    titles[randomIndex],
                    descriptions[randomIndex],
                    images[randomIndex % images.length],
                    demands[randomIndex],
                    locations[randomIndex],
                    type[randomIndex]
            );
            recentListings.add(recentListing);
        }

        return recentListings;
    }
}
