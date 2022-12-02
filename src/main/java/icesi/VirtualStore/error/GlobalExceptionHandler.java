package icesi.VirtualStore.error;

import icesi.VirtualStore.constant.VirtualStoreErrorCode;
import icesi.VirtualStore.error.exception.VirtualStoreError;
import icesi.VirtualStore.error.exception.VirtualStoreException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<VirtualStoreError> handleException(VirtualStoreException virtualStoreException) {
        return new ResponseEntity<>(virtualStoreException.getError(), virtualStoreException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<VirtualStoreError> handleAnnotationException(MethodArgumentNotValidException methodArgumentNotValidException) {
        VirtualStoreException virtualStoreException = new VirtualStoreException(HttpStatus.BAD_REQUEST, new VirtualStoreError(VirtualStoreErrorCode.CODE_01, Objects.requireNonNull(methodArgumentNotValidException.getFieldError()).getDefaultMessage()));
        return new ResponseEntity<>(virtualStoreException.getError(),virtualStoreException.getHttpStatus());
    }
    @ExceptionHandler
    public ResponseEntity<VirtualStoreError> handleConstraintException(ConstraintViolationException constraintViolationException) {
        VirtualStoreException virtualStoreException = new VirtualStoreException(HttpStatus.BAD_REQUEST, new VirtualStoreError(VirtualStoreErrorCode.CODE_01, Objects.requireNonNull(constraintViolationException.getConstraintViolations().stream().reduce("",(s, constraintViolation) ->  constraintViolation.getMessage(), (s, s2) -> s + s2))));
        return new ResponseEntity<>(virtualStoreException.getError(), virtualStoreException.getHttpStatus());
    }
    @ExceptionHandler
    public ResponseEntity<VirtualStoreError> handleAnnotationTypeMismatch(MethodArgumentTypeMismatchException methodArgumentTypeMismatchException) {
        VirtualStoreException virtualStoreException = new VirtualStoreException(HttpStatus.BAD_REQUEST, new VirtualStoreError(VirtualStoreErrorCode.CODE_01, VirtualStoreErrorCode.CODE_01.getMessage()));
        return new ResponseEntity<>(virtualStoreException.getError(), virtualStoreException.getHttpStatus());
    }
}
