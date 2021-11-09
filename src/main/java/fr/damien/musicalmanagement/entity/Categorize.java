package fr.damien.musicalmanagement.entity;

public class Categorize {

    private int songId;
    private int typeId;

    public Categorize(int songId, int typeId) {
        this.songId = songId;
        this.typeId = typeId;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
