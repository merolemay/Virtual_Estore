package icesi.VirtualStore.model;


import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "item")
@Entity
@Data
public class Item {

    @Id
    @Type(type="org.hibernate.type.PostgresUUIDType")
    private UUID itemId;

    private String name;

    private String description;

    private Double price;

    private String image;

    private boolean available;


    @ManyToOne
    @JoinColumn(name = "order_item_id")
    private OrderItem orderItem;

}
