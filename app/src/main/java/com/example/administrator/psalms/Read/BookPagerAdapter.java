package com.example.administrator.psalms.Read;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.psalms.R;
import com.example.administrator.psalms.domain.Article;
import com.example.administrator.psalms.domain.PrefaceLab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-08-03.
 */

public class BookPagerAdapter extends PagerAdapter {

    List<Article> datas = new ArrayList<>();
    List<String> titles = new ArrayList<>();
    LayoutInflater inflater;
    String topicTitle;

    public BookPagerAdapter(Context context, String topicTitle) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.topicTitle = topicTitle;
    }

    public void setDatas(List<Article> datas){
        this.datas = datas;
        for(Article item : datas){
            titles.add(item.getTitle());
        }
    }

    /**
     * 표지, 서문, 목록에 해당하는 페이지를 따로 추가해준다
     */
    @Override
    public int getCount() {
        return 3+datas.size();
    }

    /**
     * 표지, 서문, 목록은 위치가 정해져 있기 떄문에 위치에 따라 따로 인플레이션 해 준다
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = null;
        // 표지
        if(position == 0){
            view = inflater.inflate(R.layout.item_book_pager_cover, container, false);
            TextView bookTitle = (TextView) view.findViewById(R.id.bookCoverTitle);
            bookTitle.setText(topicTitle);
            //서문
        } else if(position == 1){
            view = inflater.inflate(R.layout.item_book_pager_preface, container, false);
            TextView prefaceContent = (TextView) view.findViewById(R.id.prefaceContent);
            String content = PrefaceLab.getInstance(container.getContext()).queryOne(topicTitle).get(0).getContent();
            prefaceContent.setText(content);
            // 목록
        } else if(position == 2){
            view = inflater.inflate(R.layout.item_book_pager_contents, container, false);
            ListView contentList = (ListView) view.findViewById(R.id.contentsListView);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(container.getContext(), android.R.layout.simple_list_item_1, titles);
            contentList.setAdapter(adapter);
            // 각 페이지
        } else {
            view = inflater.inflate(R.layout.item_book_pager_page, container, false);

        }
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
