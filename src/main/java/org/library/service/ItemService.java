package org.library.service;

import org.library.entity.BorrowedEntity;
import org.library.entity.ItemEntity;
import org.library.repository.BorrowedRepository;
import org.library.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private static final Logger logger = LoggerFactory.getLogger(ItemService.class);

    static final String ERROR_LOGGER_MESSAGE = "Unable to retrieve entries from items table";

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private BorrowedRepository borrowedRepository;

    /**
     * Query all entries in items table.
     *
     * @return {@link org.library.dto.ItemDto}
     */
    public List<ItemEntity> getAllItems(){
        List<ItemEntity> items = new ArrayList<>();
        try {
            items = itemRepository.findAll();
        } catch (NullPointerException exception) {
            logger.error(ERROR_LOGGER_MESSAGE);
        }
        logger.info("Found {} entries, when retrieving all items from items table", (long) items.size());
        return items;
    }

    /**
     * Query all entries in Borrowed table.
     *
     * @return {@link org.library.dto.ItemDto}
     */
    public List<BorrowedEntity> getAllBorrowedItems(){
        List<BorrowedEntity> items = new ArrayList<>();
        try {
            items = borrowedRepository.findAll();
        } catch (NullPointerException exception) {
            logger.error(ERROR_LOGGER_MESSAGE);
        }
        logger.info("Found {} entries, when retrieving all items from borrowed table", (long) items.size());
        return items;
    }

    /**
     * Query all entries in items table by type.
     *
     * @return {@link org.library.dto.ItemDto}
     */
    public List<ItemEntity> findByItemType(final String itemType){
        List<ItemEntity> items = new ArrayList<>();
        try {
            items = itemRepository.findByType(itemType);
        } catch (NullPointerException exception) {
            logger.error(ERROR_LOGGER_MESSAGE);
        }
        logger.info("Found {} entries, when finding by item type of {}", (long) items.size(), itemType);
        return items;
    }

    /**
     * Query items table by item name
     *
     * @param itemName item name
     * @return {@link org.library.dto.ItemDto}
     */
    public List<ItemEntity> findByItemName(final String itemName){
        List<ItemEntity> items = new ArrayList<>();
        try {
            items = itemRepository.findByName(itemName);
        } catch (NullPointerException exception) {
            logger.error(ERROR_LOGGER_MESSAGE);
        }
        logger.info("Found {} entries with name {}", items.size(), itemName);
        return items;
    }

    /**
     * Query items table by itemId
     *
     * @param itemId item name
     * @return {@link org.library.dto.ItemDto}
     */
    public Optional<ItemEntity> findById(final Integer itemId){
        Optional<ItemEntity> items = Optional.empty();
        try {
            items = itemRepository.findById(itemId);
        } catch (NullPointerException exception) {
            logger.error(ERROR_LOGGER_MESSAGE);
        }
        return items;
    }


    /**
     * Update query that changes the items' availability count by 1
     * and increase onLoan count by 1
     *
     * @param itemName item name
     * @param itemId id
     */
    @Transactional
    public void deductAvailableCount(final String itemName, final Integer itemId){
       itemRepository.deductAvailableCount(itemName);
       logger.info("Successfully updated {} availability count", itemName);
       itemRepository.insertIntoBorrowed(itemId);
       logger.info("Successfully inserted item {} into borrowed table", itemId);
    }

    /**
     * Update query that increases the items' availability by 1
     * and decreases onLoan count by 1
     *
     * @param itemName item name
     */
    @Transactional
    public void returnItem(final String itemName){
        itemRepository.returnItem(itemName);
        List<ItemEntity> item = itemRepository.findByName(itemName);
        logger.info("Successfully updated {} availability count", itemName);
        borrowedRepository.removeReturnedItem(item.get(0).getId());
        logger.info("Successfully removed entry with itemId {} from borrowed table", item.get(0).getId());
    }
}
