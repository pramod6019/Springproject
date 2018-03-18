package axela.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class Controller_ExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(Controller_ExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ExceptionResponse> generalException(Exception e) throws Exception {
		// System.out.println("Controlleradice----");
		ExceptionResponse er = new ExceptionResponse();
		er.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		er.setDesc(e.getMessage());
		LOGGER.info("logger exception======" + e.getMessage() + "\r\n  Logger Exception Location======" + e.getStackTrace()[0]);
		// System.out.println("eee==111===" + e);
		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
