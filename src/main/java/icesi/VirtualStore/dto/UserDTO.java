package icesi.VirtualStore.dto;


import icesi.VirtualStore.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
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

    @NotBlank
    private String email;

    @NotNull
    private String phoneNumber;

    @NotNull
    @Size(min = 1, max = 120)
    private String address;

    private RoleDTO role;

}
