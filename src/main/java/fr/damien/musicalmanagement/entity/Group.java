package fr.damien.musicalmanagement.entity;

public class Group {

    private int id;
    private String label;
    private String characteristic;

    public Group() {
    }

    public Group(String label, String characteristic) {
        this.label = label;
        this.characteristic = characteristic;
    }

    public Group(int id, String label, String characteristic) {
        this.id = id;
        this.label = label;
        this.characteristic = characteristic;
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

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }
}
