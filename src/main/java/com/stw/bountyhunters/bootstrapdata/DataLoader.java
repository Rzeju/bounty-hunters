package com.stw.bountyhunters.bootstrapdata;

import com.stw.bountyhunters.model.BountyHunter;
import com.stw.bountyhunters.model.EquippedItem;
import com.stw.bountyhunters.model.enums.EquipmentSlot;
import com.stw.bountyhunters.repositories.BountyHunterRepository;
import com.stw.bountyhunters.repositories.EquippedItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataLoader implements CommandLineRunner {

    private final BountyHunterRepository bountyHunterRepository;
    private final EquippedItemRepository equippedItemRepository;

    public DataLoader(BountyHunterRepository bountyHunterRepository, EquippedItemRepository equippedItemRepository) {
        this.bountyHunterRepository = bountyHunterRepository;
        this.equippedItemRepository = equippedItemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {

        BountyHunter hunter1 = new BountyHunter();
        hunter1.setName("Rzeju Hunter");
        hunter1.setLogin("Rzeju");
        hunter1.setPassword("Rzeju007");
        hunter1.setEmail("pandrzejak93@gmail.com");
        hunter1.setPower(171717L);
        hunter1.setFactor(new BigDecimal(1));

        EquippedItem item1 = new EquippedItem();
        item1.setName("Bracers");
        item1.setPower(100L);
        item1.setBuyPrice(1000L);
        item1.setSellPrice(100L);
        item1.setEquipmentSlot(EquipmentSlot.BRACERS);

        hunter1.addEquippedItems(item1);

        bountyHunterRepository.save(hunter1);
        equippedItemRepository.save(item1);
    }
}
