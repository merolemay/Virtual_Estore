package icesi.VirtualStore.model;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "item")
public class Item {

    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID itemID;

    private boolean available;

    @ManyToOne
    @JoinColumn(name = "order_item_id")
    private OrderItem orderItem;

    @ManyToOne
    @JoinColumn(name = "item_type_id")
    private ItemType itemType;
}
