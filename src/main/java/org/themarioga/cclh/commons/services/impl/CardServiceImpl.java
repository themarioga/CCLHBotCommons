package org.themarioga.cclh.commons.services.impl;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.themarioga.cclh.commons.dao.intf.CardDao;
import org.themarioga.cclh.commons.enums.CardTypeEnum;
import org.themarioga.cclh.commons.exceptions.ApplicationException;
import org.themarioga.cclh.commons.models.*;
import org.themarioga.cclh.commons.services.intf.CardService;

import java.util.Date;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    private final Logger logger = LoggerFactory.getLogger(CardServiceImpl.class);

    private final CardDao cardDao;

    @Autowired
    public CardServiceImpl(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED, rollbackOn = ApplicationException.class)
    public Card create(Card card) {
        logger.debug("Creating card: {}", card);

        card.setCreationDate(new Date());
        return cardDao.create(card);
    }

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED, rollbackOn = ApplicationException.class)
    public Card update(Card card) {
        logger.debug("Updating card: {}", card);

        return cardDao.update(card);
    }

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED, rollbackOn = ApplicationException.class)
    public void delete(Card card) {
        logger.debug("Delete card: {}", card);

        cardDao.delete(card);
    }

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED, rollbackOn = ApplicationException.class)
    public void deleteById(long id) {
        logger.debug("Delete card by ID: {}", id);

        cardDao.deleteById(id);
    }


    @Override
    @Transactional(value = Transactional.TxType.SUPPORTS, rollbackOn = ApplicationException.class)
    public Card findOne(long id) {
        logger.debug("Getting card with ID: {}", id);

        return cardDao.findOne(id);
    }

    @Override
    @Transactional(value = Transactional.TxType.SUPPORTS, rollbackOn = ApplicationException.class)
    public List<Card> findCardsByDictionaryIdAndType(Dictionary dictionary, CardTypeEnum cardTypeEnum) {
        logger.debug("Getting cards by dictionary {} and type {}", dictionary, cardTypeEnum);

        return cardDao.findCardsByDictionaryIdAndType(dictionary, cardTypeEnum);
    }

    @Override
    @Transactional(value = Transactional.TxType.SUPPORTS, rollbackOn = ApplicationException.class)
    public long countCardsByDictionaryIdAndType(Dictionary dictionary, CardTypeEnum cardTypeEnum) {
        logger.debug("Counting cards by dictionary {} and type {}", dictionary, cardTypeEnum);

        return cardDao.countCardsByDictionaryIdAndType(dictionary, cardTypeEnum);
    }

}
