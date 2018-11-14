package com.example.consultants.week4daily2.ui.github;

import com.example.consultants.week4daily2.model.githubresponse.GithubResponse;
import com.example.consultants.week4daily2.ui.base.BasePresenter;
import com.example.consultants.week4daily2.ui.base.BaseView;

public interface GithubContract {

    interface View extends BaseView {

        void onUserInfo(GithubResponse userInfo);
    }

    interface Presenter extends BasePresenter<View> {

        void getUserInfo(String login);
    }
}
