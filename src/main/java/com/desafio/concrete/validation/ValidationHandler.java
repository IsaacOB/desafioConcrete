package com.desafio.concrete.validation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.desafio.concrete.dto.ValidationErrorDTO;
import com.desafio.concrete.exception.EmailNotFound;
import com.desafio.concrete.exception.ExistingEmailException;
import com.desafio.concrete.exception.InvalidSession;
import com.desafio.concrete.exception.NotAutorize;
import com.desafio.concrete.exception.PasswordNotFound;
import com.desafio.concrete.exception.UserNotFound;

@RestControllerAdvice
public class ValidationHandler {

	@ResponseStatus(code = HttpStatus.CONFLICT)
	@ExceptionHandler(ExistingEmailException.class)
	public ValidationErrorDTO existingEmailHandler(ExistingEmailException exception) {

		String message = exception.getMessage();
		ValidationErrorDTO erro = new ValidationErrorDTO(message);
		return erro;
	}

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmailNotFound.class)
	public ValidationErrorDTO emailNotFound(EmailNotFound exception) {

		String message = exception.getMessage();
		ValidationErrorDTO erro = new ValidationErrorDTO(message);
		return erro;
	}

	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(PasswordNotFound.class)
	public ValidationErrorDTO passwordNotFound(PasswordNotFound exception) {

		String message = exception.getMessage();
		ValidationErrorDTO erro = new ValidationErrorDTO(message);
		return erro;
	}

	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(NotAutorize.class)
	public ValidationErrorDTO notAutorize(NotAutorize exception) {

		String message = exception.getMessage();
		ValidationErrorDTO erro = new ValidationErrorDTO(message);
		return erro;
	}

	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(UserNotFound.class)
	public ValidationErrorDTO userNotFound(UserNotFound exception) {

		String message = exception.getMessage();
		ValidationErrorDTO erro = new ValidationErrorDTO(message);
		return erro;
	}

	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(InvalidSession.class)
	public ValidationErrorDTO invalidSession(InvalidSession exception) {

		String message = exception.getMessage();
		ValidationErrorDTO erro = new ValidationErrorDTO(message);
		return erro;
	}

}
