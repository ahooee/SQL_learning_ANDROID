package ir.linuxian.sql.activityha;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ir.linuxian.sql.R;
import ir.linuxian.sql.adapterha.AmoozeshListAdapter;
import ir.linuxian.sql.komakkar.RecyclerTouchHandler;
import ir.linuxian.sql.modelha.AmoozeshListModel;

public class AmoozeshFehrestActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    List<AmoozeshListModel> amoozeshListModels;

    AmoozeshListAdapter amoozeshListAdapter;

    SearchView searchView;

    List<AmoozeshListModel> newamoozeshListModels ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fehrest_amoozesh);


        listSaaz();

        recyclerView = findViewById(R.id.recycler_amoozesh);

        amoozeshListAdapter =new AmoozeshListAdapter(amoozeshListModels);




        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);

        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {


                if(position <= 1 || position == 6 ){

                    return 2;

                }else if(position > 1 && position <=5){

                    return 1;
                }else if(position > 6){
                    return 1;
                }else{

                    return 2;

                }



            }
        };


        gridLayoutManager.setSpanSizeLookup(spanSizeLookup);
        recyclerView.setLayoutManager(gridLayoutManager);




        recyclerView.setAdapter(amoozeshListAdapter);

        searchView = findViewById(R.id.search_list);

        searchView.setQueryHint("جستجو");

        //assign the list to the new list
        newamoozeshListModels = amoozeshListModels;

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                //for search in English pharse
                newText = newText.toLowerCase();

                newamoozeshListModels = new ArrayList<>();


                if(newText.isEmpty()){

                    newamoozeshListModels = amoozeshListModels;

                }else {


                    for (AmoozeshListModel amoozeshListModel : amoozeshListModels) {

                        if (amoozeshListModel.getNaam().toLowerCase().contains(newText)) {

                           if(!((amoozeshListModel.getGoone() == AmoozeshListModel.SARSAFHE) )) {

                                newamoozeshListModels.add(amoozeshListModel);
                            }



                        }


                    }

                }

                amoozeshListAdapter.search(newamoozeshListModels);


                //Toast.makeText(AmoozeshFehrestActivity.this,newText,Toast.LENGTH_SHORT).show();
                return false;
            }
        });



        recyclerView.addOnItemTouchListener(new RecyclerTouchHandler(AmoozeshFehrestActivity.this,new RecyclerTouchHandler.ClickKon() {
            @Override
            public void Onclick(View v, int pos) {



                if(newamoozeshListModels.get(pos).getGoone()!=AmoozeshListModel.SARSAFHE)
                    startActivity(new Intent(AmoozeshFehrestActivity.this,AmoozeshActivity.class).putExtra("shomare",newamoozeshListModels.get(pos).getNamaye()));
            }
        }));







    }

    private void listSaaz() {

        amoozeshListModels =new ArrayList<>();

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

