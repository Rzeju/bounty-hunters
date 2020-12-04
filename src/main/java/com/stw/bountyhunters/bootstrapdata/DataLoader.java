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
                .email("pandrzejak93@gmail.com").power(171717L).factor(new BigDecimal(1)).build();

        BountyHunter hunter2 = BountyHunter.builder().name("Hunter 2").login("hunter_2").password("password_2")
                .email("hunter2@gmail.com").power(2000L).factor(new BigDecimal(1)).build();

        BountyHunter hunter3 = BountyHunter.builder().name("Hunter 3").login("hunter_3").password("password_3")
                .email("hunter3@gmail.com").power(3000L).factor(new BigDecimal(1)).build();

        EquippedItem item1 = EquippedItem.builder().name("Bracers").power(100L).buyPrice(1000L)
                .sellPrice(100L).equipmentSlot(EquipmentSlot.BRACERS).build();

        hunter1.addEquippedItems(item1);

        bountyHunterRepository.save(hunter1);
        bountyHunterRepository.save(hunter2);
        bountyHunterRepository.save(hunter3);
    }
}
