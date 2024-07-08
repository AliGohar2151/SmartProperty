package com.example.smartproperty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;

public class agent_adapter extends RecyclerView.Adapter<agent_adapter.AgentViewHolder> {

    private List<agent_model> agentList;
    private Context context;

    public agent_adapter(List<agent_model> agentList, Context context) {
        this.agentList = agentList;
        this.context = context;
    }

    @NonNull
    @Override
    public AgentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.findagent_recyclerview, parent, false);
        return new AgentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AgentViewHolder holder, int position) {
        agent_model agent = agentList.get(position);
        holder.name.setText(agent.getName());
        holder.profilePic.setImageResource(agent.getProfileImage());
        // Set listeners for buttons if necessary
    }

    @Override
    public int getItemCount() {
        return agentList.size();
    }

    public static class AgentViewHolder extends RecyclerView.ViewHolder {

        CircleImageView profilePic;
        TextView name;
        MaterialButton callButton, messageButton;

        public AgentViewHolder(@NonNull View itemView) {
            super(itemView);
            profilePic = itemView.findViewById(R.id.profile_pic);
            name = itemView.findViewById(R.id.txt_name);
            callButton = itemView.findViewById(R.id.call_button);
            messageButton = itemView.findViewById(R.id.message_button);
        }
    }
}
