package me.study.getinline.controller.error;

import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;
import me.study.getinline.constant.ErrorCode;
import me.study.getinline.dto.APIErrorResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseErrorController implements ErrorController {

	@RequestMapping(path ="/error", produces = MediaType.TEXT_HTML_VALUE)
	public ModelAndView errorHtml(HttpServletResponse response) {
		HttpStatus status = HttpStatus.valueOf(response.getStatus());
		ErrorCode errorCode = status.is4xxClientError() ? ErrorCode.BAD_REQUEST : ErrorCode.INTERNAL_ERROR;
		return new ModelAndView("error", Map.of(
				"statusCode", status.value(),
				"errorCode", errorCode,
				"message", errorCode.getMessage(status.getReasonPhrase())
		),
		status);
	}

	@RequestMapping("/error")
	public ResponseEntity<APIErrorResponse> error(HttpServletResponse response) {
		HttpStatus status = HttpStatus.valueOf(response.getStatus());
		ErrorCode errorCode = status.is4xxClientError() ? ErrorCode.BAD_REQUEST : ErrorCode.INTERNAL_ERROR;
		return ResponseEntity
				.status (status)
				.body(APIErrorResponse.of(false, errorCode));
	}


}
