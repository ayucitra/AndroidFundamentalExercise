package com.omrobbie.androidfundamentalexercise.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by omrobbie on 25/11/2017.
 */

public class Note implements Parcelable {

    private int id;
    private String title;
    private String content;
    private String dateTime;
    private String dateTime_Alarm;

    public Note() {
    }

    public Note(int id, String title, String content, String dateTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.dateTime = dateTime;
    }

    public Note(int id, String title, String content, String dateTime, String dateTime_Alarm) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.dateTime = dateTime;
        this.dateTime_Alarm = dateTime_Alarm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDateTime_Alarm() {
        return dateTime_Alarm;
    }

    public void setDateTime_Alarm(String dateTime_Alarm) {
        this.dateTime_Alarm = dateTime_Alarm;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.title);
        dest.writeString(this.content);
        dest.writeString(this.dateTime);
        dest.writeString(this.dateTime_Alarm);
    }

    protected Note(Parcel in) {
        this.id = in.readInt();
        this.title = in.readString();
        this.content = in.readString();
        this.dateTime = in.readString();
        this.dateTime_Alarm = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel source) {
            return new Note(source);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };
}
