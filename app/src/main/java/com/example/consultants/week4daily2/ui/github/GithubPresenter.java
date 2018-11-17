package com.example.consultants.week4daily2.ui.github;

import android.util.Log;

import com.example.consultants.week4daily2.model.data.GithubRepository;
import com.example.consultants.week4daily2.model.data.RepoCallback;
import com.example.consultants.week4daily2.model.data.remote.RemoteDataSource;
import com.example.consultants.week4daily2.model.githubresponse.GithubResponse;
import com.example.consultants.week4daily2.model.githubresponse.RepoResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubPresenter implements GithubContract.Presenter {
    public static final String TAG = GithubPresenter.class.getSimpleName() + "_TAG";
    GithubContract.View view;
    GithubRepository repository;

    public GithubPresenter(GithubRepository repository, GithubContract.View view) {
        this.repository = repository;
        this.view = view;
    }

    @Override
    public void getUserInfo(String login) {
        Log.d(TAG, "getUserInfo: " + login);
        RemoteDataSource remoteDataSource = repository.getRemoteDataSource();
        remoteDataSource.getUserInfo(login).enqueue(new Callback<GithubResponse>() {
            @Override
            public void onResponse(Call<GithubResponse> call, Response<GithubResponse> response) {
                //moved this code into Presenter, couldn't get it to work in GithubRepository
                if (response.body() != null)
                {
                    String company = "";
                    if (response.body().getCompany() != null) {
                        company = response.body().getCompany().toString();
                    }

                    view.onUserInfo(response.body().getBio(),
                            company,
                            response.body().getLocation(),
                            response.body().getBlog());
                    Log.d(TAG, "onResponse: "+ response.body().getCompany());
                }
            }

            @Override
            public void onFailure(Call<GithubResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void getRepos(String login)
    {
        repository.getRepos(login, new RepoCallback() {
            @Override
            public void onSuccess(List<RepoResponse> repoList) {
                Log.d(TAG, "onSuccess: ");
                view.onRepos(repoList);
            }

            @Override
            public void onFailure(String error) {
                view.showError(error);
            }
        });
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
