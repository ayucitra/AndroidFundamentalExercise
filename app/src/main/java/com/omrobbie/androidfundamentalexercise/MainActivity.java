package com.omrobbie.androidfundamentalexercise;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.omrobbie.androidfundamentalexercise.adapter.NoteAdapter;
import com.omrobbie.androidfundamentalexercise.model.Note;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.progress_bar)
    ProgressBar progress_bar;

    @BindView(R.id.rv_notes)
    RecyclerView rv_notes;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    private NoteAdapter adapter;
    private List<Note> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupEnv();
        setupList();

        fab.setOnClickListener(this);

        loadDummyData();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:
                break;
        }
    }

    private void setupEnv() {
        ButterKnife.bind(this);
    }

    private void setupList() {
        adapter = new NoteAdapter(notes);
        rv_notes.setLayoutManager(new LinearLayoutManager(this));
        rv_notes.setAdapter(adapter);
    }

    private void loadDummyData() {
        for (int i = 0; i < 10; i++) {
            notes.add(new Note(i, "Title " + i, "Content " + i, "date"));
        }
        progress_bar.setVisibility(View.GONE);
    }
}
