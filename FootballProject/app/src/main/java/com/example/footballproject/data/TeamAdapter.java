package com.example.footballproject.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.footballproject.R;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.MyViewHolder> {
    private List<Team> teamsList;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, founded, nickname;
        public ImageView logo;
        public LinearLayout teamCard;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            nickname = (TextView) view.findViewById(R.id.nickname);
            founded = (TextView) view.findViewById(R.id.founded);
            logo = (ImageView) view.findViewById(R.id.logo);
            teamCard = (LinearLayout) view.findViewById(R.id.teamCard);
        }



    }
    public TeamAdapter(){
        super();
    }

    public TeamAdapter(Context mContext, List<Team> teamsList) {
        this.mContext=mContext;
        this.teamsList = teamsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.team_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Team team = teamsList.get(position);
        String nickText = "Город " + team.getCity();
        String foundedText = "Основан: " + team.getFounded();
        holder.title.setText(team.getTitle());
        holder.nickname.setText(nickText);
        holder.founded.setText(foundedText);
        Glide.with(mContext).load(team.getLogoURL()).into(holder.logo);
    }

    @Override
    public int getItemCount() {
        return teamsList.size();
    }

}
