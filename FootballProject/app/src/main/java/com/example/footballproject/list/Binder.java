package com.example.footballproject.list;

import com.example.footballproject.data.Team;

import java.util.List;

public interface Binder {
    interface View {
        void setTeams(List<Team> movieList);
    }

    interface Presenter {
        void onCreate();
    }

    interface Model {
        List<Team>  createTeams();
    }
}
