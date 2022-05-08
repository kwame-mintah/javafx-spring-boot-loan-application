package org.library.repository;

import org.library.entity.RequestedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestedRepository extends JpaRepository<RequestedEntity, Integer> {

    @Modifying(clearAutomatically = true)
    @Query(value = "INSERT INTO public.requested(item_name, item_type, request_reason) " +
            "VALUES (:itemName, :itemType, :requestReason)", nativeQuery = true)
    void insertItemRequest(@Param("itemName") final String itemName,
                           @Param("itemType") final String itemType,
                           @Param("requestReason") final String requestReason);
}
