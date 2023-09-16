package me.study.getinline.controller.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import me.study.getinline.constant.ErrorCode;
import me.study.getinline.constant.PlaceType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(APIPlaceController.class)
class APIPlaceControllerTest {

	private final MockMvc mvc;

	public APIPlaceControllerTest(@Autowired MockMvc mvc) {
		this.mvc = mvc;
	}

	@DisplayName("[API][GET] 장소 리스트 조회")
	@Test
	void giveNothing_whenRequestingPlaces_thenReturnsListOfPlacesInStandardResponse() throws Exception {
		// given


		// when & then
		// https://github.com/json-path/JsonPath 참고
		mvc.perform(get("/api/places"))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.data").isArray())
				.andExpect(jsonPath("$.data[0].placeType").value(PlaceType.COMMON.name()))
				.andExpect(jsonPath("$.data[0].placeName").value("랄라베드민턴장"))
				.andExpect(jsonPath("$.data[0].address").value("서울시 강남구 강남대로 1234"))
				.andExpect(jsonPath("$.data[0].phoneNumber").value("010-1234-5678"))
				.andExpect(jsonPath("$.data[0].capacity").value(30))
				.andExpect(jsonPath("$.data[0].memo").value("신장개업"))
				.andExpect(jsonPath("$.success").value(true))
				.andExpect(jsonPath("$.errorCode").value(ErrorCode.OK.getCode()))
				.andExpect(jsonPath("$.message").value(ErrorCode.OK.getMessage()));
	}

	@DisplayName("[API][GET] 단일 장소 조회 - 장소 있는 경우")
	@Test
	void givenPlaceAndItsId_whenRequestingPlace_thenReturnPlaceInStandardResponse() throws Exception {
		// given
		int placeId = 1;

		// when & then
		mvc.perform(get("/api/places/" + placeId))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.data.placeType").value(PlaceType.COMMON.name()))
				.andExpect(jsonPath("$.data.placeName").value("랄라베드민턴장"))
				.andExpect(jsonPath("$.data.address").value("서울시 강남구 강남대로 1234"))
				.andExpect(jsonPath("$.data.phoneNumber").value("010-1234-5678"))
				.andExpect(jsonPath("$.data.capacity").value(30))
				.andExpect(jsonPath("$.data.memo").value("신장개업"))
				.andExpect(jsonPath("$.success").value(true))
				.andExpect(jsonPath("$.errorCode").value(ErrorCode.OK.getCode()))
				.andExpect(jsonPath("$.message").value(ErrorCode.OK.getMessage()));
	}

	@DisplayName("[API][GET] 단일 장소 조회 - 장소 없는 경우")
	@Test
	void givenPlaceAndItsId_whenRequestingPlace_thenReturnEmptyStandardResponse() throws Exception {
		// given
		int placeId = 2;

		// when & then
		mvc.perform(get("/api/places/" + placeId))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.data").isEmpty())
				.andExpect(jsonPath("$.success").value(true))
				.andExpect(jsonPath("$.errorCode").value(ErrorCode.OK.getCode()))
				.andExpect(jsonPath("$.message").value(ErrorCode.OK.getMessage()));
	}
}