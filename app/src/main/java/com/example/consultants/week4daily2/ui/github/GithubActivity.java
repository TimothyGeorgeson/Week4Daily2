package com.example.consultants.week4daily2.ui.github;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.consultants.week4daily2.R;
import com.example.consultants.week4daily2.model.data.GithubRepository;
import com.example.consultants.week4daily2.model.data.local.LocalDataSource;
import com.example.consultants.week4daily2.model.data.remote.RemoteDataSource;
import com.example.consultants.week4daily2.model.githubresponse.GithubResponse;

public class GithubActivity extends AppCompatActivity implements GithubContract.View {

    public static final String TAG = GithubActivity.class.getSimpleName() + "_TAG";
    private RemoteDataSource remoteDataSource;
    private GithubPresenter presenter;
    private EditText etGithub;
    private TextView tvItem1;
    private TextView tvItem2;
    private TextView tvItem3;
    private TextView tvItem4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGithub = findViewById(R.id.etGithub);
        tvItem1 = findViewById(R.id.tvItem1);
        tvItem2 = findViewById(R.id.tvItem2);
        tvItem3 = findViewById(R.id.tvItem3);
        tvItem4 = findViewById(R.id.tvItem4);
        remoteDataSource = new RemoteDataSource();

        presenter = new GithubPresenter(new GithubRepository(new LocalDataSource(), remoteDataSource), this);
    }

    public void clickGithub(View view) {
        switch (view.getId()) {
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

        Log.d(TAG, "userInfo: " + userInfo.getBio());

    }

    //finally got the data to UI, with this method
    @Override
    public void onSendingData(String bio, String company, String location, String blog) {
        tvItem1.setText("Bio: " + bio);
        tvItem2.setText("Company: " + company);
        tvItem3.setText("Location: " + location);
        tvItem4.setText("Blog: " + blog);
    }
}
