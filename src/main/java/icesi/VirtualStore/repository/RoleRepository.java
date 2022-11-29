package icesi.VirtualStore.repository;

import icesi.VirtualStore.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RoleRepository extends CrudRepository<Role, UUID> {
}
