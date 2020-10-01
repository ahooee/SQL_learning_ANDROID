package ir.linuxian.sql.komakkar;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import ir.linuxian.sql.R;
import ir.linuxian.sql.activityha.AghazActivity;
import ir.linuxian.sql.activityha.EntekhabActivity;

public class Neveshtan {




    final String[] RANGHA ={"2372f3","ff0002","f2e71a","49cf44","d848ff","ffffff","0097f6","ababab"};

    int tNamaye = 0;
    int takhir = 0;
    int takhirAvalie = 0;
    int tSize = 0;
    Handler handler;
    TextView textView;


    String matn;


    public Neveshtan(String matn , int takhir , int takhirAvalie){

        this.matn = matn ;
        this.takhir = takhir ;
        this.takhirAvalie = takhirAvalie ;



    }



    public void nevisandeh(TextView tv){


        this.textView = tv;



        handler = new Handler();


          final Runnable runnable = new Runnable() {
            @Override
            public void run() {

                textView.setText(matn.substring(0,tNamaye++));


                if(tNamaye<=matn.length())

                    handler.postDelayed(this,takhir);



            }

              @Override
              protected void finalize() throws Throwable {
                  super.finalize();
              }
          };

          handler.postDelayed(runnable,takhirAvalie);

    }



    public  void khoshnevis(final Context context , final LinearLayout linearLayout, final LinearLayout.LayoutParams layoutParams ){


         handler = new Handler();

        final Runnable runnable1= new Runnable(){


            @Override
            public void run() {

                TextView tv = new TextView(context);
                tv.setTextSize(33);

                tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tv.setLayoutParams(layoutParams);
                tv.setTextAppearance(context, R.style.cursive);

                tv.setTextColor(Color.parseColor("#"+RANGHA[tNamaye]));

                tv.setText(matn.substring(tNamaye, ++tNamaye));

                linearLayout.addView(tv);

                if(tNamaye <matn.length())
                    handler.postDelayed(this, takhir);





            }
        };

        handler.postDelayed(runnable1,takhir);


    }












}
