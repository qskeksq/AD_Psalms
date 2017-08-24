package com.example.administrator.psalms.Read;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.psalms.R;
import com.example.administrator.psalms.domain.BibleLab;

/**
 * A simple {@link Fragment} subclass.
 */
public class BibleFragment extends Fragment {


    public BibleFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bible, container, false);

        Log.e("확인", BibleLab.getInstance(getActivity()).readAll().size()+"");
//        Log.e("확인", BibleLab.getInstance(getActivity()).queryBook(1).get(0).getBook()+"");
//        Log.e("확인", BibleLab.getInstance(getActivity()).queryBook(1).get(0).getChapter()+"");
//        Log.e("확인", BibleLab.getInstance(getActivity()).queryBook(1).get(0).getVerse()+"");
//        Log.e("확인", BibleLab.getInstance(getActivity()).queryBook(1).get(0).getContent()+"");

        return view;
    }

}
