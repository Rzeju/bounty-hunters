package com.stw.bountyhunters.model;

import com.stw.bountyhunters.model.enums.EquipmentSlot;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@MappedSuperclass
public abstract class Item extends NameEntity {

    private Long power;
    private Long buyPrice;
    private Long sellPrice;

    @Enumerated(EnumType.STRING)
    private EquipmentSlot equipmentSlot;

}
