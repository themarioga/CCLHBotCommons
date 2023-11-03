package org.themarioga.cclh.commons.enums;

public enum ErrorEnum {
    USER_EMPTY(1L, "El usuario no puede ser nulo"),
    USER_ID_EMPTY(2L, "El id de usuario no puede ser nulo"),
    USER_NAME_EMPTY(3L, "El nombre de usuario no puede estar vacío"),
    USER_NOT_FOUND(4L, "El usuario no se ha encontrado"),
    USER_NOT_ACTIVE(5L, "El usuario no está activo"),
    USER_ALREADY_EXISTS(6L, "El usuario ya existe"),
    ROOM_EMPTY(7L, "La sala no puede ser nula"),
    ROOM_ID_EMPTY(8L, "El id de la sala no puede ser nulo"),
    ROOM_NAME_EMPTY(9L, "El nombre de la sala no puede estar vacía"),
    ROOM_NOT_FOUND(10L, "La sala no se ha encontrado"),
    ROOM_NOT_ACTIVE(11L, "La sala no está activa"),
    ROOM_ALREADY_EXISTS(12L, "La sala ya existe"),
    GAME_NOT_FOUND(13L, "Juego no encontrado"),
    GAME_NOT_CONFIGURED(14L, "Juego no configurado"),
    GAME_NOT_FILLED(15L, "Juego no completado"),
    GAME_ALREADY_EXISTS(16L, "Juego ya configurado"),
    GAME_ALREADY_CONFIGURED(17L, "Juego ya configurado"),
    GAME_ALREADY_FILLED(18L, "Juego lleno"),
    GAME_ALREADY_STARTED(19L, "Juego ya iniciado"),
    CARD_NOT_FOUND(20L, "Carta no encontrada"),
    CARD_ALREADY_EXISTS(21L, "Carta ya existente"),
    CARD_ALREADY_USED(22L, "Carta ya usada"),
    CARD_TEXT_TOO_LONG(23L, "Texto de la carta demasiado largo"),
    DICTIONARY_NOT_FOUND(24L, "Diccionario no encontrado"),
    DICTIONARY_NOT_FILLED(25L, "Diccionario no completado"),
    DICTIONARY_ALREADY_EXISTS(26L, "Diccionario ya existe"),
    DICTIONARY_ALREADY_FILLED(27L, "Diccionario ya completado"),
    PLAYER_NOT_FOUND(28L, "Jugador no encontrado"),
    PLAYER_ALREADY_EXISTS(29L, "Jugador ya existente"),
    PLAYER_ALREADY_VOTED(30L, "El jugador ya ha votado");

    final Long errorCode;
    final String errorDesc;

    ErrorEnum(Long errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    public Long getErrorCode() {
        return errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public static ErrorEnum getByCode(Long errorCode) {
        for (ErrorEnum errorEnum : values()) {
            if (errorEnum.getErrorCode().equals(errorCode)) return errorEnum;
        }

        return null;
    }

    public static ErrorEnum getByDesc(String errorDesc) {
        for (ErrorEnum errorEnum : values()) {
            if (errorEnum.getErrorDesc().equals(errorDesc)) return errorEnum;
        }

        return null;
    }

}