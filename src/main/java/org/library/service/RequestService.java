package org.library.service;

import org.library.repository.RequestedRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RequestService {
    private static final Logger logger = LoggerFactory.getLogger(RequestService.class);

    @Autowired
    private RequestedRepository requestedRepository;

    @Transactional
    public void insertRequest(final String itemName, final String itemType, final String requestReason){
        requestedRepository.insertItemRequest(itemName, itemType, requestReason);
        logger.info("Successfully insert request with itemName {}, itemType {} with requestReason {}",
                itemName, itemType, requestReason);
    }

}
