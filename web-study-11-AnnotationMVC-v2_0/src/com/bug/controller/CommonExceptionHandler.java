package com.bug.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("springapp.board")
public class CommonExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public String handleException() {
		return "error/common_exception";
	}
}
