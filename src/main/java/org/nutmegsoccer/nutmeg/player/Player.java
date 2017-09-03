package org.nutmegsoccer.nutmeg.player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.nutmegsoccer.nutmeg.address.Address;
import org.nutmegsoccer.nutmeg.phone.Phone;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name="player")
public class Player {
    
	@Id 
    @Column(name = "id", nullable = false)
    private int id;
    
	@Column(name = "first_name", nullable = false)
    private String firstName;
    
	@Column(name = "last_name", nullable = false)
    private String lastName;
    
	@Column(name = "gender", nullable = false)
    private String gender;
    
	@Column(name = "birthday", nullable = false)
    private Date birthday;
    
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="id", cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_id")
	private Phone phone;

    public Player(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}