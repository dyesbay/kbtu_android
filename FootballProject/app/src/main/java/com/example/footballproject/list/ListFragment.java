package com.example.footballproject.list;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.footballproject.R;
import com.example.footballproject.data.Team;
import com.example.footballproject.data.TeamAdapter;

import java.util.List;

public class ListFragment extends Fragment implements Binder.View{
    private OnFragmentInteractionListener mListener;
    private Binder.Presenter presenter;
    private RecyclerView recyclerView;
    private TeamAdapter mAdapter;

    public ListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ListPresenter(this);
        mListener = (OnFragmentInteractionListener) getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_list, container, false);
        configureRecyclerView(view);

//        requireActivity().setTitle("Футбольные клубы Англии");
        return view;
    }

    @Override
    public void setTeams(List<Team> teams){
        mAdapter = new TeamAdapter(getContext(), teams);
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    private void configureRecyclerView (View view){
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL));
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        presenter.onCreate();
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                presenter.onListItemClicked(mListener,position);
            }
            @Override
            public void onLongClick(View view, int position) {}
        }));
    }

    public interface OnFragmentInteractionListener {
        void onTeamClicked(int TeamID);
    }
}
