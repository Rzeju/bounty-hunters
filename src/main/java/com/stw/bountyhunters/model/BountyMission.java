package com.stw.bountyhunters.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class BountyMission extends NameEntity {

    @ManyToOne
    @JoinColumn(name = "bounty_hunter_id")
    public  BountyHunter bountyHunter;

    @OneToOne
    @JoinColumn(name = "bounty_target_id")
    public BountyTarget bountyTarget;

    @Builder
    public BountyMission(Long id, String name, BountyHunter bountyHunter, BountyTarget bountyTarget) {
        super(id, name);
        this.bountyHunter = bountyHunter;
        this.bountyTarget = bountyTarget;
    }
}
