package icesi.VirtualStore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "item")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID itemId;

    private boolean available;

    @ManyToOne
    @JoinColumn(name = "order_item_id")
    private OrderItem orderItem;

    @ManyToOne
    @JoinColumn(name = "item_type_id")
    private ItemType itemType;


    @PrePersist
    public void generateId() {
        this.itemId = UUID.randomUUID();
    }
}
