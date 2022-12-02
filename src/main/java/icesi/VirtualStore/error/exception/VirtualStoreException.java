package icesi.VirtualStore.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class VirtualStoreException extends RuntimeException {
    private HttpStatus httpStatus;
    private VirtualStoreError error;
}
