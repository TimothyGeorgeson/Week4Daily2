package com.example.consultants.week4daily2.model.data.remote;

import com.example.consultants.week4daily2.model.data.RepoCallback;
import com.example.consultants.week4daily2.model.githubresponse.RepoResponse;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RemoteObserver implements Observer<List<RepoResponse>> {

    RepoCallback callback;

    public RemoteObserver(RepoCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(List<RepoResponse> listRepos) {
        callback.onSuccess(listRepos);
    }

    @Override
    public void onError(Throwable e) {
        callback.onFailure(e.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
