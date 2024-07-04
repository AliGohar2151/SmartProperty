package com.example.smartproperty;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class projects_adapter extends RecyclerView.Adapter<projects_adapter.projects_viewholder> {


    Context context;
    private  List<projects_model> projects_list;

    public projects_adapter(Context context, List<projects_model> projects_list){
        this.context = context;

        this.projects_list=projects_list;
    }

    @NonNull
    @Override
    public projects_adapter.projects_viewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.projects_recyclerview,parent,false);
        return new projects_viewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull projects_viewholder holder, int position) {
        projects_model project = projects_list.get(position);
        holder.title.setText(project.getTitle());
        holder.description.setText(project.getDescription());
        holder.demand.setText(project.getDemand());
        holder.location.setText(project.getLocation());
        holder.type.setText(project.getType());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,selected_property_activity.class);
                intent.putExtra("title",project.getTitle());
                intent.putExtra("description",project.getDescription());
                intent.putExtra("demand",project.getDemand());
                intent.putExtra("location",project.getLocation());
                intent.putExtra("type",project.getType());
                context.startActivity(intent);

            }
        });

    }


    @Override
    public int getItemCount() {
        return projects_list.size();
    }

    public static class projects_viewholder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        TextView demand;
        TextView location;
        TextView type;

        public projects_viewholder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txt_title);
            description = itemView.findViewById(R.id.txt_description);
            demand = itemView.findViewById(R.id.txt_demand);
            location = itemView.findViewById(R.id.txt_location);
            type=itemView.findViewById(R.id.txt_type);

        }
    }


}
