package org.library.repository;

import org.library.entity.BorrowedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowedRepository extends JpaRepository<BorrowedEntity, Integer> {

    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM borrowed WHERE ITEM_ID=:item_id", nativeQuery = true)
    void removeReturnedItem(@Param("item_id") final Integer itemId);
}
