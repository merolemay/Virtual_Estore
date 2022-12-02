package icesi.VirtualStore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemTypeDTO {

    private UUID itemTypeId;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private double price;

    private String image;
}
