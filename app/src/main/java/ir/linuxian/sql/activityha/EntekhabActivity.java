package ir.linuxian.sql.activityha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import ir.linuxian.sql.R;

public class EntekhabActivity extends AppCompatActivity {

    float text_Amoozesh_andaze,text_Azmoon_andaze,text_Linuxian_andaze,text_Tanzimat_andaze,text_Source_andaze
            ,text_Amoozesh_andazeBG,text_Azmoon_andazeBG,text_Linuxian_andazeBG,text_Tanzimat_andazeBG,text_Source_andazeBG;


    LinearLayout li_Amoozesh,li_Azmoon,li_Tanzimat,li_Linuxian,li_Source;
    TextView text_Amoozesh,text_Azmoon,text_Tanzimat,text_Linuxian,text_Source;

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entekhab);





        aghaaze();

        text_KK_BG_andaze();

        onClicks();




    }

    private void onClicks() {


        li_Amoozesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TO START AMOOZESH INDEX ACTIVITY
                startActivity(new Intent(EntekhabActivity.this, AmoozeshFehrestActivity.class));


            }
        });





        li_Tanzimat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TO START TANZIMAT ACTIVITY
                //startActivity(new Intent(EntekhabActivity.this,TanzimatActivity.class));
            }
        });

        li_Linuxian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(EntekhabActivity.this,AghazActivity.class));
            }
        });


        li_Azmoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(EntekhabActivity.this);
                Toast.makeText(EntekhabActivity.this,sharedPreferences.getBoolean("bootstate",true)+"",Toast.LENGTH_LONG).show();

                SharedPreferences.Editor prefEditor = sharedPreferences.edit();
                prefEditor.putBoolean("bootstate",false);
                prefEditor.apply();

            }
        });



    }


    private void text_KK_BG_andaze() {


        text_Amoozesh_andaze = 40;
        text_Azmoon_andaze = 30;
        text_Linuxian_andaze = 25;
        text_Source_andaze = 20;
        text_Tanzimat_andaze = 20;

        text_Amoozesh_andazeBG = 55;
        text_Azmoon_andazeBG = 40;
        text_Linuxian_andazeBG = 35;
        text_Source_andazeBG = 30;
        text_Tanzimat_andazeBG = 30;


        textView_andaze(text_Amoozesh, text_Amoozesh_andaze);
        textView_andaze(text_Azmoon, text_Azmoon_andaze);
        textView_andaze(text_Linuxian, text_Linuxian_andaze);
        textView_andaze(text_Source, text_Source_andaze);
        textView_andaze(text_Tanzimat, text_Tanzimat_andaze);











    }

    private void textView_andaze(TextView textView, float andaze) {

        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,andaze);


    }


    private void aghaaze() {


        li_Amoozesh = findViewById(R.id.linear_amoozesh);
        li_Azmoon = findViewById(R.id.linear_azmoon);
        li_Tanzimat = findViewById(R.id.linear_tanzimat);
        li_Linuxian = findViewById(R.id.linear_linuxian);
        li_Source = findViewById(R.id.linear_source);


        text_Amoozesh = findViewById(R.id.text_amoozesh);
        text_Azmoon = findViewById(R.id.text_azmoon);
        text_Tanzimat = findViewById(R.id.text_tanzimat);
        text_Linuxian = findViewById(R.id.text_linuxian);
        text_Source = findViewById(R.id.text_source);

        setAndaze(li_Amoozesh);
        setAndaze(li_Azmoon);
        setAndaze(li_Linuxian);
        setAndaze(li_Source);
        setAndaze(li_Tanzimat);

        mediaPlayer = MediaPlayer.create(this,R.raw.startup);

        mediaPlayer.start();




        /*

        longClick_nama(li_Amoozesh,text_Amoozesh,text_Amoozesh_andaze,text_Amoozesh_andazeBG);

        longClick_nama(li_Azmoon,text_Azmoon,text_Azmoon_andaze,text_Azmoon_andazeBG);

        longClick_nama(li_Tanzimat,text_Tanzimat,text_Tanzimat_andaze,text_Tanzimat_andazeBG);

        longClick_nama(li_Linuxian,text_Linuxian,text_Linuxian_andaze,text_Linuxian_andazeBG);

        longClick_nama(li_Source,text_Source,text_Source_andaze,text_Source_andazeBG);


         */


    }

    private void setAndaze(LinearLayout linearLayout) {

        linearLayout.setScaleX(0.001f);
        linearLayout.setScaleY(0.001f);
        linearLayout.setAlpha(0.1f);


        linearLayout.setTranslationX(400);
        linearLayout.setTranslationX(400);
        linearLayout.animate().translationX(0);
        linearLayout.animate().alpha(1f);
        linearLayout.animate().scaleY(1f).scaleX(1f).setDuration(2500);
        //linearLayout.animate().rotation(360).setDuration(2500);

    }

    private void longClick_nama(final LinearLayout linearLayout, final TextView textView,final float textAndaze,final float textAndazeBG) {

        ColorDrawable linerDraw_Color = (ColorDrawable) linearLayout.getBackground();

        final int liner_Color = linerDraw_Color.getColor();


        final int text_Color = textView.getCurrentTextColor();



        linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                textView.setTextColor(Color.parseColor("#178ff2"));
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,textAndazeBG);
                linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));

                return true;
            }
        });

        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    linearLayout.setBackgroundColor(liner_Color);

                    textView.setTextColor(text_Color);
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,textAndaze);

                }


                return false;
            }
        });


        linearLayout.animate().rotation(360);





    }

    @Override
    protected void onStop() {

        if(mediaPlayer != null) {

            if(mediaPlayer.isPlaying())
                mediaPlayer.stop();

            mediaPlayer.release();

            mediaPlayer = null;
        }

        super.onStop();
    }

    @Override
    protected void onDestroy() {

        if(mediaPlayer != null) {

            if(mediaPlayer.isPlaying())
                mediaPlayer.stop();

            mediaPlayer.stop();
            mediaPlayer.release();

        mediaPlayer = null ;
        }

        super.onDestroy();
    }

}
