package io.daasrattale.functionalendpoints.song;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SongRouterConfig {

    private final SongHandler handler;

    public SongRouterConfig(SongHandler handler) {
        this.handler = handler;
    }


    @Bean
    RouterFunction<ServerResponse> getAllSongs() {

        return route().path("/songs", builder -> builder
                        .GET(handler::getAllSongs)
                        .POST("/new", handler::addSong))
                .build();
    }
}
