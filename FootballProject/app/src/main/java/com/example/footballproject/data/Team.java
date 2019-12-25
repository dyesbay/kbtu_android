package com.example.footballproject.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {
    @JsonProperty("team_id")
    private int id;
    @JsonProperty("name")
    private String title;
    @JsonProperty("venue_capacity")
    private int capacity;
    @JsonProperty("venue_name")
    private String stadium;
    @JsonProperty("founded")
    private String founded;
    @JsonProperty("venue_city")
    private String city;
    @JsonProperty("logo")
    public String logoURL;
}
