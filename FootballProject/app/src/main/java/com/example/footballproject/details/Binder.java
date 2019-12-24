package com.example.footballproject.details;

import com.example.footballproject.data.Team;

import java.util.List;

public interface Binder {
    interface View {
        void setTeam(Team team);
    }

    interface Presenter {
        void onCreate(int id);
        void onTeamLoaded(Team team);
    }

    interface Model {
        void getTeam(int id);
    }
}
