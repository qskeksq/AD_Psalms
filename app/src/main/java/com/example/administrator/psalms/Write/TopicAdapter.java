package com.example.administrator.psalms.Write;

import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.psalms.R;

/**
 * Created by Administrator on 2017-08-01.
 */

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.Holder> {

    Activity activity;

    public TopicAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }



    public class Holder extends RecyclerView.ViewHolder {

        private TextView topicTitle;
        private ImageView topicSettings;
        private TextView topicWords;
        private ConstraintLayout topicLayout;
        private View view;

        public Holder(View itemView) {
            super(itemView);
            view = itemView;
            initView(itemView);
            setListener();
        }

        private void initView(View itemView) {
            topicTitle = (TextView) itemView.findViewById(R.id.topicTitle);
            topicSettings = (ImageView) itemView.findViewById(R.id.topicSettings);
            topicWords = (TextView) itemView.findViewById(R.id.topicWords);
            topicLayout = (ConstraintLayout) itemView.findViewById(R.id.topicLayout);
        }

        private void setListener(){
            topicSettings.setOnClickListener(v->{
                PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
                activity.getMenuInflater().inflate(R.menu.topic, popupMenu.getMenu());
                popupMenu.show();
            });
            topicLayout.setOnClickListener(v-> {
                ((AppCompatActivity) activity).getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .add(R.id.container, new ArticleFragment())
                        .commit();
            });
        }
    }
}
