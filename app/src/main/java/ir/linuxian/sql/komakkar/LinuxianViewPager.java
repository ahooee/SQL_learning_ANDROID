package ir.linuxian.sql.komakkar;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class LinuxianViewPager extends ViewPager {


    public LinuxianViewPager(@NonNull Context context) {

        super(context);
    }

    public LinuxianViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {


        super(context, attrs);


    }




    @Override
    public void setAdapter(PagerAdapter pagerAdapter){

        super.setAdapter(pagerAdapter);

    setCurrentItem(pagerAdapter.getCount());

    }




}
