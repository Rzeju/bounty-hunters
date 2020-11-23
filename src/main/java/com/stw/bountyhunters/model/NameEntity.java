package com.stw.bountyhunters.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Setter
@Getter
@MappedSuperclass
public abstract class NameEntity extends BaseEntity {

    private String name;

}
