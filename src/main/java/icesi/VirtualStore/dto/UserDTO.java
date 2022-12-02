package icesi.VirtualStore.dto;

import icesi.VirtualStore.validation.CustomAnnotations.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private UUID userId;

    private String email;

    private String phoneNumber;

    private String address;

    private RoleDTO role;

}
