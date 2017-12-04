package com.omrobbie.androidfundamentalexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;
import com.omrobbie.androidfundamentalexercise.model.Note;
import com.omrobbie.androidfundamentalexercise.utils.DateTime;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    public static String DATA = "DATA_DETAIL";

    @BindView(R.id.et_title)
    TextView et_title;

    @BindView(R.id.tv_datetime)
    TextView tv_datetime;

    @BindView(R.id.et_content)
    TextView et_content;

    private boolean isVisible;

    private Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setupEnv();
        setupData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_notification, menu);

        menu.findItem(R.id.mn_notif_on).setVisible(isVisible);
        menu.findItem(R.id.mn_notif_off).setVisible(!isVisible);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mn_notif_on:
                setNotifMenuOn(false);
                break;

            case R.id.mn_notif_off:
                setNotifMenuOn(true);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupEnv() {
        ButterKnife.bind(this);
        invalidateOptionsMenu();

        String json = getIntent().getStringExtra(DATA);
        note = new Gson().fromJson(json, Note.class);
    }

    private void setupData() {
        et_title.setText(note.getTitle());
        tv_datetime.setText(DateTime.getLongDate(note.getDateTime()));
        et_content.setText(note.getContent());

        if (DateTime.isGreaterThanNow(note.getDateTime_Notif())) setNotifMenuOn(true);
        else setNotifMenuOn(false);
    }

    private void setNotifMenuOn(boolean on) {
        isVisible = on;
        invalidateOptionsMenu();
    }
}
