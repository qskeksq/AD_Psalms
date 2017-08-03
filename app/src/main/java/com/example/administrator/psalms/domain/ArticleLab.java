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

public class ArticleLab {

    private static ArticleLab sArticleLab;
    DBHelper helper;
    Dao<Article, Integer> dao;

    public static ArticleLab getInstance(Context context){
        if(sArticleLab == null){
            sArticleLab = new ArticleLab(context);
        }
        return sArticleLab;
    }

    public ArticleLab(Context context) {
        helper = DBHelper.getInstance(context);
        try {
            dao = helper.getDao(Article.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 데이터 추가
     */
    public void create(Article article){
        try {
            dao.create(article);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 데이터 업데이트
     */
    public void update(Article article){
        try {
            dao.update(article);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 데이터 삭제
     */
    public void delete(Article article){
        try {
            dao.delete(article);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 한 개 데이터 조회
     */
    public Article readOne(Article article){
        Article temp = null;
        try {
            temp = dao.queryForId(article.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    /**
     * 전체 데이터 조회
     */
    public List<Article> readAll(){
        List<Article> articles = new ArrayList<>();
        try {
            articles = dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    /**
     * 특정 데이터 검색
     */
    public List<Article> querySome(String title){
        QueryBuilder<Article, Integer> builder = dao.queryBuilder();
        List<Article> datas = null;
        try {
            datas = builder.where().eq("topicTitle", title).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datas;
    }

}
