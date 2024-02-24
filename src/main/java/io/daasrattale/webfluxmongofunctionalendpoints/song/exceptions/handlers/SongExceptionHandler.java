package io.daasrattale.webfluxmongofunctionalendpoints.song.exceptions.handlers;

import io.daasrattale.webfluxmongofunctionalendpoints.song.exceptions.InvalidUUIDException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;
import java.util.Objects;

@ControllerAdvice
public class SongExceptionHandler {

    @ExceptionHandler(InvalidUUIDException.class)
    public ResponseEntity<Map<String, Object>> handle (InvalidUUIDException exception){
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
}
