package io.daasrattale.functionalendpoints.song;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface SongRepository extends ReactiveCrudRepository<Song, UUID> {
}
