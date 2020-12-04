package com.stw.bountyhunters.repositories;

import com.stw.bountyhunters.model.EquippedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquippedItemRepository extends JpaRepository<EquippedItem, Long> {
}
