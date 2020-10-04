package ir.linuxian.sql.activityha;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ir.linuxian.sql.R;
import ir.linuxian.sql.adapterha.AmoozeshListAdapter;
import ir.linuxian.sql.komakkar.AhooeeToast;
import ir.linuxian.sql.komakkar.RecyclerTouchHandler;
import ir.linuxian.sql.modelha.AmoozeshListModel;

public class AmoozeshFehrestActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    LinearLayout linearAmoozesh;

    TextView textView;

    List<AmoozeshListModel> amoozeshListModels;

    AmoozeshListAdapter amoozeshListAdapter;

    SearchView searchView;

    List<AmoozeshListModel> newamoozeshListModels ;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fehrest_amoozesh);


        init();

        listSaaz();

        gridLayoutSetter(false);

        jostojoo();


        recyclerViewOnItemTouch();




    }



    

    private void recyclerViewOnItemTouch() {

        recyclerView.addOnItemTouchListener(new RecyclerTouchHandler(AmoozeshFehrestActivity.this,new RecyclerTouchHandler.ClickKon() {
            @Override
            public void Onclick(View v, int pos) {



                if(newamoozeshListModels.get(pos).getGoone()!=AmoozeshListModel.SARSAFHE)
                    startActivity(new Intent(AmoozeshFehrestActivity.this,AmoozeshActivity.class).putExtra("shomare",newamoozeshListModels.get(pos).getNamaye()));
            }
        }));





    }

    private void jostojoo() {


        searchView.setQueryHint(getResources().getString(R.string.search));

        //assign the list to the new list
        newamoozeshListModels = amoozeshListModels;

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                int natayej = 0;
                for(AmoozeshListModel amoozeshListModel : amoozeshListModels){

                    if(amoozeshListModel.getNaam().toLowerCase().contains(query) &&
                            !((amoozeshListModel.getGoone() == AmoozeshListModel.SARSAFHE) ))
                        natayej = natayej +1;
                }

                String searchToast;

                if(natayej>0){

                    searchToast = natayej+" "+getString(R.string.search_toast);
                }else {

                    searchToast = getString(R.string.yaft_nashod);
                }



                new AhooeeToast(AmoozeshFehrestActivity.this)
                        .setLayoutAndDurations(R.layout.ahooee_toast_layout,R.id.ahooee_toast_tv,searchToast,true,400,Toast.LENGTH_SHORT);





                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                //for search in English pharse
                newText = newText.toLowerCase();

                newamoozeshListModels = new ArrayList<>();


                if(newText.isEmpty()){

                    linearAmoozesh.removeAllViews();
                    linearAmoozesh.addView(recyclerView);
                    linearAmoozesh.setBackgroundColor(Color.parseColor("#000000"));

                    newamoozeshListModels = amoozeshListModels;

                    gridLayoutSetter(false);

                }else {

                    gridLayoutSetter(true);

                    int yabande = 0;

                    for (AmoozeshListModel amoozeshListModel : amoozeshListModels) {

                        if (amoozeshListModel.getNaam().toLowerCase().contains(newText)) {

                            linearAmoozesh.removeAllViews();
                            linearAmoozesh.addView(recyclerView);
                            linearAmoozesh.setBackgroundColor(Color.parseColor("#000000"));

                            yabande = yabande + 1;

                            if(!((amoozeshListModel.getGoone() == AmoozeshListModel.SARSAFHE) )) {

                                newamoozeshListModels.add(amoozeshListModel);
                            }



                        }


                    }

                    if(yabande == 0){

                        linearAmoozesh.removeAllViews();

                        linearAmoozesh
                                .setBackground(AmoozeshFehrestActivity.this.getResources().getDrawable(R.drawable.mostatil_soorati));

                        textView = new TextView(AmoozeshFehrestActivity.this);
                        textView.setText(R.string.yaft_nashod);
                        textView.setTextAppearance(AmoozeshFehrestActivity.this,R.style.yabande);
                        textView.setTextColor(Color.WHITE);
                        linearAmoozesh.addView(textView);

                    }




                }

                amoozeshListAdapter.search(newamoozeshListModels);




                //Toast.makeText(AmoozeshFehrestActivity.this,newText,Toast.LENGTH_SHORT).show();
                return false;
            }
        });



    }

    private void gridLayoutSetter(final boolean ifinSearch) {

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);

        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {

                if(ifinSearch){

                    return 1;

                }else {

                if(position <= 1 || position == 6 ){

                    return 2;

                }else{

                    return 1;

                }


                }


            }
        };


        gridLayoutManager.setSpanSizeLookup(spanSizeLookup);
        recyclerView.setLayoutManager(gridLayoutManager);





    }


    private void init() {

        amoozeshListModels =new ArrayList<>();

        linearAmoozesh = findViewById(R.id.linear_amoozesh);

        recyclerView = new RecyclerView(this);

        searchView = findViewById(R.id.search_list);



        RecyclerView.LayoutParams layoutParams =
                new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,RecyclerView.LayoutParams.MATCH_PARENT);


        recyclerView.setLayoutParams(layoutParams);


        amoozeshListAdapter =new AmoozeshListAdapter(amoozeshListModels);

        recyclerView.setAdapter(amoozeshListAdapter);

        linearAmoozesh.addView(recyclerView);


    }

    private void listSaaz() {


        int i = 0;

        for(String naam : getResources().getStringArray(R.array.amoozesh_list)) {

            int namaye =0;
            int goone = 0;

            if(i==0 || i==6) {

                goone = AmoozeshListModel.SARSAFHE;
                namaye = 0;



            }else if((i>0 && i<6)){


                    goone =AmoozeshListModel.MAFAHIM;
                    namaye=i-1;



            }else{

                goone = AmoozeshListModel.DASTOORAT;
                namaye = i-2;

            }



            AmoozeshListModel amoozeshListModel = new AmoozeshListModel(naam, goone , namaye );


            amoozeshListModels.add(amoozeshListModel);


            i++;

        }
    }




    }

