package com.example.consultants.week4daily2.ui.github;

import com.example.consultants.week4daily2.model.githubresponse.GithubResponse;
import com.example.consultants.week4daily2.model.githubresponse.RepoResponse;
import com.example.consultants.week4daily2.ui.base.BasePresenter;
import com.example.consultants.week4daily2.ui.base.BaseView;

import java.util.List;

public interface GithubContract {

    interface View extends BaseView {

        void onUserInfo(String bio, String company, String location, String blog);
        void onRepos(List<RepoResponse> repoList);
    }

    interface Presenter extends BasePresenter<View> {

        void getUserInfo(String login);
        void getRepos(String login);
    }
}
