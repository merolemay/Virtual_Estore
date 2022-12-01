package icesi.VirtualStore.model;


import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "order")
@Entity
@Data
public class Order {
    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID orderId;

    private Double total;

    private String status;


    @ManyToOne
    @JoinColumn(name = "id")
    private User user;
}
