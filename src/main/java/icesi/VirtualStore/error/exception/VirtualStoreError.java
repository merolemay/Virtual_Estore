package icesi.VirtualStore.error.exception;

import icesi.VirtualStore.constant.VirtualStoreErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VirtualStoreError {
    private VirtualStoreErrorCode code;
    private String message;
}
