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
import com.example.administrator.psalms.domain.Topic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-08-01.
 */

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.Holder> {

    Activity activity;
    List<Topic> datas = new ArrayList<>();

    public TopicAdapter(Activity activity) {
        this.activity = activity;
    }

    public void setData(List<Topic> datas){
        this.datas = datas;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Topic topic = datas.get(position);
        holder.topicTitle.setText(topic.getTitle());
        holder.topicWords.setText(topic.getWords());
        holder.title = topic.getTitle();
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private TextView topicTitle;
        private ImageView topicSettings;
        private TextView topicWords;
        private ConstraintLayout topicLayout;
        String title;

        public Holder(View itemView) {
            super(itemView);
            initView(itemView);
            setListener();
        }

        private void initView(View itemView) {
            topicTitle = (TextView) itemView.findViewById(R.id.articleTitle);
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
            topicLayout.setOnClickListener(v->
                ((AppCompatActivity) activity).getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        // todo 이름을 보내주면 나중에 이름이 같을 경우가 생길 수 있으므로 UUID 고유값으로 바꿔줘야 한다.
                        .add(R.id.container, ArticleFragment.newInstance(title))
                        .commit()
            );
        }
    }
}
