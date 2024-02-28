package io.daasrattale.webfluxmongofunctionalendpoints.song;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Document
@Getter
@Setter
@AllArgsConstructor
public class Song {
    @Id
    private UUID id;
    private String title;
    private String artist;
}
