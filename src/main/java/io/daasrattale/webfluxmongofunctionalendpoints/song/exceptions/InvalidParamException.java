package io.daasrattale.webfluxmongofunctionalendpoints.song.exceptions;

import lombok.Getter;

@Getter
public class InvalidParamException extends RuntimeException {

    private final String paramName;

    public InvalidParamException(final String paramName) {
        this.paramName = paramName;
    }
}
