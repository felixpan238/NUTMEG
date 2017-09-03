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

    @NotNull
    @Column(name = "phone_number", nullable = false)
    private int phoneNumber;

    @Size(max = 10)
    @Column(name = "phone_type", nullable = false)
    private String phoneType;

    @ManyToOne
    @JoinColumn(name = "player_id", updatable = false, insertable = false)
    private Player player;

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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}