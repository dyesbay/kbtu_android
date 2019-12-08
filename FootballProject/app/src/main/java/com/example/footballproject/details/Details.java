package com.example.footballproject.details;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.footballproject.R;
import com.example.footballproject.data.Team;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Details extends Fragment implements Binder.View {
    private static final String TEAMID = "teamid";
    private int teamId;
    private DetailsPresenter presenter;
    private OnFragmentInteractionListener mListener;
    private TextView title, descriptionView, stadiumView, nickView, fView;
    private ImageView teamPosterView;
    public static Details newInstance(int position) {
        Details fragment = new Details();
        Bundle args = new Bundle();
        args.putInt(TEAMID, position);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            teamId = getArguments().getInt(TEAMID);
        }
        presenter = new DetailsPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        title = view.findViewById(R.id.team_title);
        descriptionView = view.findViewById(R.id.description);
        teamPosterView = view.findViewById(R.id.logo);
        stadiumView = view.findViewById(R.id.team_stadium);
        nickView = view.findViewById(R.id.team_nickname);
        fView = view.findViewById(R.id.team_founded);
//        configureShareButton(view);

        return view;
    }

    public void setTeam (Team team){
        title.setText(team.getTitle());
        descriptionView.setText(team.getHistory());
        stadiumView.setText(team.getStadium());
        nickView.setText(team.getNickname());
        fView.setText(team.getFounded());
        getActivity().setTitle(team.getTitle());
        Glide.with(getContext()).load(team.getLogo()).into(teamPosterView);

    }
//    private void configureShareButton (View view){
//        FloatingActionButton shareButton = view.findViewById(R.id.fab);
//        shareButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent sendIntent = new Intent();
//                sendIntent.setAction(Intent.ACTION_SEND);
//                Team team = presenter.getTeam();
//                String movieText = team.getTitle() + "\n" + team.getNickname() + "\n" + team.getFounded() + "\n" + team.getStadium() + "\n" + team.getHistory();
//                sendIntent.putExtra(Intent.EXTRA_TEXT, movieText);
//                sendIntent.setType("text/plain");
//
//                Intent shareIntent = Intent.createChooser(sendIntent, null);
//                startActivity(shareIntent);
//            }
//        });
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
    }
}
