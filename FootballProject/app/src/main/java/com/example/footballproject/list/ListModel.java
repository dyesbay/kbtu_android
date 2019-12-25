package com.example.footballproject.list;

import androidx.annotation.NonNull;

import com.example.footballproject.R;
import com.example.footballproject.api.LeagueApiResponse;
import com.example.footballproject.api.NetworkService;
import com.example.footballproject.data.Team;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListModel implements Binder.Model {
    private final List<Team> teams = new ArrayList<>();
    private Binder.Presenter presenter;
    public ListModel (Binder.Presenter presenter){
        this.presenter = presenter;
    }
    @Override
    public void loadTeams (int leagueID){
        NetworkService.getInstance()
                .getApi()
                .getTeamsByLeagueID(leagueID)
                .enqueue(new Callback<LeagueApiResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<LeagueApiResponse> call,@NonNull Response<LeagueApiResponse> response) {
                        List <Team> buffer = new ArrayList<>();
                        System.out.println(response.toString());
                        try {
                            buffer = response.body().getResult().getTeams();
                        }
                        catch (NullPointerException e){
                            System.out.println("No valid response");
                        }
                        teams.clear();
                        teams.addAll(buffer);
                        presenter.callViewOnTeamsLoaded(teams);
                    }

                    @Override
                    public void onFailure(@NonNull Call<LeagueApiResponse> call, @NonNull Throwable t) {
                        t.printStackTrace();
                        System.out.println("Loading team list failed");
                    }
                });
    }
}
