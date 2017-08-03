package com.example.administrator.psalms.Write;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.administrator.psalms.R;
import com.example.administrator.psalms.domain.Article;
import com.example.administrator.psalms.domain.ArticleLab;

/**
 * 새 글 입력 프래그먼트
 */
public class NewArticleFragment extends Fragment {


    private EditText inputTItle;
    private EditText inputContent;
    private Toolbar toolbar2;
    String topicTitle;

    public static NewArticleFragment newInstance(String title){
        NewArticleFragment fragment = new NewArticleFragment();
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
        View view = inflater.inflate(R.layout.fragment_new_article, container, false);
        init(view);
        setToolbar();
        return view;
    }


    private void init(View view) {
        inputTItle= (EditText) view.findViewById(R.id.inputPrefaceTitle);
        inputContent = (EditText) view.findViewById(R.id.inputContent);
        toolbar2 = (Toolbar) view.findViewById(R.id.prefaceToolbar);
    }

    /**
     * 툴바 설정
     */
    private void setToolbar(){
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar2);
        setHasOptionsMenu(true);
        toolbar2.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar2.setTitle("새 노래");
        toolbar2.setNavigationOnClickListener(v->getActivity().onBackPressed());
    }

    /**
     * 옵션 메뉴 설정
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.new_article, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.saveArticle:
                Article article = new Article();
                article.setTitle(inputTItle.getText().toString());
                article.setContent(inputContent.getText().toString());
                article.setTopicTitle(topicTitle);
                ArticleLab.getInstance(getActivity()).create(article);
                getActivity().onBackPressed();
                break;
            case R.id.tempSave:
                break;
        }
        return true;
    }


}
