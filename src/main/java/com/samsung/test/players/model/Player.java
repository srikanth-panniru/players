package com.samsung.test.players.model;

import com.samsung.test.players.request.PlayerRequest;
import com.samsung.test.players.util.DateUtil;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "players")
public class Player {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "players_id", sequenceName = "players_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "players_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dob")
    private Date dob;

    @Enumerated(EnumType.STRING)
    @Column(name = "player_type")
    private PlayerType playerType;

    @Column(name = "jersey_number")
    private Integer jerseyNumber;

    @Column(name = "created_at")
    private final Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public Player() {
        this.createdAt = DateUtil.getCurrentTime();
    }

    public Player(PlayerRequest playerRequest) {
        this();
        this.updateAttributes(playerRequest);
    }

    public Player update(PlayerRequest playerRequest) {
        this.updateAttributes(playerRequest);
        this.updatedAt = DateUtil.getCurrentTime();
        return this;
    }

    private void updateAttributes(PlayerRequest playerRequest) {
        this.firstName = playerRequest.getFirstName();
        this.lastName = playerRequest.getLastName();
        this.dob = playerRequest.getDob();
        this.jerseyNumber = playerRequest.getJerseyNumber();
        this.playerType = playerRequest.getPlayerType();
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(Integer jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
