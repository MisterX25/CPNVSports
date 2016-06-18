package Entities;

import java.util.GregorianCalendar;

/**
 * Created by Xavier on 17.06.16.
 */
public class Coach extends Person {

    private String licenseNumber;
    private GregorianCalendar expirationDate;

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public GregorianCalendar getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(GregorianCalendar expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Constructor
     *
     * @param firstname
     * @param lastname
     */
    public Coach(String firstname, String lastname) {
        super(firstname, lastname);
    }
}
