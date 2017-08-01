package com.example.administrator.psalms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.example.administrator.psalms.Home.HomeActivity;
import com.example.administrator.psalms.Read.LibraryActivity;
import com.example.administrator.psalms.Util.BottomNavigationHelper;
import com.example.administrator.psalms.Write.TopicActivity;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigation;
    private ConstraintLayout layoutHome, layoutLibrary, layoutWrite, layoutAccount;
    HomeActivity homeActivity;
    TopicActivity topicActivity;
    LibraryActivity libraryActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setNavigationView();

        if(homeActivity == null)
            homeActivity = new HomeActivity(this);

        if (topicActivity == null)
            topicActivity = new TopicActivity(this);

        if (libraryActivity == null)
            libraryActivity = new LibraryActivity(this);

    }


    /**
     * 뷰s 초기화
     */
    private void initView() {
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        layoutHome = (ConstraintLayout) findViewById(R.id.layout_home);
        layoutLibrary = (ConstraintLayout) findViewById(R.id.layout_library);
        layoutWrite = (ConstraintLayout) findViewById(R.id.layout_write);
        layoutAccount = (ConstraintLayout) findViewById(R.id.layout_account);
    }

    /**
     * 하단 탭 뷰 설정
     */
    private void setNavigationView() {
        // 탭 뷰 아이템 클릭 리스너 set
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        // 클릭시 디폴트로 발생하는 애니메이션 제거
        BottomNavigationHelper.removeShiftMode(navigation);
    }

    /**
     * 하단 탭 뷰 리스너
     */
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setViewInvisible();
                    layoutHome.setVisibility(View.VISIBLE);
                    return true;
                case R.id.navigation_library:
                    setViewInvisible();
                    layoutLibrary.setVisibility(View.VISIBLE);
                    return true;
                case R.id.navigation_write:
                    setViewInvisible();
                    layoutWrite.setVisibility(View.VISIBLE);
                    return true;
                case R.id.navigation_account:
                    setViewInvisible();
                    layoutAccount.setVisibility(View.VISIBLE);
                    return true;
            }
            return false;
        }

    };

    /**
     * 선택된 뷰 이외의 뷰 Visibility 관리
     */
    private void setViewInvisible() {
        layoutHome.setVisibility(View.INVISIBLE);
        layoutLibrary.setVisibility(View.INVISIBLE);
        layoutWrite.setVisibility(View.INVISIBLE);
        layoutAccount.setVisibility(View.INVISIBLE);
    }


}
