package com.example.consultants.week4daily2.ui.github;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.consultants.week4daily2.R;
import com.example.consultants.week4daily2.model.data.local.MyRepo;

import java.util.ArrayList;

public class RepoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo);

        RecyclerView rvRepoList;
        RecyclerViewAdapter adapter;
        RecyclerView.LayoutManager layoutManager;

        //get array list from parcelable
        ArrayList<MyRepo> repoList = getIntent().getParcelableArrayListExtra("repos");

        //set adapter
        adapter = new RecyclerViewAdapter(repoList);
        layoutManager = new LinearLayoutManager(this);
        rvRepoList = findViewById(R.id.rvRepoList);
        rvRepoList.setAdapter(adapter);
        rvRepoList.setLayoutManager(layoutManager);
    }
}
