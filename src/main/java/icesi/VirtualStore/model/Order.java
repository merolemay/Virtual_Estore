package icesi.VirtualStore.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Table(name = "`order`")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID orderId;

    private double total;

    private String status;

    @OneToMany(mappedBy = "order",
    cascade = CascadeType.MERGE,
    fetch = FetchType.LAZY)
    private List<OrderItem> orderItemList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    public void generateId() {
        this.orderId = UUID.randomUUID();
    }
}
