package com.ipisis.errors;

import com.ipisis.models.responses.DetalleErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.Objects;

@ControllerAdvice
public class ValidacionModeloError {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerErrorValidacion(MethodArgumentNotValidException exception) {

        DetalleErrorResponse detalleError = DetalleErrorResponse.builder()
                .timestamp(new Date())
                .error("Error validando los campos del objeto")
                .detalle(Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage())
                .build();
        return new ResponseEntity<>(detalleError, HttpStatus.BAD_REQUEST);
    }
}
