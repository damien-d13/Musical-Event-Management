package fr.damien.musicalmanagement.entity;

public class Localise {

    private int userId;
    private int addressId;

    public Localise() {
    }

    public Localise(int addressId) {
        this.addressId = addressId;
    }

    public Localise(int userId, int addressId) {
        this.userId = userId;
        this.addressId = addressId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }


}
