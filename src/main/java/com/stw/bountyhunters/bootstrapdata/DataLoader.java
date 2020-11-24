package com.stw.bountyhunters.bootstrapdata;

import com.stw.bountyhunters.model.BountyHunter;
import com.stw.bountyhunters.model.EquippedItem;
import com.stw.bountyhunters.model.enums.EquipmentSlot;
import com.stw.bountyhunters.repositories.BountyHunterRepository;
import com.stw.bountyhunters.repositories.EquippedItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;

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

    private void loadData() throws Exception {

        BountyHunter hunter1 = BountyHunter.builder().name("Rzeju Hunter").login("Rzeju").password("password")
                .email("pandrzejak93@gmail.com").power(171717L).factor(new BigDecimal(1)).equippedItems(new HashSet<>()).build();

        EquippedItem item1 = EquippedItem.builder().name("Bracers").power(100L).buyPrice(1000L)
                .sellPrice(100L).equipmentSlot(EquipmentSlot.BRACERS).build();

        hunter1.addEquippedItems(item1);

        bountyHunterRepository.save(hunter1);
        equippedItemRepository.save(item1);
    }
}
