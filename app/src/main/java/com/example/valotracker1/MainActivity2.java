package com.example.valotracker1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5;

    private RecyclerView recyclerView;
    private StatAdapter statAdapter;
    private List<StatModel> statList;
    private TextView totalPartidas, partidasGanadas, partidasPerdidas;

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                startActivity(intent);
            }
        });


        db = FirebaseFirestore.getInstance();


        recyclerView = findViewById(R.id.recyclerView);
        totalPartidas = findViewById(R.id.totalPartidas);
        partidasGanadas = findViewById(R.id.partidasGanadas);
        partidasPerdidas = findViewById(R.id.partidasPerdidas);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        statList = new ArrayList<>();
        statAdapter = new StatAdapter(statList);
        recyclerView.setAdapter(statAdapter);


        fetchStatsFromFirestore();
    }

    private void fetchStatsFromFirestore() {

        CollectionReference statsCollection = db.collection("stats");
        statsCollection.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {

                    statList.clear();
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        StatModel stat = document.toObject(StatModel.class);
                        statList.add(stat);
                    }

                    statAdapter.notifyDataSetChanged();


                    calculateStatistics(statList);
                } else {

                }
            }
        });
    }

    private void calculateStatistics(List<StatModel> stats) {
        int totalPartidasValue = stats.size();
        int ganadas = 0;
        int perdidas = 0;

        for (StatModel stat : stats) {
            if ("Ganada".equals(stat.getResultados())) {
                ganadas++;
            } else if ("Perdida".equals(stat.getResultados())) {
                perdidas++;
            }
        }

        totalPartidas.setText("Total de Partidas Registradas: " + totalPartidasValue);
        partidasGanadas.setText("Ganadas: " + ganadas);
        partidasPerdidas.setText("Perdidas: " + perdidas);
    }

}
