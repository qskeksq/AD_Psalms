package com.example.administrator.psalms;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LauncherActivity extends AppCompatActivity {

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setWindow();
        setContentView(R.layout.activity_launcher);
        splash();
        try {
            createDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 1. 상태바 없애기
     * 2. 액션바 없애기
     */
    private void setWindow(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * 스플래시 4초 딜레이
     */
    private void splash(){
        handler.postDelayed(()->{
                Intent intent = new Intent(LauncherActivity.this, LoginActivity.class);
                startActivity(intent);
                LauncherActivity.this.finish();
        }, 2000);
    }


//    String DB_PATH;
    static String DB_NAME = "bible.db";
    SQLiteDatabase db;
    Context context;




    // 데이터 베이스가 없으면 열어준다.
    public void createDatabase() throws IOException {

        boolean dbExists = checkDatabase();

        if(dbExists) {

            if(BuildConfig.DEBUG){
                try{
                    // 디버그 모드에서는 항상 데이터베이스를 복사해서 새로 생성한다
                    copyDatabase();
                }catch (IOException e){

                }
            }

        } else {
            try{
                // 여기가 핵심
                copyDatabase();
            }catch (IOException e){

            }
        }
    }

    // 데이터베이스가 열려있는지 확인하고 열려 있으면 닫아준다..
    public boolean checkDatabase(){

        SQLiteDatabase checkDB = null;
        try{
            String myPath = "/data/data/"+getPackageName()+"/"+"databases/" + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e){

        }

        if(checkDB != null){
            checkDB.close();
        }

        return checkDB != null ? true : false;
    }

    // 에셋에 넣어준 sqlite 파일을 위에서 만들어 준 데이터베이스에 복사해준다. 이 메소드를 호출하지 않으면 복사해 놓은 파일을 사용할 수 없다.
    public void copyDatabase() throws IOException {
        InputStream myInput = getAssets().open(DB_NAME);
        String outFileName = "/data/data/"+getPackageName()+"/"+"databases/"+ DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

}
