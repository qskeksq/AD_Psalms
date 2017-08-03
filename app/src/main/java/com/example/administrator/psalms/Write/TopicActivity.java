package com.example.administrator.psalms.Write;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.psalms.R;
import com.example.administrator.psalms.domain.Topic;
import com.example.administrator.psalms.domain.TopicLab;

/**
 * 시편 주제 리스트
 */

public class TopicActivity {

    /**
     * Topic 뷰
     */
    private TextView add;
    private TextView order;
    private RecyclerView topicRecycler;
    private Activity activity;
    TopicAdapter adapter;

    /**
     * 커스텀 다이럴로그
     */
    private EditText topicTitleInput;
    private EditText topicWordsInput;
    private ImageView addTopicTitle;
    private ImageView addTopicWords;
    private RecyclerView topicTemplateRecycler;
    private ImageView addTopicTemplate;
    private Button topicConfirm;
    private Button topicCancel;

    public TopicActivity(Activity activity) {
        this.activity = activity;
        init();
        setTopicRecycler();
        setListener();
    }

    private void init() {
        add = (TextView) activity.findViewById(R.id.addTopicTitle);
        order = (TextView) activity.findViewById(R.id.order);
        topicRecycler = (RecyclerView) activity.findViewById(R.id.topicRecycler);
        adapter = new TopicAdapter(activity);
        adapter.setData(TopicLab.getInstance(activity).readAll());
    }

    private void setTopicRecycler() {
        topicRecycler.setAdapter(adapter);
        topicRecycler.setLayoutManager(new LinearLayoutManager(activity));
    }

    private void setListener() {
        add.setOnClickListener(v -> {
            View view = View.inflate(activity, R.layout.custom_add_dialog, null);
            initDialogView(view);
            setDialogListener();
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle("시편 추가");
            builder.setView(view);
            builder.show();
        });
    }

    /**
     * 커스텀 다이럴로그 초기화
     */
    private void initDialogView(View view) {
        topicTitleInput = (EditText) view.findViewById(R.id.topicTitleInput);
        topicWordsInput = (EditText) view.findViewById(R.id.topicWordsInput);
        addTopicTitle = (ImageView) view.findViewById(R.id.addTopicTitle);
        addTopicWords = (ImageView) view.findViewById(R.id.addTopicWords);
        topicTemplateRecycler = (RecyclerView) view.findViewById(R.id.topicTemplateRecycler);
        addTopicTemplate = (ImageView) view.findViewById(R.id.addTopicTemplate);
        topicConfirm = (Button) view.findViewById(R.id.topicConfirm);
        topicCancel = (Button) view.findViewById(R.id.topicCancel);
    }

    /**
     * 커스텀 다이얼로그 확인, 취소 버튼 리스너 set
     */
    private void setDialogListener(){
        topicConfirm.setOnClickListener(v->{
            Topic topic = new Topic();
            topic.setTitle(topicTitleInput.getText().toString());
            topic.setWords(topicWordsInput.getText().toString());
            TopicLab.getInstance(activity).create(topic);
            adapter.setData(TopicLab.getInstance(activity).readAll());
            adapter.notifyDataSetChanged();
        });
        topicCancel.setOnClickListener(v->activity.finish());
    }


}
