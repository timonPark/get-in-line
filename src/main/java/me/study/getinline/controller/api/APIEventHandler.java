package me.study.getinline.controller.api;

import static org.springframework.web.servlet.function.ServerResponse.created;
import static org.springframework.web.servlet.function.ServerResponse.ok;

import jakarta.servlet.ServletException;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import me.study.getinline.dto.EventRequestDto;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

@Component
public class APIEventHandler {

	public ServerResponse getEvents(final ServerRequest request) {
		return ok().body(List.of("place1", "place2"));
	}

	public ServerResponse getEventDetail(final ServerRequest request) {
		return ok().body("evnetId: " + request.pathVariable("eventId"));
	}

	public ServerResponse createEvent(final ServerRequest request) throws ServletException, IOException {
		return created(URI.create("/api/places/1")).body("eventId event: " + request.body(EventRequestDto.class).getEventId());
	}

	public ServerResponse updateEvents(final ServerRequest request) {
		return ok().body("update eventId: " + request.pathVariable("eventId"));
	}

	public ServerResponse deleteEvents(final ServerRequest request) {
		return ok().body("delete eventId: " + request.pathVariable("eventId"));
	}
}
