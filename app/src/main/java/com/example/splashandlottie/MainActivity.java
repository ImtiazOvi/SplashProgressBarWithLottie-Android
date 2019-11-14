package com.example.splashandlottie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

        /*
        Create date   :   13.11.19
        Modified date :
        Description   :   This is splash screen with lottie. And it's launching activity.
        Created by    :   Imtiaz
        */
public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    int progressTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        /*this method for initializing all things*/
        initUI();
    }

    private void initUI() {
        progressBar = findViewById(R.id.progressBarId);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                /*this method for progressBar time changing*/
                progressBarValueChange();
                /*this method for after finishing splash screen the go expected*/
                startApp();
            }
        });
        thread.start();
    }

    public void progressBarValueChange(){
        for (progressTime = 20; progressTime<=100; progressTime = progressTime + 20){
            try {
                Thread.sleep(2000);
                progressBar.setProgress(progressTime);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void startApp(){
        Intent intent = new Intent(MainActivity.this,AnotherActivity.class);
        startActivity(intent);
        finish();
    }
}

