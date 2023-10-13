package org.themarioga.cclh.commons.exceptions.game;

import org.themarioga.cclh.commons.enums.ErrorEnum;
import org.themarioga.cclh.commons.exceptions.ApplicationException;

public class GameDoesntExistsException extends ApplicationException {

    private final long id;

    public GameDoesntExistsException(long id) {
        super(ErrorEnum.GAME_NOT_FOUND);

        this.id = id;
    }

    public long getID() {
        return id;
    }

}
