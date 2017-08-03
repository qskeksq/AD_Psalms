package com.example.administrator.psalms.Read;

import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
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

public class MyLibraryAdapter extends RecyclerView.Adapter<MyLibraryAdapter.Holder> {

    Activity activity;
    List<Topic> topics = new ArrayList<>();

    public void setDatas(List<Topic> topics) {
        this.topics = topics;;
    }

    public MyLibraryAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Topic topic = topics.get(position);
        holder.bookTitle.setText(topic.getTitle());
        holder.topicTitle = topic.getTitle();
    }

    @Override
    public int getItemCount() {
        return topics.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private ConstraintLayout bookLayout;
        private ImageView bookSettings;
        private TextView bookTitle;
        String topicTitle;

        public Holder(View itemView) {
            super(itemView);
            initView(itemView);
            setListener();
        }

        private void initView(View view) {
            bookLayout = (ConstraintLayout) view.findViewById(R.id.bookLayout);
            bookSettings = (ImageView) view.findViewById(R.id.bookSettings);
            bookTitle = (TextView) view.findViewById(R.id.bookTitle);
        }

        private void setListener(){
            bookLayout.setOnClickListener(v->
                    ((AppCompatActivity) activity).getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)
                    .add(R.id.container, BookFragment.newInstance(topicTitle))
                    .commit());
        }




    }
}
