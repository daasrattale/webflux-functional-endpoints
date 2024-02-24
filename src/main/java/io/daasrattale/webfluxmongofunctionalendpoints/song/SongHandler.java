package io.daasrattale.functionalendpoints.song;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class SongHandler {

    public Mono<ServerResponse> getAllSongs(ServerRequest request) {

        Flux<SongDTO> songsFlux = Flux.just(
                new SongDTO("s1", "a1", new Date()),
                new SongDTO("s2", "a2", new Date()),
                new SongDTO("s3", "a3", new Date())
        );
        return ServerResponse
                .ok()
                .body(songsFlux, SongDTO.class);
    }


    public Mono<ServerResponse> addSong(ServerRequest serverRequest) {
        return ServerResponse
                .ok()
                .bodyValue("Added");
    }
}
