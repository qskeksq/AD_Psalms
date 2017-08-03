package com.example.administrator.psalms.domain.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrator.psalms.domain.Article;
import com.example.administrator.psalms.domain.Preface;
import com.example.administrator.psalms.domain.Topic;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Administrator on 2017-08-02.
 */

public class DBHelper extends OrmLiteSqliteOpenHelper {

    private static DBHelper sHelper;
    static final String DATABASE_NAME = "psalms_database";
    static final int DATAVASE_VERSION = 1;

    public static DBHelper getInstance(Context context){
        if(sHelper == null){
            sHelper = new DBHelper(context);
        }
        return sHelper;
    }

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATAVASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Topic.class);
            TableUtils.createTable(connectionSource, Article.class);
            TableUtils.createTable(connectionSource, Preface.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource, Topic.class, true);
            TableUtils.dropTable(connectionSource, Article.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
