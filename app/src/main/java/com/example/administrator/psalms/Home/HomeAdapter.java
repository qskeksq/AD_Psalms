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

import static com.example.administrator.psalms.Util.Const.TYPE_DAILY_DECISION;
import static com.example.administrator.psalms.Util.Const.TYPE_DAILY_QT;
import static com.example.administrator.psalms.domain.Home.original;
import static com.example.administrator.psalms.domain.Home.selectedItem;

/**
 * Created by Administrator on 2017-08-02.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.Holder> {

    List<HomeDummy> datas;

    public HomeAdapter() {
//        setData();
    }
//
//    public void setData() {
//        Log.e("확인", "setData 호출 확인");
//        original.clear();   // todo 여기서 이거 없애면 데이터가 두 배로 늘어나는데 호출은 한 번 됨. 이유 찾아내자
//        original.add(new HomeDummy(TYPE_DAILY_QT));
//        original.add(new HomeDummy(TYPE_DAILY_DECISION));
//    }

    @Override
    public int getItemViewType(int position) {
        return selectedItem.get(position).getViewType();
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
        }
        return new Holder(view, viewType);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        if(selectedItem.get(position).isShown()){
            holder.edit.setVisibility(View.VISIBLE);
        } else {
            holder.edit.setVisibility(View.GONE);
        }
        holder.position = position;
    }

    @Override
    public int getItemCount() {
        return selectedItem.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        ImageView edit;
        int position;

        public Holder(View itemView, int viewType) {
            super(itemView);
            switch (viewType) {
                case TYPE_DAILY_QT:
                    edit = (ImageView) itemView.findViewById(R.id.closeDailyQt);
                    break;
                case TYPE_DAILY_DECISION:
                    edit = (ImageView) itemView.findViewById(R.id.closeDailyDecision);
                    break;
            }
            edit.setOnClickListener(v-> {
                selectedItem.remove(position);
                notifyDataSetChanged();
            });
        }
    }
}
