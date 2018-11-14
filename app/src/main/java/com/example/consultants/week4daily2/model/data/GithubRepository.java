package com.example.consultants.week4daily2.model.data;

import android.util.Log;

import com.example.consultants.week4daily2.MainController;
import com.example.consultants.week4daily2.model.data.local.LocalDataSource;
import com.example.consultants.week4daily2.model.data.remote.RemoteDataSource;
import com.example.consultants.week4daily2.model.githubresponse.GithubResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubRepository {
    public static final String TAG = GithubRepository.class.getSimpleName() + "_TAG";

    LocalDataSource localDataSource;
    RemoteDataSource remoteDataSource;
    GithubResponse responseBody;

    public GithubRepository(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    public GithubResponse getUserInfo(String login) {

        Log.d(TAG, "getUserInfo: ");

        remoteDataSource.getUserInfo(login).enqueue(new Callback<GithubResponse>() {

            @Override
            public void onResponse(Call<GithubResponse> call, Response<GithubResponse> response) {

                if (response.body() != null)
                {
                    //tried saving it to a field variable and returning
                    setResponseBody(response.body());
                    //then tried singleton controller class
                    MainController.getInstance().setResponse(response.body());
                    //I get a correct response here in logs, but don't know how to get this value back to main UI
                    Log.d(TAG, "onResponse: "+ response.body().getCompany());
                }
            }

            @Override
            public void onFailure(Call<GithubResponse> call, Throwable t) {

            }
        });
        //Log.d(TAG, "getUserInfo: OutsideCall " + responseBody.getCompany());
        return responseBody;
    }

    private void setResponseBody(GithubResponse response)
    {
        responseBody = response;
    }

}




