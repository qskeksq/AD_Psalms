package com.example.administrator.psalms.Home;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.psalms.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-08-02.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.Holder> {

    static final int TYPE_DAILY_QT = 0;
    static final int TYPE_DAILY_DECISION = 1;
    static final int TYPE_RECENT_ARTICLE = 2;
    static final int TYPE_NEW_ARTICLE = 3;
    static final int TYPE_MAX = 4;

    public static List<HomeDummy> original = new ArrayList<>();

    public HomeAdapter() {
        setData();
    }

    public void setData(){
        Log.e("확인", "setData 호출 확인");
        original.clear();   // todo 여기서 이거 없애면 데이터가 두 배로 늘어나는데 호출은 한 번 됨. 이유 찾아내자
        original.add(new HomeDummy(TYPE_DAILY_QT));
        original.add(new HomeDummy(TYPE_DAILY_DECISION));
//        original.add(new HomeDummy(TYPE_RECENT_ARTICLE));
//        original.add(new HomeDummy(TYPE_NEW_ARTICLE));
    }

    @Override
    public int getItemViewType(int position) {
        return original.get(position).getViewType();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case TYPE_DAILY_QT:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_brief_qt, parent, false);
                break;
            case TYPE_DAILY_DECISION:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_decision, parent, false);
                break;
            case TYPE_RECENT_ARTICLE:
                break;
            case TYPE_NEW_ARTICLE:
                break;
        }
        return new Holder(view, viewType);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        if(original.get(position).isShown()){
            holder.edit.setVisibility(View.VISIBLE);
        } else {
            holder.edit.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return original.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        ImageView edit;

        public Holder(View itemView, int viewType) {
            super(itemView);
            switch (viewType) {
                case TYPE_DAILY_QT:
                    edit = (ImageView) itemView.findViewById(R.id.closeDailyQt);
                    break;
                case TYPE_DAILY_DECISION:
                    edit = (ImageView) itemView.findViewById(R.id.closeDailyDecision);
                    break;
                case TYPE_RECENT_ARTICLE:
                    break;
                case TYPE_NEW_ARTICLE:
                    break;
            }

        }

    }
}
