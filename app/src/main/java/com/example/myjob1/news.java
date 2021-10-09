package com.example.myjob1;

import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class news extends Fragment {

    public news() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //将xml文件压缩至container
        return inflater.inflate(R.layout.fragment_news, container, false);
    }
}