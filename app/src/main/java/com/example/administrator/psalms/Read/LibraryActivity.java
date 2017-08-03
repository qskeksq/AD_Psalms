package com.example.administrator.psalms.Read;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.administrator.psalms.R;
import com.example.administrator.psalms.domain.TopicLab;

/**
 * Created by Administrator on 2017-08-01.
 */

public class LibraryActivity {

    private RecyclerView libraryRecycler,subscribeRecycler;
    private TextView subscribe;
    MyLibraryAdapter libraryAdapter;
    SubscribeAdapter subscribeAdapter;
    Activity activity;

    public LibraryActivity(Activity activity) {
        this.activity = activity;
        init();
        setLibraryRecycler();
        setSubscribeRecycler();
    }

    private void init() {
        libraryRecycler = (RecyclerView) activity.findViewById(R.id.libraryRecycler);
        subscribeRecycler = (RecyclerView) activity.findViewById(R.id.subscribeRecycler);
        subscribe = (TextView) activity.findViewById(R.id.subscribeTxt);
        libraryAdapter = new MyLibraryAdapter(activity);
        subscribeAdapter = new SubscribeAdapter();
        libraryAdapter.setDatas(TopicLab.getInstance(activity).readAll());
    }

    private void setLibraryRecycler(){
        libraryRecycler.setAdapter(libraryAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(activity);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        libraryRecycler.setLayoutManager(manager);
    }

    private void setSubscribeRecycler(){
        subscribeRecycler.setAdapter(subscribeAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(activity);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        subscribeRecycler.setLayoutManager(manager);
    }


}
