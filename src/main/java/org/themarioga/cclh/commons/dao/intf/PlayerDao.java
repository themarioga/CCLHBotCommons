package org.themarioga.cclh.commons.dao.intf;

import org.themarioga.cclh.commons.dao.InterfaceHibernateDao;
import org.themarioga.cclh.commons.models.PlayedCard;
import org.themarioga.cclh.commons.models.Player;
import org.themarioga.cclh.commons.models.VotedCard;
import org.themarioga.cclh.commons.models.User;

public interface PlayerDao extends InterfaceHibernateDao<Player> {

    Player findPlayerByUser(User user);

    PlayedCard findCardByPlayer(Long playerId);

    VotedCard findVotesByPlayer(Long playerId);

}
