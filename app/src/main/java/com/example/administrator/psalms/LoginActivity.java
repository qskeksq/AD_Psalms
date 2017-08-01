package com.example.administrator.psalms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void email(View view){
        goMain();
    }

    public void kakao(View view){
        goMain();
    }

    public void google(View view){
        goMain();
    }

    private void goMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(this, "환영합니다", Toast.LENGTH_SHORT).show();
        finish();
    }

}
