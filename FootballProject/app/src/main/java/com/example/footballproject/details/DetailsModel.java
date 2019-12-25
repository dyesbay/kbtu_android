package com.example.footballproject.details;

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

public class DetailsModel implements Binder.Model {
    public DetailsViewModel viewModel;
    public DetailsModel (DetailsViewModel viewModel){
        this.viewModel= viewModel;
    }
    @Override
    public void getTeam (int id){
        NetworkService.getInstance()
                .getApi()
                .getTeamByID(id)
                .enqueue(new Callback<LeagueApiResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<LeagueApiResponse> call, @NonNull Response<LeagueApiResponse> response) {
                        Team team;
                        System.out.println(response.toString());
                        try {
                            team = response.body().getResult().getTeams().get(0);
                            viewModel.onTeamLoaded(team);
                        }
                        catch (NullPointerException e){
                            System.out.println("No valid response");
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<LeagueApiResponse> call, @NonNull Throwable t) {
                        System.out.println("Loading team list failed");
                    }
                });

    }
}
