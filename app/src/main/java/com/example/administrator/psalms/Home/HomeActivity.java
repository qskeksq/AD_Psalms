package com.example.administrator.psalms.Home;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.psalms.R;

import static com.example.administrator.psalms.Home.HomeAdapter.original;

/**
 * Created by Administrator on 2017-08-02.
 */

public class HomeActivity {

    private RecyclerView homeItemRecycler;
    private TextView edit;
    private RecyclerView homeRecycler;
    HomeAdapter adapter;
    Activity activity;

    public HomeActivity(Activity activity) {
        this.activity = activity;
        init();
        setListener();
        setHomeRecycler();
    }

    /**
     * 뷰s 초기화
     */
    private void init() {
        homeItemRecycler = (RecyclerView) activity.findViewById(R.id.homeItemRecycler);
        edit = (TextView) activity.findViewById(R.id.edit);
        homeRecycler = (RecyclerView) activity.findViewById(R.id.homeRecycler);
        adapter = new HomeAdapter();
    }

    private void setHomeRecycler(){
        homeRecycler.setAdapter(adapter);
        homeRecycler.setLayoutManager(new LinearLayoutManager(activity));
    }

    private void setListener(){
        edit.setOnClickListener(v->{

            if(edit.getText().toString().equals("편집")) {    //edit.getText().toString().equals(R.string.home_edit) 는 안 되는군.
                edit.setText(R.string.home_edit_confirm);
                for (HomeDummy item : original) {
                    item.setShown(true);
                }
                adapter.notifyDataSetChanged();
            } else {
                edit.setText(R.string.home_edit);
                for (HomeDummy item : original) {
                    item.setShown(false);
                }
                adapter.notifyDataSetChanged();
            }
        });
    }




}
