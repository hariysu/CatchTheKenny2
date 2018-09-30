package com.example.abdurahmanaydin.catchthekenny2;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textTime;
    TextView textScore;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    int score;
    boolean gameFinished = false;
    ImageView [] imageArray;
    Runnable runnable;
    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score=0;
        imageView1=(ImageView) findViewById(R.id.imageView1);
        imageView2=(ImageView) findViewById(R.id.imageView2);
        imageView3=(ImageView) findViewById(R.id.imageView3);
        imageView4=(ImageView) findViewById(R.id.imageView4);
        imageView5=(ImageView) findViewById(R.id.imageView5);
        imageView6=(ImageView) findViewById(R.id.imageView6);
        imageView7=(ImageView) findViewById(R.id.imageView7);
        imageView8=(ImageView) findViewById(R.id.imageView8);
        imageView9=(ImageView) findViewById(R.id.imageView9);

        imageArray=new ImageView[]{imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9};

        hideImages();

        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long l) {
                textTime=(TextView) findViewById(R.id.textTime);
                textTime.setText("Time: "+l/1000);
            }

            @Override
            public void onFinish() {
                textTime=(TextView) findViewById(R.id.textTime);
                textTime.setText("Time's off ");
                handler.removeCallbacks(runnable);
                gameFinished=true;
            }
        }.start();

    }


    public void increaseScore(View view){

        if(gameFinished==false){
            textScore=(TextView)findViewById(R.id.textScore);
            score++;
            textScore.setText("Score: "+score);
        }

    }

    public void hideImages(){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                for(ImageView image:imageArray) {
                    image.setVisibility(View.INVISIBLE);
                }
                    Random r=new Random();
                    int i=r.nextInt(8-0);
                    imageArray[i].setVisibility(View.VISIBLE);
                    handler.postDelayed(this,500);

            }
        };
        handler.post(runnable);


    }
}
