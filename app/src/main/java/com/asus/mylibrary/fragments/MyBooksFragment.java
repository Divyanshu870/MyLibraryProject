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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.asus.mylibrary.R;
import com.asus.mylibrary.adapters.MyBooksAdapter;
import com.asus.mylibrary.listener.ClickListener;
import com.asus.mylibrary.model.MyBooksList;
import com.folioreader.FolioReader;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Jaypatelbond created on 15-03-2020.
 */

public class MyBooksFragment extends Fragment implements ClickListener {
    @BindView(R.id.recyclerViewMyBooks)
    RecyclerView recyclerViewMyBooks;
    @BindView(R.id.buttonAdd)
    Button buttonAdd;
    @BindView(R.id.viewEmptyAddBooks)
    LinearLayout viewEmptyAddBooks;
    MyBooksAdapter myBooksAdapter;
    RxPermissions rxPermissions;
    private File storage;
    private String[] storagePaths;

    public MyBooksFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerViewMyBooks.setVisibility(View.VISIBLE);
        recyclerViewMyBooks.setLayoutManager(new LinearLayoutManager(getContext()));

        //if you face lack in scrolling then add following lines
        recyclerViewMyBooks.setHasFixedSize(true);
        recyclerViewMyBooks.setItemViewCacheSize(20);
        recyclerViewMyBooks.setDrawingCacheEnabled(true);
        recyclerViewMyBooks.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recyclerViewMyBooks.setNestedScrollingEnabled(false);

        myBooksAdapter = new MyBooksAdapter(getContext(), getMyBookList());
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false);
        recyclerViewMyBooks.setLayoutManager(layoutManager);
        recyclerViewMyBooks.setAdapter(myBooksAdapter);
        myBooksAdapter.setClickListener(MyBooksFragment.this);


    }

    private List<MyBooksList> getMyBookList() {
        List<MyBooksList> myBooksLists = new ArrayList<>();
        myBooksLists.add(new MyBooksList(R.drawable.milk_and_honey, "Milk and Honey"));
        myBooksLists.add(new MyBooksList(R.drawable.the_sun_and_her_flower, "The Sun and Her Flower"));
        myBooksLists.add(new MyBooksList(R.drawable.the_lost_continent, "The Lost Continent"));
        myBooksLists.add(new MyBooksList(R.drawable.the_lost_oasis, "The Lost Oasis"));
        myBooksLists.add(new MyBooksList(R.drawable.the_time_machine, "The Time Machine"));
        myBooksLists.add(new MyBooksList(R.drawable.the_secret_island, "The Secret Island"));
        myBooksLists.add(new MyBooksList(R.drawable.war_and_peace, "War and Peace"));
        myBooksLists.add(new MyBooksList(R.drawable.worms_of_the_book, "Worms of the Book"));
        myBooksLists.add(new MyBooksList(R.drawable.frankenstein, "Frankenstein"));
        myBooksLists.add(new MyBooksList(R.drawable.around_the_world, "Around the World"));
        myBooksLists.add(new MyBooksList(R.drawable.happy_return, "Happy Return"));
        return myBooksLists;

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_books, container, false);
        ButterKnife.bind(this, view);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void ItemClicked(View view, int position) {
        FolioReader folioReader = FolioReader.get();
        // Opening Books(EPUB) from there postions
        if (position == 0) {
            folioReader.openBook("file:///android_asset/mil_and_honey.epub");
        }
        if (position == 1) {
            folioReader.openBook("file:///android_asset/the_sun_and_her_flowers.epub");
        }
        if (position == 2) {
            folioReader.openBook("file:///android_asset/burroughs_lost_continent.epub");
        }
        if (position == 3) {
            folioReader.openBook("file:///android_asset/dent_lost_oasis.epub");
        }
        if (position == 4) {
            folioReader.openBook("file:///android_asset/wells_time_machine.epub");
        }
        if (position == 5) {
            folioReader.openBook("file:///android_asset/blyton_secret_island.epub");
        }
        if (position == 6) {
            folioReader.openBook("file:///android_asset/howard_worms_of_the_earth.epub");
        }
        if (position == 7) {
            folioReader.openBook("file:///android_asset/shelley_frankenstein.epub");
        }
        if (position == 8) {
            folioReader.openBook("file:///android_asset/verne_around_the_world_in_80_days.epub");
        }
        if (position == 9) {
            folioReader.openBook("file:///android_asset/forester_happy_return.epub");
        }
    }
}
