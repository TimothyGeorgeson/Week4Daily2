package com.example.consultants.week4daily2.ui.github;

import android.util.Log;

import com.example.consultants.week4daily2.MainController;
import com.example.consultants.week4daily2.model.data.GithubCallback;
import com.example.consultants.week4daily2.model.data.GithubRepository;
import com.example.consultants.week4daily2.model.githubresponse.GithubResponse;

import java.util.List;

public class GithubPresenter implements GithubContract.Presenter {
    public static final String TAG = GithubPresenter.class.getSimpleName() + "_TAG";
    GithubContract.View view;
    GithubRepository repository;

    public GithubPresenter(GithubRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getUserInfo(String login) {

        repository.getUserInfo(login);

        Log.d(TAG, "Presenter result ");

        //I think this runs before getUserInfo() call finishes, and its always null
        if (MainController.getInstance().getResponse() != null)
            view.onUserInfo(MainController.getInstance().getResponse());

    }

    @Override
    public void onAttach(GithubContract.View view) {

        this.view = view;
    }

    @Override
    public void onDetach() {

        this.view = null;
    }
}
