package me.study.getinline.controller.api;

import java.util.List;
import me.study.getinline.constant.PlaceType;
import me.study.getinline.dto.APIDataResponse;
import me.study.getinline.dto.PlaceDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/places")
@RestController()
public class APIPlaceController {

	@GetMapping("")
	public APIDataResponse<List<PlaceDto>> places(){
		return APIDataResponse.of(
				List.of(PlaceDto.builder()
						.placeType(PlaceType.COMMON.name())
						.placeName("랄라베드민턴장")
						.address("서울시 강남구 강남대로 1234")
						.phoneNumber("010-1234-5678")
						.capacity(30)
						.memo("신장개업")
						.build()));
	}

	@GetMapping("/{placeId}")
	public APIDataResponse<PlaceDto> placeDetail(@PathVariable Integer placeId){
		return
				APIDataResponse.of(
						placeId == 1 ?
								PlaceDto.builder()
									.placeType(PlaceType.COMMON.name())
									.placeName("랄라베드민턴장")
									.address("서울시 강남구 강남대로 1234")
									.phoneNumber("010-1234-5678")
									.capacity(30)
									.memo("신장개업")
								.build() :
								null
				);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public APIDataResponse<PlaceDto> createPlace(@RequestBody PlaceDto placeDto) {
		return APIDataResponse.of(placeDto);
	}

	@PutMapping("/{placeId}")
	public String updatePlace(@PathVariable Integer placeId, @RequestBody PlaceDto placeDto) {
		return "update placeId: " + placeId;
	}

	@DeleteMapping("/{placeId}")
	public String deletePlace(@PathVariable Integer placeId) {
		return "delete placeId: " + placeId;
	}
}
