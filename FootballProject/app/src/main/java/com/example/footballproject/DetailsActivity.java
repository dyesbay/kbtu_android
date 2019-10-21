package com.example.footballproject;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private TextView title, descriptionView, stadiumView, nickView, fView;
    private ImageView teamPosterView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        title = findViewById(R.id.team_title);
        descriptionView = findViewById(R.id.description);
        teamPosterView = findViewById(R.id.logo);
        stadiumView = findViewById(R.id.team_stadium);
        nickView = findViewById(R.id.team_nickname);
        fView = findViewById(R.id.team_founded);
        FloatingActionButton shareButton = findViewById(R.id.fab);

        final String teamTitle = getIntent().getStringExtra("team_title");
        final String nickname = "Прозвище: "  + getIntent().getStringExtra("team_nickname");
        final String founded = "Дата основания: " + getIntent().getStringExtra("team_founded");
        final String stadium = "Стадион: " + getIntent().getStringExtra("team_stadium");
        final String history = getIntent().getStringExtra("team_history");
        int poster = getIntent().getIntExtra("team_logo", 0);
        title.setText(teamTitle);
        descriptionView.setText(history);
        stadiumView.setText(stadium);
        nickView.setText(nickname);
        fView.setText(founded);
        setTitle(teamTitle);

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                String movieText = teamTitle + "\n" + nickname + "\n" + founded + "\n" + stadium + "\n" + history;
                sendIntent.putExtra(Intent.EXTRA_TEXT, movieText);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });

        Glide.with(this).load(poster).into(teamPosterView);

    }
}
