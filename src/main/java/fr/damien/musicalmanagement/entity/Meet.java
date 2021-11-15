package fr.damien.musicalmanagement.entity;

import java.util.Date;

public class Meet {

    private int id;
    private String label;
    private Date dateStart;
    private Date dateStop;
    private String periodicity;
    private int nbCustomerExpected;
    private int addressId;
    private int userId;

    public Meet() {
    }

    public Meet(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public Meet(String label, Date dateStart, Date dateStop, String periodicity, int nbCustomerExpected, int addressId, int userId) {
        this.label = label;
        this.dateStart = dateStart;
        this.dateStop = dateStop;
        this.periodicity = periodicity;
        this.nbCustomerExpected = nbCustomerExpected;
        this.addressId = addressId;
        this.userId = userId;
    }

    public Meet(int id, String label, Date dateStart, Date dateStop, String periodicity, int nbCustomerExpected, int addressId, int userId) {
        this.id = id;
        this.label = label;
        this.dateStart = dateStart;
        this.dateStop = dateStop;
        this.periodicity = periodicity;
        this.nbCustomerExpected = nbCustomerExpected;
        this.addressId = addressId;
        this.userId = userId;
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

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateStop() {
        return dateStop;
    }

    public void setDateStop(Date dateStop) {
        this.dateStop = dateStop;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public int getNbCustomerExpected() {
        return nbCustomerExpected;
    }

    public void setNbCustomerExpected(int nbCustomerExpected) {
        this.nbCustomerExpected = nbCustomerExpected;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return getLabel();
    }
}
