package model;

public class Goal {

    private String shooter;
    private int minute;
    private long idGoal;
    private long idMatch;
    private boolean isGood;


    public Goal(String shooter, int minute, long idMatch) {
        this.shooter = shooter;
        this.minute = minute;
        this.idMatch = idMatch;
    }

    public String getShooter() {
        return shooter;
    }

    public void setShooter(String shooter) {
        this.shooter = shooter;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public long getIdGoal() {
        return idGoal;
    }

    public void setIdGoal(long idGoal) {
        this.idGoal = idGoal;
    }

    public long getIdMatch() {
        return idMatch;
    }

    public void setIdMatch(long idMatch) {
        this.idMatch = idMatch;
    }

    public boolean isGood() {
        return isGood;
    }

    public void setGood(boolean good) {
        isGood = good;
    }

    public Goal() {
    }
}
