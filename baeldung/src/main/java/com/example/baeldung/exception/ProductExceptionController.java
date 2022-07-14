package com.example.baeldung.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController extends RuntimeException {
   private static final long serialVersionUID = 1L;

   @ExceptionHandler(value = ProductExceptionController.class)
   public ResponseEntity<Object> exception(ProductExceptionController e) {
       return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
   }
}
