package com.example.footballproject.api;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ApiEndpoints{
    @Headers({"x-rapidapi-host:api-football-v1.p.rapidapi.com", "x-rapidapi-key:6ccaa461e6mshe2a26e8f1ef35aep15eefcjsnad19b41b5b5c"})
    @GET("/v2/teams/team/{team_id}")
    Call<LeagueApiResponse> getTeamByID(@Path("team_id") int id);

    @Headers({"x-rapidapi-host:api-football-v1.p.rapidapi.com", "x-rapidapi-key:6ccaa461e6mshe2a26e8f1ef35aep15eefcjsnad19b41b5b5c"})
    @GET("/v2/teams/league/{league_id}")
    Call<LeagueApiResponse> getTeamsByLeagueID(@Path("league_id") int id);
}
