package com.stw.bountyhunters.model;

import com.stw.bountyhunters.model.enums.BountyHunterType;
import lombok.Getter;
import lombok.Setter;
import org.thymeleaf.util.ArrayUtils;

import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table("bounty_hunetrs")
public class BountyHunter extends NameEntity {

    @Column("login")
    private String login;

    @Column("password")
    private String password;

    @Column("email")
    private String email;

    @Column("power")
    private Long power;

    @Column("factor")
    private BigDecimal factor;

    @Column("money")
    private BigDecimal money;

    @Column("image")
    private Byte[] image;

    @Column("type")
    @Enumerated(EnumType.STRING)
    private BountyHunterType bountyHunterType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bountyHunter")
    private Set<EquippedItem> equippedItems = new HashSet<>();

    public BountyHunter addEquippedItems(EquippedItem item) {
        item.setBountyHunter(this);
        this.getEquippedItems().add(item);
        return this;
    }

    public Byte[] addImage(String path) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(path));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "jpg", bos);
        byte[] data = bos.toByteArray();
        Byte[] result = new Byte[data.length];
        int i = 0;
        for(byte b : data) {
            result[i] = b;
            i++;
        }
        this.setImage(result);
        return result;
    }



}
