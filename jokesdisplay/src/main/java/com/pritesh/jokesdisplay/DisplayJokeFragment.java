package com.pritesh.jokesdisplay;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DisplayJokeFragment extends Fragment {

    public DisplayJokeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_display_joke, container, false);

        Intent intent = getActivity().getIntent();
        String joke = intent.getStringExtra(DisplayJoke.JOKE_KEY);
        TextView jokeTextView = (TextView) view.findViewById(R.id.joke);
        if (joke != null && joke.length() != 0) {
            jokeTextView.setText(joke);
        }

        return view;
    }
}
