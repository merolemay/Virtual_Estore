package icesi.VirtualStore.dto;

import icesi.VirtualStore.validation.CustomAnnotations;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    @CustomAnnotations.ValidUsername
    private String username;
    private String password;

}
