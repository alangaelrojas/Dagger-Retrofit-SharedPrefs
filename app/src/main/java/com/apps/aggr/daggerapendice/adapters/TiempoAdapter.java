package com.apps.aggr.daggerapendice.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.aggr.daggerapendice.R;
import com.apps.aggr.daggerapendice.model.Tiempo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TiempoAdapter extends RecyclerView.Adapter<TiempoAdapter.HolderTiempo> {

    private List<Tiempo> meteorologia;

    public TiempoAdapter(){
        meteorologia = new ArrayList<>();
    }

    public void add(List<Tiempo> tiempo){
        this.meteorologia.addAll(tiempo);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HolderTiempo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tiempo, parent, false);
        return new HolderTiempo(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderTiempo holder, int position) {
        Tiempo tiempo = new Tiempo();
        tiempo = meteorologia.get(position);
        Long tiempoLong = Long.parseLong(tiempo.getDt());
        Date date = new Date((long)tiempoLong*1000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss", Locale.US);
        String tiempoS = dateFormat.format(date);

        holder.txtFecha.setText(tiempoS);
        holder.txtTemp.setText(meteorologia.get(position).getMain().getTemp());
        holder.txtHum.setText(meteorologia.get(position).getMain().getHumidity());

    }

    @Override
    public int getItemCount() {
        return meteorologia.size();
    }

    public class HolderTiempo extends RecyclerView.ViewHolder{
        private TextView txtFecha,txtTemp, txtHum;

        public HolderTiempo(@NonNull View itemView) {
            super(itemView);
            txtFecha = itemView.findViewById(R.id.txtFecha);
            txtHum = itemView.findViewById(R.id.txtHumedad);
            txtTemp = itemView.findViewById(R.id.txtTemperatura);
        }
    }
}
