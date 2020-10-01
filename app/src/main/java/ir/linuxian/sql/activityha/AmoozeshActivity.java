package ir.linuxian.sql.activityha;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.google.android.material.tabs.TabLayout;

import ir.linuxian.sql.R;
import ir.linuxian.sql.adapterha.MatnNamaSafheAdapter;
import ir.linuxian.sql.fragmentha.MatnNamaFragment;
import ir.linuxian.sql.komakkar.LinuxianViewPager;

public class AmoozeshActivity extends AppCompatActivity implements MatnNamaFragment.OnFragmentInteractionListener {




    LinuxianViewPager viewPager;

    TabLayout tabLayout;

    Toolbar toolbar;

    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amoozesh);


        meghdardehi();

        aghaaze();










      //  bundle =new Bundle();

        //bundle.putString("matn",getResources().getStringArray(R.array.amoozesh_matnha)[getIntent().getIntExtra("shomare",0)<2?getIntent().getIntExtra("shomare",0):0]);




//        fragmentEzafe(bundle);


    }

    private void aghaaze() {


        Resources resources = getResources();

        int resId = getIntent().getIntExtra("shomare",0);


        TypedArray typedArray = resources.obtainTypedArray(R.array.amoozesh_matnha);

        String[] matnha = resources.getStringArray(typedArray.getResourceId(resId,0));

        typedArray.recycle();



        typedArray = resources.obtainTypedArray(R.array.amoozesh_onvanha);

        String[] onvanha = resources.getStringArray(typedArray.getResourceId(resId,0));

        typedArray.recycle();




        typedArray =resources.obtainTypedArray(R.array.amoozesh_linkha);

        String[] linkha = resources.getStringArray(typedArray.getResourceId(resId,0));


        typedArray.recycle();


        typedArray = resources.obtainTypedArray(R.array.amoozesh_dastoorat);

        String[] dastoorat = resources.getStringArray(typedArray.getResourceId(resId,0));


        typedArray.recycle();


            typedArray = resources.obtainTypedArray(R.array.amoozesh_sqls);

            String[]  sqls = resources.getStringArray(typedArray.getResourceId(resId , 0));

            typedArray.recycle();



        viewPager.setAdapter(new MatnNamaSafheAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,matnha,onvanha,linkha,dastoorat,sqls));



        tabLayout.setupWithViewPager(viewPager);




    }

    private void meghdardehi() {

        viewPager = findViewById(R.id.pager_amoozesh);
        tabLayout = findViewById(R.id.tablayout_linuxian);

        toolbar =findViewById(R.id.toolbar_amoozesh);






    }

 /*   private void fragmentEzafe(Bundle bundle) {

        FragmentManager fragmentManager =getSupportFragmentManager();

        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();


        MatnNamaFragment matnNamaFragment = new MatnNamaFragment();

        matnNamaFragment.setArguments(bundle);


        fragmentTransaction.add(R.id.linear_amoozesh,matnNamaFragment);


        fragmentTransaction.commit();



    }



  */


    @Override
    public void onFragmentInteraction(Uri uri) {



    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
