package fr.damien.musicalmanagement.entity;

public class Practice {

    private int userId;
    private int intrumentId;

    public Practice() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIntrumentId() {
        return intrumentId;
    }

    public void setIntrumentId(int intrumentId) {
        this.intrumentId = intrumentId;
    }
}
