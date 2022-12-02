package icesi.VirtualStore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDTO {

    private UUID id;

    private String email;

    private String phoneNumber;


    @Size(min = 10, max = 120, message = "The address must have between 10 and 120 characters")
    private String address;

    @NotNull
    private String password;

    @NotNull
    private String roleName;

}
