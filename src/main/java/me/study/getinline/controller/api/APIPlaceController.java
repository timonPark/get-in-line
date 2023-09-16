package me.study.getinline.controller.api;

import java.util.List;
import me.study.getinline.constant.ErrorCode;
import me.study.getinline.constant.PlaceType;
import me.study.getinline.dto.APIDataResponse;
import me.study.getinline.dto.PlaceRequestDto;
import me.study.getinline.dto.PlaceResponseDto;
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
	public APIDataResponse<List<PlaceResponseDto>> places(){
		return APIDataResponse.of(
				List.of(PlaceResponseDto.builder()
						.placeType(PlaceType.COMMON.name())
						.placeName("랄라베드민턴장")
						.address("서울시 강남구 강남대로 1234")
						.phoneNumber("010-1234-5678")
						.capacity(30)
						.memo("신장개업")
						.build()));
	}

	@GetMapping("/{placeId}")
	public APIDataResponse<PlaceResponseDto> placeDetail(@PathVariable Integer placeId){
		return
				APIDataResponse.of(
						placeId == 1 ?
								PlaceResponseDto.builder()
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
