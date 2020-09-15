package ir.linuxian.sql.activityha;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fehrest_amoozesh);


        listSaaz();

        recyclerView = findViewById(R.id.recycler_amoozesh);

        amoozeshListAdapter =new AmoozeshListAdapter(amoozeshListModels);


        recyclerView.addOnItemTouchListener(new RecyclerTouchHandler(AmoozeshFehrestActivity.this,new RecyclerTouchHandler.ClickKon() {
            @Override
            public void Onclick(View v, int pos) {



                if(amoozeshListModels.get(pos).getGoone()!=AmoozeshListModel.SARSAFHE)
                    startActivity(new Intent(AmoozeshFehrestActivity.this,AmoozeshActivity.class).putExtra("shomare",amoozeshListModels.get(pos).getNamaye()));
            }
        }));


        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);

        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {


                if(position <= 1 || position == 4 ){

                    return 2;

                }else if(position > 1 && position <=3){

                    return 1;
                }else if(position > 4){
                    return 1;
                }else{

                    return 2;

                }



            }
        };


        gridLayoutManager.setSpanSizeLookup(spanSizeLookup);
        recyclerView.setLayoutManager(gridLayoutManager);




        recyclerView.setAdapter(amoozeshListAdapter);





    }

    private void listSaaz() {

        amoozeshListModels =new ArrayList<>();

        int i = 0;

        for(String naam : getResources().getStringArray(R.array.amoozesh_list)) {

            int namaye =0;
            int goone = 0;

            if(i==0 || i==4) {

                goone = AmoozeshListModel.SARSAFHE;
                namaye = 0;



            }else if((i>0 && i<4)){


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

