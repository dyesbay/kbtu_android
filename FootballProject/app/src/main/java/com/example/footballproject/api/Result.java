package com.example.footballproject.api;

import com.example.footballproject.data.Team;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    @JsonProperty("teams")
    List<Team> teams;
}