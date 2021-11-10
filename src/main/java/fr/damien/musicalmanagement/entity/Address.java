package fr.damien.musicalmanagement.entity;

public class Address {

    private int id;
    private String label;
    private int number;
    private String street;
    private String complement;
    private String region;
    private String country;

    public Address() {
    }

    public Address(String region, String country) {
        this.region = region;
        this.country = country;
    }

    public Address(String label, int number, String street, String complement, String region, String country) {
        this.label = label;
        this.number = number;
        this.street = street;
        this.complement = complement;
        this.region = region;
        this.country = country;
    }

    public Address(int id, String label, int number, String street, String complement, String region, String country) {
        this.id = id;
        this.label = label;
        this.number = number;
        this.street = street;
        this.complement = complement;
        this.region = region;
        this.country = country;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
