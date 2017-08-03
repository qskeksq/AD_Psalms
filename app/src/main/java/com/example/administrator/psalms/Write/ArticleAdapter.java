package com.example.administrator.psalms.Write;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.psalms.R;
import com.example.administrator.psalms.domain.Article;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-08-01.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.Holder> {

    List<Article> datas = new ArrayList<>();


    public void setDatas(List<Article> datas) {
        this.datas = datas;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Article article = datas.get(position);
        holder.articleTitle.setText(article.getTitle());
        holder.articleWords.setText(article.getContent());
    }

    @Override
    public int getItemCount() {

        return datas.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private ConstraintLayout topicLayout;
        private TextView articleTitle;
        private TextView articleWords;
        private TextView articleDate;

        public Holder(View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View view) {
            topicLayout = (ConstraintLayout) view.findViewById(R.id.topicLayout);
            articleTitle = (TextView) view.findViewById(R.id.articleTitle);
            articleWords = (TextView) view.findViewById(R.id.articleWords);
            articleDate = (TextView) view.findViewById(R.id.articleDate);
        }
    }
}
