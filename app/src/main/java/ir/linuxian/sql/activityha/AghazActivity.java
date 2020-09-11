package ir.linuxian.sql.activityha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import ir.linuxian.sql.R;

public class AghazActivity extends AppCompatActivity {

    TextView textView0,textView1,textView2;
    MediaPlayer mediaPlayer;
    LinearLayout linearLayoutBottom;
    LinearLayout.LayoutParams layoutParams;

    final String tv0Text = "به نام خداوند بخشنده و بخشایشگر";

    final String tv1Text = "آموزش SQL"
            +"\n\n"
            +"بر محور پایگاه داده MYSQL";
    final String tv2Text = "#التماس_دعا";

    final String linuxianText = "linuxian";
    final int mDelay = 60;
    final int mDelay1 = 730;
    int mIndex = 0;
    int mIndex1 = 0;
    final String[] colorAraye ={"2372f3","ff0002","f2e71a","49cf44","d848ff","ffffff","0097f6","ababab"};

    final Handler mHandler = new Handler();
    final Handler mHandler1 = new Handler();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aghaz);

        //initialize variables
        init();

        //Running splash animation
        splashRUN();
    }

    private void splashRUN() {


        mediaPlayer.start();


        final Runnable runnable= new Runnable(){


            @Override
            public void run() {


                if(mIndex<=tv0Text.length()){
                    textView0.setText(tv0Text.substring(0, mIndex++));


                }else if(mIndex>tv0Text.length() && mIndex<=(tv0Text.length()+tv1Text.length())){

                    textView1.setText(tv1Text.substring(0, mIndex++-tv0Text.length()));

                }else if(mIndex>(tv0Text.length()+tv1Text.length())){

                    textView2.setText(tv2Text.substring(0, mIndex++-(tv0Text.length()+tv1Text.length())));


                }


                if(mIndex <= (tv0Text.length()+tv1Text.length()+tv2Text.length())) {
                    mHandler.postDelayed(this, mDelay);

                }

            }
        };

        mHandler.postDelayed(runnable,mDelay);


        final Runnable runnable1= new Runnable(){


            @Override
            public void run() {

                TextView tv = new TextView(AghazActivity.this);
                tv.setTextSize(33);

                tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tv.setLayoutParams(layoutParams);
                tv.setTextAppearance(AghazActivity.this,R.style.cursive);

                tv.setTextColor(Color.parseColor("#"+colorAraye[mIndex1]));

                tv.setText(linuxianText.substring(mIndex1, ++mIndex1));

                linearLayoutBottom.addView(tv);

                if(mIndex1 <linuxianText.length()) {
                    mHandler1.postDelayed(this, mDelay1);



                }else{

                    startActivity(new Intent(AghazActivity.this, EntekhabActivity.class));

                    AghazActivity.this.finish();
                }

            }
        };

        mHandler1.postDelayed(runnable1,mDelay1);




    }

    private void init() {

        textView0 =findViewById(R.id.tv0);
        textView1 =findViewById(R.id.tv1);
        textView2 =findViewById(R.id.tv2);


        linearLayoutBottom = findViewById(R.id.linearlayout_Bottom);

        layoutParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.weight=1;
        layoutParams.gravity= Gravity.CENTER;

        mediaPlayer =MediaPlayer.create(AghazActivity.this,R.raw.typing);






    }
}