package org.themarioga.cclh.commons.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@jakarta.persistence.Table(name = "t_player_hand")
public class PlayerHandCard implements Serializable {

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;
    @Id
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private Card card;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerHandCard that = (PlayerHandCard) o;
        return Objects.equals(player, that.player) && Objects.equals(card, that.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, card);
    }

}
