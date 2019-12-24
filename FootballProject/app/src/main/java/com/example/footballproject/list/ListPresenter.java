package com.example.footballproject.list;

import com.example.footballproject.data.Team;

import java.util.List;

public class ListPresenter implements Binder.Presenter {
    private Binder.View view;
    private Binder.Model model;

    private List<Team> teams;
    public ListPresenter(Binder.View mView) {
        this.view = mView;
        this.model = new ListModel(this);
    }

    @Override
    public void onCreate (){
        model.loadTeams(3);
    }

    @Override
    public void callViewOnTeamsLoaded (List<Team> teams){
        view.setTeams(teams);
        this.teams=teams;
    }

    @Override
    public void onListItemClicked(ListFragment.OnFragmentInteractionListener listener, int position) {
        Team team = teams.get(position);
        listener.onTeamClicked(team.getId());
    }
}
