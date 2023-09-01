package me.study.getinline.domain;

import java.time.LocalDateTime;
import lombok.Data;
import me.study.getinline.constant.PlaceType;

@Data
public class Place {
	private Long id;

	private PlaceType placeType;
	private String placeName;
	private String address;
	private String phoneNumber;
	private Integer capacity;
	private String memo;

	private LocalDateTime creatdAt;
	private LocalDateTime modifiedAt;

}
