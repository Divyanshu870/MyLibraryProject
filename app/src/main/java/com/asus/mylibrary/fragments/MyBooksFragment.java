package com.asus.mylibrary.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.asus.mylibrary.R;

/**
 * @author Jaypatelbond created on 15-03-2020.
 */

public class MyBooksFragment extends Fragment {

    public MyBooksFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_books, container, false);

        // Inflate the layout for this fragment
        return view;
    }
}
