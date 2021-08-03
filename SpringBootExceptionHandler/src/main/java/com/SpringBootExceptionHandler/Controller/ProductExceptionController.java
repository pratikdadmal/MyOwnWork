package com.SpringBootExceptionHandler.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.SpringBootExceptionHandler.Error.ProductNotfoundException;

@ControllerAdvice
public class ProductExceptionController {

	 @ExceptionHandler(value = ProductNotfoundException.class)
	   public ResponseEntity<Object> exception(ProductNotfoundException exception) {
	      return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
	   }
}
