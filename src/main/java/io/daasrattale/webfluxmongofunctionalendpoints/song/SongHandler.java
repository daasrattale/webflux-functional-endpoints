package io.daasrattale.webfluxmongofunctionalendpoints.song;


import io.daasrattale.webfluxmongofunctionalendpoints.song.exceptions.InvalidParamException;
import io.daasrattale.webfluxmongofunctionalendpoints.song.exceptions.InvalidUUIDException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class SongHandler {

    private final SongRepository repository;

    public SongHandler(SongRepository repository) {
        this.repository = repository;
    }

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse
                .ok()
                .body(repository.findAll(), Song.class);
    }

    public Mono<ServerResponse> findAllByArtist(ServerRequest request) {


        return Mono.just(request.queryParam("artist"))
                .doOnNext(System.out::println)
                .map(s -> repository.findAllByArtist(s.orElseThrow(() -> new InvalidParamException("artist"))))
                .flatMap(songFlux -> ServerResponse
                        .ok()
                        .body(songFlux, Song.class));
    }

    public Mono<ServerResponse> create(ServerRequest request) {
       return request.bodyToMono(Song.class)
               .switchIfEmpty(Mono.error(new RuntimeException("Song body not found")))
               .doOnNext(song -> song.setId(UUID.randomUUID()))
               .flatMap(song -> ServerResponse
                       .ok()
                       .body(repository.save(song), Song.class)
               );
    }

    public Mono<ServerResponse> delete(ServerRequest request) {
        return Mono.just(request.pathVariable("id"))
                .map(UUID::fromString)
                .doOnError(throwable -> {
                    throw new InvalidUUIDException(throwable);
                })
                .flatMap(songId -> ServerResponse
                        .ok()
                        .body(repository.deleteById(songId), Void.class)
                );
    }


}
