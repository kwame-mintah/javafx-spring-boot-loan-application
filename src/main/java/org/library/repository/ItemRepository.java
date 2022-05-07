package org.library.repository;


import org.library.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer>{
    List<ItemEntity> findByType(final String itemType);
    List<ItemEntity> findByName(final String itemName);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE items SET available_count = items.available_count - ABS(1), on_loan = items.on_loan + ABS(1)" +
            " WHERE NAME=?1", nativeQuery = true)
    void deductAvailableCount(@Param("itemName") final String itemName);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE items SET available_count = items.available_count + ABS(1), on_loan = items.on_loan - ABS(1)" +
            " WHERE NAME=:itemName", nativeQuery = true)
    void returnItem(@Param("itemName") final String itemName);

    @Modifying(clearAutomatically = true)
    @Query(value = "INSERT INTO public.borrowed (item_id) VALUES(:itemId)", nativeQuery = true)
    void insertIntoBorrowed(@Param("itemId") final Integer itemId);
}
