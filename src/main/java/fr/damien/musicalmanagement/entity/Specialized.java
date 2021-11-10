package fr.damien.musicalmanagement.entity;

public class Specialized {

    private int userId;
    private int specialityId;

    public Specialized() {
    }

    public Specialized(int userId, int specialityId) {
        this.userId = userId;
        this.specialityId = specialityId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }
}
