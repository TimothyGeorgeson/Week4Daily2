package com.example.consultants.week4daily2;

import com.example.consultants.week4daily2.model.githubresponse.GithubResponse;

public class MainController {

    public static MainController instance;
    GithubResponse response;

    private MainController()
    {

    }

    public static MainController getInstance()
    {
        if(instance == null)
        {
            instance = new MainController();
        }
        return instance;
    }

    public void setResponse(GithubResponse response)
    {
        this.response = response;
    }

    public GithubResponse getResponse()
    {
        return response;
    }
}
