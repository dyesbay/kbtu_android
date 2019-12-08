package com.example.footballproject.details;

import com.example.footballproject.data.Team;

import java.util.List;

import lombok.Getter;

public class DetailsPresenter implements Binder.Presenter {
    private Binder.View view;
    private Binder.Model model;
    @Getter
    private Team team;

    public DetailsPresenter(Binder.View mView) {
        this.view = mView;
        this.model = new DetailsModel();
    }

    @Override
    public void onCreate (int id){
        team = model.getTeam(id);
        view.setTeam(team);
    }


}
