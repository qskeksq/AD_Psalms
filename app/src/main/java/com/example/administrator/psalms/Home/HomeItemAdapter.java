package com.example.administrator.psalms.Home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.psalms.R;
import com.example.administrator.psalms.domain.Home;

import static com.example.administrator.psalms.Util.Const.TYPE_DAILY_DECISION;
import static com.example.administrator.psalms.Util.Const.TYPE_DAILY_QT;
import static com.example.administrator.psalms.domain.Home.selectedItem;

/**
 * Created by Administrator on 2017-08-03.
 */

public class HomeItemAdapter extends RecyclerView.Adapter<HomeItemAdapter.Holder> {

    HomeActivity activity;

    public HomeItemAdapter(HomeActivity activity) {
        this.activity = activity;
    }

    @Override
    public int getItemViewType(int position) {
        return Home.getInstance().getHomeItem().get(position).getViewType();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType){
            case TYPE_DAILY_QT:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_item_daily_qt, parent, false);
                break;
            case TYPE_DAILY_DECISION:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_item_daily_decision, parent, false);
                break;
        }
        return new Holder(view, viewType);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.position = position;
    }

    @Override
    public int getItemCount() {
        return Home.getInstance().getHomeItem().size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        int position;

        public Holder(View itemView, int viewType) {
            super(itemView);
            itemView.setOnClickListener(v->{
                // todo 이제 이거 영구저장 하는 거 하면 됨
                selectedItem.add(Home.getInstance().getHomeItem().get(position));
                activity.setHomeAdapter();
            });
        }
    }

}
