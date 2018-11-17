package com.example.consultants.week4daily2.model.data;

import android.util.Log;

import com.example.consultants.week4daily2.model.data.local.LocalDataSource;
import com.example.consultants.week4daily2.model.data.remote.RemoteDataSource;
import com.example.consultants.week4daily2.model.data.remote.RemoteObserver;
import com.example.consultants.week4daily2.model.githubresponse.GithubResponse;
import com.example.consultants.week4daily2.ui.github.GithubContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubRepository {
    public static final String TAG = GithubRepository.class.getSimpleName() + "_TAG";

    LocalDataSource localDataSource;
    RemoteDataSource remoteDataSource;

    public GithubRepository(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    public RemoteDataSource getRemoteDataSource() {
        return remoteDataSource;
    }

    public LocalDataSource getLocalDataSource() {
        return localDataSource;
    }

    //unused, as I moved this logic to be done in presenter for now
    public void getUserInfo(String login) {
        Log.d(TAG, "getUserInfo: ");
        remoteDataSource.getUserInfo(login).enqueue(new Callback<GithubResponse>() {
            @Override
            public void onResponse(Call<GithubResponse> call, Response<GithubResponse> response) {
                if (response.body() != null) {
                    //I get a correct response here in logs, but didn't know how to get this value back to main UI
                    Log.d(TAG, "onResponse: "+ response.body().getCompany());
                }
            }

            @Override
            public void onFailure(Call<GithubResponse> call, Throwable t) {

            }
        });
    }

    public void getRepos(String login, final RepoCallback callback) {

        remoteDataSource.getRepositoriesObs(login)
//                    make the network call on the worker thread
                .subscribeOn(Schedulers.io())
//                    get the results back on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RemoteObserver(callback));


    }

}




