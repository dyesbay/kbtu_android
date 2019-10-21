package com.example.footballproject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    private String title, nickname,  stadium,founded, history;
    public int logo;
}
