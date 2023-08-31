package me.study.getinline.controller.api;

import java.util.List;
import me.study.getinline.dto.PlaceRequestDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RouterFunctions.route;
import static org.springframework.web.servlet.function.RequestPredicates.path;

@Configuration
public class APIPlaceRouter {

	@Bean
	public RouterFunction<ServerResponse> placeRouter() {
		return route().nest(path("/api/places"), builder -> builder
						.GET("", req -> ServerResponse.ok().body(List.of("place", "place2")))
						.GET("/{placeId}", req -> ServerResponse.ok().body("placeId: " + req.pathVariable("placeId")))
						.POST("", req -> ServerResponse.ok().body("creat placeId: " + req.body(PlaceRequestDto.class).getPlaceId()))
						.PUT("/{placeId}", req -> ServerResponse.ok().body("update placeId: " + req.pathVariable("placeId")))
						.DELETE("/{placeId}", req -> ServerResponse.ok().body("delete placeId: " + req.pathVariable("placeId")))
				).build();
	}

}
