package com.example.consultants.week4daily2.ui.github;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.consultants.week4daily2.R;
import com.example.consultants.week4daily2.model.data.GithubRepository;
import com.example.consultants.week4daily2.model.data.local.LocalDataSource;
import com.example.consultants.week4daily2.model.data.remote.RemoteDataSource;
import com.example.consultants.week4daily2.model.githubresponse.GithubResponse;

public class GithubActivity extends AppCompatActivity implements GithubContract.View{

    public static final String TAG = GithubActivity.class.getSimpleName() + "_TAG";
    private RemoteDataSource remoteDataSource;
    private GithubPresenter presenter;
    private EditText etGithub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGithub = findViewById(R.id.etGithub);
        remoteDataSource = new RemoteDataSource();

        presenter = new GithubPresenter(new GithubRepository(new LocalDataSource(), remoteDataSource));
    }

    public void clickGithub(View view) {
        switch (view.getId())
        {
            case R.id.btnProfile:
                presenter.getUserInfo(etGithub.getText().toString());
                break;
            case R.id.btnRepositories:

                break;
        }
    }

    @Override
    public void showError(String error) {

        Log.d(TAG, "showError: " + error);
    }

    @Override
    public void onUserInfo(GithubResponse userInfo) {

        Log.d(TAG, "userInfo: "+ userInfo.getBio());

    }
}
