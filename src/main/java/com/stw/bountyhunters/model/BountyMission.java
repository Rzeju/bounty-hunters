package com.stw.bountyhunters.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
public class BountyMission extends NameEntity {

    @ManyToOne
    @JoinColumn(name = "bounty_hunter_id")
    public final BountyHunter bountyHunter;

    @OneToOne
    public final BountyTarget bountyTarget;




}
