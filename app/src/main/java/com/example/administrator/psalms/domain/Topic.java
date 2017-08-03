package com.example.administrator.psalms.domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2017-08-02.
 */

@DatabaseTable(tableName = "topic")
public class Topic {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String title;
    @DatabaseField
    private String words;

    /**
     * 기본 생성자
     */
    public Topic() {

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

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }
}
