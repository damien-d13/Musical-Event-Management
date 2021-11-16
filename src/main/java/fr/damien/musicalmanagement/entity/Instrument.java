package fr.damien.musicalmanagement.entity;

public class Instrument {

    private int id;
    private String label;

    public Instrument() {
    }

    public Instrument(String label) {
        this.label = label;
    }

    public Instrument(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return getLabel();
    }
}
