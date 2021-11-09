package fr.damien.musicalmanagement.entity;

public class Participates {

    private int groupId;
    private int userId;

    public Participates() {
    }

    public Participates(int groupID, int userId) {
        this.groupId = groupId;
        this.userId = userId;
    }
}
