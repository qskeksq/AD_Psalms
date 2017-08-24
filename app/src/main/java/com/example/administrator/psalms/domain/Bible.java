package com.example.administrator.psalms.domain;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2017-08-03.
 */

@DatabaseTable(tableName = "bible_korHRV")
public class Bible {

    @DatabaseField
    private int book;
    @DatabaseField
    private int chapter;
    @DatabaseField
    private int verse;
    @DatabaseField
    private String content;

    public Bible() {

    }

    public int getBook() {
        return book;
    }

    public void setBook(int book) {
        this.book = book;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public int getVerse() {
        return verse;
    }

    public void setVerse(int verse) {
        this.verse = verse;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
