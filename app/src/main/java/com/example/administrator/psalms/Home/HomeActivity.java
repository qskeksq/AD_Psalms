package com.example.administrator.psalms.Home;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.psalms.R;

import static com.example.administrator.psalms.domain.Home.original;
import static com.example.administrator.psalms.domain.Home.selectedItem;


/**
 * Created by Administrator on 2017-08-02.
 */

public class HomeActivity {

    private RecyclerView homeItemRecycler;
    private TextView edit;
    private RecyclerView homeRecycler;
    HomeAdapter homeAdapter;
    HomeItemAdapter homeItemAdapter;
    Activity activity;

    public HomeActivity(Activity activity) {
        this.activity = activity;
        init();
        setListener();
        setHomeRecycler();
        setHomeItemRecycler();
    }

    /**
     * 뷰s 초기화
     */
    private void init() {
        homeRecycler = (RecyclerView) activity.findViewById(R.id.homeRecycler);
        homeItemRecycler = (RecyclerView) activity.findViewById(R.id.homeItemRecycler);
        edit = (TextView) activity.findViewById(R.id.edit);
        homeAdapter = new HomeAdapter();
        homeItemAdapter = new HomeItemAdapter(this);
    }

    private void setHomeRecycler(){
        homeRecycler.setAdapter(homeAdapter);
        homeRecycler.setLayoutManager(new LinearLayoutManager(activity));
    }

    private void setHomeItemRecycler(){
        homeItemRecycler.setAdapter(homeItemAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(activity);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        homeItemRecycler.setLayoutManager(manager);
    }

    public void setHomeAdapter(){
        homeAdapter.notifyDataSetChanged();
    }

    private void setListener(){
        edit.setOnClickListener(v->{

            if(edit.getText().toString().equals("편집")) {    //edit.getText().toString().equals(R.string.home_edit) 는 안 되는군.
                edit.setText(R.string.home_edit_confirm);
                for (HomeDummy item : selectedItem) {
                    item.setShown(true);
                }
                homeAdapter.notifyDataSetChanged();
                homeItemRecycler.setVisibility(View.VISIBLE);
            } else {
                edit.setText(R.string.home_edit);
                for (HomeDummy item : selectedItem) {
                    item.setShown(false);
                }
                homeAdapter.notifyDataSetChanged();
                homeItemRecycler.setVisibility(View.GONE);
            }
        });
    }




}
