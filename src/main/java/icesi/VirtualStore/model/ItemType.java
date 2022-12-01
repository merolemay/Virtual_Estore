package icesi.VirtualStore.model;


import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Table(name = "item_type")
@Entity
@Data
public class ItemType {

    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID itemTypeId;

    private String name;

    private String description;

    private Double price;

    private String image;
}
