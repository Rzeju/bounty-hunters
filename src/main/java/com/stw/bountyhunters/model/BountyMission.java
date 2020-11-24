package com.stw.bountyhunters.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class BountyMission extends NameEntity {

    @ManyToOne
    @JoinColumn(name = "bounty_hunter_id")
    public  BountyHunter bountyHunter;

    @OneToOne
    public BountyTarget bountyTarget;

    @Builder
    public BountyMission(Long id, String name, BountyHunter bountyHunter, BountyTarget bountyTarget) {
        super(id, name);
        this.bountyHunter = bountyHunter;
        this.bountyTarget = bountyTarget;
    }
}
