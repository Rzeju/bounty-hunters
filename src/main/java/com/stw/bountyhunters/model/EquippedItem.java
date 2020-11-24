package com.stw.bountyhunters.model;

import com.stw.bountyhunters.model.enums.EquipmentSlot;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class EquippedItem extends Item {

    @ManyToOne
    @JoinColumn(name = "bounty_hunter_id")
    private BountyHunter bountyHunter;

    @Builder
    public EquippedItem(Long id, String name, Long power, Long buyPrice, Long sellPrice, EquipmentSlot equipmentSlot, BountyHunter bountyHunter) {
        super(id, name, power, buyPrice, sellPrice, equipmentSlot);
        this.bountyHunter = bountyHunter;
    }
}
