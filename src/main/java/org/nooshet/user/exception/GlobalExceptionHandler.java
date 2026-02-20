package org.nooshet.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private ResponseEntity<Map<String, Object>> buildErrorResponse(String code, String message, int status, String path) {
        Map<String, Object> error = new HashMap<>();
        error.put("code", code);
        error.put("message", message);
        error.put("status", status);
        error.put("path", path);
        error.put("timestamp", ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        Map<String, Object> wrapper = new HashMap<>();
        wrapper.put("error", error);
        return ResponseEntity.status(status).body(wrapper);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        StringBuilder sb = new StringBuilder();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            sb.append(fieldError.getField()).append(": ").append(fieldError.getDefaultMessage()).append("; ");
        }
        String path = request.getDescription(false).replace("uri=", "");
        return buildErrorResponse("BAD_REQUEST", "Validation failed: " + sb.toString(), 400, path);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleAll(Exception ex, WebRequest request) {
        String path = request.getDescription(false).replace("uri=", "");
        return buildErrorResponse("INTERNAL_SERVER_ERROR", "Internal server error", 500, path);
    }

    @ExceptionHandler(org.nooshet.user.exception.BadRequestException.class)
    public ResponseEntity<Map<String, Object>> handleBadRequest(org.nooshet.user.exception.BadRequestException ex, WebRequest request) {
        String path = request.getDescription(false).replace("uri=", "");
        return buildErrorResponse("BAD_REQUEST", ex.getMessage(), 400, path);
    }

    @ExceptionHandler(org.nooshet.user.exception.ConflictException.class)
    public ResponseEntity<Map<String, Object>> handleConflict(org.nooshet.user.exception.ConflictException ex, WebRequest request) {
        String path = request.getDescription(false).replace("uri=", "");
        return buildErrorResponse("CONFLICT", ex.getMessage(), 409, path);
    }
}
