package me.study.getinline.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlaceDto {
	private String placeType;
	private String placeName;
	private String address;
	private String phoneNumber;
	private Integer capacity;
	private String memo;

}
