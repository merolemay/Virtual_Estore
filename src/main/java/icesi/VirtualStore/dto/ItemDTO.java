package icesi.VirtualStore.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class ItemDTO {

    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private double price;

    private String image;
}
