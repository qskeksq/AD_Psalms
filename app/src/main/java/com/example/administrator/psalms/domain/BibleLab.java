package com.example.administrator.psalms.domain;

import android.content.Context;

import com.example.administrator.psalms.domain.DB.DBHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Article 에 대한 CRUD
 */

public class BibleLab {

    private static BibleLab sBibleLab;
    DBHelper helper;
    Dao<Bible, Integer> dao;

    public static BibleLab getInstance(Context context){
        if(sBibleLab == null){
            sBibleLab = new BibleLab(context);
        }
        return sBibleLab;
    }

    public BibleLab(Context context) {
        helper = DBHelper.getInstance(context);
        try {
            dao = helper.getDao(Bible.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 데이터 추가
     */
    public void create(Bible bible){
        try {
            dao.create(bible);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 데이터 업데이트
     */
    public void update(Bible bible){
        try {
            dao.update(bible);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 데이터 삭제
     */
    public void delete(Bible bible){
        try {
            dao.delete(bible);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 전체 데이터 조회
     */
    public List<Bible> readAll(){
        List<Bible> bible = new ArrayList<>();
        try {
            bible = dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bible;
    }


    /**
     * 책 검색
     */
    public List<Bible> queryBook(int book){
        QueryBuilder<Bible, Integer> builder = dao.queryBuilder();
        List<Bible> datas = null;
        try {
            datas = builder.where().eq("book", book).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datas;
    }

    /**
     * 장 검색
     */
    public List<Bible> queryChapter(int book, int chapter){
        QueryBuilder<Bible, Integer> builder = dao.queryBuilder();
        List<Bible> datas = null;
        try {
            datas = builder.where().eq("book", book).and().eq("chapter", chapter).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datas;
    }

    /**
     * 절 검색
     */
    public List<Bible> queryPhrase(int book, int chapter, int verse){
        QueryBuilder<Bible, Integer> builder = dao.queryBuilder();
        List<Bible> datas = null;
        try {
            datas = builder.where().eq("book", book).and().eq("chapter", chapter).and().eq("verse", verse).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datas;
    }

}
