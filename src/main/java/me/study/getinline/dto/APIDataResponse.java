package me.study.getinline.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import me.study.getinline.constant.ErrorCode;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class APIDataResponse<T> extends APIErrorResponse {

	private final T data;

	protected APIDataResponse(T data) {
		super(true, ErrorCode.OK.getCode(), ErrorCode.OK.getMessage());
		this.data = data;
	}

	protected APIDataResponse(Integer code, T data) {
		super(true, code, ErrorCode.OK.getMessage());
		this.data = data;
	}

	public static <T> APIDataResponse<T> of(T data) {
		return new APIDataResponse(data);
	}

	public static <T> APIDataResponse<T> of(Integer code, T data) {
		return new APIDataResponse(code, data);
	}
}
