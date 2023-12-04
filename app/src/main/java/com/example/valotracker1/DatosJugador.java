package com.example.valotracker1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class DatosJugador extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn_add;
    Spinner spinnerAgentes, spinnerResultados, spinnerMapas;
    EditText kills, combatScore, muertes, asistencias;
    private FirebaseFirestore mfirestore;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_jugador);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn_add = findViewById(R.id.btn_add);

        mfirestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        spinnerAgentes = findViewById(R.id.spinnerAgentes);
        spinnerResultados = findViewById(R.id.spinnerResultados);
        spinnerMapas = findViewById(R.id.spinnerMapas);
        kills = findViewById(R.id.kills);
        combatScore = findViewById(R.id.combatScore);
        muertes = findViewById(R.id.muertes);
        asistencias = findViewById(R.id.asistencias);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DatosJugador.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DatosJugador.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DatosJugador.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DatosJugador.this, MainActivity4.class);
                startActivity(intent);
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAuth.getCurrentUser() != null) {
                    String userId = mAuth.getCurrentUser().getUid();

                    String agentes = spinnerAgentes.getSelectedItem().toString().trim();
                    String resultados = spinnerResultados.getSelectedItem().toString().trim();
                    String mapas = spinnerMapas.getSelectedItem().toString().trim();
                    String kill = kills.getText().toString().trim();
                    String score = combatScore.getText().toString().trim();
                    String deaths = muertes.getText().toString().trim();
                    String assists = asistencias.getText().toString().trim();

                    if (agentes.isEmpty() || resultados.isEmpty() || mapas.isEmpty() || kill.isEmpty() || score.isEmpty() || deaths.isEmpty() || assists.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Rellena todos los datos", Toast.LENGTH_SHORT).show();
                    } else {
                        postResult(userId, agentes, resultados, mapas, kill, score, deaths, assists);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Usuario no autenticado", Toast.LENGTH_SHORT).show();
                    // startActivity(new Intent(DatosJugador.this, LoginActivity.class));
                }
            }
        });

        Spinner spinnerAgentes = findViewById(R.id.spinnerAgentes);
        String[] nombresAgentes = {"Breach", "Brimstone", "Cypher", "Jett", "Killjoy", "Omen", "Phoenix", "Raze", "Reyna", "Sage", "Skye", "Sova", "Viper",};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, nombresAgentes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAgentes.setAdapter(adapter);

        Spinner spinnerResultados = findViewById(R.id.spinnerResultados);
        String[] resultados = {"Ganada", "Perdida"};
        ArrayAdapter<String> resultadosAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, resultados);
        resultadosAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerResultados.setAdapter(resultadosAdapter);

        Spinner spinnerMapas = findViewById(R.id.spinnerMapas);
        String[] nombresMapas = {"Ascent", "Bind", "Haven", "Icebox", "Split"};
        ArrayAdapter<String> mapasAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, nombresMapas);
        mapasAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMapas.setAdapter(mapasAdapter);
    }

    private void postResult(String userId, String agentes, String resultados, String mapas, String kill, String score, String deaths, String assists) {
        if (mAuth.getCurrentUser() != null) {
            StatModel stat = new StatModel(userId, agentes, resultados, mapas, kill, score, deaths, assists);

            mfirestore.collection("stats").add(stat)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(getApplicationContext(), "Creado exitosamente", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Error al ingresar los datos: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }
}
