package com.stw.bountyhunters.model;

import com.stw.bountyhunters.model.enums.BountyTargetType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class BountyTarget extends NameEntity {

    private BigDecimal bounty;
    private BountyTargetType bountyTargetType;

}
