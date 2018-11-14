package com.example.consultants.week4daily2.ui.github;

import android.util.Log;

import com.example.consultants.week4daily2.MainController;
import com.example.consultants.week4daily2.model.data.GithubCallback;
import com.example.consultants.week4daily2.model.data.GithubRepository;
import com.example.consultants.week4daily2.model.data.remote.RemoteDataSource;
import com.example.consultants.week4daily2.model.githubresponse.GithubResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubPresenter implements GithubContract.Presenter {
    public static final String TAG = GithubPresenter.class.getSimpleName() + "_TAG";
    GithubContract.View view;
    GithubRepository repository;
    RemoteDataSource remoteDataSource;

    public GithubPresenter(GithubRepository repository, GithubContract.View view) {
        this.repository = repository;
        remoteDataSource = new RemoteDataSource();
        this.view = view;
    }

    @Override
    public void getUserInfo(String login) {
        Log.d(TAG, "getUserInfo: " + login);
        remoteDataSource.getUserInfo(login).enqueue(new Callback<GithubResponse>() {
            @Override
            public void onResponse(Call<GithubResponse> call, Response<GithubResponse> response) {
                //moved this code into Presenter, couldn't get it to work in GithubRepository
                if (response.body() != null)
                {
                    view.onSendingData(response.body().getBio().toString(),
                            response.body().getCompany().toString(),
                            response.body().getLocation().toString(),
                            response.body().getBlog().toString());
                    Log.d(TAG, "onResponse: "+ response.body().getCompany());
                }
            }

            @Override
            public void onFailure(Call<GithubResponse> call, Throwable t) {

            }
        });


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
