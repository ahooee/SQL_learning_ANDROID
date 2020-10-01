package ir.linuxian.sql.fragmentha;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.sqlite.db.SimpleSQLiteQuery;

import java.util.List;
import java.util.concurrent.ExecutionException;

import ir.linuxian.sql.R;
import ir.linuxian.sql.komakkar.MatnAra;
import ir.linuxian.sql.paygahdade.DAmooz;
import ir.linuxian.sql.paygahdade.DAmoozDataBase;


public class MatnNamaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MatnNamaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MatnNamaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MatnNamaFragment newInstance(String param1, String param2) {
        MatnNamaFragment fragment = new MatnNamaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        View view = inflater.inflate(R.layout.fragment_matnnama, container, false);


        takmilMohtava(view);




        // Inflate the layout for this fragment
        return view;
    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    private void takmilMohtava(View namayeAsli) {

        int linkha_index =0;

        String linkha ;

        String[] motoon , dastoorat , jadavel;

        LinearLayout linearLayout;

        assert getArguments() != null;

        motoon = getArguments().getStringArray("matnha");

        dastoorat = getArguments().getStringArray("dastoorha");

        linkha = getArguments().getString("linkha");

        jadavel = getArguments().getStringArray("jadavel");

        linearLayout = namayeAsli.findViewById(R.id.linear_matnnama);




        if(motoon!=null)
        for(int i=0;i<motoon.length;i++){


            if(motoon[i].contains("λκ")) {
                String[] matnM = motoon[i].split("λκ");
                for (String matn : matnM) {

                    TextView textView = new TextView(getActivity());

                    int indexofSQL=0;
                    if(matn.contains("ζ")) {
                        indexofSQL = Character.getNumericValue(matn.charAt(matn.lastIndexOf("ζ") + 1));
                        matn = matn.replaceAll("ζ\\d", "");


                        Toast.makeText(getContext(), "s" + indexofSQL, Toast.LENGTH_LONG).show();
                        MatnAra matnAra = new MatnAra(matn, linkha, textView);

                        linkha_index = matnAra.anjam(linkha_index);


                        textView.setBackground(namayeAsli.getContext().getResources().getDrawable(R.drawable.mostatil_amoozesh_matn));

                        linearLayout.addView(textView);




                        try {
                            assert jadavel != null;
                            jadvalSaaz(namayeAsli,jadavel[indexofSQL]);
                        } catch (ExecutionException | InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {


                        MatnAra matnAra = new MatnAra(matn, linkha, textView);

                        linkha_index = matnAra.anjam(linkha_index);


                        textView.setBackground(namayeAsli.getContext().getResources().getDrawable(R.drawable.mostatil_amoozesh_matn));

                        linearLayout.addView(textView);






                    }





                    }




            }else{


                TextView textView = new TextView(getActivity());

                MatnAra matnAra = new MatnAra(motoon[i], linkha, textView);

                linkha_index = matnAra.anjam(linkha_index);


                textView.setBackground(namayeAsli.getContext().getResources().getDrawable(R.drawable.mostatil_amoozesh_matn));

                linearLayout.addView(textView);


            }
            if(dastoorat!=null)
            if(dastoorat.length>i && !dastoorat[i].isEmpty()){

                TextView textView1 = new TextView(getActivity());

                textView1.setText(dastoorat[i]);



                textView1.setTextSize(TypedValue.COMPLEX_UNIT_SP,16);

                textView1.setBackground(namayeAsli.getContext().getResources().getDrawable(R.drawable.mostatil_abi_padded));

                textView1.setTextColor(Color.parseColor("#FFFFFF"));

                linearLayout.addView(textView1);

            }





        }




    }


    @SuppressLint("StaticFieldLeak")
    private void jadvalSaaz(final View view , final String sqlDastoor) throws ExecutionException, InterruptedException {

        LinearLayout linearLayout = view.findViewById(R.id.linear_matnnama);

        LinearLayout.LayoutParams tableLayoutParams =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

        tableLayoutParams.setMargins(23,23,23,23);


        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(1,1,1,1);


        TableLayout tableLayout = new TableLayout(view.getContext());

        tableLayout.setLayoutParams(tableLayoutParams);


        List<DAmooz> dAmoozan ;

        dAmoozan = new AsyncTask<Void,Void,List<DAmooz>>(){

            @Override
            protected List<DAmooz> doInBackground(Void... voids) {


                @SuppressLint("WrongThread") DAmoozDataBase dAmoozDataBase = DAmoozDataBase.getInstance(view.getContext());
                return dAmoozDataBase.getDamoozDAO().getDAmoozha(new SimpleSQLiteQuery(sqlDastoor));

            }
        }.execute(new Void[3]).get();

        String[] list ;

        list=new String[]{"UID","FName","LName","Paye","Moaddel"};

        satrSaaz(view,layoutParams,tableLayout,list);







        for(DAmooz dAmooz : dAmoozan) {

            list = new String[]{dAmooz.getUid()+"",dAmooz.getFirstName()+"",
            dAmooz.getLastName()+"",dAmooz.getPaye()+"",dAmooz.getMoaddel()+""};
            satrSaaz(view,layoutParams,tableLayout,list);


        }

        if(tableLayout.getParent()!=null)
            ((ViewGroup)(tableLayout.getParent())).removeView(tableLayout);
        else
            linearLayout.addView(tableLayout);
    }

    private void satrSaaz(View view,TableRow.LayoutParams layoutParams ,TableLayout tableLayout , String[] list) {
        

        TextView textView00 ;
        TextView textView01 ;
        TextView textView02 ;
        TextView textView03 ;
        TextView textView04 ;


        TableRow tableRow = new TableRow(view.getContext());
        tableRow.setBackgroundColor(Color.parseColor("#077907"));

        tableRow.setLayoutParams(layoutParams);

        textView00 = new TextView(view.getContext());
        textView01 = new TextView(view.getContext());
        textView02 = new TextView(view.getContext());
        textView03 = new TextView(view.getContext());
        textView04 = new TextView(view.getContext());

        textView00.setPadding(5,2,5,2);
        textView01.setPadding(5,2,5,2);
        textView02.setPadding(5,2,5,2);
        textView03.setPadding(5,2,5,2);
        textView04.setPadding(5,2,5,2);

        int rang = view.getContext().getResources().getColor(R.color.rang_jadval);

        textView00.setTextColor(rang);
        textView01.setTextColor(rang);
        textView02.setTextColor(rang);
        textView03.setTextColor(rang);
        textView04.setTextColor(rang);



        textView00.setLayoutParams(layoutParams);
        textView01.setLayoutParams(layoutParams);
        textView02.setLayoutParams(layoutParams);
        textView03.setLayoutParams(layoutParams);
        textView04.setLayoutParams(layoutParams);

        Drawable drawable = view.getResources().getDrawable(R.drawable.mostatil_amoozesh_jadval);

        textView00.setBackground(drawable);
        textView01.setBackground(drawable);
        textView02.setBackground(drawable);
        textView03.setBackground(drawable);
        textView04.setBackground(drawable);


        textView00.setText(list[0]);
        textView01.setText(list[1]);
        textView02.setText(list[2]);
        textView03.setText(list[3]);
        textView04.setText(list[4]);

        tableRow.addView(textView00);
        tableRow.addView(textView01);
        tableRow.addView(textView02);
        tableRow.addView(textView03);
        tableRow.addView(textView04);

        tableLayout.addView(tableRow);




    }


}
