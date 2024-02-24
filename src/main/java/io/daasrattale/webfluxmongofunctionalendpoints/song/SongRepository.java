package io.daasrattale.webfluxmongofunctionalendpoints.song;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;
@Repository
public interface SongRepository extends ReactiveCrudRepository<Song, UUID> {

    Flux<Song> findAllByArtist(String artist);

}
