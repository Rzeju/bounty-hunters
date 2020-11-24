package com.stw.bountyhunters.model;

import com.stw.bountyhunters.model.enums.EquipmentSlot;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
public abstract class Item extends NameEntity {

    private Long power;
    private Long buyPrice;
    private Long sellPrice;

    @Enumerated(EnumType.STRING)
    private EquipmentSlot equipmentSlot;

    public Item(Long id, String name, Long power, Long buyPrice, Long sellPrice, EquipmentSlot equipmentSlot) {
        super(id, name);
        this.power = power;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.equipmentSlot = equipmentSlot;
    }
}
