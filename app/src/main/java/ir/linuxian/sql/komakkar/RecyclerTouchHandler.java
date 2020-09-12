package ir.linuxian.sql.komakkar;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerTouchHandler implements RecyclerView.OnItemTouchListener {


    public ClickKon clickKon;
    public GestureDetector daryaftLamse;

    public RecyclerTouchHandler(Context context, ClickKon clickKon ) {
        this.clickKon = clickKon;
        this.daryaftLamse = new GestureDetector(context , new GestureDetector.SimpleOnGestureListener(){

            @Override
            public boolean onSingleTapUp(MotionEvent event){



                return true;
            }


        });


    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

        View view = rv.findChildViewUnder(e.getX(),e.getY());

        if(view != null && clickKon != null && daryaftLamse.onTouchEvent(e))
            clickKon.Onclick(view,rv.getChildAdapterPosition(view));



        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {


    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }


    public interface ClickKon{

        void Onclick(View v, int pos);

    }
}
