package org.nutmegsoccer.nutmeg.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "street_number", nullable = false)
    private String streetNumber;
    @Column(name = "street_name_1", nullable = false)
    private String streetName1;
    @Column(name = "street_name_2")
    private String streetName2;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "province", nullable = false)
    private String province;
    @Column(name = "country", nullable = false)
    private String country;

    public Address(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName1() {
        return streetName1;
    }

    public void setStreetName1(String streetName1) {
        this.streetName1 = streetName1;
    }

    public String getStreetName2() {
        return streetName2;
    }

    public void setStreetName2(String streetName2) {
        this.streetName2 = streetName2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
