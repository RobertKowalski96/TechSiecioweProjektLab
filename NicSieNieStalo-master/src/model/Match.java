package model;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private String opponent;
    private String date;
    private int goodGoals;
    private int badGoals;
    private long idMatch;


    public Match(String opponent, String date) {
        this.opponent = opponent;
        this.date = date;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public long getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(long idMatch) {
        this.idMatch = idMatch;
    }

    public int getGoodGoals() {
        return goodGoals;
    }

    public void setGoodGoals(int goodGoals) {
        this.goodGoals = goodGoals;
    }

    public int getBadGoals() {
        return badGoals;
    }

    public void setBadGoals(int badGoals) {
        this.badGoals = badGoals;
    }

    public Match() {
    }
}
