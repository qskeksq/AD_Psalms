package com.example.administrator.psalms.domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2017-08-02.
 */
@DatabaseTable(tableName = "article")
public class Article {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String topicTitle;
    @DatabaseField
    private String title;
    @DatabaseField
    private String content;
    @DatabaseField
    private String date;

    public Article() {

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

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
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
}
