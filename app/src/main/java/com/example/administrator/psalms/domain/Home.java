package com.example.administrator.psalms.domain;

import com.example.administrator.psalms.Home.HomeDummy;

import java.util.ArrayList;
import java.util.List;

import static com.example.administrator.psalms.Util.Const.TYPE_DAILY_DECISION;
import static com.example.administrator.psalms.Util.Const.TYPE_DAILY_QT;

/**
 * Created by Administrator on 2017-08-03.
 */

public class Home {

    private static Home sHome;

    public static List<HomeDummy> original = new ArrayList<>();
    public static List<HomeDummy> homeItem = new ArrayList<>();
    public static List<HomeDummy> selectedItem = new ArrayList<>();

    public static Home getInstance() {
        if(sHome == null){
            sHome = new Home();
        }
        return sHome;
    }

    public Home(){
        init();
    }

    public void init(){
        homeItem.add(new HomeDummy(TYPE_DAILY_QT));
        homeItem.add(new HomeDummy(TYPE_DAILY_DECISION));
    }

    public List<HomeDummy> getHomeItem(){
        return homeItem;
    }

}
