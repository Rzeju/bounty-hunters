package com.stw.bountyhunters.services;

import com.stw.bountyhunters.model.EquippedItem;
import com.stw.bountyhunters.repositories.EquippedItemRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EquippedItemServiceImpl implements EquippedItemService {

    private final EquippedItemRepository equippedItemRepository;

    public EquippedItemServiceImpl(EquippedItemRepository equippedItemRepository) {
        this.equippedItemRepository = equippedItemRepository;
    }

    @Override
    public Set<EquippedItem> findAll() {
        Set<EquippedItem> items = new HashSet<>();
        equippedItemRepository.findAll().forEach(items::add);
        return items;
    }

    @Override
    public EquippedItem findById(Long aLong) {
        return equippedItemRepository.findById(aLong).orElse(null);
    }

    @Override
    public EquippedItem save(EquippedItem object) {
        return equippedItemRepository.save(object);
    }

    @Override
    public void delete(EquippedItem object) {
        equippedItemRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        equippedItemRepository.deleteById(aLong);
    }
}
