package org.library.service;

import org.library.entity.ItemEntity;
import org.library.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    private static final Logger logger = LoggerFactory.getLogger(ItemService.class);

    @Autowired
    private ItemRepository itemRepository;

    public List<ItemEntity> getAllItems(){
        List<ItemEntity> items = new ArrayList<>();
        try {
            items = itemRepository.findAll();
        } catch (NullPointerException exception) {
            logger.error("Unable to retrieve entries from items table");
        }
        logger.info("Found {} entries, when retrieving all items from database", (long) items.size());
        return items;
    }

    public List<ItemEntity> findByItemType(final String itemType){
        List<ItemEntity> items = new ArrayList<>();
        try {
            items = itemRepository.findByType(itemType);
        } catch (NullPointerException exception) {
            logger.error("Unable to retrieve entries from items table");
        }
        logger.info("Found {} entries, when find by item type of {}", (long) items.size(), itemType);
        return items;
    }

    public List<ItemEntity> findByItemName(final String itemName){
        List<ItemEntity> items = new ArrayList<>();
        try {
            items = itemRepository.findByName(itemName);
        } catch (NullPointerException exception) {
            logger.error("Unable to retrieve entries from items table");
        }
        logger.info("Look up of item by name {}", itemName);
        return items;
    }
}
