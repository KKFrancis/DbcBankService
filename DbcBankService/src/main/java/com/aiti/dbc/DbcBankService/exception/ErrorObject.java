package com.aiti.dbc.DbcBankService.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorObject {

	private String message;
	private List<String> details;
	private HttpStatus status;
	private LocalDateTime timeStamp;
	
	
	
}
