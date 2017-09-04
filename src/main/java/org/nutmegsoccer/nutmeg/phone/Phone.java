package org.nutmegsoccer.nutmeg.phone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.nutmegsoccer.nutmeg.player.Player;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="phone")
public class Phone {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "phone_number", nullable = false)
    private int phoneNumber;

    @Size(max = 10)
    @Column(name = "phone_type", nullable = false)
    private String phoneType;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "player_id", updatable = false, insertable = false)
    private Player player;

    public Phone(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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