package me.study.getinline.controller.api;

import me.study.getinline.dto.EventRequestDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RequestMapping("/api/events")
//@RestController()
public class APIEventController {

	@GetMapping("")
	public String events() {
		return "done";
	}

	@GetMapping("/{eventId}")
	public String eventDetail(@PathVariable Integer eventId) {
		return "evnetId: " + eventId;
	}

	@PostMapping()
	public String createEvent(@RequestBody EventRequestDto eventRequestDto) {
		return "create eventId: " + eventRequestDto.getEventId();
	}

	@PutMapping("/{eventId}")
	public String updateEvent(@PathVariable Integer eventId, @RequestBody EventRequestDto eventRequestDto) {
		return "update eventId: " + eventId;
	}

	@DeleteMapping("/{eventId}")
	public String deleteEvent(@PathVariable Integer eventId) {
		return "delete eventId: " + eventId;
	}
}
