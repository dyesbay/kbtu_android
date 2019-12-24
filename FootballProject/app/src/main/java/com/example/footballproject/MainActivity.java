package com.example.footballproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballproject.data.Team;
import com.example.footballproject.data.TeamAdapter;
import com.example.footballproject.details.Details;
import com.example.footballproject.list.ListFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements com.example.footballproject.list.ListFragment.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ListFragment listFragment = new ListFragment();
        ft.replace(R.id.main_container, listFragment);
        ft.commit();
    }

    @Override
    public void onTeamClicked (int id){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Details detailsFragment = Details.newInstance(id);
        ft.replace(R.id.main_container, detailsFragment).addToBackStack( "tag" ).commit();
    }

}
