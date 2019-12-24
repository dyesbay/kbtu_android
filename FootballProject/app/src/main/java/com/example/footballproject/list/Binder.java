package com.example.footballproject.list;

import com.example.footballproject.data.Team;

import java.util.List;

public interface Binder {
    interface View {
        void setTeams(List<Team> movieList);
    }

    interface Presenter {
        void onCreate();
        void callViewOnTeamsLoaded(List <Team> teams);
        void onListItemClicked(ListFragment.OnFragmentInteractionListener listener, int position);
    }

    interface Model {
        void loadTeams(int leagueID);
    }
}
