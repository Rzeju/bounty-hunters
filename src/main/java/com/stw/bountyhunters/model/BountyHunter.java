package com.stw.bountyhunters.model;

import com.stw.bountyhunters.model.enums.BountyHunterType;
import lombok.Getter;
import lombok.Setter;
import org.thymeleaf.util.ArrayUtils;

import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="bounty_hunter")
public class BountyHunter extends NameEntity {

    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="power")
    private Long power;

    @Column(name="factor")
    private BigDecimal factor;

    @Column(name="money")
    private BigDecimal money;

    @Column(name="type")
    @Enumerated(EnumType.STRING)
    private BountyHunterType bountyHunterType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bountyHunter")
    private Set<EquippedItem> equippedItems = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bountyHunter")
    private Set<OwnedItem> ownedItems = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bountyHunter")
    private Set<BountyMission> missions = new HashSet<>();

    public BountyHunter addEquippedItems(EquippedItem item) {
        item.setBountyHunter(this);
        this.getEquippedItems().add(item);
        return this;
    }





}
