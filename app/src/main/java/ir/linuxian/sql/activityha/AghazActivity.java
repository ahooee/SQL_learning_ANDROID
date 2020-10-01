package ir.linuxian.sql.activityha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

import ir.linuxian.sql.R;
import ir.linuxian.sql.komakkar.Neveshtan;
import ir.linuxian.sql.paygahdade.DAmooz;
import ir.linuxian.sql.paygahdade.DAmoozDataBase;

public class AghazActivity extends AppCompatActivity {


    TextView textView0,textView1,textView2;
    MediaPlayer mediaPlayer;
    LinearLayout linearLayoutBottom;
    LinearLayout.LayoutParams layoutParams;

    SharedPreferences sharedPreferences;

    SharedPreferences.Editor prefEditor;

    boolean bootState = false;

    final String matn0 = "به نام خداوند بخشنده و بخشایشگر";

    final String matn1 = "آموزش SQL"
            +"\n\n"
            +"بر محور پایگاه داده MYSQL";
    final String matn2 = "#التماس_دعا";

    final String ahooeeMatn = "ahooee";


    final int takhir = 60;
    final int takhirAhooee = 800;


    TextView[] textViews ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aghaz);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        bootState = sharedPreferences.getBoolean("bootstate",false);

        if(bootState) {

            //if this is not first run of the app , go to the next activity and finish current activity

            startActivity(new Intent(this, EntekhabActivity.class));

            AghazActivity.this.finish();


        }else {


            //initialize variables
            init();

            try {
                dataBaseINIT();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            splashRUN();









        }


    }

    private void splashRUN() {


        mediaPlayer.start();


        new Neveshtan(matn0,takhir,0).nevisandeh(textView0);

        new Neveshtan(matn1,takhir,takhir* matn1.length()).nevisandeh(textView1);

        new Neveshtan(matn2,takhir,takhir*(matn0.length()+matn1.length())).nevisandeh(textView2);

        new Neveshtan(ahooeeMatn,takhirAhooee,0).khoshnevis(this,linearLayoutBottom,layoutParams);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(AghazActivity.this,EntekhabActivity.class));

                AghazActivity.this.finish();

            }
        },takhirAhooee*ahooeeMatn.length()+800);







        prefEditor = sharedPreferences.edit();

        prefEditor.putBoolean("bootstate",true);

        prefEditor.apply();



    }

    private void init() {





        textView0 =findViewById(R.id.tv0);
        textView1 =findViewById(R.id.tv1);
        textView2 =findViewById(R.id.tv2);

        textViews = new TextView[]{textView0, textView1, textView2};

        linearLayoutBottom = findViewById(R.id.linearlayout_Bottom);

        layoutParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.weight=1;
        layoutParams.gravity= Gravity.CENTER;

        mediaPlayer =MediaPlayer.create(AghazActivity.this,R.raw.typing);









    }

    @SuppressLint("StaticFieldLeak")
    private void dataBaseINIT() throws ExecutionException, InterruptedException {


        DAmooz dAmooz =new AsyncTask<Void, Void, DAmooz>() {
            @Override
            protected DAmooz doInBackground(Void... voids) {

                DAmoozDataBase dAmoozDataBase = DAmoozDataBase.getInstance(AghazActivity.this);




                for(int i=0;i<9;i++) {

                    dAmoozDataBase.getDamoozDAO().insetDAmooz(new DAmooz(i,"mo"+i,"ka"+i,i+3,i*13.5f));




                }
                SupportSQLiteQuery supportSQLiteQuery = new SimpleSQLiteQuery("Select * from damooz");
                return dAmoozDataBase.getDamoozDAO().getDAmooz(supportSQLiteQuery);
            }
        }.execute(new Void[3]).get();


        //just fot test
        //Toast.makeText(this, dAmooz.getFirstName(),Toast.LENGTH_LONG).show();





    }


    @Override
    protected void onStop() {

        if(mediaPlayer != null) {

            if(mediaPlayer.isPlaying())
                mediaPlayer.stop();

            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null ;

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