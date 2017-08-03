package com.example.administrator.psalms.domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2017-08-02.
 */

@DatabaseTable(tableName = "preface")
public class Preface {

    @DatabaseField
    private String title;
    @DatabaseField
    private String content;
    @DatabaseField
    private String date;
    @DatabaseField
    private String topicTitle;

    public Preface() {

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }
}
