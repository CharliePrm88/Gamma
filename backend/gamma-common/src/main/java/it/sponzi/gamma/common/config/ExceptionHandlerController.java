package it.sponzi.gamma.common.config;

import it.sponzi.gamma.common.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    protected Mono<ResponseEntity<String>> handleIllegalArgument(IllegalArgumentException ex) {
        return Mono.just(ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @ExceptionHandler(IllegalStateException.class)
    protected Mono<ResponseEntity<String>> handleIllegalState(IllegalStateException ex) {
        return Mono.just(ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @ExceptionHandler(NotFoundException.class)
    protected Mono<ResponseEntity<Void>> handleNotFound(NotFoundException ex) {
        return Mono.just(ResponseEntity.notFound().build());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
