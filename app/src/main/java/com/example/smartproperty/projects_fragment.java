package com.example.smartproperty;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartproperty.projects_model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class projects_fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private projects_adapter adapter;
    private List<projects_model> projectsList;

    public projects_fragment() {
        // Required empty public constructor
    }

    public static projects_fragment newInstance(String param1, String param2) {
        projects_fragment fragment = new projects_fragment();
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

        // Initialize your data with random projects
        projectsList = generateRandomProjects(10); // Change 10 to the number of items you want

        // Adapter initialization and setup
        adapter = new projects_adapter(projectsList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_projects_fragment, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return view;
    }



    private List<projects_model> generateRandomProjects(int count) {
        List<projects_model> projects = new ArrayList<>();
        Random random = new Random();

        String[] titles = {
                "Luxury Apartment in Downtown",
                "Spacious Villa with Garden",
                "Modern Townhouse with Garage",
                "Cozy Studio in Urban Setting",
                "Family Home near Schools",
                "Seaside Retreat with Ocean View",
                "Charming Cottage in the Countryside",
                "Contemporary Loft in the City Center",
                "Mountain Chalet with Ski Access",
                "Historic Mansion with Landscaped Gardens"
        };

        String[] descriptions = {
                "Beautifully designed apartment with panoramic views of the city skyline.",
                "Large villa featuring multiple bedrooms, garden, and swimming pool, 6 bed rooms with attache bathroom.",
                "Newly built townhouse with modern amenities and private garage.",
                "Compact studio apartment perfect for young professionals.",
                "Ideal family home with spacious rooms and close proximity to schools.",
                "Secluded retreat offering stunning ocean views and beach access.",
                "Quaint cottage with rustic charm and peaceful surroundings.",
                "Sleek loft apartment designed for urban living with stylish interiors.",
                "Cosy chalet nestled in the mountains, perfect for winter sports enthusiasts.",
                "Historic mansion with elegant architecture and expansive grounds."
        };

        String[] demands = {
                "400,000 PKR",
                "650,000 PKR",
                "500,000 PKR",
                "300,000 PKR",
                "550,000 PKR",
                "800,000 PKR",
                "350,000 PKR",
                "420,000 PKR",
                "700,000 PKR",
                "1,200,000 PKR"
        };

        String[] locations = {
                "Downtown, Islamabad",
                "Bahria Town, Lahore",
                "Clifton, Karachi",
                "F-10, Islamabad",
                "Gulberg, Lahore",
                "Defence, Karachi",
                "Johar Town, Lahore",
                "G-11, Islamabad",
                "North Nazimabad, Karachi",
                "Model Town, Lahore"
        };

        String[] type={
                "Rent",
                "Sell",
                "Rent",
                "Sell",
                "Rent",
                "Sell",
                "Rent",
                "Rent",
                "Sell",
                "Rent"
        };

        int[] images = {
                R.drawable.project_placeholder,
                R.drawable.project_placeholder,
                R.drawable.project_placeholder,
                R.drawable.project_placeholder,
                R.drawable.project_placeholder,
                R.drawable.project_placeholder,
                R.drawable.project_placeholder,
                R.drawable.project_placeholder,
                R.drawable.project_placeholder,
                R.drawable.project_placeholder
        };

        for (int i = 0; i < count; i++) {
            int randomIndex = random.nextInt(titles.length);
            projects_model project = new projects_model(
                    titles[randomIndex],
                    descriptions[randomIndex],
                    images[randomIndex % images.length],
                    demands[randomIndex],
                    locations[randomIndex],
                    type[randomIndex]
            );
            projects.add(project);
        }

        return projects;
    }
}
