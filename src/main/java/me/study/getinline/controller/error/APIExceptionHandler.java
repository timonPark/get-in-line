package me.study.getinline.controller.error;

import java.util.Map;
import me.study.getinline.constant.ErrorCode;
import me.study.getinline.dto.APIErrorResponse;
import me.study.getinline.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@RestControllerAdvice(annotations = RestController.class)
public class APIExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<APIErrorResponse> general(GeneralException e) {
		ErrorCode errorCode = e.getErrorCode();
		HttpStatus status = errorCode.isClientSideError() ?
				HttpStatus.BAD_REQUEST :
				HttpStatus.INTERNAL_SERVER_ERROR;
		return ResponseEntity
						.status(status)
						.body(APIErrorResponse.of(
								false, errorCode, errorCode.getMessage(e)
						));
	}

	@ExceptionHandler
	public ResponseEntity<APIErrorResponse> exception(Exception e) {
		ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		return ResponseEntity
				.status(status)
				.body(APIErrorResponse.of(
						false, errorCode, errorCode.getMessage(e)
				));
	}

}
