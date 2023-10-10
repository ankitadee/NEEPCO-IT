package com.example.neepco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.jar.Attributes;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private List<NewUserdata> items;
    private Context context;

    public MyAdapter(List<NewUserdata> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_adapter_layout, null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        NewUserdata myItems= items.get(position);
        holder.mFeed.setText(myItems.getmFeed());
        holder.mIssue.setText(myItems.getmIssue());
        holder.mName.setText(myItems.getmName());
        holder.mPhone.setText(myItems.getmPhone());
        holder.mDate.setText(myItems.getmDate());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    static class MyViewHolder extends RecyclerView.ViewHolder {
        private  TextView mName, mIssue, mFeed, mPhone, mDate;
        public MyViewHolder (@NonNull View itemView) {
            super(itemView);
            mFeed= itemView.findViewById(R.id.locTV);
            mIssue= itemView.findViewById(R.id.issueTV);
            mName= itemView.findViewById(R.id.nameTV);
            mPhone= itemView.findViewById(R.id.phoneTV);
            mDate= itemView.findViewById(R.id.dateTV);


        }
    }
}

