package com.stw.bountyhunters.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class OwnedItem extends Item {

    @ManyToOne
    @JoinColumn(name = "bounty_hunter_id")
    private BountyHunter bountyHunter;

}
