package me.study.getinline.domain;

import java.time.LocalDateTime;
import lombok.Data;
import me.study.getinline.constant.EventStatus;

@Data
public class Event {
	private Long id;

	private Long placeId;
	private String eventName;
	private EventStatus eventStatus;
	private LocalDateTime eventStartDateTime;
	private LocalDateTime eventEndDatetime;
	private Integer currentNumberOfPeople;
	private Integer capacity;
	private String memo;

	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;

}
