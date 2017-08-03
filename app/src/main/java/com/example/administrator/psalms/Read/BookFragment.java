package com.example.administrator.psalms.Read;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.psalms.R;
import com.example.administrator.psalms.domain.Article;
import com.example.administrator.psalms.domain.ArticleLab;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookFragment extends Fragment {

    String topicTitle;
    BookPagerAdapter adapter;
    List<Article> articles;
    private ViewPager bookPager;

    public static BookFragment newInstance(String title) {
        BookFragment fragment = new BookFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        topicTitle = getArguments().getString("title");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book, container, false);
        init(view);
        setBookPager();
        setData();
        return view;
    }

    private void init(View view) {
        bookPager = (ViewPager) view.findViewById(R.id.bookPager);
        adapter = new BookPagerAdapter(getContext(), topicTitle);
    }

    private void setBookPager(){
        bookPager.setAdapter(adapter);
    }

    /**
     * todo 비동기로 빼내야 함
     */
    private void setData(){
        articles = ArticleLab.getInstance(getContext()).querySome(topicTitle);
        adapter.setDatas(articles);
        adapter.notifyDataSetChanged();
    }
}
