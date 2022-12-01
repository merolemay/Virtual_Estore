package icesi.VirtualStore.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

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
