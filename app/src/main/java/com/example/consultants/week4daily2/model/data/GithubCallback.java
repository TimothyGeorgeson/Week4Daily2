package com.example.consultants.week4daily2.model.data;

import com.example.consultants.week4daily2.model.githubresponse.GithubResponse;

import java.util.List;

public interface GithubCallback {

    void onSuccess(List<GithubResponse> userInfo);

    void onFailure(String error);
}
