package com.example.consultants.week4daily2.model.data.remote;

import com.example.consultants.week4daily2.model.data.GithubCallback;
import com.example.consultants.week4daily2.model.githubresponse.GithubResponse;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RemoteObserver implements Observer<GithubResponse> {

    GithubCallback callback;

    public RemoteObserver(GithubCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(GithubResponse githubResponse) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
