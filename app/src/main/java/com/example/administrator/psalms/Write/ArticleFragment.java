package com.example.administrator.psalms.Write;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.psalms.R;
import com.example.administrator.psalms.domain.ArticleLab;

/**
 * 상세 글 리스트 프래그먼트
 */
public class ArticleFragment extends Fragment {


    private Toolbar toolbar;
    private RecyclerView articleRecycler;
    private View view;
    ArticleAdapter adapter;
    String title;
    private Button preface;

    public static ArticleFragment newInstance(String title) {
        ArticleFragment fragment = new ArticleFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString("title");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_write, container, false);
        init(view);
        setArticleRecycler();
        setToolbar();
        setListener();
        return view;
    }

    /**
     * 초기화
     */
    private void init(View view) {
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        articleRecycler = (RecyclerView) view.findViewById(R.id.articleRecycler);
        preface = (Button) view.findViewById(R.id.preface);
        adapter = new ArticleAdapter();
        adapter.setDatas(ArticleLab.getInstance(getActivity()).querySome(title));
    }

    /**
     * 리사이클러뷰 set
     */
    private void setArticleRecycler() {
        articleRecycler.setAdapter(adapter);
        articleRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    /**
     * 툴바 설정
     */
    private void setToolbar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setTitle("시편 주제");
        toolbar.setNavigationOnClickListener(v -> getActivity().onBackPressed());
    }

    /**
     * 리스너 설정
     */
    private void setListener(){
        preface.setOnClickListener(v->goPreface());
    }

    /**
     * 옵션 메뉴 설정
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.article, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.newArticle:
                goNewArticle();
                break;
        }
        return true;
    }

    /**
     * Fragment 띄우기
     */
    private void goNewArticle(){
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container, NewArticleFragment.newInstance(title))  // todo 여기서 add 로 하면 옵션메뉴가 계속 축적되는데 이유 찾아내자
                .commit();
    }

    private void goPreface(){
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container, PrefaceFragment.newInstance(title))  // todo 여기서 add 로 하면 옵션메뉴가 계속 축적되는데 이유 찾아내자
                .commit();
    }
}
