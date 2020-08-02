package com.example.sih_v2.retailer;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sih_v2.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class PostAdapter extends FirebaseRecyclerAdapter<post,PostAdapter.PastViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public PostAdapter(@NonNull FirebaseRecyclerOptions<post> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PastViewHolder holder, int position, @NonNull post model) {
        holder.address.setText(model.getAddress());
        holder.agencyName.setText(model.getAgency_name());
        holder.contact.setText(model.getContact());
        holder.dId.setText(model.getDealer_ID()+"");
        holder.dist.setText(model.getDistrict());
        holder.personName.setText(model.getPerson_Name());
        holder.state.setText(model.getState());

        //Toast.makeText(PostAdapter.this,"Select District "+model.getState(),Toast.LENGTH_SHORT).show();

    }

    @NonNull
    @Override
    public PastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.msg, parent, false);

        return new PastViewHolder(view);
    }

    class PastViewHolder extends RecyclerView.ViewHolder{
        TextView agencyName,personName,contact,address,dId,dist,state;

        public PastViewHolder(@NonNull View itemView) {
            super(itemView);
            address = itemView.findViewById(R.id.address);
            agencyName = itemView.findViewById(R.id.agencyName);
            contact = itemView.findViewById(R.id.contact);
            dId = itemView.findViewById(R.id.dealerId);
            dist = itemView.findViewById(R.id.district);
            personName = itemView.findViewById(R.id.personName);
            state = itemView.findViewById(R.id.state);

        }
    }
}