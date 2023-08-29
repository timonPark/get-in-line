package me.study.getinline.controller.api;

import me.study.getinline.dto.PlaceRequestDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/places")
@RestController()
public class APIPlaceController {

	@GetMapping("")
	public String places(){
		return "done";
	}

	@GetMapping("/{placeId}")
	public String placeDetail(@PathVariable Integer placeId){
		return "placeId: " + placeId;
	}

	@PostMapping("")
	public String createPlace(@RequestBody PlaceRequestDto placeRequestDto) {
		return "creat placeId: " + placeRequestDto.getPlaceId();
	}

	@PutMapping("/{placeId}")
	public String updatePlace(@PathVariable Integer placeId, @RequestBody PlaceRequestDto placeRequestDto) {
		return "update placeId: " + placeId;
	}

	@DeleteMapping("/{placeId}")
	public String deletePlace(@PathVariable Integer placeId) {
		return "delete placeId: " + placeId;
	}
}
