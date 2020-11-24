package com.stw.bountyhunters.model;

import com.stw.bountyhunters.model.enums.BountyHunterType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
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

    @Builder
    public BountyHunter(Long id, String name, String login, String password, String email, Long power, BigDecimal factor, BigDecimal money, BountyHunterType bountyHunterType, Set<EquippedItem> equippedItems, Set<OwnedItem> ownedItems, Set<BountyMission> missions) {
        super(id, name);
        this.login = login;
        this.password = password;
        this.email = email;
        this.power = power;
        this.factor = factor;
        this.money = money;
        this.bountyHunterType = bountyHunterType;
        this.equippedItems = equippedItems;
        this.ownedItems = ownedItems;
        this.missions = missions;
    }

    public BountyHunter addEquippedItems(EquippedItem item) {
        item.setBountyHunter(this);
        this.getEquippedItems().add(item);
        return this;
    }





}
