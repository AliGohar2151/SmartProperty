package com.example.smartproperty;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class findAgents_activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private agent_adapter agentAdapter;
    private List<agent_model> agentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_find_agents);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.agent_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Toolbar toolbar = findViewById(R.id.toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        // Sample data
        agentList = new ArrayList<>();
        agentList.add(new agent_model("Raja Shahab Haider", R.drawable.profilepic));
        agentList.add(new agent_model("John Doe", R.drawable.profilepic));
        agentList.add(new agent_model("Jane Smith", R.drawable.profilepic));

        agentAdapter = new agent_adapter(agentList, this);
        recyclerView.setAdapter(agentAdapter);
    }
}