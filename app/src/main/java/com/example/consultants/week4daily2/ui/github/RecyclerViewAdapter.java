package com.example.consultants.week4daily2.ui.github;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.consultants.week4daily2.R;
import com.example.consultants.week4daily2.model.data.local.MyRepo;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<MyRepo> repoList;

    public RecyclerViewAdapter(List<MyRepo> repoList) {
        this.repoList = repoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final MyRepo repo = repoList.get(i);

        viewHolder.tvName.setText(repo.getName());
        viewHolder.tvCreated.setText(repo.getCreated());
        viewHolder.tvBranch.setText(repo.getBranch());
    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvCreated;
        TextView tvBranch;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvCreated = itemView.findViewById(R.id.tvCreated);
            tvBranch = itemView.findViewById(R.id.tvBranch);
        }
    }
}
