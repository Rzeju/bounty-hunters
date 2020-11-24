package com.stw.bountyhunters.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Setter
@Getter
@MappedSuperclass
@NoArgsConstructor
public abstract class NameEntity extends BaseEntity {

    private String name;

    public NameEntity(Long id, String name) {
        super(id);
        this.name = name;
    }
}
