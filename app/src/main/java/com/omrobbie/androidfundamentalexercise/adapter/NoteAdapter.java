package com.omrobbie.androidfundamentalexercise.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.omrobbie.androidfundamentalexercise.DetailActivity;
import com.omrobbie.androidfundamentalexercise.R;
import com.omrobbie.androidfundamentalexercise.model.Note;
import com.omrobbie.androidfundamentalexercise.utils.DateTime;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by omrobbie on 25/11/2017.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private List<Note> list;

    public NoteAdapter(List<Note> list) {
        this.list = list;
    }

    public void update(Note item) {
        list.add(item);
        notifyDataSetChanged();
    }

    public void replace(List<Note> items) {
        list = items;
        notifyDataSetChanged();
    }

    public void clear() {
        list.clear();
        notifyDataSetChanged();
    }

    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_note, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(NoteAdapter.ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        TextView tv_title;

        @BindView(R.id.tv_datetime)
        TextView tv_datetime;

        @BindView(R.id.tv_content)
        TextView tv_content;

        @BindView(R.id.iv_notification)
        ImageView iv_notification;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final Note item) {
            tv_title.setText(item.getTitle());
            tv_datetime.setText(DateTime.getLongDate(item.getDateTime()));
            tv_content.setText(item.getContent());

            if (DateTime.isGreaterThanNow(item.getDateTime_Notif())) {
                iv_notification.setVisibility(View.VISIBLE);
            } else iv_notification.setVisibility(View.GONE);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                    intent.putExtra(DetailActivity.DATA, new Gson().toJson(item));
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
