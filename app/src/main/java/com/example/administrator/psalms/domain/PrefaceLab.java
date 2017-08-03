package com.example.administrator.psalms.domain;

import android.content.Context;

import com.example.administrator.psalms.domain.DB.DBHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * preface CRUD
 */

public class PrefaceLab {

    private static PrefaceLab sPrefaceLab;
    DBHelper helper;
    Dao<Preface, Integer> dao;

    /**
     * 싱글턴
     */
    public static PrefaceLab getInstance(Context context){
        if(sPrefaceLab == null){
            sPrefaceLab = new PrefaceLab(context);
        }
        return sPrefaceLab;
    }

    /**
     * 생성자
     * @param context
     */
    public PrefaceLab(Context context) {
        helper = DBHelper.getInstance(context);
        try {
            dao = helper.getDao(Preface.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   /**
     * 데이터 추가
     */
    public void create(Preface preface){
        try {
            // 이게 createOrUpdate 가 언제 써야 하는지 알아볼 필요가 있다
            dao.create(preface);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 데이터 업데이트
     */
    public void update(Preface preface){
        try {
            dao.update(preface);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 데이터 삭제
     */
    public void delete(Preface preface){
        try {
            dao.delete(preface);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 전체 데이터 조회
     */
    public List<Preface> readAll(){
        List<Preface> prefaces = new ArrayList<>();
        try {
            prefaces = dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prefaces;
    }

    /**
     * 특정 데이터 검색
     */
    public List<Preface> queryOne(String title){
        QueryBuilder<Preface, Integer> builder = dao.queryBuilder();
        List<Preface> datas = null;
        try {
            datas = builder.where().eq("topicTitle", title).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datas;
    }

}
