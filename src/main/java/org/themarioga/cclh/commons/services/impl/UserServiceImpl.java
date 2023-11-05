package org.themarioga.cclh.commons.services.impl;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.themarioga.cclh.commons.dao.intf.UserDao;
import org.themarioga.cclh.commons.enums.ErrorEnum;
import org.themarioga.cclh.commons.exceptions.ApplicationException;
import org.themarioga.cclh.commons.exceptions.user.UserAlreadyExistsException;
import org.themarioga.cclh.commons.exceptions.user.UserDoesntExistsException;
import org.themarioga.cclh.commons.exceptions.user.UserNotActiveException;
import org.themarioga.cclh.commons.models.User;
import org.themarioga.cclh.commons.services.intf.UserService;
import org.themarioga.cclh.commons.util.Assert;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED, rollbackOn = ApplicationException.class)
    public User createOrReactivate(long id, String name) {
        logger.debug("Creating or reactivating user: {} ({})", id, name);

        Assert.assertNotNull(id, ErrorEnum.USER_ID_EMPTY);
        Assert.assertNotEmpty(name, ErrorEnum.USER_NAME_EMPTY);

        User userFromBd = userDao.findOne(id);
        if (userFromBd == null) {
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setActive(true);
            user.setCreationDate(new Date());
            return userDao.create(user);
        } else {
            if (Boolean.FALSE.equals(userFromBd.getActive())) {
                userFromBd.setName(name);
                userFromBd.setActive(true);
                return userDao.update(userFromBd);
            } else {
                logger.error("Error trying to create user {} ({}): Already exists", id, name);
                throw new UserAlreadyExistsException(id);
            }
        }
    }

    @Override
    @Transactional(value = Transactional.TxType.SUPPORTS, rollbackOn = ApplicationException.class)
    public User getById(long id) {
        logger.debug("Getting user with ID: {}", id);

        User user = userDao.findOne(id);
        if (user == null) {
            logger.error("Error getting user with id {}: Doesn't exists.", id);
            throw new UserDoesntExistsException(id);
        }
        if (Boolean.FALSE.equals(user.getActive())) {
            logger.error("Error getting user with id {}: Not active.", id);
            throw new UserNotActiveException(id);
        }

        return user;
    }

}
