package ir.linuxian.sql.komakkar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class AhooeeToast extends Toast {

    Context context;
    int animZaman = 300;
    public AhooeeToast(Context context) {
        super(context);
        this.context = context;
    }


    public void setLayout(int layout , int view ,String matn, boolean anim){

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view0 = layoutInflater.inflate(layout,null);

        View toastView = view0.findViewById(view);

        if(toastView instanceof TextView){

            ((TextView) toastView).setText(matn);

        }



        if(anim){
            toastView.setScaleX(0.1f);
            toastView.setScaleY(0.1f);

            toastView.animate().scaleX(1f).setDuration(animZaman);
            toastView.animate().scaleY(1f).setDuration(animZaman);
        }

        super.setView(view0);


        super.show();



    }

    public void setLayoutAndDurations(int layout , int view ,String matn , boolean anim ,int animZaman , int toastZaman){

        this.animZaman = animZaman;

        super.setDuration(toastZaman);

        setLayout(layout,view,matn,anim);



    }




}
