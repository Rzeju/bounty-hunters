package com.stw.bountyhunters.model;

import com.stw.bountyhunters.model.enums.BountyTargetType;
import lombok.*;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BountyTarget extends NameEntity {

    private BigDecimal bounty;
    private BountyTargetType bountyTargetType;

    @Builder
    public BountyTarget(Long id, String name, BigDecimal bounty, BountyTargetType bountyTargetType) {
        super(id, name);
        this.bounty = bounty;
        this.bountyTargetType = bountyTargetType;
    }
}
