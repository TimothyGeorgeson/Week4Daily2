package com.example.consultants.week4daily2.model.data.remote;

import com.example.consultants.week4daily2.model.githubresponse.GithubResponse;
import com.example.consultants.week4daily2.utils.NetworkHelper;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {

    private Retrofit createInstance() {

        return new Retrofit.Builder()
                .baseUrl(NetworkHelper.BASE_GITHUB_URL)
//                use for converting the response using Gson
                .addConverterFactory(GsonConverterFactory.create())
                //using rxjava adapter
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private  RemoteService getRemoteService() {
        return createInstance().create(RemoteService.class);
    }

    //use call object
    public Call<GithubResponse> getUserInfo(String login) {

        return getRemoteService().getUserInfo(login);
    }

    //using rxjava
    public Observable<GithubResponse> getUserInfoObs(String username) {
        return getRemoteService().getRandomUserObs(username);
    }
}
