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

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "sddress")
    private Player player

    public Address(){

    }

}
