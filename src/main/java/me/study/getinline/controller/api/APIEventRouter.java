package me.study.getinline.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RequestPredicates.path;
import static org.springframework.web.servlet.function.RouterFunctions.route;

@Configuration
public class APIEventRouter {

	@Autowired
	private APIEventHandler apiEventHandler;

	@Bean
	public RouterFunction<ServerResponse> eventRouter() {
		return route().nest(path("/api/events"), builder -> builder
				.GET("", apiEventHandler::getEvents)
				.GET("/{eventId}", apiEventHandler::getEventDetail)
				.POST("", apiEventHandler::createEvent)
				.PUT("/{eventId}", apiEventHandler::updateEvents)
				.DELETE("/{eventId}", apiEventHandler::deleteEvents)
		).build();
	}

}
