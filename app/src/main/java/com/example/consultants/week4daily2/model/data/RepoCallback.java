package com.example.consultants.week4daily2.model.data;

import com.example.consultants.week4daily2.model.githubresponse.RepoResponse;

import java.util.List;

public interface RepoCallback {

    void onSuccess(List<RepoResponse> repoList);

    void onFailure(String error);
}
