package io.daasrattale.webfluxmongofunctionalendpoints.song.exceptions;

import lombok.Getter;

@Getter
public class InvalidUUIDException extends RuntimeException {

    private final Throwable cause;

    public InvalidUUIDException(final Throwable cause) {
        this.cause = cause;
    }
}
