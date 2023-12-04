package com.example.valotracker1;

public class StatModel {
    private String userId;
    private String agentes;
    private String resultados;
    private String mapas;
    private String kill;
    private String score;
    private String deaths;
    private String assists;

    public StatModel() {}

    public StatModel(String userId, String agentes, String resultados, String kill) {
        this.userId = userId;
        this.agentes = agentes;
        this.resultados = resultados;
        this.kill = kill;
    }


    public StatModel(String userId, String agentes, String resultados, String mapas, String kill, String score, String deaths, String assists) {
        this.userId = userId;
        this.agentes = agentes;
        this.resultados = resultados;
        this.mapas = mapas;
        this.kill = kill;
        this.score = score;
        this.deaths = deaths;
        this.assists = assists;
    }


    public String getUserId() {
        return userId;
    }

    public String getAgentes() {
        return agentes;
    }

    public String getResultados() {
        return resultados;
    }

    public String getMapas() {
        return mapas;
    }

    public String getKill() {
        return kill;
    }

    public String getScore() {
        return score;
    }

    public String getDeaths() {
        return deaths;
    }

    public String getAssists() {
        return assists;
    }
}