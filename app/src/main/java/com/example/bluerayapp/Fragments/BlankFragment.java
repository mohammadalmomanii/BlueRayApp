package com.example.bluerayapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bluerayapp.R;


public class BlankFragment extends Fragment {


    static String title;
    TextView textView;

    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance(String s){
        BlankFragment fragment=new BlankFragment();
        title=s;
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_blank, container, false);
        textView=view.findViewById(R.id.txt);
        textView.setText(title);
        return view;
    }
}