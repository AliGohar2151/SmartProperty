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

public class your_property_adapter extends RecyclerView.Adapter<your_property_adapter.yourProperty_viewholder> {


    Context context;
    private List<your_property_model> property_list;


    public your_property_adapter(Context context,List<your_property_model> property_list){
        this.context =context;
        this.property_list=property_list;
    }


    @NonNull
    @Override
    public your_property_adapter.yourProperty_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.your_property_recyclerview,parent,false);
        return new yourProperty_viewholder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull your_property_adapter.yourProperty_viewholder holder, int position) {

        your_property_model property=property_list.get(position);
        holder.title.setText(property.getTitle());
        holder.description.setText(property.getDescription());
        holder.demand.setText(property.getDemand());
        holder.location.setText(property.getLocation());
        holder.type.setText(property.getType());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,selected_property_activity.class);
                intent.putExtra("title",property.getTitle());
                intent.putExtra("description",property.getDescription());
                intent.putExtra("demand",property.getDemand());
                intent.putExtra("location",property.getLocation());
                intent.putExtra("type",property.getType());
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return property_list.size();
    }

    public static class yourProperty_viewholder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        TextView demand;
        TextView location;
        TextView type;

        public yourProperty_viewholder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txt_title);
            description = itemView.findViewById(R.id.txt_description);
            demand = itemView.findViewById(R.id.txt_demand);
            location = itemView.findViewById(R.id.txt_location);
            type=itemView.findViewById(R.id.txt_type);
        }
    }
}
