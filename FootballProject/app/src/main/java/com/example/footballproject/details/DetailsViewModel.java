package com.example.footballproject.details;

import com.example.footballproject.data.Team;

import java.util.List;

import lombok.Getter;

public class DetailsViewModel implements Binder.Presenter {
    private Binder.View view;
    private Binder.Model model;
    @Getter
    private Team team;

    public DetailsViewModel(Binder.View mView) {
        this.view = mView;
        this.model = new DetailsModel(this);
    }

    @Override
    public void onCreate (int id){
        model.getTeam(id);

    }

    @Override
    public void onTeamLoaded(Team team) {
        team=team;
        view.setTeam(team);

    }
}
