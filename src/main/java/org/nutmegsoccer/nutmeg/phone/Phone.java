package org.nutmegsoccer.nutmeg.phone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Phone {

    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "phone_number", nullable = false)
    private int phoneNumber;
    @Column(name = "phone_type", nullable = false)
    private String phoneType;

    public Phone(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }
}
