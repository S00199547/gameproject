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



    Button bDeepPink,bRed,bYellow,bSkyBlue ,btnplay;
    View Option1,Option2,Option3,Option4;
    String Answer="";
    int count,score=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent mIntent=getIntent();
       score=mIntent.getIntExtra("score",0);


        /*bDeepPink=findViewById(R.id.Pink);
        bRed=findViewById(R.id.Red);
        bYellow=findViewById(R.id.Yellow);
        bSkyBlue=findViewById(R.id.SkyBlue);*/
         btnplay=findViewById(R.id.btndoplay);

         Option1=findViewById(R.id.btnSelectedRed);
         Option2=findViewById(R.id.btnSelectedRed);
         Option3=findViewById(R.id.btnSelectedSkyBlue);
         Option4=findViewById(R.id.btnSelectedYellow);

         count =4;
         int doplay= 2 * score;
         count = count + doplay;






    }


    public void check(){
        if(Option1.getVisibility()==View.VISIBLE || Option2.getVisibility() ==
        View.VISIBLE || Option3.getVisibility() == View.VISIBLE || Option4.getVisibility() ==View.VISIBLE){
            Option1.setVisibility(View.INVISIBLE);
            Option2.setVisibility(View.INVISIBLE);
            Option3.setVisibility(View.INVISIBLE);
            Option4.setVisibility(View.INVISIBLE);
        }

    }

    public  void  selection(View selection,int random){
        selection.setVisibility(View.VISIBLE);
        Answer=Answer + random;
    }
    public void doPlay(View view) {
        if(count ==0){
            Intent intent = new Intent(MainActivity.this,Screen2.class);
            intent.putExtra("score",score);
            intent.putExtra("answer",Answer);
            startActivity(intent);
        }

    }

    public void domove(View view) {

        if(count !=0){
            check();
            int random = new Random().nextInt(4)+1;
            View selectionColor=null;
            if(random == 1){
                selectionColor=Option1;
            }
            else  if (random == 2){
                selectionColor=Option2;
            }
            else  if(random == 3){
                selectionColor=Option3;
            }
            else if(random == 4){
                selectionColor=Option4;
            }
            selection(selectionColor,random);
            count--;
        }

    }




}