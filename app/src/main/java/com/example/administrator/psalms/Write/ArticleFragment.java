package com.example.administrator.psalms.Write;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.psalms.R;

/**
 * 상세 글 리스트 프래그먼트
 */
public class ArticleFragment extends Fragment {


    private Toolbar toolbar;
    private RecyclerView articleRecycler;
    private View view;
    ArticleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_write, container, false);
        init(view);
        setArticleRecycler();
        setToolbar();
        Log.e("확인", "view");
        return view;
    }

    /**
     * 초기화
     *
     * @param view
     */
    private void init(View view) {
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        articleRecycler = (RecyclerView) view.findViewById(R.id.articleRecycler);
        adapter = new ArticleAdapter();
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
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.container, new NewArticleFragment())  // todo 여기서 add 로 하면 옵션메뉴가 계속 축적되는데 이유 찾아내자
                        .commit();
                break;
        }
        return true;
    }
}
