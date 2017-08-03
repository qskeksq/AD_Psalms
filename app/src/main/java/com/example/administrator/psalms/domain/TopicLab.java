package com.example.administrator.psalms.domain;

import android.content.Context;

import com.example.administrator.psalms.domain.DB.DBHelper;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Topic 에 대한 CRUD
 */

public class TopicLab {

    private static TopicLab sTopicLab;
    DBHelper helper;
    Dao<Topic, Integer> dao;

    public static TopicLab getInstance(Context context){
        if(sTopicLab == null){
            sTopicLab = new TopicLab(context);
        }
        return sTopicLab;
    }

    public TopicLab(Context context) {
        helper = DBHelper.getInstance(context);
        try {
            dao = helper.getDao(Topic.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 데이터 추가
     */
    public void create(Topic topic){
        try {
            dao.create(topic);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 데이터 업데이트
     */
    public void update(Topic topic){
        try {
            dao.update(topic);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 데이터 삭제
     */
    public void delete(Topic topic){
        try {
            dao.delete(topic);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 한 개 데이터 조회
     */
    public Topic readOne(Topic topic){
        Topic temp = null;
        try {
            temp = dao.queryForId(topic.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return temp;
    }

    /**
     * 전체 데이터 조회
     */
    public List<Topic> readAll(){
        List<Topic> topics = new ArrayList<>();
        try {
            topics = dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return topics;
    }
}
