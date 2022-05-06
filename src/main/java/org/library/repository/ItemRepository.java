package org.library.repository;


import org.library.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer>{
    List<ItemEntity> findByType(final String itemType);
    List<ItemEntity> findByName(final String itemName);
}
