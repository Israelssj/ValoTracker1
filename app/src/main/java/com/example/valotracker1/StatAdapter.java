package com.example.valotracker1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StatAdapter extends RecyclerView.Adapter<StatAdapter.ViewHolder> {

    private List<StatModel> statList;

    public StatAdapter(List<StatModel> statList) {
        this.statList = statList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_stat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StatModel stat = statList.get(position);


        holder.agenteTextView.setText("Agente: " + stat.getAgentes());
        holder.resultadoTextView.setText("Resultado: " + stat.getResultados());
        holder.killsTextView.setText("Kills: " + String.valueOf(stat.getKill()));
        holder.scoreTextView.setText("Combat Score: " + String.valueOf(stat.getScore()));
        holder.deathsTextView.setText("Muertes: " + String.valueOf(stat.getDeaths()));
        holder.assistsTextView.setText("Asistencias: " + String.valueOf(stat.getAssists()));
        holder.mapasTextView.setText("Mapas: " + stat.getMapas());
    }

    @Override
    public int getItemCount() {
        return statList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView agenteTextView, resultadoTextView, killsTextView;
        TextView scoreTextView, deathsTextView, assistsTextView;
        TextView mapasTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            agenteTextView = itemView.findViewById(R.id.agenteTextView);
            resultadoTextView = itemView.findViewById(R.id.resultadoTextView);
            killsTextView = itemView.findViewById(R.id.killsTextView);
            scoreTextView = itemView.findViewById(R.id.combatScoreTextView);
            deathsTextView = itemView.findViewById(R.id.deathsTextView);
            assistsTextView = itemView.findViewById(R.id.assistsTextView);
            mapasTextView = itemView.findViewById(R.id.mapasTextView); // Nuevo TextView
        }
    }
}