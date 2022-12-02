package icesi.VirtualStore.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Table(name = "order")
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
    @OneToMany
    private List<OrderItem> orderItemList;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    public double getTotal() {
        double total = 0;
        for (OrderItem i:orderItemList) {
           for(Item ii: i.getItems()){
               total+= ii.getItemType().getPrice();
           }
        }
        return total;
    }

    @PrePersist
    public void generateId() {
        this.orderId = UUID.randomUUID();
    }
}
