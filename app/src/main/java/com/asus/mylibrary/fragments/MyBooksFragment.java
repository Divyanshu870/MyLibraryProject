package com.asus.mylibrary.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.asus.mylibrary.R;
import com.asus.mylibrary.adapters.Constant;
import com.asus.mylibrary.adapters.MyBooksAdapter;
import com.asus.mylibrary.utils.SearchDocument;
import com.asus.mylibrary.utils.StorageUtil;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Jaypatelbond created on 15-03-2020.
 */

public class MyBooksFragment extends Fragment {
    @BindView(R.id.recyclerViewMyBooks)
    RecyclerView recyclerViewMyBooks;
    @BindView(R.id.buttonAdd)
    Button buttonAdd;
    @BindView(R.id.viewEmptyAddBooks)
    LinearLayout viewEmptyAddBooks;
    MyBooksAdapter myBooksAdapter;
    RxPermissions rxPermissions;

    public MyBooksFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initLoadDocuments();

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_books, container, false);
        ButterKnife.bind(this, view);
        recyclerViewMyBooks.setVisibility(View.VISIBLE);
        recyclerViewMyBooks.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        //if you face lack in scrolling then add following lines
        recyclerViewMyBooks.setHasFixedSize(true);
        recyclerViewMyBooks.setItemViewCacheSize(20);
        recyclerViewMyBooks.setDrawingCacheEnabled(true);
        recyclerViewMyBooks.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recyclerViewMyBooks.setNestedScrollingEnabled(false);

        myBooksAdapter = new MyBooksAdapter(getContext());

        recyclerViewMyBooks.setAdapter(myBooksAdapter);
        // Inflate the layout for this fragment
        return view;
    }

    private void initLoadDocuments() {
        //load data here
        String[] storagePaths = StorageUtil.getStorageDirectories(getContext());

        for (String path : storagePaths) {
            File storage = new File(path);
            SearchDocument.load_Directory_Files(storage);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
