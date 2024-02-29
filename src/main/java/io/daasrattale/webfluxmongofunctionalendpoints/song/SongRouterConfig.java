package io.daasrattale.webfluxmongofunctionalendpoints.song;

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
    public RouterFunction<ServerResponse> router() {
        return route().path("/songs", builder -> builder
                .GET("/artist", handler::findAllByArtist)
                .GET(handler::findAll) // Get endpoints' order is important
                .POST("/new", handler::create)
                .DELETE("/{id}", handler::delete)
        ).build();
    }
}
