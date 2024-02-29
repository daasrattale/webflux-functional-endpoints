package io.daasrattale.webfluxmongofunctionalendpoints.song.exceptions.handlers;

import io.daasrattale.webfluxmongofunctionalendpoints.song.exceptions.InvalidUUIDException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
@Slf4j
public class SongExceptionHandler {


    @ExceptionHandler(InvalidUUIDException.class)
    public ResponseEntity<Map<String, ?>> handle(final InvalidUUIDException exception) {
        return ResponseEntity
                .badRequest()
                .body(
                        Map.of(
                                "status", 400,
                                "message", "Invalid UUID",
                                "details", exception.getCause().getMessage()
                        )
                );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, ?>> handle(final Exception exception) {
        log.error("Unhandled Error, message: {}", exception.getMessage());
        return ResponseEntity
                .internalServerError()
                .body(
                        Map.of(
                                "status", 500,
                                "message", "Unknown Error",
                                "details", exception.getMessage()
                        )
                );
    }
}
