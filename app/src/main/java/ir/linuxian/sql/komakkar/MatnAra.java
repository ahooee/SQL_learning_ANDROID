package ir.linuxian.sql.komakkar;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MatnAra {

    String matn;

    String[] linkha_araye;

    TextView textView;

    public MatnAra(String matn ,String linkha, TextView textView){

        Log.d("cherra",linkha);


        this.matn = matn;

        linkha =linkha.replaceAll(" ","");

        if(linkha.length()>0)
        this.linkha_araye = linkha.split(",");

        this.textView = textView;

    }




    public int anjam(int linkha_index){





        SpannableStringBuilder spannableStringBuilder=new SpannableStringBuilder(matn);

        String zirReshteyeFeli=matn;
        int makanEesharegar=0;



        if(linkha_araye!=null)
        while(zirReshteyeFeli.contains("ξ")) {



            spannableStringBuilder.setSpan(new URLSpan(linkha_araye[linkha_index]), makanEesharegar+zirReshteyeFeli.indexOf("ξ"), makanEesharegar+zirReshteyeFeli.indexOf("ξξ"), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


            makanEesharegar+=zirReshteyeFeli.indexOf("ξξ")+2;
            zirReshteyeFeli=zirReshteyeFeli.substring(zirReshteyeFeli.indexOf("ξξ")+2);

            linkha_index++;
        }

        while(matn.contains("ξ")) {

            spannableStringBuilder.delete(matn.indexOf("ξ"), matn.indexOf("ξ") + 1);
            matn=matn.replaceFirst("ξ","");
        }





        zirReshteyeFeli=matn;
        makanEesharegar=0;



        while(zirReshteyeFeli.contains("π")) {

            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#00877a")), makanEesharegar+zirReshteyeFeli.indexOf("π"), makanEesharegar+zirReshteyeFeli.indexOf("ππ"), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableStringBuilder.setSpan(new StyleSpan(Typeface.BOLD), makanEesharegar+zirReshteyeFeli.indexOf("π"), makanEesharegar+zirReshteyeFeli.indexOf("ππ"), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);




            makanEesharegar+=zirReshteyeFeli.indexOf("ππ")+2;
            zirReshteyeFeli=zirReshteyeFeli.substring(zirReshteyeFeli.indexOf("ππ")+2);
        }

        while(matn.contains("π")) {

            spannableStringBuilder.delete(matn.indexOf("π"), matn.indexOf("π") + 1);
            matn=matn.replaceFirst("π","");
        }



        zirReshteyeFeli=matn;
        makanEesharegar=0;

        while(zirReshteyeFeli.contains("φ")) {

            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#c4462d")), makanEesharegar+zirReshteyeFeli.indexOf("φ"), makanEesharegar+zirReshteyeFeli.indexOf("φφ"), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableStringBuilder.setSpan(new StyleSpan(Typeface.BOLD), makanEesharegar+zirReshteyeFeli.indexOf("φ"), makanEesharegar+zirReshteyeFeli.indexOf("φφ"), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannableStringBuilder.setSpan(new RelativeSizeSpan(1.5f), makanEesharegar+zirReshteyeFeli.indexOf("φ"), makanEesharegar+zirReshteyeFeli.indexOf("φφ"), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


            makanEesharegar+=zirReshteyeFeli.indexOf("φφ")+2;
            zirReshteyeFeli=zirReshteyeFeli.substring(zirReshteyeFeli.indexOf("φφ")+2);
        }



        while(matn.contains("φ")) {



            spannableStringBuilder.delete(matn.indexOf("φ"), matn.indexOf("φ") + 1);
            matn=matn.replaceFirst("φ","");
        }




        textView.setText(spannableStringBuilder);

        textView.setTextDirection(View.TEXT_DIRECTION_RTL);

        textView.setTextSize(24);
        textView.setTextColor(Color.DKGRAY);
        textView.setMovementMethod(LinkMovementMethod.getInstance());




        return linkha_index;



    }




}
