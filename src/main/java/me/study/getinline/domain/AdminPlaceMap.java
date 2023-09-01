package me.study.getinline.domain;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class AdminPlaceMap {
	private Long id;

	private Long adminId;
	private Long placeId;

	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
}
