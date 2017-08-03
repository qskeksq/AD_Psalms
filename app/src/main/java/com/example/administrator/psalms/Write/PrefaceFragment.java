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
import com.example.administrator.psalms.domain.Preface;
import com.example.administrator.psalms.domain.PrefaceLab;

/**
 * A simple {@link Fragment} subclass.
 */
public class PrefaceFragment extends Fragment {

    String topicTitle;
    Preface preface;
    private EditText inputPrefaceTitle;
    private EditText inputPrefaceContent;
    private Toolbar prefaceToolbar;

    public static PrefaceFragment newInstance(String title) {
        PrefaceFragment fragment = new PrefaceFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        topicTitle = getArguments().getString("title");
        // todo 임시방편일 수 있으니 해결할 것
        try{
            preface = PrefaceLab.getInstance(getActivity()).queryOne(topicTitle).get(0);
            return;
        } catch (Exception e){

        }
        preface = new Preface();


//        if(PrefaceLab.getInstance(getActivity()).readAll().size() == 0) {
//            preface = new Preface();
//        } else {
//            preface = PrefaceLab.getInstance(getActivity()).queryOne(topicTitle).get(0);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_preface, container, false);
        initView(view);
        setToolbar();
        return view;
    }

    /**
     * 초기화
     */
    private void initView(View view) {
        inputPrefaceTitle = (EditText) view.findViewById(R.id.inputPrefaceTitle);
        inputPrefaceContent = (EditText) view.findViewById(R.id.inputPrefaceContent);
        prefaceToolbar = (Toolbar) view.findViewById(R.id.prefaceToolbar);

        inputPrefaceTitle.setText(preface.getTitle());
        inputPrefaceContent.setText(preface.getContent());
    }

    /**
     * 툴바 설정
     */
    private void setToolbar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(prefaceToolbar);
        setHasOptionsMenu(true);
        prefaceToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        prefaceToolbar.setTitle("서문");
        prefaceToolbar.setNavigationOnClickListener(v -> getActivity().onBackPressed());
    }

    /**
     * 옵션 메뉴 설정
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.preface, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.savePreface:
                Preface preface = new Preface();
                preface.setTitle(inputPrefaceTitle.getText().toString());
                preface.setContent(inputPrefaceContent.getText().toString());
                preface.setTopicTitle(topicTitle);
                // todo 두 번째 일 때는 update 되어야 한다- update 는 좀 더 알아봐야 할 듯
//
//                try{
//                    // 처음일 때는 이 줄에서 넘어가고, 두번째부터는 try 문에서 update 한다.
//                    PrefaceLab.getInstance(getActivity()).queryOne(topicTitle);
//                    PrefaceLab.getInstance(getActivity()).update(preface);
//                    getActivity().onBackPressed();
//                    break;
//                } catch (Exception e){
//
//                }
                PrefaceLab.getInstance(getActivity()).create(preface);
                getActivity().onBackPressed();
                break;
            case R.id.tempSavePreface:
                break;
        }
        return true;
    }
}
