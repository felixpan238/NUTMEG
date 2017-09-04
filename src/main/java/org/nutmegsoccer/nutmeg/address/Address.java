package org.nutmegsoccer.nutmeg.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.nutmegsoccer.nutmeg.player.Player;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="address")
public class Address {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Size(max = 10)
    @Column(name = "street_number", nullable = false)
    private String streetNumber;

    @NotNull
    @Size(max = 30)
    @Column(name = "street_name_1", nullable = false)
    private String streetName1;

    @Size(max = 30)
    @Column(name = "street_name_2")
    private String streetName2;

    @Size(max = 30)
    @Column(name = "city", nullable = false)
    private String city;

    @Size(max = 2)
    @Column(name = "province", nullable = false)
    private String province;

    @Size(max = 2)
    @Column(name = "country", nullable = false)
    private String country;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address")
    private Player player;

    public Address(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
