package com.example.footballproject.list;

import com.example.footballproject.data.Team;

import java.util.List;

public class ListPresenter implements Binder.Presenter {
    private Binder.View view;
    private Binder.Model model;

    private List<Team> teams;
    public ListPresenter(Binder.View mView) {
        this.view = mView;
        this.model = new ListModel();
    }

    @Override
    public void onCreate (){
        teams = model.createTeams();
        view.setTeams(teams);
    }


}
