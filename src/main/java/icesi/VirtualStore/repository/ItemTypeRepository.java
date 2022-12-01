package icesi.VirtualStore.repository;

import icesi.VirtualStore.model.ItemType;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ItemTypeRepository extends CrudRepository<ItemType, UUID> {

}
