package icesi.VirtualStore.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Table(name = "order_item")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID orderItemId;

    private int quantity;

    @OneToMany(mappedBy = "orderItem",
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY)
    private List<Item> items;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @PrePersist
    public void generateId() {
        this.orderItemId = UUID.randomUUID();
    }
}
