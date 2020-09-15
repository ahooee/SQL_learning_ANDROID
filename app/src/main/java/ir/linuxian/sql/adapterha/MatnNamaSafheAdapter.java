package ir.linuxian.sql.adapterha;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import ir.linuxian.sql.fragmentha.MatnNamaFragment;

public class MatnNamaSafheAdapter extends FragmentStatePagerAdapter {

    String[] matnha,onvanha,linkha,dastoorat, jadavel;

    String[] motoon ;

    public MatnNamaSafheAdapter(@NonNull FragmentManager fm, int behavior, String[] matnha,
                                String[] onvanha, String[] linkha , String[] dastoorat , String[] jadavel) {



        super(fm, behavior);

        this.linkha = linkha;

        this.matnha = matnha;

        this.onvanha = onvanha;

        this.dastoorat = dastoorat;

        this.jadavel = jadavel;
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {


        Bundle bundle = new Bundle();


            motoon = (matnha[matnha.length - position - 1]).split("αβ");

        bundle.putStringArray("matnha",motoon);


        Log.d("chera",linkha[matnha.length-position-1]);
        bundle.putString("matn",matnha[matnha.length-position-1]);
        bundle.putString("linkha",linkha[matnha.length-position-1]);
        String[] dastoorha = {};
        if(dastoorat.length>0)
            dastoorha = (dastoorat[matnha.length-position-1]).split("δ");

        bundle.putStringArray("dastoorha",dastoorha);

        if(jadavel.length>0)
            jadavel = (jadavel[matnha.length-position-1].split("πθ"));

        bundle.putStringArray("jadavel",jadavel);


        if(position>4){

            bundle.putBoolean("jadval",true);




        }



        MatnNamaFragment matnNamaFragment = new MatnNamaFragment();

        matnNamaFragment.setArguments(bundle);

        return matnNamaFragment;
    }

    @Override
    public int getCount() {
        return matnha.length;
    }




    @Override
    public CharSequence getPageTitle(int position){

        return onvanha[onvanha.length-position-1];
    }
}
