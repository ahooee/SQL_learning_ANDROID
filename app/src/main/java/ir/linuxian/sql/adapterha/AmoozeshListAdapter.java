package ir.linuxian.sql.adapterha;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.linuxian.sql.R;
import ir.linuxian.sql.modelha.AmoozeshListModel;

public class AmoozeshListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    List<AmoozeshListModel> amoozeshListSatrha;

    public AmoozeshListAdapter(List<AmoozeshListModel> amoozeshListSatrha){

        this.amoozeshListSatrha = amoozeshListSatrha;


    }


    static class SarsafheViewHolder extends RecyclerView.ViewHolder{


        TextView textViewSarsafhe;
        LinearLayout linearSarsafhe;

        Resources resources;


        public SarsafheViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewSarsafhe = itemView.findViewById(R.id.textview_sarsafhe);

            linearSarsafhe = itemView.findViewById(R.id.linear_sarsafhe);

            resources = itemView.getResources();
        }




        public void takmilSarSafhe(AmoozeshListModel amoozeshListModel){

            textViewSarsafhe.setText(amoozeshListModel.getNaam());
            textViewSarsafhe.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
            textViewSarsafhe.setGravity(Gravity.CENTER);
            linearSarsafhe.setBackground(resources.getDrawable(R.drawable.mostatil_sarsafhe));





        }

    }




    static class MafahimListViewHolder extends RecyclerView.ViewHolder{


        TextView
                //textViewShomare,
                textViewOnvan;

        LinearLayout linearLayout;

        Resources resources;


        private MafahimListViewHolder(@NonNull View itemView) {

            super(itemView);

           // textViewShomare = itemView.findViewById(R.id.txt_satr_amoozesh_shomare);

            textViewOnvan = itemView.findViewById(R.id.txt_satr_amoozesh_onvan);

            linearLayout = itemView.findViewById(R.id.lin_satr_amoozesh_onvan);

            resources = itemView.getResources();



        }



        private void takmilMafahim(AmoozeshListModel amoozeshListModel, int pos){


            int r=0,g=((pos*5)+99),b=255;

            
            textViewOnvan.setText(amoozeshListModel.getNaam());

//            textViewShomare.setText(""+pos+1);



          //  linearLayout.setBackgroundColor(Color.rgb(r,g,b-(pos*5)));

            /*textViewOnvan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    TextView tv = (TextView) view;

                    view.getContext().startActivity(new Intent(view.getContext(), AmoozeshActivity.class).putExtra("shomare",pos));





                }
            });

*/

        }








    }


    static class DastooratListViewHolder extends RecyclerView.ViewHolder{

        LinearLayout linearLayout;
        TextView textView;
        Resources resources;

        public DastooratListViewHolder(@NonNull View itemView) {
            super(itemView);

            this.linearLayout = itemView.findViewById(R.id.linear_dastoorat);
            this.textView = itemView.findViewById(R.id.textview_dastoorat);

            this.resources = itemView.getResources();

        }

        private void takmilDastoorat(AmoozeshListModel amoozeshListModel){

            textView.setText(amoozeshListModel.getNaam());
            //linearLayout.setBackground(resources.getDrawable(R.drawable.mostatil_sabz));

        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {





        RecyclerView.ViewHolder viewHolder = null;
        if(viewType == AmoozeshListModel.SARSAFHE){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sarsafhe_list_amoozesh,parent,false);

            viewHolder = new SarsafheViewHolder(view);

        }else if(viewType == AmoozeshListModel.MAFAHIM){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.satr_list_mafahim,parent,false);

            viewHolder = new MafahimListViewHolder(view);

        }else if(viewType==AmoozeshListModel.DASTOORAT) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.satr_list_dastoorat,parent,false);

            viewHolder = new DastooratListViewHolder(view);

        }



        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        if(amoozeshListSatrha.get(position).getGoone() == AmoozeshListModel.SARSAFHE){

            SarsafheViewHolder viewHolder = (SarsafheViewHolder)holder;


            viewHolder.takmilSarSafhe(amoozeshListSatrha.get(position));

        }else if(amoozeshListSatrha.get(position).getGoone() == AmoozeshListModel.MAFAHIM) {

            MafahimListViewHolder viewHolder = (MafahimListViewHolder) holder;

            viewHolder.takmilMafahim(amoozeshListSatrha.get(position), position);


        }else if(amoozeshListSatrha.get(position).getGoone()==AmoozeshListModel.DASTOORAT){

            DastooratListViewHolder viewHolder = (DastooratListViewHolder) holder;
            viewHolder.takmilDastoorat(amoozeshListSatrha.get(position));

        }





    }



    @Override
    public int getItemCount() {





        return amoozeshListSatrha.size();
    }


    @Override
    public int getItemViewType(int pos){


        return amoozeshListSatrha.get(pos).getGoone();
    }
}
