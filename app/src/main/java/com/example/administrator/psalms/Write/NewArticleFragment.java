package com.example.administrator.psalms.Write;


import android.os.Bundle;
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
import android.widget.Toast;

import com.example.administrator.psalms.R;

/**
 * 새 글 입력 프래그먼트
 */
public class NewArticleFragment extends Fragment {


    private EditText editText4;
    private EditText editText5;
    private Toolbar toolbar2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_article, container, false);
        init(view);
        setToolbar();
        return view;
    }


    private void init(View view) {
        editText4 = (EditText) view.findViewById(R.id.editText4);
        editText5 = (EditText) view.findViewById(R.id.editText5);
        toolbar2 = (Toolbar) view.findViewById(R.id.articleToolbar);
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
                Toast.makeText(getActivity(), "확인", Toast.LENGTH_SHORT).show();
                getActivity().onBackPressed();
                break;
            case R.id.tempSave:
                Toast.makeText(getActivity(), "확인", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }


}
