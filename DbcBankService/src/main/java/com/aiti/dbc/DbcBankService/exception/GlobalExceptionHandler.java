package com.aiti.dbc.DbcBankService.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Method not supported");
		ErrorObject errObj = new ErrorObject(message, details, status, LocalDateTime.now());
		return ResponseEntity.status(status).body(errObj);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Type not supported");
		ErrorObject errObj = new ErrorObject(message, details, status, LocalDateTime.now());
		return ResponseEntity.status(status).body(errObj);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Path variable is not there");
		ErrorObject errObj = new ErrorObject(message, details, status, LocalDateTime.now());
		return ResponseEntity.status(status).body(errObj);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Missing parameter request");
		ErrorObject errObj = new ErrorObject(message, details, status, LocalDateTime.now());
		return ResponseEntity.status(status).body(errObj);
	}

	@Override
	protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();	
		List<String> details = new ArrayList<>();
		details.add("Conversion not supported");
		ErrorObject errObj = new ErrorObject(message, details, status, LocalDateTime.now());	
		return ResponseEntity.status(status).body(errObj);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Type mismatch pls");
		ErrorObject errObj = new ErrorObject(message, details, status, LocalDateTime.now());
		return ResponseEntity.status(status).body(errObj);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Message is not readable");
		ErrorObject errObj = new ErrorObject(message, details, status, LocalDateTime.now());
		return ResponseEntity.status(status).body(errObj);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Argument not valid");
		ErrorObject errObj = new ErrorObject(message, details, status, LocalDateTime.now());
		return ResponseEntity.status(status).body(errObj);
	}
	
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<Object> accountNotFoundException(AccountNotFoundException ax){
		String message  = ax.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Cannot find the account you requested");
		details.add(ax.getMessage());
		ErrorObject errObj = new ErrorObject(message, details, HttpStatus.NOT_FOUND, LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errObj);
	}
	
	@ExceptionHandler(AccountAvailableException.class)
	public ResponseEntity<Object> accountAvailableException(AccountAvailableException ex){
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Account number is available");
		details.add(ex.getMessage());
		ErrorObject errObj = new ErrorObject(message, details, HttpStatus.FOUND, LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.FOUND).body(errObj);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleOtherException(Exception e){
		String message = e.getMessage();
		List<String> details = new ArrayList<>();
		details.add(e.getMessage());
		ErrorObject errObj = new ErrorObject(message, details, HttpStatus.BAD_REQUEST, LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errObj);
	}
}
