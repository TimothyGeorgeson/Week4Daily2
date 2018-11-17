package com.example.consultants.week4daily2.model.data.remote;

import com.example.consultants.week4daily2.model.githubresponse.GithubResponse;
import com.example.consultants.week4daily2.model.githubresponse.RepoResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RemoteService {

    //    using the call object
    @GET("users/{user}")
    Call<GithubResponse> getUserInfo(@Path("user") String login);

    //    using the rxjava observable
    @GET("users/{user}/repos")
    Observable<List<RepoResponse>> getRepositoriesObs(@Path("user") String login);

}
