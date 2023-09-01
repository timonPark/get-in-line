package me.study.getinline.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

	OK(0, ErrorCategory.NORMAL, "OK"),

	BAD_REQUST(10000, ErrorCategory.CLIENT_SIDE, "bad request"),
	SPRING_BAD_REQUST(10001, ErrorCategory.CLIENT_SIDE)

	private final Integer code;
	private final ErrorCategory errorCategory;
	private final String message;

	public enum ErrorCategory {
		NORMAL, CLIENT_SIDE, SERVER_SIDE
	}
}
