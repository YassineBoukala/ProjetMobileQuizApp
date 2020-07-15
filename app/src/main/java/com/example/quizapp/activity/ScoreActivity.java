package com.example.quizapp.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapp.R;
import com.github.lzyzsd.circleprogress.CircleProgress;

public class ScoreActivity extends AppCompatActivity {

    CircleProgress circleProgress_score;
    Button btn_retry,btn_exit;
    ImageView imageView ;
    static final int REQUEST_IMAGE_CAPTURE = 0;
    Button locale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        circleProgress_score=findViewById(R.id.circle_progress);
        btn_retry=findViewById(R.id.btn_retry_score);
        btn_exit=findViewById(R.id.btn_exit_score);
        imageView = findViewById(R.id.picture);
        locale= findViewById(R.id.btn_locale);

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

        int scorepercentage=getIntent().getIntExtra("FinalScore",0);
        circleProgress_score.setProgress(scorepercentage);
        btn_retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ScoreActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });
        btn_exit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
                Intent intent=new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
            }
        });
       locale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ScoreActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap=(Bitmap) data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Intent intent=new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
}
