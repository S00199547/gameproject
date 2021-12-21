package edu.mahnoor.finalgameproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.FitWindowsFrameLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final int DeepPink=1;
    private final int Red=2;
    private final int Yellow=3;
    private final int SkyBlue=4;

    Animation anim;
    Animation flashPlay;

    Button bDeepPink,bRed,bYellow,bSkyBlue ,btnplay;
    View Option1,Option2,Option3,Option4;
    String Answer="";
    int count,score=0;

    int sequenceCount=4,n=0;
    int[] gameSequence=new int[120];
    int arrayIndex=0;

    CountDownTimer ct = new CountDownTimer(6000,1500) {
        @Override
        public void onTick(long millisUntilFinished) {
            oneButton();

        }
        @Override
        public void onFinish() {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent mIntent=getIntent();
        score=mIntent.getIntExtra("score",0);


        bDeepPink=findViewById(R.id.Pink);
        bRed=findViewById(R.id.Red);
        bYellow=findViewById(R.id.Yellow);
        bSkyBlue=findViewById(R.id.SkyBlue);
         btnplay=findViewById(R.id.btndoplay);

         Option1=findViewById(R.id.Red);
         Option2=findViewById(R.id.btnSelectedRed);
         Option3=findViewById(R.id.btnSelectedSkyBlue);
         Option4=findViewById(R.id.btnSelectedYellow);

         count =4;
         int doplay=2* score;
         count = count+ doplay;


         flashPlay = new AlphaAnimation(1,0);
         flashPlay.setDuration(300);
         flashPlay.setStartOffset(3000);
         flashPlay.setRepeatCount(20);
         btnplay.startAnimation(flashPlay);



    }


    public void check(){
        if(Option1.getVisibility()==View.VISIBLE || Option2.getVisibility() ==
        View.VISIBLE || Option3.getVisibility() == View.VISIBLE || Option4.getVisibility() ==View.VISIBLE){
            Option1.setVisibility(View.VISIBLE);
            Option2.setVisibility(View.INVISIBLE);
            Option3.setVisibility(View.INVISIBLE);
            Option4.setVisibility(View.INVISIBLE);
        }

    }

    private  void  oneButton(){
       // n= getRandom(sequenceCount);
        //sb.append(String.valueOf(n)+",");
        Toast.makeText(this,"Number=" + n, Toast.LENGTH_SHORT).show();

        switch (n) {

            case 1:
                flashButton(bDeepPink);
                gameSequence[arrayIndex++] = DeepPink;
                break;

            case 2:
                flashButton(bRed);
                gameSequence[arrayIndex++] = Red;
                break;

            case 3:
                flashButton(bSkyBlue);
                gameSequence[arrayIndex++]=SkyBlue;
                break;

            case 4:
                flashButton(bYellow);
                gameSequence[arrayIndex++]= Yellow;
                break;

            default:
                break;

        }

    }

    public  void  selection(View selection,int random){
        selection.setVisibility(View.VISIBLE);
        Answer=Answer + random;
    }

    public void domove(View view) {

        if(count !=0){
            check();
            int random = new Random().nextInt(4)+1;
            View selectionColor=null;
            if(random ==1){
                selectionColor=Option1;
            }
            else  if (random ==2){
                selectionColor=Option2;
            }
            else  if(random ==3){
                selectionColor=Option3;
            }
            else if(random ==4){
                selectionColor=Option4;
            }
            selection(selectionColor,random);
            count--;
        }

    }
    private  void flashButton(Button button){

        anim = new AlphaAnimation(1,0.0f);
        anim.setDuration(1000);

        anim.setRepeatCount(0);
        button.startAnimation(anim);


    }
    private  int getRandom(int maxValue){
        return ((int)((Math.random()) * maxValue) +1);

    }


    public void doPlay(View view) {
        if(count ==0){
            Intent myIntent = new Intent(MainActivity.this,Screen2.class);
            myIntent.putExtra("score",score);
            myIntent.putExtra("answer",Answer);
            startActivity(myIntent);
        }

    }
}