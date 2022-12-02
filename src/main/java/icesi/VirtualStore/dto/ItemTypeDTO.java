package icesi.VirtualStore.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ItemTypeDTO {

    private String itemId;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private double price;

    private String image;
}
