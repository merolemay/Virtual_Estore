package icesi.VirtualStore.repository;

import icesi.VirtualStore.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ItemRepository extends CrudRepository<Item, UUID> {


}
