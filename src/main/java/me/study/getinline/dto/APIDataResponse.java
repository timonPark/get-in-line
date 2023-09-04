package me.study.getinline.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class APIDataResponse extends APIErrorResponse {

	private final Object data;

	protected APIDataResponse(final Boolean success, final Integer errorCode, final String message, Object data) {
		super(success, errorCode, message);
		this.data = data;
	}

	public static APIDataResponse of(boolean success, Integer errorCode, String message, Object data) {
		return new APIDataResponse(success, errorCode, message, data);
	}
}
