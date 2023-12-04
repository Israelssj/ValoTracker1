package com.example.valotracker1;

import com.google.gson.annotations.SerializedName;

public class PlayerData {
    @SerializedName("name")
    private String playerName;

    @SerializedName("score")
    private int playerScore;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
