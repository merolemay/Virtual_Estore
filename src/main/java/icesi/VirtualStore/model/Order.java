package icesi.VirtualStore.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "order")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @Type(type="org.hibernate.type.PostgresUUIDType")
    private UUID orderId;

    private int total;

    private String status;


    @ManyToOne
    @JoinColumn(name = "id")
    private User user;
}
