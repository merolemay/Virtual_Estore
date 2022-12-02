package icesi.VirtualStore.dto;

import icesi.VirtualStore.validation.CustomAnnotations.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    @ValidUsername
    private String username;
    @ValidPassword
    private String password;

}
